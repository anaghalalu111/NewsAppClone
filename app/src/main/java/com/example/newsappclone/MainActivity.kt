package com.example.newsappclone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newsappclone.model.NewsRepository
import com.example.newsappclone.navigation.NavigationGraph
import com.example.newsappclone.network.RetrofitInstance
import com.example.newsappclone.viewmodel.NewsViewModel
import com.example.newsappclone.viewmodel.NewsViewModelFactory


class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {


        val repository = NewsRepository(RetrofitInstance.api)
        val factory = NewsViewModelFactory(repository)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val viewModel:NewsViewModel = viewModel(factory=factory)

       NavigationGraph( viewModel = viewModel)

        }
    }
}

