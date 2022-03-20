package homework.chegg.com.chegghomework.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import homework.chegg.com.chegghomework.buisness.datasource.cache.AppDatabase
import homework.chegg.com.chegghomework.buisness.datasource.cache.AppDatabase.Companion.DATABASE_NAME
import homework.chegg.com.chegghomework.buisness.datasource.cache.story.StoryDao
import homework.chegg.com.chegghomework.buisness.datasource.datastore.AppDataStore
import homework.chegg.com.chegghomework.buisness.datasource.datastore.AppDataStoreManager
import homework.chegg.com.chegghomework.buisness.datasource.network.main.ApiMainService
import homework.chegg.com.chegghomework.buisness.domain.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Singleton
    @Provides
    fun provideDataStoreManager(
        application: Application
    ): AppDataStore {
        return AppDataStoreManager(application)
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(gsonBuilder: Gson): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
    }

    @Singleton
    @Provides
    fun provideAppDb(app: Application): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration() // get correct db version if schema changed
            .build()
    }



    @Singleton
    @Provides
    fun provideApiMainService(retrofitBuilder: Retrofit.Builder): ApiMainService {
        return retrofitBuilder
            .build()
            .create(ApiMainService::class.java)
    }

    @Singleton
    @Provides
    fun provideStoryDao(db: AppDatabase): StoryDao {
        return db.getStoryDao()
    }

}