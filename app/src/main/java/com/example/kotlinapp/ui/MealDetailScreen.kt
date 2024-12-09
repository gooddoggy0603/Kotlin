package com.yourpackage.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.kotlinapp.data.Meal

@Composable
fun MealDetailScreen(meal: Meal) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = meal.strMeal, style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = rememberImagePainter(meal.strMealThumb),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(200.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Category: ${meal.strCategory}", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Instructions:", style = MaterialTheme.typography.h6)
        Text(text = meal.strInstructions, style = MaterialTheme.typography.body1)
    }
}
