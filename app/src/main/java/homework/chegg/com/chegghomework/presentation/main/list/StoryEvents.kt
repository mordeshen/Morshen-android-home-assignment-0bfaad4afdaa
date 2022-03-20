package homework.chegg.com.chegghomework.presentation.main.list

import homework.chegg.com.chegghomework.buisness.domain.util.StateMessage


sealed class StoryEvents {

    object NewSearch : StoryEvents()

    object NextPage: StoryEvents()

    data class UpdateQuery(val query: String): StoryEvents()

    object GetOrderAndFilter: StoryEvents()

    data class Error(val stateMessage: StateMessage): StoryEvents()

    object OnRemoveHeadFromQueue: StoryEvents()
}
