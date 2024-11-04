package com.example.nokiatest.etc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nokiatest.JetTipApp.R

class ArtSpaceApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}
@Composable
fun App(){
    var shownArtworkID by remember {
        mutableIntStateOf(0)
    }


    val artworks: MutableList<Artwork> = mutableListOf(
        Artwork(pictureResourceID = painterResource(id = R.drawable.abstract_art),
            artworkTitle = "a lonely window",
            creator = "abcd",
            dateCreated = 2011)
    )
    BaseCanvas(shownID = shownArtworkID,
        artworksList = artworks
    ) { newVal ->
        shownArtworkID = newVal
    }
}

@Composable
fun BaseCanvas(shownID: Int,
               artworksList: MutableList<Artwork>,
               onValChange: (Int) -> Unit){
    val bruh: Array<Pair<Float, Color>> = arrayOf(
        0.0f to Color(red = 33, green = 39, blue = 63, alpha = 255),
        1.0f to Color(red = 251, green = 214, blue = 255, alpha = 255)
    )
    val buttonsColor = ButtonDefaults.buttonColors(
        Color(red = 105, green = 86, blue = 142, alpha = 255)
    )
    Box(modifier = Modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(CornerSize(8.dp)))
        .background(
            brush = Brush.verticalGradient(
                colorStops = bruh
            )
        ),
        contentAlignment = Alignment.TopCenter
    ){
        Surface(
            modifier = Modifier
                .clip(RoundedCornerShape(CornerSize(6.dp)))
                .padding(vertical = 4.dp, horizontal = 8.dp),
            color = Color.Transparent
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Surface(
                    modifier = Modifier
                        .requiredWidth(300.dp)
                        .requiredHeight(460.dp)
                        .clip(RoundedCornerShape(CornerSize(6.dp)))
                        .padding(top = 24.dp, bottom = 12.dp, start = 8.dp, end = 8.dp),
                    shadowElevation = 8.dp,
                    color = Color.Transparent
                ) {
                    Image(painter = artworksList[shownID].pictureResourceID,
                        contentDescription = "123",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.padding(32.dp)
                        )
                }
                Surface(
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 24.dp)
                        .clip(RoundedCornerShape(CornerSize(8.dp))),
                    color = Color(red = 63, green = 49, blue = 83, alpha = 156)) {
                    Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {

                        Text(text = artworksList[shownID].artworkTitle,
                            modifier = Modifier.padding(horizontal = 8.dp),
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.LightGray)

                        Row {
                            Text(text = buildAnnotatedString {
                                withStyle(SpanStyle(
                                    color = Color.LightGray,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.SemiBold
                                )) {
                                    append(artworksList[shownID].creator)
                                }
                            }, modifier = Modifier.padding(8.dp))

                            Text(text = buildAnnotatedString {
                                withStyle(SpanStyle(
                                    color = Color.LightGray,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    fontStyle = FontStyle.Italic,
                                    shadow = Shadow(Color.DarkGray, Offset(0.05f, 0.05f))
                                )) {
                                    append(artworksList[shownID].dateCreated.toString())
                                }
                            }, modifier = Modifier.padding(8.dp))
                        }
                    }
                }
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Transparent
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center) {

                        Button(
                            onClick = { onValChange(shownID - 1)},
                            modifier = Modifier.weight(1.0f, false),
                            colors = buttonsColor
                            ) {
                            Text(text = "Previous artwork")
                        }

                        Spacer(modifier = Modifier.weight(1.0f, true))

                        Button(
                            onClick = { onValChange(shownID + 1)},
                            modifier = Modifier.weight(1.0f, false),
                            colors = buttonsColor
                            ) {
                            Text(text = "Next creation")
                        }
                    }
                }
            }
        }
    }
}
data class Artwork(val pictureResourceID: Painter, val artworkTitle: String,
                   val creator: String, val dateCreated: Int)