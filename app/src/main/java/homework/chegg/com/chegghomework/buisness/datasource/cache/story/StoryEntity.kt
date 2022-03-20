package homework.chegg.com.chegghomework.buisness.datasource.cache.story

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import homework.chegg.com.chegghomework.buisness.domain.model.Story
import java.util.*

@Entity(tableName = "story")
data class StoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pk")
    val pk: Int = 0,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "subtitle")
    val subtitle: String,

    @ColumnInfo(name = "imageUrl")
    val imageUrl: String,

    //in Minute
    @ColumnInfo(name = "timeToErase")
    val timeToErase: Long
)


fun StoryEntity.toStory(): Story {
    return Story(
        title = title,
        subtitle = subtitle,
        imageUrl = imageUrl
    )
}

fun Story.toEntity(kind:Int): StoryEntity {
    return StoryEntity(
        title = title ?: "" ,
        subtitle = subtitle ?: "",
        imageUrl = imageUrl ?: "",
        timeToErase = createTimeStampByKind(kind),
    )
}

fun createTimeStampByKind(kind: Int):Long{
    return when (kind) {
        1 -> createTimeStamp(300000)
        2 -> createTimeStamp(1800000)
        3 -> createTimeStamp(3600000)
        else -> createTimeStamp(300000)
    }
}


fun createTimeStamp(time:Long):Long{
    return System.currentTimeMillis() + time
}