package homework.chegg.com.chegghomework.buisness.datasource.network.main.responses

import com.google.gson.annotations.SerializedName
import homework.chegg.com.chegghomework.buisness.datasource.network.main.dto.StoryCDTO
import homework.chegg.com.chegghomework.buisness.datasource.network.main.dto.toStory
import homework.chegg.com.chegghomework.buisness.domain.model.Story

class StoryCResponse (
    @SerializedName("stories")
    var stories: List<StoryCDTO>

    )

fun StoryCResponse.toList(): List<Story>{
    val list: MutableList<Story> = mutableListOf()
    for(dto in stories){
        list.add(
            dto.toStory()
        )
    }
    return list
}