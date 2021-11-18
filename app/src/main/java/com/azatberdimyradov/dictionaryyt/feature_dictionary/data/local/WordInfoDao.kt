package com.azatberdimyradov.dictionaryyt.feature_dictionary.data.local

import androidx.room.*
import com.azatberdimyradov.dictionaryyt.feature_dictionary.data.local.entity.WordInfoEntity
import com.azatberdimyradov.dictionaryyt.feature_dictionary.domain.model.WordInfo

@Dao
interface WordInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordInfos(infos: List<WordInfoEntity>)

    @Query("DELETE FROM wordinfoentity WHERE word IN(:words)")
    suspend fun deleteWordInfos(words: List<String>)

    @Query("SELECT * FROM wordinfoentity WHERE word LIKE '%' || :word || '%'")
    suspend fun getWordInfos(word: String): List<WordInfoEntity>

}