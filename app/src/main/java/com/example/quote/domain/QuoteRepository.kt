package com.example.quote.domain

import com.example.quote.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    // suspend fun getQuotes(): Flow<QuoteResponse?>
    suspend fun getQuoteRandom(): Flow<QuoteModel>
    suspend fun getQuote(quoteId:Int): Flow<QuoteModel>
    //suspend fun editQuote(quoteModel: QuoteModel, token:String): Flow<QuoteResponse?>
    //suspend fun addQuote(quoteModel: QuoteModel, token:String): Flow<QuoteResponse?>
    suspend fun addQuote(quoteModel: QuoteModel)
    suspend fun getAllQuote(): Flow<List<QuoteModel>>
}

