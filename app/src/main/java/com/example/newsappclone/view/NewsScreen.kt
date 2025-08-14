package com.example.newsappclone.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.newsappclone.model.Article
import com.example.newsappclone.model.Category
import com.example.newsappclone.viewmodel.NewsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen( category: String,viewModel: NewsViewModel, navController: NavController) {

    /*Data fetched from the state variable in view model to the UI for displaying to the user*/
    val newsList by viewModel.news.collectAsState()


    Scaffold(
        topBar = { TopAppBar(title = { Text(text= category) },
            modifier = Modifier.padding(2.dp),
            colors = TopAppBarDefaults.topAppBarColors(
            Color.Transparent),
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back button" )

                }
            }
            )
        }

    ) {innerPadding->
        
/*check if the data is available*/

        newsList?.articles?.let { articleList ->
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                items(articleList) { article ->
                    NewsCard(article)
                }
            }
        }
    }
    }
    @Composable
    fun NewsCard(article: Article) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .width(290.dp)
                    .padding(bottom = 4.dp)
                    .height(450.dp)
                    .clickable { OnClick },
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            )
            {
                Column(
                    modifier = Modifier
                        .height(470.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                   AsyncImage(model = article.urlToImage,
                       contentDescription ="News image",
                       modifier = Modifier
                           .height(320.dp)
                           .clip(RoundedCornerShape(4.dp)),
                       alignment = Alignment.Center,
                       contentScale = ContentScale.Crop)

                    Text(
                        text = article.title ?: "No Title",
                        style = MaterialTheme.typography.headlineMedium,
                        fontSize = 10.sp, textAlign = TextAlign.Center,
                        modifier = Modifier.padding(3.dp),
                        letterSpacing = 0.02.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 12.sp
                    )

                    Text(
                        text = article.description ?: "No description",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(3.dp),
                        fontWeight = FontWeight.Medium,
                        letterSpacing = 0.02.sp,
                        lineHeight = 10.sp,
                        color = Color.LightGray,
                        maxLines = 4
                    )

                    Text(
                        text = article.content ?: "No content",
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(3.dp),
                        letterSpacing = 0.02.sp,
                        lineHeight = 10.sp,
                        maxLines = 3
                    )
                }
            }
        }
    }

















