@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.nokiatest.movieApp.screens.homeScreen

import android.annotation.SuppressLint
import android.icu.lang.UCharacter.toUpperCase
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nokiatest.JetTipApp.R
import com.example.nokiatest.movieApp.model.Movie
import com.example.nokiatest.movieApp.model.getMovies
import com.example.nokiatest.movieApp.navigation.MovieScreens
import com.example.nokiatest.movieApp.widgets.MovieRow


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {Surface(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(60.dp),
            color = Color(red = 93, green = 108, blue = 111, alpha = 208)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                    TopAppBar(
                        modifier = Modifier
                            .height(80.dp),
                        colors = TopAppBarDefaults
                            .topAppBarColors(containerColor = Color.Transparent),
                        title = {
                            Text(
                                text = toUpperCase(stringResource(R.string.movies_main_title)),
                                modifier = Modifier.requiredWidth(160.dp),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 30.sp
                            )
                        })
                }
            }
        },
    ) {
            MainContent(navController = navController)

    }
}
@Composable
fun MainContent(navController: NavController,
                movieList: List<Movie> = getMovies()){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)) {
        LazyColumn {
            items(movieList){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
//                        .wrapContentHeight() comment commited in lazy column cards modifier
                        .wrapContentHeight(unbounded = true)
                        .padding(vertical = 4.dp)
                        .clip(RoundedCornerShape(CornerSize(8.dp)))

                ){
                    MovieRow(movie = it) { movieID ->
                        navController
                            .navigate(MovieScreens.MoreDetailsScreen.name + "/$movieID")
                        //DetailsScreen/Avatar??????????
                        Log.d("Clicked on", "MainContent: ${it.title}")
                    }
                }
            }
        }

    }
}
