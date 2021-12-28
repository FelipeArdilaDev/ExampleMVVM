package com.example.examplemvvm_aristidevs.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examplemvvm_aristidevs.data.model.QuoteModel
import com.example.examplemvvm_aristidevs.domain.GetQuotesUseCase
import com.example.examplemvvm_aristidevs.domain.GetRandomQuotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase:GetQuotesUseCase,
    private val getRandomQuotesUseCase:GetRandomQuotesUseCase
) : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

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