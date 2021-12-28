package com.example.examplemvvm_aristidevs.data.network

import com.example.examplemvvm_aristidevs.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}