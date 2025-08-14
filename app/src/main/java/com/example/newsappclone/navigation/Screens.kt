package com.example.newsappclone.navigation

sealed class Screens(val route:String) {
    object CategoryScreen:Screens(route = "category_screen")
    object NewsScreen:Screens(route = "news_screen/{category}")

    /*This function helps to create the full route, by inserting the actual category name*/
    fun createRoute(category:String) = "news_screen/$category"
}