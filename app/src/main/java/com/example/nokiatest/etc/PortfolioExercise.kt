package com.example.nokiatest.etc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nokiatest.JetTipApp.R
import com.example.nokiatest.ui.theme.NokiaTestTheme

class PortfolioExercise : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NokiaTestTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    CreateBaseCard()
                }
            }
        }
    }
}
@Composable
fun CreateBaseCard (){
    val buttonClickState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(),
        color = Color.White) {
        Card(modifier = Modifier.padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                AvatarCreator()
                HorizontalDivider(modifier = Modifier
                    .size(300.dp, 30.dp)
                    .padding(0.dp, 10.dp),
                                    thickness = 0.9.dp,
                                    color = Color.DarkGray)
                InfoCreator()
                Button(
                    onClick = { buttonClickState.value = !buttonClickState.value
                    }
                ) {
                    Text(text = "Education",
                        modifier = Modifier.padding(4.dp),
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Monospace)
                }
                if (buttonClickState.value)
                     ButtonContent()
            }
        }
    }
}

@Composable
private fun InfoCreator() {
    Column(modifier = Modifier.padding(4.dp)) {
        Text(
            text = "Malek Mohammad K.",
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            fontSize = 26.sp,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Android Compose Programmer",
            modifier = Modifier.padding(3.dp),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = Color.DarkGray
        )
        Text(
            text = "@malekmohammadkooshan",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(2.dp),
            color = Color.DarkGray
        )
    }
}

@Composable
private fun AvatarCreator(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(165.dp)
            .padding(start = 18.dp),
        shadowElevation = 4.dp,
        shape = RectangleShape,
        border = BorderStroke(1.5.dp, Color.LightGray),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "face of kooshan",
            modifier = modifier.size(120.dp),
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
fun ButtonContent(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(3.dp),
            color = Color.White,
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(2.5.dp, Color.LightGray)
        ){
            Portfolio(data = listOf("Diploma degree",
                "License degree",
                "Masters"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn { items(data) {
        item -> Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(3.dp),
        ) {
                Row(modifier = Modifier
                    .padding(10.dp)
                    .background(Color.White)
                    .padding(2.dp)) {
                    AvatarCreator(modifier = Modifier.size(90.dp))
                    Column(modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically),
                            ) {
                        Text(text = item,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold)
                        Text(text = "Well, something like nothing ", color = Color.Black,
                            fontFamily = FontFamily.Default,
                            fontSize = 14.sp)
                    }
             }

    }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NokiaTestTheme {

    }
}