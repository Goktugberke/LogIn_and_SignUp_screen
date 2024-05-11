package com.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.app.navigation.RecipeFinderAppRouter
import com.app.navigation.Screen
import com.app.screens.LoginScreen
import com.app.screens.SignUpScreen
import com.app.screens.HomeScreen

@Composable
fun RecipeFinderApp(){
    Surface(modifier = Modifier.fillMaxSize(),
            color = Color( 0xFFE49E00)
    ) {
        if (homeViewModel.isUserLoggedIn.value == true) {
            RecipeFinderAppRouter.navigateTo(Screen.HomeScreen)
        }

        Crossfade(targetState = RecipeFinderAppRouter.currentScreen) { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }



                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.HomeScreen -> {
                   HomeScreen()
                }
            }
        }

    }
}
