@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.nokiatest.movieapp.screens.detailsScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nokiatest.JetTipApp.R
import com.example.nokiatest.movieapp.model.Movie
import com.example.nokiatest.movieapp.model.getMovies
import com.example.nokiatest.movieapp.widgets.HorizontalBigDivider
import com.example.nokiatest.movieapp.widgets.MovieAppTopAppBar
import com.example.nokiatest.movieapp.widgets.ScrollableMovieGallery

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(modifier: Modifier = Modifier,
                  navController: NavController,
                  movieID: String? = "0") {

    val theMovie: Movie = getMovies().filter { it.id == movieID }[0]

    Scaffold(
        topBar = { MovieAppTopAppBar()}
    ) {
        Surface(modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(CornerSize(9.dp)))
            .paint(
                painter = painterResource(id = R.drawable.mainbackground),
                false,
                contentScale = ContentScale.FillBounds
            ),
            color = Color.Transparent) {
            Column {
                Spacer(modifier = Modifier.height(100.dp))


                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    ScrollableMovieGallery(theMovie = theMovie)
                }

                HorizontalBigDivider()


                Row {
                    Column(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(buildAnnotatedString {
                            withStyle(SpanStyle(
                                fontSize = 24.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Cursive
                            )){
                                append("Director: \n\t\t")
                            }
                            withStyle(
                                SpanStyle(
                                fontSize = 22.sp,
                                color = Color.White,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily.Cursive
                            )
                            ){
                                append("${theMovie.director}\n")
                            }
                            withStyle(SpanStyle(
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )){
                                append("Genre: ")
                            }
                            withStyle(SpanStyle(
                                fontSize = 14.sp,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )){
                                append("\n\t${theMovie.genre}\n\n")
                            }
                            withStyle(
                                SpanStyle(
                                    fontSize = 15.5.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily.Serif,
                                    textGeometricTransform =
                                    TextGeometricTransform(1.3f)
                                )
                            ){
                                append("Country & Year: \n\t${theMovie.country}" +
                                        ",${theMovie.year}\n\n")
                            }
                            withStyle(
                                SpanStyle(
                                    fontSize = 18.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily.Serif
                                )
                            ){
                                append("Language: \n\t${theMovie.language}")
                            }
                        })
                    }
                    VerticalDivider(
                        modifier = Modifier.height(280.dp),
                        thickness = 2.5.dp,
                        color = Color
                            (red = 196, green = 196, blue = 196, alpha = 158)
                    )
                    Column {

                    }
                }
            }
        }
    }
}