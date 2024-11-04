package com.example.nokiatest.movieapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nokiatest.movieapp.navigation.MovieNavigation
import com.example.nokiatest.ui.theme.NokiaTestTheme

class MovieApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NokiaTestTheme {
                MyApp {
                    MovieNavigation()
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyApp(modifier: Modifier = Modifier,
          content: @Composable () -> Unit){
        content()
}

@Preview
@Composable
fun MovieAppDarkThemePreview(){
    NokiaTestTheme(darkTheme = true) {
        MyApp {
            MovieNavigation()
        }
    }
}
