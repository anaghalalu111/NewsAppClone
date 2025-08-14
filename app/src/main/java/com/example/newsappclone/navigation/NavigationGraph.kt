package com.example.newsappclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsappclone.view.CategoryScreen
import com.example.newsappclone.view.NewsScreen

import com.example.newsappclone.viewmodel.NewsViewModel

@Composable
fun NavigationGraph(viewModel: NewsViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.CategoryScreen.route) {

        /*First screen - Category Screen*/
        composable(Screens.CategoryScreen.route){
            CategoryScreen(navController=navController, viewModel)
        }

        /*Second Screen - [with arguments]- NewsScreen*/

        composable(Screens.NewsScreen.route,
            arguments = listOf(navArgument("category"){type = NavType.StringType},
            ))
        {backStackEntry->

            //Get the category name from the route
            val category= backStackEntry.arguments?.getString("category")?:"Unknown"

            NewsScreen(viewModel =viewModel, navController =navController, category = category)
        }



    }
}

