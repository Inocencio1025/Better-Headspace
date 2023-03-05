package com.example.betterheadspace.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.betterheadspace.ListeningScreen
import com.example.betterheadspace.MainScreen
import com.example.betterheadspace.Screen
import com.example.betterheadspace.userMood

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {


        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }


        composable(route = Screen.ListeningScreen.route + "/{mood}",
        arguments = listOf(
            navArgument("mood") { type = NavType.StringType }
        )
        ) { entry ->
            entry.arguments?.getString("mood")
                ?.let { ListeningScreen(navController = navController, userMood = it) }
        }
    }
}