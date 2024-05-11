package com.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.components.ButtonComponent
import com.app.components.ClickableLoginTextComponent
import com.app.components.DividerTextComponent
import com.app.components.MyTextField
import com.app.components.PasswordTextField
import com.app.data.login.LoginViewModel
import com.app.data.signup.SignupUIEvent
//import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.data.signup.SignupViewModel
import com.app.navigation.RecipeFinderAppRouter
import com.app.navigation.Screen
import com.example.deneme31.R
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
@Composable
fun SignUpScreen(signupViewModel: SignupViewModel = viewModel()) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFE49E00))
                .padding(24.dp),

            ){
            ProvideWindowInsets {


                Column (
                    Modifier
                        .navigationBarsWithImePadding()
                        .padding(24.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.Bottom),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    //FOR OUR LOGO
                    Icon(
                        painter = painterResource(id = R.drawable.logo),
                        null,
                        Modifier.size(80.dp),
                        tint = colorResource(id = R.color.buttonColor)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    //USERNAME TEXT FIELD
                    MyTextField(
                        labelValue = stringResource(id = R.string.first_name),
                        painterResource(id = R.drawable.profile),
                        onTextChanged = {
                            signupViewModel.onEvent(SignupUIEvent.FirstNameChanged(it))
                        },
                        errorStatus = signupViewModel.registrationUIState.value.firstNameError
                    )
                    //SURNAME TEXT FIELD
                    MyTextField(
                        labelValue = stringResource(id = R.string.last_name),
                        painterResource = painterResource(id = R.drawable.profile),
                        onTextChanged = {
                            signupViewModel.onEvent(SignupUIEvent.LastNameChanged(it))
                        },
                        errorStatus = signupViewModel.registrationUIState.value.lastNameError
                    )
                    //EMAIL TEXT FIELD
                    MyTextField(
                        labelValue = stringResource(id = R.string.email),
                        painterResource = painterResource(id = R.drawable.email),
                        onTextChanged = {
                            signupViewModel.onEvent(SignupUIEvent.EmailChanged(it))
                        },
                        errorStatus = signupViewModel.registrationUIState.value.emailError
                    )
                    //PASSWORD TEXT FIELD
                    PasswordTextField(
                        labelValue = stringResource(id = R.string.password),
                        painterResource = painterResource(id = R.drawable.baseline_lock_24),
                        onTextSelected = {
                            signupViewModel.onEvent(SignupUIEvent.PasswordChanged(it))
                        },
                        errorStatus = signupViewModel.registrationUIState.value.passwordError
                    )

                    Spacer(modifier = Modifier.height(40.dp)) //For creating a space between password field and Register button


                    ButtonComponent(
                        value = stringResource(id = R.string.register),
                        onButtonClicked = {
                            signupViewModel.onEvent(SignupUIEvent.RegisterButtonClicked)
                        },
                        isEnabled = signupViewModel.allValidationsPassed.value
                    )

                    DividerTextComponent()

                    ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                        RecipeFinderAppRouter.navigateTo(Screen.LoginScreen)
                    })

                }
            }
        }
        if(signupViewModel.signUpInProgress.value) {
            CircularProgressIndicator()
        }
    }
}
@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
}
