package homework.chegg.com.chegghomework.buisness.datasource.cache.story

class StoryQueryUtils {
    
    companion object {
        private const val TAG = "StoryQueryUtils"

        // values
        const val STORY_ORDER_ASC: String = ""
        const val STORY_ORDER_DESC: String = "-"
        const val STORY_FILTER_USERNAME = "username"
        const val STORY_FILTER_DATE_UPDATED = "date_updated"

        val ORDER_BY_ASC_DATE_UPDATED = STORY_ORDER_ASC + STORY_FILTER_DATE_UPDATED
        val ORDER_BY_DESC_DATE_UPDATED = STORY_ORDER_DESC + STORY_FILTER_DATE_UPDATED
        val ORDER_BY_ASC_USERNAME = STORY_ORDER_ASC + STORY_FILTER_USERNAME
        val ORDER_BY_DESC_USERNAME = STORY_ORDER_DESC + STORY_FILTER_USERNAME
    }
    
}