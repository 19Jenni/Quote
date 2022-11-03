package com.example.quote.domain.usecase

import com.example.quote.domain.QuoteRepository
import com.example.quote.domain.model.QuoteModel
import javax.inject.Inject

class GetQuoteAddUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {
    //suspend fun  getQuoteRandom(): Flow<QuoteModel> = quoteRepository.getQuoteRandom()
    suspend fun  addQuote(quoteModel: QuoteModel)=quoteRepository.addQuote(quoteModel)
}