package homework.chegg.com.chegghomework.buisness.datasource.network.main.responses

import com.google.gson.annotations.SerializedName
import homework.chegg.com.chegghomework.buisness.datasource.network.main.dto.StoryADTO
import homework.chegg.com.chegghomework.buisness.datasource.network.main.dto.toStory
import homework.chegg.com.chegghomework.buisness.domain.model.Story

class StoryAResponse(
    @SerializedName("stories")
    var stories: List<StoryADTO>
)

fun StoryAResponse.toList(): List<Story>{
    val list: MutableList<Story> = mutableListOf()
    for(dto in stories){
        list.add(
            dto.toStory()
        )
    }
    return list
}