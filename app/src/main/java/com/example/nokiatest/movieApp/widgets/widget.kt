package com.example.nokiatest.movieApp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.nokiatest.JetTipApp.R
import com.example.nokiatest.movieApp.model.Movie
import com.example.nokiatest.movieApp.model.getMovies


@Composable
fun MiniIconBox(icon: Painter,
                imageScale: Int,
                text: String,
                textSize: Int){
    Surface(
        modifier = Modifier.size(imageScale.dp),
        shape = RoundedCornerShape(CornerSize(5.dp)),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = icon,
                contentDescription = "mini detail icon",
                modifier = Modifier.size(imageScale.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = text,
                fontSize = textSize.sp,
                fontFamily = FontFamily.Monospace,
                color = Color.DarkGray
            )

        }
    }
}
@Composable
fun MovieRow(movie: Movie = getMovies()[0],
             onClick: (String) -> Unit = {}){

    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = with(Modifier) {
//            wrapContentHeight()
//            Why is still a short footage of each card still empty?
//              animated visibility or wrap components..?
            fillMaxWidth()
                .paint(
                    painter = painterResource(id = R.drawable.galaxy_background),
                    contentScale = ContentScale.FillBounds
                )
                .padding(top = 6.dp, bottom = 0.dp)
                .clickable { onClick(movie.id) }
        },
        colors = CardDefaults.cardColors(Color.Transparent),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 6.dp)
//                    .wrapContentSize(unbounded = false,
//                        align = Alignment.Center)
                ,
                shape = CircleShape,
                color = Color.Transparent,
                border = BorderStroke(0.2.dp, Color.LightGray)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = movie.images[0],
                        contentScale = ContentScale.Fit,
                    ),
                    contentDescription = "movie main image",
                    modifier = Modifier.size(130.dp)
                )
            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    text = movie.title.replaceFirst(
                        movie.title[0],
                        movie.title[0].uppercaseChar()
                    ),
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 25.sp,
                    maxLines = 1,
                    style = TextStyle.Default,
                    fontFamily = FontFamily.SansSerif,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = movie.director,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = Color.White
                )
                Text(
                    text = movie.year,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White
                )

                Icon(imageVector = if (expanded)
                    Icons.AutoMirrored.Filled.KeyboardArrowLeft
                else Icons.Default.KeyboardArrowDown,
                    contentDescription = "details arrow icon",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { expanded = !expanded },
                    tint = Color.White
                )

                AnimatedVisibility(
                    visible = expanded,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(buildAnnotatedString {
                            withStyle(ParagraphStyle(
                                textAlign = TextAlign.Start,
                                textIndent = TextIndent(4.sp, 2.sp),
                                lineHeight = TextUnit(4.0f, TextUnitType(8L)),
                            ), block = {
                                append("- " + movie.plot)
                            })
                        },
                            color = Color.White)

                        HorizontalDivider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            thickness = 1.4.dp,
                            color = Color.LightGray
                        )

                        Text(buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.White,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    shadow = Shadow(Color.DarkGray, blurRadius = 1.0f),
                                    textGeometricTransform = TextGeometricTransform(1.0f, 0.0f)
                                )
                            ) {
                                append("Country: ${movie.country}")
                            }
                        },)

                        Text(buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    color = Color.White,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    shadow = Shadow(Color.DarkGray, blurRadius = 1.0f),
                                    textGeometricTransform = TextGeometricTransform(1.1f, 0.0f),
                                    baselineShift = BaselineShift.Subscript
                                )
                            ) {
                                append("Language: ${movie.language}")
                            }
                        })
                    }
                }
            }
        }
//            Modifier.offset(x = 290.dp, y = (-40).dp)
//        changes the position of a component being shown, but not originally (like buttons!!)
    }
}

@Composable
fun ScrollableMovieGallery(theMovie: Movie) {
    LazyRow(
        modifier = Modifier.wrapContentHeight(unbounded = true),
        contentPadding = PaddingValues(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(theMovie.images.subList(1, theMovie.images.size - 1)) {
            Surface(
                modifier = Modifier
                    .size(width = 320.dp, height = 160.dp)
                    .padding(horizontal = 5.dp),
                shape = RoundedCornerShape(CornerSize(8.dp)),
                color = Color.Transparent,
                shadowElevation = 4.dp,
                border = BorderStroke(
                    2.5.dp, Color
                        (red = 38, green = 46, blue = 78, alpha = 213)
                )
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = it),
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