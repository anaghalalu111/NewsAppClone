package com.example.newsappclone.model

import com.example.newsappclone.network.NewsApiService
import retrofit2.Response

class NewsRepository (private val apiService: NewsApiService){


    /*Function to fetch news from api*/

    suspend fun getNewsByCategory(category: String, apiKey:String): Response<NewsResponse> {

        return apiService.getNewsByCategory(category,apiKey)

    }

}