package com.example.newsappclone.model

data class Article(
    val source: Source,
    val title:String?,
    val description:String?,
    val content:String?,
    val urlToImage:String
)
