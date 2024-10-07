@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.nokiatest.movieApp.screens.detailsScreen

import android.annotation.SuppressLint
import android.icu.lang.UCharacter.toUpperCase
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.nokiatest.JetTipApp.R
import com.example.nokiatest.movieApp.model.Movie
import com.example.nokiatest.movieApp.model.getMovies

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movie: String?) {

    val theMovie: Movie = getMovies().filter { it.id == movie }[0]

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
                                text = toUpperCase("the movie"),
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 30.sp
                            )
                        }
                    },
                    navigationIcon = {
                        Surface(color = Color.Transparent) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "back button",
                                modifier = Modifier
                                    .clickable { navController.popBackStack() }
                                    .size(35.dp)
                                    .clip(RoundedCornerShape(CornerSize(20.dp)))
                                    .border(
                                        3.dp,
                                        Color.DarkGray,
                                        shape = RoundedCornerShape(size = 15.dp)
                                    )
                            )
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
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(120.dp))

                Text(
                    text = theMovie.title,
                    fontSize = 50.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )

                HorizontalDivider(
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 4.dp)
                        .fillMaxWidth(),
                    thickness = 2.5.dp,
                    color = Color
                        (red = 27, green = 6, blue = 80, alpha = 235)
                )

                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    LazyRow(
                        modifier = Modifier.wrapContentHeight(unbounded = true),
                        contentPadding = PaddingValues(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        items(theMovie.images.subList(1, theMovie.images.size - 1)){
                            Surface(
                                modifier = Modifier
                                    .size(width = 320.dp, height = 160.dp)
                                    .padding(horizontal = 5.dp),
                                shape = RoundedCornerShape(CornerSize(8.dp)),
                                color = Color.Transparent,
                                shadowElevation = 4.dp,
                                border = BorderStroke(2.5.dp, Color
                                    (red = 38, green = 46, blue = 78, alpha = 213))
                            ) {
                                Image(painter = rememberAsyncImagePainter(model = it),
                                    contentDescription = "a photo of movies gallery",
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(CornerSize(8.dp)))
                                        .padding(2.5.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}