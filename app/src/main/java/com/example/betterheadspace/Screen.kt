package com.example.betterheadspace

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object ListeningScreen : Screen("listening_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
