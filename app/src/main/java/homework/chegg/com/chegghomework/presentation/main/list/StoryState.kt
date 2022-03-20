package homework.chegg.com.chegghomework.presentation.main.list

import homework.chegg.com.chegghomework.buisness.domain.util.Queue
import homework.chegg.com.chegghomework.buisness.domain.util.StateMessage
import homework.chegg.com.chegghomework.buisness.domain.model.Story

data class StoryState(
    val isLoading: Boolean = false,
    val storyList: List<Story> = listOf(),
    val query: String = "",
    val page: Int = 1,
    val isQueryExhausted: Boolean = false, // no more results available, prevent next page
    val queue: Queue<StateMessage> = Queue(mutableListOf()),
)
