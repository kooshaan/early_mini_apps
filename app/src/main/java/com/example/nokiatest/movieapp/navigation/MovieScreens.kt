package com.example.nokiatest.movieapp.navigation

enum class MovieScreens {
    HomeScreen,
    DetailsScreen,
    MoreDetailsScreen;
    companion object{
        fun fromRoute(route: String?): MovieScreens
        = when (route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            MoreDetailsScreen.name -> MoreDetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("this route: $route is not recognized")
        }
    }
}