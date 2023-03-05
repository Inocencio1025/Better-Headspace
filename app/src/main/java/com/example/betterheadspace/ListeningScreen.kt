package com.example.betterheadspace


import android.content.Context
import android.widget.Toast
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay


@Composable
fun ListeningScreen (navController: NavController, userMood: String) {

    val mContext = LocalContext.current

    var isFavorite by remember {
        mutableStateOf(false)
    }

    var isPlaying by remember {
        mutableStateOf(true)
    }

    var isChecked by remember {
        mutableStateOf(false)
    }


    suspend fun runAnimation() {
        while (MusicPlayer.mMediaPlayer.isPlaying) {
            delay(1000) // set here your delay between animations
            isChecked = !isChecked
        }
    }



    //for background
    LinearGradient()

    //clouds
    Box(modifier = (Modifier
        .fillMaxWidth(5f)
        .fillMaxHeight(.4f))){
        Image(
            painter = painterResource(id = R.mipmap.ic_clouds_foreground),
            contentDescription = "favorite",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .align(alignment = Alignment.Center))
    }
    Column {
        CreateHeaderText(text = userMood)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.15f)
                .padding(top = 12.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.Center

        ) {


            // favorite button
            Button(
                modifier = Modifier
                    .width(72.dp)
                    .fillMaxHeight(),
                onClick = {
                    isFavorite = !isFavorite
                    showFavToast(isFavorite, mContext)
                },
                colors= ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {


                if (!isFavorite){
                    Image(
                        painter = painterResource(id = R.drawable.ic_unfavorite),
                        contentDescription = "not favorite",
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.Black))
                }
                else {
                    Image(
                        painter = painterResource(id = R.drawable.ic_favorite),
                        contentDescription = "favorite",
                        modifier = Modifier.fillMaxSize())
                }


            }

            Spacer(modifier = Modifier.width(36.dp))

            // pause/play button
            Button(
                shape = CircleShape,
                modifier = Modifier
                    .size(72.dp),
                onClick = {
                    isPlaying = !isPlaying

                    if (MusicPlayer.mMediaPlayer.isPlaying)
                        MusicPlayer.mMediaPlayer.pause()
                    else
                        MusicPlayer.mMediaPlayer.start()
                },

                colors= ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {


                if (isPlaying) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_pause),
                        contentDescription = "pause",
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentScale = ContentScale.FillBounds
                    )
                }
                else {
                    Image(
                        painter = painterResource(id = R.drawable.ic_play),
                        contentDescription = "play",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Fit
                    )
                }
            }
            Spacer(modifier = Modifier.width(36.dp))

            // skip button
            Button(

                colors= ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                modifier = Modifier
                    .width(72.dp)
                    .fillMaxHeight(),
                onClick = { MusicPlayer.skipSong(mContext)

                }
            ){
                Text(
                    text = "SKIP",
                modifier = Modifier.fillMaxSize(),
                color = Color.White,
                textAlign = TextAlign.Center)
            }
        } //end row





        //feel good text
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.4f)
                .align(alignment = Alignment.CenterHorizontally)
        ){

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.5f)
                    //.background(color = Color.White)
                    .align(alignment = Alignment.CenterHorizontally)
            ){
                Text(
                    text = "How was your day?",
                    modifier = Modifier
                        .align(alignment = Alignment.Center),
                    style = TextStyle(fontSize = 24.sp)
                )
            }

            //textfeild
            var value by remember { mutableStateOf("") }
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .align(alignment = Alignment.CenterHorizontally)
                //.background(color = Color.Red)
            ) {
                TextField(
                    value = value,
                    onValueChange = { newText ->
                        value = newText
                    },
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            }


        }


        //for animation notes
        val transitionNotes = rememberInfiniteTransition()
        val num by transitionNotes.animateFloat(
            initialValue = 0f,
            targetValue = 2f,
            animationSpec = infiniteRepeatable(
                animation = tween(3000),
                repeatMode = RepeatMode.Restart
            )
        )
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.4f)
            .padding(horizontal = 48.dp)
            .align(alignment = Alignment.CenterHorizontally)
            //.background(color = Color.Red)

        ){
            if (num > 1f) {
                Image(
                    painter = painterResource(id = R.drawable.ic_notes_1),
                    contentDescription = "notes",
                    modifier = Modifier
                        .fillMaxSize()
                )}
            else {
                Image(
                    painter = painterResource(id = R.drawable.ic_notes_2),
                    contentDescription = "notes",
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }


        //for animation octy
        val transitionOcty = rememberInfiniteTransition()
        val num2 by transitionOcty.animateFloat(
            initialValue = 12f,
            targetValue = -12f,
            animationSpec = infiniteRepeatable(
                animation = tween(2000),
                repeatMode = RepeatMode.Reverse
            )
        )


        Spacer(modifier = Modifier.height(12.dp + num2.dp))
        Box(modifier = Modifier
            //.background(color = Color.White)
            .align(alignment = Alignment.CenterHorizontally)
            .fillMaxSize()
        ){

            Image(
                painter = painterResource(id = R.mipmap.ic_octy_foreground),
                contentDescription = "Octy",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillHeight
            )
        }
    } //end column


}

fun showFavToast(favorite: Boolean, context: Context) {
    var message =""
    if (favorite)
        message = "Added to Favorites"
    else
        message = "Removed from Favorites"

    val myToast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
    myToast.show()
}

