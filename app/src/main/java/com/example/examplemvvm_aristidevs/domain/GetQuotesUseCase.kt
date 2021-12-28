package com.example.examplemvvm_aristidevs.domain

import com.example.examplemvvm_aristidevs.data.QuoteRepository
import com.example.examplemvvm_aristidevs.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository : QuoteRepository) {

    suspend operator fun invoke(): List<QuoteModel> = repository.getAllQuotes()
}