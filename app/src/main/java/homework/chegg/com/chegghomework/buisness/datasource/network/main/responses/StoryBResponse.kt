package homework.chegg.com.chegghomework.buisness.datasource.network.main.responses

import com.google.gson.annotations.SerializedName
import homework.chegg.com.chegghomework.buisness.datasource.network.main.dto.StoryBDTO
import homework.chegg.com.chegghomework.buisness.datasource.network.main.dto.toStory
import homework.chegg.com.chegghomework.buisness.domain.model.Story

data class StoryBResponse(
    val metadata: MyMetadata
)

data class MyMetadata(
    @SerializedName("this")
    val _this: String,

    @SerializedName("innerdata")
    val data: List<StoryBDTO>
)

fun StoryBResponse.toList(): List<Story>{
    val list: MutableList<Story> = mutableListOf()
    for(dto in metadata.data){
        list.add(
            dto.toStory()
        )
    }
    return list
}