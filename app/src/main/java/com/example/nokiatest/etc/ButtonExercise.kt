package com.example.nokiatest.etc

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ButtonExercise : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                Surface(color = colorScheme.background) {
                        TheApp()

                }

        }
    }

    @Composable
    private fun TheApp() {
        var amount by remember {
            mutableIntStateOf(100)
        }
        Surface(modifier = Modifier.fillMaxSize(),
                color = Color.Transparent) {
            Column (verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally){
                Text("In his name we trust", fontSize = 36.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.DarkGray,
                    fontStyle = FontStyle.Normal,
                    textDecoration = TextDecoration.None,
                    letterSpacing = TextUnit.Unspecified,
                    )
                Spacer(modifier = Modifier.height(150.dp))
                Text(text = "$amount", fontSize = 40.sp,
                    color = Color.Magenta,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.height(20.dp))
                CircleButton(amount) { incrementedValue -> amount = incrementedValue }
                SquareButton(amount) { decrementedValue -> amount = decrementedValue }
            }

        }
    }

    @Composable
    fun SquareButton(amount: Int, decrementMe: (Int) -> Unit) {
        Card(modifier = Modifier
            .size(84.dp, 84.dp)
            .padding(6.dp)
            .clickable {
                decrementMe(amount - 1)
                Log.d("Decrement", "SquareButton: -1 applied")
            },
            shape = CardDefaults.elevatedShape,
            border = BorderStroke(2.dp, Color.LightGray)
        ) {
            Box (contentAlignment = Alignment.Center) {
                Text(text = "-TAP-", Modifier.fillMaxHeight()
                    .fillMaxWidth().wrapContentSize(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center)
            }

        }
    }

}

@Composable
fun CircleButton(amount: Int, incrementMe: (Int) -> Unit){
    Card(modifier = Modifier
        .padding(10.dp)
        .size(210.dp)
        .clickable {
            incrementMe(amount + 1)
            Log.d("Oops", "CircleButton: ${amount + 1}")
        },
        shape = CircleShape,
        colors = CardDefaults.cardColors(Color.LightGray),
        elevation = CardDefaults.cardElevation(12.dp)
    ){
        Box(modifier = Modifier.clip(CircleShape),
            contentAlignment = Alignment.Center){
            Text(text = "+TAP+",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .wrapContentSize(),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp
            )
        }
    }
}
