package homework.chegg.com.chegghomework.buisness.datasource.cache.story

import androidx.room.*
import homework.chegg.com.chegghomework.buisness.datasource.cache.story.StoryEntity
import homework.chegg.com.chegghomework.buisness.domain.util.Constants.Companion.PAGINATION_PAGE_SIZE

@Dao
interface StoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(story: StoryEntity): Long

    @Delete
    suspend fun deleteStory(story:StoryEntity)

    @Query("DELETE FROM story WHERE pk = :pk")
    suspend fun deleteStory(pk:Int)

    @Query("""
        SELECT * FROM story 
        WHERE title LIKE '%' || :query || '%' 
        OR subtitle LIKE '%' || :query || '%' 
        LIMIT (:page * :pageSize)
        """)
    suspend fun getAllStories(
        query: String,
        page: Int,
        pageSize: Int = PAGINATION_PAGE_SIZE
    ): List<StoryEntity>
}