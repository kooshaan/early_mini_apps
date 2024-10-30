package com.example.nokiatest.movieapp.screens.moreDetailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.nokiatest.JetTipApp.R
import com.example.nokiatest.movieapp.model.Movie
import com.example.nokiatest.movieapp.model.getMovies
import com.example.nokiatest.movieapp.widgets.MiniIconBox
import com.example.nokiatest.movieapp.widgets.ScrollableMovieGallery
import com.skydoves.cloudy.cloudy

@Composable
fun MoreDetailsScreen(
    navController: NavController,
    movieID: String?
) {
    val theMovie: Movie = getMovies().filter { movie -> movie.id == movieID }[0]
    val colorBreakPoints = arrayOf(
        0.0f to Color(red = 78, green = 79, blue = 83, alpha = 255),
        1.0f to Color(red = 227, green = 228, blue = 228, alpha = 255)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = rememberAsyncImagePainter(model = theMovie.images[0]),
            contentDescription = "base blur background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .cloudy(170),
            alpha = 0.80f)
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = with(Modifier) {
                    fillMaxWidth()
                        .requiredHeight(215.dp)
                        .padding(top = 30.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
                        .background(brush = Brush.verticalGradient(
                            colorStops = colorBreakPoints
                            ),
                            shape = RoundedCornerShape(CornerSize(10.dp))
                        )
                        .clip(RoundedCornerShape(CornerSize(10.dp)))

                },
                color = Color.Transparent
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Surface(
                        modifier = Modifier
//                            .size(width = 155.dp, height = 204.dp)
                            .padding(5.dp),
                        shape = RoundedCornerShape(CornerSize(10.dp)),
                        color = Color.Transparent
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = theMovie.images[0]),
                            contentDescription = "more-details-screen main poster",

                            contentScale = ContentScale.FillHeight

                        )
                    }

                    Spacer(modifier = Modifier.width(30.dp))

                    Column {
                        MiniIconBox(
                            icon = R.drawable.director_icon,
                            text = theMovie.director,
                            textSize = 11
                        )
                        MiniIconBox(
                            icon = R.drawable.year_icon,
                            text = theMovie.year,
                            textSize = 11
                        )

                        MiniIconBox(
                            icon = R.drawable.awards_icon,
                            text = theMovie.awards.substringBefore('.'),
                            textSize = 11
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Column {
                        MiniIconBox(
                            icon = R.drawable.category_icon,
                            text = theMovie.genre,
                            textSize = 11
                        )
                        MiniIconBox(
                            icon = R.drawable.country_icon,
                            text = theMovie.country,
                            textSize = 11
                        )

                        MiniIconBox(
                            icon = R.drawable.rating_icon,
                            text = theMovie.imdbRating,
                            textSize = 11
                        )
                    }
                    Spacer(modifier = Modifier.width(5.dp))
                    Column {
                        MiniIconBox(
                            icon = R.drawable.duration_icon,
                            text = theMovie.runtime,
                            textSize = 11
                        )

                        MiniIconBox(
                            icon = R.drawable.language_icon,
                            text = theMovie.language,
                            textSize = 11
                        )

                        MiniIconBox(
                            icon = R.drawable.parent_guide_icon,
                            text = theMovie.rated,
                            textSize = 11
                        )


                    }
                }

            }
            Surface(
                shape = RoundedCornerShape(CornerSize(10.dp)),
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(240.dp)
                    .padding(horizontal = 10.dp),
                color = MaterialTheme.colorScheme.background

            ){
                Row {
                    Column {
                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    SpanStyle(
                                        color = MaterialTheme.colorScheme.onBackground,
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight.Bold
                                    )
                                ) {
                                    append("Summary")
                                }
                            },
                            modifier = Modifier
                                .padding(top = 12.dp, start = 12.dp, end = 12.dp),
                        )
                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    ParagraphStyle(
                                        TextAlign.Justify,
                                        textDirection = TextDirection.Ltr,
                                        lineHeight = 18.sp,
                                        textIndent = TextIndent(firstLine = 6.sp, restLine = 0.sp)
                                    )
                                ) {
                                    append(theMovie.plot)
                                }
                            },
                            modifier = Modifier
                                .padding(top = 12.dp, start = 12.dp, end = 8.dp)
                                .width(170.dp),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                    Column {
                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    SpanStyle(
                                        color = MaterialTheme.colorScheme.onBackground,
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily.Default,
                                        fontWeight = FontWeight.Bold
                                    )
                                ) {
                                    append("Insight")
                                }
                            },
                            modifier = Modifier
                                .padding(start = 0.dp, end = 12.dp,
                                    top = 12.dp, bottom = 12.dp)
                        )

                        Box(
                            modifier = Modifier
                                .padding(start = 4.dp, end = 5.dp, bottom = 0.dp)
                                .clip(RoundedCornerShape(CornerSize(8.dp)))
                                .size(height = 187.dp, width = 136.dp)
                                .border(
                                    0.55.dp,
                                    Color.DarkGray,
                                    shape = RoundedCornerShape(
                                        CornerSize(8.dp)
                                    )
                                )
                                .background(Color.Transparent),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(
                                    model =
                                    theMovie.images[theMovie.images.size - 1]
                                ),
                                modifier = Modifier.fillMaxSize(),
                                contentDescription = "Trailer poster",
                                contentScale = ContentScale.FillBounds,
                                alpha = 0.86f,
                                alignment = Alignment.Center
                            )
                        }

                    }
                }

            }
            ScrollableMovieGallery(theMovie = theMovie)
        }
    }
}