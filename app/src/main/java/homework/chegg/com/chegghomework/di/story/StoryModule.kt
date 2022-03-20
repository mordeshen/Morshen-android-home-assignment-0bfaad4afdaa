package homework.chegg.com.chegghomework.di.story

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import homework.chegg.com.chegghomework.buisness.datasource.cache.story.StoryDao
import homework.chegg.com.chegghomework.buisness.datasource.network.main.ApiMainService
import homework.chegg.com.chegghomework.buisness.interactors.SearchStories
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StoryModule {

    //currently ain't no need with submodule
    @Singleton
    @Provides
    fun provideSearchBlogs(
        service: ApiMainService,
        dao: StoryDao,
    ): SearchStories{
        return SearchStories(service, dao)
    }
}

















