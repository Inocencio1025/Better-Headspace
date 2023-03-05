package com.example.betterheadspace

import android.content.Context
import android.media.MediaPlayer

object MusicPlayer {
    var mMediaPlayer = MediaPlayer()
    var currentMusicList = listOf<Int>()



    //all music
    val chillMusic = listOf(
        R.raw.bedtime_after_a_coffee,
        R.raw.blue_boi,
        R.raw.faithful_mission,
        R.raw.lost_memories,
        R.raw.path_of_the_fireflies,
        R.raw.warm_horizon)

    val gloomyMusic = listOf(
        R.raw.blue_boi,
        R.raw.helen_2,
        R.raw.herbal_tea,
        R.raw.im_falling,
        R.raw.leaving,
        R.raw.lost_memories,
        R.raw.miss_you)

    val happyMusic = listOf(
        R.raw.and_so_it_begins,
        R.raw.whistle,
        R.raw.your_little_wings)

    val allMusic = listOf(
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

    val nintendoMusic = listOf(
        R.raw.nintendo_lofi
    )

    fun choosePlaylist(mood: String){
        currentMusicList = when (mood){
            "Chill" -> chillMusic
            "Gloomy" -> gloomyMusic
            "Happy" -> happyMusic
            "Nintendo" -> nintendoMusic
            else -> allMusic
        }
    }

    fun startMusic(context: Context){
        stopMusic()
        mMediaPlayer = MediaPlayer.create( context,currentMusicList[(currentMusicList.indices).random()])
        mMediaPlayer.start()
    }

    fun stopMusic(){
        mMediaPlayer.stop()
        mMediaPlayer.release()
    }

    fun skipSong(context: Context){
        stopMusic()
        mMediaPlayer = MediaPlayer.create( context,currentMusicList[(currentMusicList.indices).random()])
        mMediaPlayer.start()
    }


}