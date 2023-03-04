package com.example.betterheadspace

import android.graphics.LinearGradient
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.betterheadspace.ui.theme.BetterHeadSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BetterHeadSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {


                    //background
                    linearGradient()

                    Column() {
                        CreateHeaderText(text = "Choose Headspace:")

                        Spacer(modifier = Modifier.height(12.dp))

                        CreateChillButton()
                        CreateGloomyButton()
                        CreateHappyButton()
                        CreateNintendoButton()
                        CreateSurpriseMeButton()
                    }



                }
            }
        }
    }
}


@Composable
fun CreateChillButton(){
    val mContext = LocalContext.current
    val list = listOf(
        R.raw.bedtime_after_a_coffee,
        R.raw.blue_boi,
        R.raw.faithful_mission,
        R.raw.lost_memories,
        R.raw.path_of_the_fireflies,
        R.raw.warm_horizon)

    Button(onClick = {



        val mMediaPlayer = MediaPlayer.create(mContext, list[(0..list.size).random()])

        mMediaPlayer.start()

    }, modifier = Modifier
        .padding(24.dp)
        .fillMaxWidth()
    ){
        Text(text = "Chill")
    }
}

@Composable
fun CreateGloomyButton(){
    val mContext = LocalContext.current

    val list = listOf(
        R.raw.blue_boi,
        R.raw.helen_2,
        R.raw.herbal_tea,
        R.raw.im_falling,
        R.raw.leaving,
        R.raw.lost_memories,
        R.raw.miss_you)

    Button(onClick = {

        val mMediaPlayer = MediaPlayer.create(mContext, list[(0..list.size).random()])
        mMediaPlayer.start()

    }, modifier = Modifier
        .padding(24.dp)
        .fillMaxWidth()
    ){
        Text("Gloomy")
    }
}

@Composable
fun CreateHappyButton(){
    val mContext = LocalContext.current
    val list = listOf(
        R.raw.and_so_it_begins,
        R.raw.whistle,
        R.raw.your_little_wings)

    Button(onClick = {

        val mMediaPlayer = MediaPlayer.create(mContext, list[(0..list.size).random()])
        mMediaPlayer.start()

    }, modifier = Modifier
        .padding(24.dp)
        .fillMaxWidth()
    ){
        Text(text = "Happy")
    }
}

@Composable
fun CreateSurpriseMeButton(){
    val mContext = LocalContext.current
    val list = listOf(
        R.raw.bedtime_after_a_coffee,
        R.raw.blue_boi,
        R.raw.faithful_mission,
        R.raw.path_of_the_fireflies,
        R.raw.warm_horizon,
        R.raw.helen_2,
        R.raw.herbal_tea,
        R.raw.im_falling,
        R.raw.leaving,
        R.raw.lost_memories,
        R.raw.miss_you,
        R.raw.and_so_it_begins,
        R.raw.whistle,
        R.raw.your_little_wings)

    Button(onClick = {
        val mMediaPlayer = MediaPlayer.create(mContext, list[(0..list.size).random()])
        mMediaPlayer.start()


    }, modifier = Modifier
        .padding(24.dp)
        .fillMaxWidth()
    ){
        Text(text = "Surprise Me")
    }
}

@Composable
fun CreateNintendoButton(){
    val mContext = LocalContext.current

    Button(onClick = {
        val mMediaPlayer = MediaPlayer.create(mContext, R.raw.nintendo_lofi)
        mMediaPlayer.start()

    }, modifier = Modifier
        .padding(24.dp)
        .fillMaxWidth()
    ){
        Text(text = "Nintendo")
    }
}


//calls background
@Composable
fun linearGradient() {
    val gradient = Brush.linearGradient(
        0.0f to Color.Magenta,
        500.0f to Color.Cyan,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Box(modifier = Modifier.background(gradient))
}

@Composable
fun CreateHeaderText(text: String){
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = text,
        textAlign = TextAlign.Center,
        style = TextStyle(
            fontSize = 24.sp,
            shadow = Shadow(
                color = Color.Black, offset = offset, blurRadius = 3f
            )
        ), modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxWidth()
    )
}

//calls logo
@Composable
fun ShowAppLogo(){

}


@Composable
fun ShowGreeting(greeting: String) {
    Text(text = "$greeting!")
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BetterHeadSpaceTheme {
        ShowGreeting("Android")
    }
}