package com.example.quote.domain.usecase

import com.example.quote.domain.QuoteRepository
import com.example.quote.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetQuoteRandomUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
){
    suspend fun getQuoteRandom(): Flow<QuoteModel> = quoteRepository.getQuoteRandom()

}
