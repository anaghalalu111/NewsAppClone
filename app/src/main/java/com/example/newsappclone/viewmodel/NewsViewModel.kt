package com.example.newsappclone.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappclone.model.NewsRepository
import com.example.newsappclone.model.NewsResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel (private val repository: NewsRepository):ViewModel() {

    /*Declare a state variable _news to hold the value of the news fetched by API*/
    private val _news = MutableStateFlow<NewsResponse?>(null)

    val news: StateFlow<NewsResponse?> = _news /*Read only version of news*/

    /*Declare a state variable to hold the value of selected category chip*/
    private val _selectedCategory = MutableStateFlow("general")
    val selectedCategory: StateFlow<String> =
        _selectedCategory/*Read only version of selected category*/

    /*function to fetch news by category*/

   // init {
       // fetchNewsByCategory(category = "technology", BuildConfig.NEWS_API_KEY)
   // }


    fun fetchNewsByCategory(category: String, apiKey: String) {

        viewModelScope.launch {
            try {
                _selectedCategory.value = category
                val response = repository.getNewsByCategory(category, apiKey)
                _news.value = response.body()
            } catch (e: Exception) {
                Log.e("API_TEST", "Error fetching news from server")
            }

        }
    }
}











