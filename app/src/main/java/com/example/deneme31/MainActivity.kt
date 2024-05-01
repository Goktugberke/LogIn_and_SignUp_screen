package com.juraj.fancyloginscreen

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.deneme31.R
//import com.goktugberkegungoren.recipefinder.R
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.example.deneme31.ui.theme.Deneme31Theme
import com.juraj.fancyloginscreen.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Deneme31Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color( 0xFFE49E00)
                ) {
                    Login()
                }
            }
        }
    }


}
//WHEN PRESSED LOG IN BUTTON
private fun Context.doLogin() {
        // If username and password is true
       // val intent = Intent(this, SignUpDoneActivity::class.java)
      //  startActivity(intent)

}



//LOGIN PAGE
@Composable
fun Login() {
    val context = LocalContext.current
    val passwordFocusRequester = FocusRequester()
    val focusManager = LocalFocusManager.current


    //WHEN KEYBOARD OPENS,THIS METHOD SCROLLS OUR FUNCTIONS TO UP
    ProvideWindowInsets {
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
            //2 TEXT AREAS
            TextInput(InputType.Name, keyboardActions = KeyboardActions(onNext = {
                passwordFocusRequester.requestFocus()
            }))
            TextInput(InputType.Password, keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
                context.doLogin()
            }), focusRequester = passwordFocusRequester)
            //FOR SIGN IN BUTTON
            Button(onClick = {
                context.doLogin()
            }, modifier = Modifier.fillMaxWidth()) {
                Text("SIGN IN", Modifier.padding(vertical = 8.dp))
            }
            //FOR WHITE LINE WE USE DIVIDER
            Divider(
                color = Color.White.copy(alpha = 0.3f),
                thickness = 1.dp,
                modifier = Modifier.padding(top = 48.dp)
            )
            //SIGN UP PAGE
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Don't have an account?", color = Color.Black)
                TextButton(onClick = {}) {
                    Text("SING UP")
                }
            }
        }
    }
}

sealed class InputType(
    val label: String,
    val icon: ImageVector,
    val keyboardOptions: KeyboardOptions,
    val visualTransformation: VisualTransformation
) {
    object Name : InputType(
        label = "Username",
        icon = Icons.Default.Person,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )

    object Password : InputType(
        label = "Password",
        icon = Icons.Default.Lock,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation()
    )
}

@OptIn(ExperimentalMaterial3Api::class)//buraya bunu ekledii satır 167 için
@Composable
fun TextInput(
    inputType: InputType,
    focusRequester: FocusRequester? = null,
    keyboardActions: KeyboardActions
) {
    var value by remember { mutableStateOf("") }

    TextField(
        value = value,
        onValueChange = { value = it },
        modifier = Modifier
            .fillMaxWidth()
            .focusOrder(focusRequester ?: FocusRequester()),
        leadingIcon = { Icon(imageVector = inputType.icon, null) },
        label = { Text(text = inputType.label) },
        shape = Shapes.small,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        singleLine = true,
        keyboardOptions = inputType.keyboardOptions,
        visualTransformation = inputType.visualTransformation, // for showing password with points
        keyboardActions = keyboardActions
    )
}
