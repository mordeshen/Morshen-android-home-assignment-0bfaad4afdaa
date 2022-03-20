package homework.chegg.com.chegghomework.buisness.datasource.network.main.dto

import com.google.gson.annotations.SerializedName
import homework.chegg.com.chegghomework.buisness.domain.model.Story

/**
{
"metadata": {
"this": "isnotimportant",
"innerdata": [
{
"aticleId": 1,
"articlewrapper": {
"header": "WOW",
"description": "SHIGAON"
},
"picture": "https://pbs.twimg.com/profile_images/2084187780/avib_400x400.jpg"
}
...
]
}
}
 */

class StoryBDTO(
    @SerializedName("aticleId")
    val aticleId: Int,

    @SerializedName("articlewrapper")
    val articlewrapper: Articlewrapper,

    @SerializedName("picture")
    val picture: String
)


class Articlewrapper(val description: String, val header: String)

fun StoryBDTO.toStory(): Story {
    return(
            Story(
                title = articlewrapper.header,
                subtitle = articlewrapper.description,
                imageUrl = picture
            ))
}

