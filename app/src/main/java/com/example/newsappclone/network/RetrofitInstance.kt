package com.example.newsappclone.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


/*Create a retrofit instance singleton*/

object RetrofitInstance {

    /*Builds retrofit*/
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/")//Base URL of the API
            .addConverterFactory(GsonConverterFactory.create())
            .build() /*Gives retrofit object*/
    }


   /*Create Api service*/
    val api:NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }

}