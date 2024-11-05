package com.example.nokiatest.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nokiatest.movieapp.screens.detailsScreen.DetailsScreen
import com.example.nokiatest.movieapp.screens.homeScreen.HomeScreen
import com.example.nokiatest.movieapp.screens.moreDetailsScreen.MoreDetailsScreen

@Composable
fun MovieNavigation(){
    val navigationController = rememberNavController()
    NavHost(navController = navigationController,
            startDestination = MovieScreens.HomeScreen.name){

        composable(MovieScreens.HomeScreen.name){
            HomeScreen(navController = navigationController)
        }

        //www.google.com/sing-in/for?what?=
        //DetailsScreen/Avatar/{movie}
        composable(
            route = MovieScreens.DetailsScreen.name+"/{movie}",
            arguments = listOf(navArgument(name = "movie"){type = NavType.StringType})
        ){
            backStackEntry ->
            DetailsScreen(
                navController = navigationController,
                movieID = backStackEntry.arguments?.getString("movie")
            )
        }

        composable(
            route = MovieScreens.MoreDetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie"){type = NavType.StringType})
        ){
            backStackEntry ->
            MoreDetailsScreen(
                navController = navigationController,
                backStackEntry.arguments?.getString("movie")
                )
        }
    }

}