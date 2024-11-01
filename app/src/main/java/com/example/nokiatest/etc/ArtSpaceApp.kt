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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    BaseCanvas(shownID = shownArtworkID) { newVal ->
        shownArtworkID = newVal
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BaseCanvas(shownID: Int = 0,
               onValChange: (Int) -> Unit = {}){
    val bruh: Array<Pair<Float, Color>> = arrayOf(
        0.0f to Color(red = 33, green = 39, blue = 63, alpha = 255),
        1.0f to Color(red = 217, green = 245, blue = 245, alpha = 255)
    )
    Box(modifier = Modifier
        .clip(RoundedCornerShape(CornerSize(8.dp)))
        .background(
            brush = Brush.linearGradient(
                colorStops = bruh,
                start = Offset(Float.MAX_VALUE, 0.0f),
                end = Offset(0.0f, Float.MAX_VALUE)
            )
        )
        .wrapContentSize(align = Alignment.Center, true),
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
                        .clip(RoundedCornerShape(CornerSize(6.dp)))
                        .padding(vertical = 8.dp, horizontal = 8.dp),
                    shadowElevation = 8.dp,
                    color = Color.Transparent
                ) {
                    Image(painter = painterResource(id = R.drawable.avatar),
                        contentDescription = "123")
                }
                Surface(color = Color.Transparent) {
                    Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "artwork title")
                        Row {
                            Text(text = buildAnnotatedString {
                                withStyle(SpanStyle()) {
                                    append("artist name")
                                }
                            })
                            Text(text = buildAnnotatedString {
                                withStyle(SpanStyle()) {
                                    append("year created")
                                }
                            })
                        }
                    }
                }
                Surface {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center) {
                        Button(
                            onClick = { onValChange(shownID - 1)},
                            modifier = Modifier.weight(1.0f, false)
                            ) {
                            Text(text = "Previous artwork")
                        }
                        Spacer(modifier = Modifier.weight(4.0f, true))
                        Button(
                            onClick = { onValChange(shownID + 1)},
                            modifier = Modifier.weight(1.0f, false)
                            ) {
                            Text(text = "Next creation")
                        }
                    }
                }
            }
        }
    }
}