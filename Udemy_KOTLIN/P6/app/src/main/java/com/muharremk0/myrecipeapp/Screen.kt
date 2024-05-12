package com.muharremk0.myrecipeapp

sealed class Screen(val route: String) {
    object RecipeScreen:Screen("recipescreen")
    object DetailScreen:Screen("detailscreen")
}