package homework.chegg.com.chegghomework.buisness.datasource.network.main

import homework.chegg.com.chegghomework.buisness.datasource.network.main.responses.StoryAResponse
import homework.chegg.com.chegghomework.buisness.datasource.network.main.responses.StoryBResponse
import homework.chegg.com.chegghomework.buisness.datasource.network.main.responses.StoryCResponse
import homework.chegg.com.chegghomework.buisness.domain.util.Constants.Companion.DATA_SOURCE_A_URL
import homework.chegg.com.chegghomework.buisness.domain.util.Constants.Companion.DATA_SOURCE_B_URL
import homework.chegg.com.chegghomework.buisness.domain.util.Constants.Companion.DATA_SOURCE_C_URL
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiMainService {
    @GET(DATA_SOURCE_A_URL)
    suspend fun getAResponse(): StoryAResponse?

    @GET(DATA_SOURCE_B_URL)
    suspend fun getBResponse(): StoryBResponse?

    @GET(DATA_SOURCE_C_URL)
    suspend fun getCResponse(): StoryCResponse?
}