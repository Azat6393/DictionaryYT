package com.azatberdimyradov.dictionaryyt.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.azatberdimyradov.dictionaryyt.feature_dictionary.domain.model.Meaning
import com.azatberdimyradov.dictionaryyt.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String,
    val origin: String,
    val meanings: List<Meaning>,
    @PrimaryKey val id: Int? = null
){
    fun toWordInto(): WordInfo{
        return WordInfo(
            meanings = meanings,
            word = word,
            origin = origin,
            phonetic = phonetic
        )
    }
}
