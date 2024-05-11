package com.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.app.components.ButtonComponent
import com.app.components.ClickableLoginTextComponent
import com.app.components.MyTextField
import com.app.components.PasswordTextField
import com.app.data.login.LoginUIEvent
import com.app.data.login.LoginViewModel
import com.app.navigation.RecipeFinderAppRouter
import com.app.navigation.Screen
import androidx.lifecycle.viewmodel.compose.viewModel
//import com.app.R
import com.app.components.*
import com.app.navigation.SystemBackButtonHandler
import com.example.deneme31.R
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding


@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
                .background(Color(0xFFE49E00)),
        ) {
            ProvideWindowInsets { //WHEN KEYBOARD OPENS,THIS METHOD SCROLLS OUR FUNCTIONS TO UP
                Column(
                    Modifier
                        .navigationBarsWithImePadding()
                        .padding(24.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Bottom),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //FOR OUR LOGO
                    Icon(
                        painter = painterResource(id = R.drawable.logo),
                        null,
                        Modifier.size(80.dp),
                        tint = colorResource(id = R.color.buttonColor)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    //2 TEXT AREAS
                    MyTextField(
                        labelValue = stringResource(id = R.string.email),
                        painterResource(id = R.drawable.email),
                        onTextChanged = {
                            loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
                        },
                        errorStatus = loginViewModel.loginUIState.value.emailError
                    )

                    PasswordTextField(
                        labelValue = stringResource(id = R.string.password),
                        painterResource(id = R.drawable.baseline_lock_24),
                        onTextSelected = {
                            loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
                        },
                        errorStatus = loginViewModel.loginUIState.value.passwordError
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    //FOR SIGN IN BUTTON
                    ButtonComponent(
                        value = stringResource(id = R.string.login),
                        onButtonClicked = {
                            loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                        },
                        isEnabled = loginViewModel.allValidationsPassed.value
                    )
                    //FOR WHITE LINE WE USE DIVIDER
                    Divider(
                        color = Color.White.copy(alpha = 0.3f),
                        thickness = 1.dp,
                        modifier = Modifier.padding(top = 48.dp)
                    )
                    //SIGN UP PAGE
                    ClickableLoginTextComponent(
                        tryingToLogin = false,
                        onTextSelected = {
                            RecipeFinderAppRouter.navigateTo(Screen.SignUpScreen)
                        })
                }
            }
        }
        if(loginViewModel.loginInProgress.value) {
            CircularProgressIndicator()
        }

    }
    SystemBackButtonHandler {
        RecipeFinderAppRouter.navigateTo(Screen.SignUpScreen)
    }
}