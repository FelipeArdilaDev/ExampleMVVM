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

    var getOutesUseCase = GetQuotesUseCase()
    var getRandomOutseUseCase = GetRandomQuoteUseCase()

    fun oncreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getOutesUseCase()

            if (result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)

            }

        }
    }

    fun randomQuote() {
        isLoading.postValue(true)
        //val currentQuote = QuoteProvider.random()
        //quoteModel.postValue(currentQuote)

        val quote = getRandomOutseUseCase()
        if (quote != null) {
            quoteModel.postValue(quote!!)
        }

        isLoading.postValue(false)
    }


}