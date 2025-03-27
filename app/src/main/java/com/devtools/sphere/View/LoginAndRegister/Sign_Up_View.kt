package com.devtools.sphere.View.LoginAndRegister

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
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devtools.sphere.Components.Buttons
import com.devtools.sphere.Components.TextFields
import com.devtools.sphere.Components.Texts
import com.devtools.sphere.ui.theme.SphereTheme


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SignUpView(nexView: () -> Unit = {} ) {
    val texts = Texts()
    val buttoms = Buttons()

    val textFields = TextFields()

    SphereTheme {


        Scaffold(


            topBar = {


                TopAppBar(

                    title = {
                        IconButton(onClick = { /* Acción de regreso */ }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }

                    },

                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.secondary,
                    ),
                )


            },

          bottomBar = {
              Column(
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(bottom = 24.dp), // Add padding to separate from the bottom
                  horizontalAlignment = Alignment.CenterHorizontally,
              ) {
                  Text(text = "By clicking Register, you agree to our", color = Color.Gray)
                  Text(
                      text = "Terms and Data Policy.",
                      fontWeight = FontWeight.Bold,
                      color = Color.Black
                  )
              }
          }

        ) { innerPadding ->


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background((MaterialTheme.colorScheme.primary)),
            ) {


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight().
                        padding(innerPadding)
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),

                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,

                    ) {


                    texts.Text_title("Sign Up")

                    Spacer(modifier = Modifier.height(8.dp))

                    texts.titleMedium("Create account and choose favorite menu",
                        Modifier.align(Alignment.Start)

                    )


                    Spacer(modifier = Modifier.height(24.dp))

                    // Campo Email
                    texts.Text_body_medium("Name")

                    textFields.textfield_normal()


                    Spacer(modifier = Modifier.height(16.dp))

                    // Campo Email
                    texts.Text_body_medium("Email")

                    textFields.textfield_normal()

                    Spacer(modifier = Modifier.height(16.dp))

                    // Campo Password
                    texts.Text_body_medium("Password")

                    textFields.textfield_password()


                    Spacer(modifier = Modifier.height(16.dp))


                    buttoms.ButtonLogin("Register",nexView)

                    Spacer(modifier = Modifier.height(16.dp))

                    // Enlace "Sign Up"
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Have an account?", color = Color.Gray)
                        Text(text = "Sign In", fontWeight = FontWeight.Bold,
                            color = Color.Black , modifier = Modifier.clickable{

                            })
                    }

                    Spacer(modifier = Modifier.height(100.dp))


                }


            }


        }


    }


}

