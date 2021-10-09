package com.example.examplemvvm.ui.viewmodel

import QuoteModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examplemvvm.domain.GetQuotesUseCase
import com.example.examplemvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    val getRandomQuotesUseCase = GetRandomQuoteUseCase()

    fun randomQuote() {
        isLoading.postValue(true)
        //val currentQuote = QuoteProvider.random()
        //quoteModel.postValue(currentQuote)

        val quote = getRandomQuotesUseCase()
        if (quote != null) {
            quoteModel.postValue(quote!!)
        }

        isLoading.postValue(false)
    }
}