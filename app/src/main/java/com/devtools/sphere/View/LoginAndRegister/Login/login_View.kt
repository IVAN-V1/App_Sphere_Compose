package com.devtools.sphere.View.LoginAndRegister.Login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devtools.sphere.Components.Buttons
import com.devtools.sphere.Components.TextFields
import com.devtools.sphere.Components.Texts
import com.devtools.sphere.R
import com.devtools.sphere.ui.theme.SphereTheme


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Login_View(NexView: () -> Unit = {},reset_password: () -> Unit = {}, NexView_Home: () -> Unit ) {

    val texts = Texts()
    val buttoms = Buttons()

    val textFields = TextFields()

    SphereTheme {


        Scaffold(
            modifier = Modifier.fillMaxWidth(),
            topBar = {

                TopAppBar(

                    title = {
                        // Flecha de regreso
                        IconButton(onClick = { /* Acción de regreso */ }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = MaterialTheme.colorScheme.secondary
                            )
                        }

                    },

                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),

                    )

            }


        ) { innerPadding ->


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
                    .background((MaterialTheme.colorScheme.primary)),
            ) {


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),

                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,

                    ) {


                    Spacer(modifier = Modifier.height(16.dp))


                    texts.Text_title("Welcome Back 👋")

                    Spacer(modifier = Modifier.height(8.dp))

                    texts.titleMedium("Sign to your account",
                        Modifier.align(Alignment.Start)

                    )


                    Spacer(modifier = Modifier.height(24.dp))

                    // Campo Email
                    texts.Text_body_medium("Email")


                    textFields.textfield_normal()

                    Spacer(modifier = Modifier.height(16.dp))

                    texts.Text_body_medium("Password")


                    textFields.textfield_password()


                    Spacer(modifier = Modifier.height(8.dp))

                    // Enlace "Forgot Password?"
                    Text(
                        text = "Forgot Password?",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Start).
                        clickable(onClick =

                            reset_password

                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))


                    buttoms.ButtonLogin("Login",NexView_Home)

                    Spacer(modifier = Modifier.height(16.dp))

                    // Enlace "Sign Up"
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Don’t have an account?", color = Color.Gray)
                        Text(
                            text = " Sign Up",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.clickable {

                                NexView()
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Divider
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        Text(text = "  Or with  ", color = Color(0xFF575555))
                        Spacer(modifier = Modifier.weight(1f))
                    }

                    Spacer(modifier = Modifier.height(24.dp))


                    buttoms.buttonWithIcon(text = "Sign in with Google", icon = R.drawable.google)
                    Spacer(modifier = Modifier.height(16.dp))


                    buttoms.buttonWithIcon(text = "Sign in my Apple ", icon = R.drawable.logoapple)


                }


            }


        }


    }


}



