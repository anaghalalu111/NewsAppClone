package com.example.newsappclone.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsappclone.model.Category

@Composable
fun CategoryCard( category: Category,isSelected:Boolean,OnClick:()->Unit) {
        Card(
            modifier = Modifier
                .width(100.dp)
                .height(120.dp)
                .padding(8.dp)
                .clickable { OnClick() },
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(3.dp)
        ) {
            Column(
               modifier = Modifier
                   .align(Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    painter = painterResource(id = category.imageResId),
                    modifier = Modifier
                        .width(300.dp)
                        .height(70.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = "Business image"
                )
                Spacer(modifier = Modifier.height(2.dp))
                
                Text(text = category.title, fontSize = 12.sp, fontWeight = FontWeight.Medium)

            }


        }
    }

