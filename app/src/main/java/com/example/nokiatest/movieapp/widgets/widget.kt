@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.nokiatest.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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
import com.example.nokiatest.movieapp.model.Movie
import com.example.nokiatest.movieapp.model.getMovies


@Composable
fun MiniIconBox( modifier: Modifier = Modifier,
                 icon: Int,
                 text: String,
                 textSize: Int,
){
    Surface(
        modifier = Modifier.size(height = 60.dp, width = 50.dp ),
        color = Color.Transparent
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = icon),
                contentDescription = "mini icons detail",
                modifier = modifier.size(25.dp, 25.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = text,
                modifier = Modifier,
                fontSize = textSize.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )


        }
    }
}
@Composable
fun MovieRow(modifier: Modifier = Modifier,
             movie: Movie = getMovies()[0],
             onClick: (String) -> Unit = {}){

    var expanded by remember {
        mutableStateOf(false)
    }

    val changedColor by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiary
        else MaterialTheme.colorScheme.primary,
        label = ""
    )

    Card(modifier = modifier.clickable { onClick(movie.id) },
        colors = CardDefaults.cardColors(changedColor)
    ) {
        Row(modifier = Modifier.animateContentSize(animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Surface(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 6.dp)
                    .wrapContentHeight(unbounded = false)

//                    .wrapContentSize(unbounded = false,
//                        align = Alignment.Center)
                ,
                shape = CircleShape,
                color = Color.Transparent
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = movie.images[0],
                        contentScale = ContentScale.Crop,
                    ),
                    contentDescription = "movie main image",
                    modifier = Modifier.requiredSize(140.dp)
                )
            }
            Column(modifier = Modifier.padding(4.dp)
            ) {
                Text(
                    text = movie.title.replaceFirst(
                        movie.title[0],
                        movie.title[0].uppercaseChar()
                    ),
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 25.sp,
                    maxLines = 1,
                    fontFamily = FontFamily.SansSerif,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.displayMedium
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
            }
        }
        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + expandHorizontally { 200 },
            exit = fadeOut() + shrinkHorizontally { 200 }
        ){
            Column(
                modifier = Modifier
                    .padding(
                        top = 4.dp, bottom = 8.dp,
                        start = 8.dp, end = 8.dp
                    )
                    .background(color = changedColor),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Text(buildAnnotatedString {
                    withStyle(ParagraphStyle(
                        textAlign = TextAlign.Justify,
                        textIndent = TextIndent(2.sp, 4.sp),
                        lineHeight = TextUnit(4.0f, TextUnitType(8L)),
                    ), block = {
                        append("- " + movie.plot)
                    })
                },
                    color = Color.White)

                HorizontalBigDivider()
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(painter = painterResource(id = R.drawable.country_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .size(20.dp))
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    shadow = Shadow(Color.DarkGray, blurRadius = 1.0f),
                                    textGeometricTransform =
                                    TextGeometricTransform(1.0f, 0.0f)
                                )
                            ) {
                                append("Country: ${movie.country}")
                            }
                        },
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    Icon(painter = painterResource(id = R.drawable.language_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .size(20.dp)
                            )

                    Text(buildAnnotatedString {
                        withStyle(
                            SpanStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                shadow = Shadow(Color.DarkGray, blurRadius = 1.0f),
                                textGeometricTransform =
                                TextGeometricTransform(1.1f, 0.0f)
                            )
                        ) {
                            append("Language: ${movie.language}")
                        }
                    })
                }
            }
        }
//            Modifier.offset(x = 290.dp, y = (-40).dp)
//        changes the position of a component being shown,
        //        but not originally (like buttons!!)
    }
}

@Composable
fun ScrollableMovieGallery(modifier: Modifier = Modifier,
                           theMovie: Movie) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 6.dp),
        shape = RoundedCornerShape(CornerSize(10.dp)),
        color = Color.Transparent,

        ) {
        LazyRow(
            modifier = Modifier.wrapContentHeight(unbounded = true),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(theMovie.images.subList(1, theMovie.images.size - 2)) {
                Surface(
                    modifier = Modifier
//                        .fillMaxSize()
                        .size(width = 270.dp, height = 180.dp)
                        .padding(end = 5.dp),
                    shape = RoundedCornerShape(CornerSize(5.dp)),
                    color = Color.Transparent,
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = it),
                        contentDescription = "a photo of movies gallery",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier.wrapContentWidth(
                            align = Alignment.CenterHorizontally, unbounded = false)
                    )
                }
            }
        }
    }
}
@Composable
fun HorizontalBigDivider(modifier: Modifier = Modifier) {
    HorizontalDivider(
        modifier = modifier
            .padding(horizontal = 4.dp, vertical = 8.dp)
            .fillMaxWidth(),
        thickness = 2.3.dp,
        color = MaterialTheme.colorScheme.onPrimary
    )
}

@Composable
fun MovieAppTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically)
            {
                Image(painter = painterResource(id = R.drawable.film_clapperboard_icon),
                    contentDescription = "top app bar logo",
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)))

                Text(text = stringResource(id = R.string.movieApp_name),
                    style = MaterialTheme.typography.displayLarge)
            }
        },
        modifier = modifier
    )
}