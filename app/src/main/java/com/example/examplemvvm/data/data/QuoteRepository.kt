package com.example.examplemvvm.data.data

import QuoteModel
import com.example.examplemvvm.data.data.model.QuoteProvider
import com.example.examplemvvm.data.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}