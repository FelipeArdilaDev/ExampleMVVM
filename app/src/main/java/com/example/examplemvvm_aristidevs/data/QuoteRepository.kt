package com.example.examplemvvm_aristidevs.data

import com.example.examplemvvm_aristidevs.data.network.QuoteService
import com.example.examplemvvm_aristidevs.data.model.QuoteModel
import com.example.examplemvvm_aristidevs.data.model.QuoteProvider
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api:QuoteService, private val quoteProvider: QuoteProvider){

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}