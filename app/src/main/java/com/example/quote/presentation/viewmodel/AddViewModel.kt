package com.example.quote.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quote.domain.model.QuoteModel
import com.example.quote.domain.usecase.GetQuoteAddUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel
@Inject constructor(
    private val getQuoteAddUseCase: GetQuoteAddUseCase
) : ViewModel() {

    fun addQuote(quoteModel: QuoteModel) {
        viewModelScope.launch {
            getQuoteAddUseCase.addQuote(quoteModel)
        }
    }
}
