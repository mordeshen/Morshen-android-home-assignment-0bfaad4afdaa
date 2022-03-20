package homework.chegg.com.chegghomework.buisness.datasource.network.main.dto

import com.google.gson.annotations.SerializedName
import homework.chegg.com.chegghomework.buisness.domain.model.Story

/**
{
    "stories": [
    {
        "title": "Interesting News!",
        "subtitle": "You're not gonna believe this...",
        "imageUrl": "https://pbs.twimg.com/profile_images/658218628127588352/v0ZLUBrt.jpg"
    }
    ...
    ]
}
*/

class StoryCDTO(


    @SerializedName("topLine")
    val topLine: String,

    @SerializedName("subLine1")
    val subLine1: String,

    @SerializedName("subline2")
    val subline2: String,


    @SerializedName("image")
    val image: String,
)

fun StoryCDTO.toStory(): Story {
    return Story(
        title = topLine,
        subtitle = "$subLine1 $subline2",
        imageUrl = image
    )
}

fun Story.toCDto(): StoryADTO{
    return StoryADTO(
        title = title ?: "",
        subtitle = subtitle ?: "",
        imageUrl = imageUrl  ?: ""
    )
}
