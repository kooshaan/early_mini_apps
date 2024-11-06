package com.example.nokiatest.movieapp.screens.homeScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.nokiatest.JetTipApp.R
import com.example.nokiatest.movieapp.model.Movie
import com.example.nokiatest.movieapp.model.getMovies
import com.example.nokiatest.movieapp.navigation.MovieScreens
import com.example.nokiatest.movieapp.widgets.MovieAppTopAppBar
import com.example.nokiatest.movieapp.widgets.MovieRow
import com.example.nokiatest.ui.theme.Shapes


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(modifier: Modifier = Modifier,
               navController: NavController) {
    Scaffold(
        topBar = { MovieAppTopAppBar() }
    ) {
        MainContent(navController = navController)

    }
}
@Composable
fun MainContent(modifier: Modifier = Modifier,
                navController: NavController,
                movieList: List<Movie> = getMovies()){
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_small)),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movieList){
            Card(
                modifier = modifier,
                shape = Shapes.medium,
                colors = CardDefaults.cardColors(Color.Transparent)
            ) {
                MovieRow(
                    modifier = Modifier.fillMaxWidth(),
                    movie = it) { movieID ->
                    navController
                        .navigate(MovieScreens.MoreDetailsScreen.name + "/$movieID")
                    //DetailsScreen/Avatar??????????
                    Log.d("Clicked on", "MainContent: ${it.title}")
                }
            }
        }
    }
}
