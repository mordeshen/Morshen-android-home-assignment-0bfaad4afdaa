package homework.chegg.com.chegghomework.buisness.interactors

import com.codingwithmitch.openapi.business.domain.util.DataState
import homework.chegg.com.chegghomework.buisness.domain.util.MessageType
import homework.chegg.com.chegghomework.buisness.domain.util.Response
import homework.chegg.com.chegghomework.buisness.domain.util.UIComponentType
import homework.chegg.com.chegghomework.buisness.datasource.cache.story.StoryDao
import homework.chegg.com.chegghomework.buisness.datasource.cache.story.toEntity
import homework.chegg.com.chegghomework.buisness.datasource.cache.story.toStory
import homework.chegg.com.chegghomework.buisness.datasource.network.main.ApiMainService
import homework.chegg.com.chegghomework.buisness.datasource.network.main.dto.toStory
import homework.chegg.com.chegghomework.buisness.datasource.network.util.handleUseCaseException
import homework.chegg.com.chegghomework.buisness.domain.model.Story
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class SearchStories(
    private val service: ApiMainService,
    private val cache: StoryDao,
) {

    private val TAG: String = "AppDebug"

    fun execute(
        query: String,
        page: Int,
    ): Flow<DataState<List<Story>>> = flow {
        emit(DataState.loading<List<Story>>())
        // get Blogs from network
        try{ // catch network exception
            val aStories = service.getAResponse()!!.stories.map { it.toStory() }
            val bStories = service.getBResponse()!!.metadata.data.map { it.toStory() }
            val cStories = service.getCResponse()!!.stories.map { it.toStory() }

            // Insert into cache
            for(story in aStories){
                try{
                    cache.insert(story.toEntity(1))
                    //here insert to Alarm Manager with the exact time to delete from the cache

                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
            // Insert into cache
            for(story in bStories){
                try{
                    cache.insert(story.toEntity(2))
                    //here insert to Alarm Manager with the exact time to delete from the cache

                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
            // Insert into cache
            for(story in cStories){
                try{
                    cache.insert(story.toEntity(3))
                    //here insert to Alarm Manager with the exact time to delete from the cache

                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }catch (e: Exception){
            emit(
                DataState.error<List<Story>>(
                    response = Response(
                        message = "Unable to update the cache.",
                        uiComponentType = UIComponentType.None(),
                        messageType = MessageType.Error()
                    )
                )
            )
        }

        // emit from cache
        val cachedStories = cache.getAllStories(
            query = query,
            page = page
        ).map { it.toStory() }

        emit(DataState.data(response = null, data = cachedStories))
    }.catch { e ->
        emit(handleUseCaseException(e))
    }
}



















