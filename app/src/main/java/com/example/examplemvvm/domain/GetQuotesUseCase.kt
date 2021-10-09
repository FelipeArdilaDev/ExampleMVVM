package com.example.examplemvvm.domain

import QuoteModel
import com.example.examplemvvm.data.data.QuoteRepository

class GetQuotesUseCase {

    private val repository = QuoteRepository()
    suspend operator fun invoke():List<QuoteModel> = repository.getAllQuotes()
}
