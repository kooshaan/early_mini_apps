package com.example.nokiatest.movieApp.screens.moreDetailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.nokiatest.movieApp.model.Movie
import com.example.nokiatest.movieApp.model.getMovies

@Composable
fun MoreDetailsScreen(
    navController: NavController,
    movieID: String?
) {
    val theMovie: Movie = getMovies().filter { movie -> movie.id == movieID }[0]

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(red = 159, green = 166, blue = 192, alpha = 255)
    ) {
        Surface(
            modifier = with(Modifier) {
                fillMaxWidth()
                    .height(720.dp)
                    .padding(vertical = 12.dp, horizontal = 20.dp)
                    .clip(RoundedCornerShape(CornerSize(10.dp)))
            },
            color = Color(red = 94, green = 96, blue = 105, alpha = 255)
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = theMovie.images[0]),
                    contentDescription = "more-details-screen main poster",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .clip(RoundedCornerShape(CornerSize(10.dp))))

                Spacer(modifier = Modifier.width(60.dp))

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {

                }
            }

        }


    }
}