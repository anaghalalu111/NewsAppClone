package com.example.newsappclone.view
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.newsappclone.R
import com.example.newsappclone.model.Category
import com.example.newsappclone.navigation.Screens
import com.example.newsappclone.viewmodel.NewsViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(navController: NavController,viewModel: NewsViewModel){
    val selected by viewModel.selectedCategory.collectAsState()

    val categories = listOf(
        Category("Business", R.drawable.business),
        Category("Technology",R.drawable.technology),
        Category("Science",R.drawable.science),
        Category("General",R.drawable.generalnews),
        Category("Health",R.drawable.health),
        Category("Sports",R.drawable.sports),
        Category("Entertainment", R.drawable.hello
        )
    )
    Scaffold(
        topBar = { TopAppBar(title = {Text("CATEGORIES") },
            colors = TopAppBarDefaults.topAppBarColors(Color.Transparent))}
    ) {innerPadding->

        LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = innerPadding,
            horizontalArrangement = Arrangement.spacedBy(10.dp)) {
       items(categories){category->
          CategoryCard(category, isSelected = category.title.lowercase()==selected, OnClick= {
              viewModel.fetchNewsByCategory(category = category.title.lowercase(), apiKey = "afcac81069d64e68a8e6427a2658b20d")
              navController.navigate(Screens.NewsScreen.createRoute(category.title))
          }
          )

       }
        }
    }
}

















