package com.devtools.sphere.View.LoginAndRegister.ResetPassword_

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devtools.sphere.Components.Buttons
import com.devtools.sphere.Components.Texts
import com.devtools.sphere.R
import com.devtools.sphere.ui.theme.SphereTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun Congratulation_view_newpassword(nexView: () -> Unit = {} ) {
    val texts = Texts()
    val buttoms = Buttons()


    SphereTheme {


        Scaffold(


            topBar = {

            },


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

                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {


                    Spacer(modifier = Modifier.height(16.dp))

                    Image(
                        painter = painterResource(id = R.drawable.congratulation),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.height(100.dp).fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))


                    Text("Password Changed!!",
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 24.sp,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    texts.titleMedium("Password changed successfully, you can login again with a new password",
                        Modifier.align(Alignment.CenterHorizontally))


                    Spacer(modifier = Modifier.height(24.dp))


                    buttoms.ButtonLogin("Login",nexView)

                    Spacer(modifier = Modifier.height(16.dp))



                }


            }


        }


    }


}
