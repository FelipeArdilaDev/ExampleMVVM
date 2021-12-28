package com.example.examplemvvm_aristidevs.domain

import com.example.examplemvvm_aristidevs.data.model.QuoteProvider
import com.example.examplemvvm_aristidevs.data.model.QuoteModel
import javax.inject.Inject

class GetRandomQuotesUseCase @Inject constructor(private val quoteProvider: QuoteProvider){

    operator fun invoke(): QuoteModel? {
        val quotes = quoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }

}