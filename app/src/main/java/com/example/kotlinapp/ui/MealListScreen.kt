package com.yourpackage.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.kotlinapp.data.Meal

@Composable
fun MealListScreen(meals: List<Meal>, onMealClick: (Meal) -> Unit) {
    LazyColumn {
        items(meals) { meal ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { onMealClick(meal) },
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp
            ) {
                Row(modifier = Modifier.padding(8.dp)) {
                    Image(
                        painter = rememberImagePainter(meal.strMealThumb),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = meal.strMeal,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}
