package com.azatberdimyradov.dictionaryyt.feature_dictionary.domain.repository

import com.azatberdimyradov.dictionaryyt.core.util.Resource
import com.azatberdimyradov.dictionaryyt.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInto(word: String): Flow<Resource<List<WordInfo>>>
}