package com.example.quote.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quote.domain.model.QuoteModel
import com.example.quote.domain.usecase.GetAllQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteAllViewModel
@Inject constructor(
    private val getAllQuoteUseCase: GetAllQuoteUseCase
) : ViewModel() {
    private val quoteModelListMutableStateFlow = MutableStateFlow<List<QuoteModel>>(listOf())
    val quoteModelList: StateFlow<List<QuoteModel>> = quoteModelListMutableStateFlow

    fun getAllQuote() {
        viewModelScope.launch {
            quoteModelListMutableStateFlow.value = getAllQuoteUseCase.getAllQuote().first()
            val value = quoteModelListMutableStateFlow.value
            println("Value: $value")
        }
    }
}
