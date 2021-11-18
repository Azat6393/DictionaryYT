package com.azatberdimyradov.dictionaryyt.feature_dictionary.presentation

import com.azatberdimyradov.dictionaryyt.feature_dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
