package com.devtools.sphere.View.LoginAndRegister.ResetPassword_

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devtools.sphere.Components.Buttons
import com.devtools.sphere.Components.SelectableCard
import com.devtools.sphere.Components.Texts
import com.devtools.sphere.R
import com.devtools.sphere.ui.theme.SphereTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun fotgotPasswordView(nextView_email: () -> Unit = {}, nextView_phone: () -> Unit = {}) {

    val texts = Texts()
    val buttoms = Buttons()


    val selectedCard = remember { mutableStateOf("Email") }

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


            ) { innerPadding ->


            Box(

                modifier = Modifier
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.primary),
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


                    texts.Text_title("Forgot Password")

                    Spacer(modifier = Modifier.height(16.dp))



                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        Arrangement.Center,
                        Alignment.CenterVertically


                    ) {

                        texts.titleMedium(
                            "Select which contact details should we use to reset your password",
                            Modifier.align(Alignment.CenterVertically)
                        )

                    }


                    Spacer(modifier = Modifier.height(16.dp))


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        SelectableCard(
                            "Email",
                            "Send to your email",
                            R.drawable.email_bulk,
                            selectedCard.value == "Email"
                        ) {
                            selectedCard.value = "Email"

                        }


                        Spacer(modifier = Modifier.width(4.dp))
                        SelectableCard(
                            "Phone",
                            "Send to your phone",
                            R.drawable.phone,
                            selectedCard.value == "Phone"
                        ) {
                            selectedCard.value = "Phone"

                        }
                    }


                    Spacer(modifier = Modifier.height(16.dp))
                    buttoms.ButtonLogin("Continue") {

                        if (selectedCard.value == "Email") {
                            nextView_email()
                        } else {
                            nextView_phone()
                        }
                    }


                }


            }


        }


    }


}



