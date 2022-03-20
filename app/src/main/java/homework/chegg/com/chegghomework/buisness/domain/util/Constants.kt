package homework.chegg.com.chegghomework.buisness.domain.util

class Constants {

    companion object{

        const val BASE_URL = "https://chegg-mobile-promotions.cheggcdn.com/android/homework/"
        const val DATA_SOURCE_A_URL = "android_homework_datasourceA.json"
        const val DATA_SOURCE_B_URL = "android_homework_datasourceB.json"
        const val DATA_SOURCE_C_URL = "android_homework_datasourceC.json"


        const val NETWORK_TIMEOUT = 6000L
        const val CACHE_TIMEOUT = 2000L
        const val TESTING_NETWORK_DELAY = 0L // fake network delay for testing
        const val TESTING_CACHE_DELAY = 0L // fake cache delay for testing


        const val PAGINATION_PAGE_SIZE = 10

        const val GALLERY_REQUEST_CODE = 201
        const val PERMISSIONS_REQUEST_READ_STORAGE: Int = 301
        const val CROP_IMAGE_INTENT_CODE: Int = 401
    }
}