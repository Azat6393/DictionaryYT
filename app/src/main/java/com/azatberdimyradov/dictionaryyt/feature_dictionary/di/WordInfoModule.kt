package com.azatberdimyradov.dictionaryyt.feature_dictionary.di

import android.app.Application
import androidx.room.Room
import com.azatberdimyradov.dictionaryyt.feature_dictionary.data.local.Converters
import com.azatberdimyradov.dictionaryyt.feature_dictionary.data.local.WordInfoDao
import com.azatberdimyradov.dictionaryyt.feature_dictionary.data.local.WordInfoDatabase
import com.azatberdimyradov.dictionaryyt.feature_dictionary.data.remote.DictionaryApi
import com.azatberdimyradov.dictionaryyt.feature_dictionary.data.repository.WordInfoRepositoryImpl
import com.azatberdimyradov.dictionaryyt.feature_dictionary.data.util.GsonParser
import com.azatberdimyradov.dictionaryyt.feature_dictionary.domain.repository.WordInfoRepository
import com.azatberdimyradov.dictionaryyt.feature_dictionary.domain.use_case.GetWordInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideGetWordInfoUserCase(repository: WordInfoRepository): GetWordInfo {
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun provideWordInfoRepository(
        api: DictionaryApi,
        dao: WordInfoDatabase
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api, dao.dao)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app, WordInfoDatabase::class.java, "word_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        return Retrofit.Builder()
            .baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }

}