package com.example.betterheadspace

import android.media.MediaPlayer
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.betterheadspace.ui.theme.lilita
import com.example.betterheadspace.ui.theme.rampartone


var userMood = ""

@Composable
fun MainScreen (navController: NavController){

    //background
    LinearGradient()


    Column(
        modifier = Modifier.fillMaxSize()
    ) {




        CreateHeaderText(text = "Choose Headspace:")




        CreateChillButton(navController)
        CreateGloomyButton(navController)
        CreateHappyButton(navController)
        CreateNintendoButton(navController)
        CreateSurpriseMeButton(navController)

    }



}


@Composable
fun CreateChillButton(navController: NavController){
    val mContext = LocalContext.current

    Button(onClick = {
        userMood = "Chill"
        MusicPlayer.choosePlaylist(userMood)
        navController.navigate(Screen.ListeningScreen.withArgs(userMood))



        MusicPlayer.startMusic(mContext)

    }, modifier = Modifier
        .padding(24.dp)
        .fillMaxWidth()
        .height(64.dp),
        shape = RoundedCornerShape(50)
    ){

        Text(text = "Chill", fontFamily = lilita,
            style = TextStyle(fontSize = 40.sp))
    }

}

@Composable
fun CreateGloomyButton(navController: NavController){
    val mContext = LocalContext.current
    Button(onClick = {
        userMood = "Gloomy"
        MusicPlayer.choosePlaylist(userMood)
        navController.navigate(Screen.ListeningScreen.withArgs(userMood))
        MusicPlayer.startMusic(mContext)

    }, modifier = Modifier
        .padding(24.dp)
        .fillMaxWidth()
        .height(64.dp),
        shape = RoundedCornerShape(50)
    ){
        Text("Gloomy", fontFamily = lilita,
            style = TextStyle(fontSize = 40.sp))
    }
}

@Composable
fun CreateHappyButton(navController: NavController){
    val mContext = LocalContext.current
    Button(onClick = {
        userMood = "Happy"
        MusicPlayer.choosePlaylist(userMood)
        navController.navigate(Screen.ListeningScreen.withArgs(userMood))
        MusicPlayer.startMusic(mContext)
    }, modifier = Modifier
        .padding(24.dp)
        .fillMaxWidth()
        .height(64.dp),
        shape = RoundedCornerShape(50)
    ){
        Text(
            text = "Happy",
            fontFamily = lilita,
            style = TextStyle(fontSize = 40.sp)
        )
    }
}

@Composable
fun CreateSurpriseMeButton(navController: NavController){
    val mContext = LocalContext.current
    Button(onClick = {
        userMood = "Shuffle"
        MusicPlayer.choosePlaylist(userMood)
        navController.navigate(Screen.ListeningScreen.withArgs(userMood))
        MusicPlayer.startMusic(mContext)

    }, modifier = Modifier
        .padding(24.dp)
        .fillMaxWidth()
        .height(64.dp),
        shape = RoundedCornerShape(50)
    ){
        Text(text = "Surprise Me", fontFamily = lilita,
            style = TextStyle(fontSize = 40.sp))
    }
}

@Composable
fun CreateNintendoButton(navController: NavController){
    val mContext = LocalContext.current
    Button(onClick = {
        userMood = "Nintendo"
        MusicPlayer.choosePlaylist(userMood)
        navController.navigate(Screen.ListeningScreen.withArgs(userMood))
        MusicPlayer.startMusic(mContext)
    }, modifier = Modifier
        .padding(24.dp)
        .fillMaxWidth()
        .height(64.dp),
        shape = RoundedCornerShape(50)
    ){
        Text(text = "Nintendo", fontFamily = rampartone,
            style = TextStyle(fontSize = 40.sp))
    }
}




@Composable
fun CreateHeaderText(text: String){
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = text,
        textAlign = TextAlign.Center,
        style = TextStyle(
            fontSize = 36.sp,
            shadow = Shadow(
                color = Color.Black, offset = offset, blurRadius = 3f
            )
        ), modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(12.dp))
}

//calls logo
@Composable
fun ShowAppLogo(){

}
//calls background
@Composable
fun LinearGradient() {
    val gradient = Brush.linearGradient(
        0.0f to Color.Magenta,
        500.0f to Color.Cyan,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Box(modifier = Modifier
        .background(gradient)
        .fillMaxSize())
}