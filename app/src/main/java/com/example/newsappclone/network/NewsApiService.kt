package com.example.newsappclone.network

import com.example.newsappclone.model.NewsResponse
import com.example.newsappclone.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/top-headlines")
     suspend fun  getNewsByCategory(
         @Query("category") category:String,
         @Query("apiKey") apiKey:String = BuildConfig.NEWS_API_KEY
     ):Response<NewsResponse>
}