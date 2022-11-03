package com.example.quote.domain.usecase

import com.example.quote.domain.QuoteRepository
import javax.inject.Inject


class GetAllQuoteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {
    suspend fun getAllQuote() = quoteRepository.getAllQuote()
}