@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.nokiatest.movieapp.screens.detailsScreen

import android.annotation.SuppressLint
import android.icu.lang.UCharacter.toUpperCase
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nokiatest.JetTipApp.R
import com.example.nokiatest.movieapp.model.Movie
import com.example.nokiatest.movieapp.model.getMovies
import com.example.nokiatest.movieapp.navigation.MovieScreens
import com.example.nokiatest.movieapp.widgets.HorizontalBigDivider
import com.example.nokiatest.movieapp.widgets.ScrollableMovieGallery

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movieID: String?) {

    val theMovie: Movie = getMovies().filter { it.id == movieID }[0]

    Scaffold(
        topBar = {
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){

                TopAppBar(
                    title = {
                        Surface(color = Color.Transparent) {
                            Text(
                                text = toUpperCase(theMovie.title),
                                fontWeight = FontWeight.ExtraBold,
                                textDecoration = TextDecoration.Underline,
                                fontSize = 40.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    navigationIcon = {
                        Row {
                            Surface(color = Color.Transparent) {
                                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "back button",
                                    modifier = Modifier
                                        .clickable { navController.popBackStack() }
                                        .size(35.dp)
                                        .border(
                                            3.dp,
                                            Color.DarkGray,
                                            shape = RoundedCornerShape(size = 15.dp)
                                        )
                                )
                            }
                            Spacer(modifier = Modifier.width(100.dp))

                            Surface(color = Color.Transparent) {
                                Icon(imageVector = Icons.Default.MoreVert,
                                    contentDescription = "More-Details_Screen entry",
                                    modifier = Modifier
                                        .size(35.dp)
                                        .clickable { navController.navigate(route = MovieScreens.MoreDetailsScreen.name + "/${theMovie.id}") })
                            }
                        }
                    },
                    colors = TopAppBarDefaults
                        .topAppBarColors(
                            containerColor = Color.Transparent
                        )
                )
            }
        }
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
                    ScrollableMovieGallery(theMovie)
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