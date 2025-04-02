package com.devtools.sphere.View.LoginAndRegister.ResetPassword_


import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devtools.sphere.Components.Buttons
import com.devtools.sphere.Components.Texts
import com.devtools.sphere.ui.theme.SphereTheme


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Reset_verificationEmail_view(nextView: () -> Unit = {} ) {
    val texts = Texts()
    val buttoms = Buttons()


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
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {


                    texts.Text_title("Verification Code")

                    Spacer(modifier = Modifier.height(8.dp))

                    texts.titleMedium("Please enter the code we just sent to email",
                        Modifier.align(Alignment.CenterHorizontally)

                    )

                    Text(text = "Johndeo@email.com", fontWeight = FontWeight.Bold,
                        color = Color.Black , modifier = Modifier.clickable{})



                    Spacer(modifier = Modifier.height(16.dp))

                  OTPInputScreen()

                    Spacer(modifier = Modifier.height(16.dp))
                    buttoms.ButtonLogin("Continue", nextView)



                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "If you didn’t receive a code?", color = Color.Gray)
                        Text(text = "Resend", fontWeight = FontWeight.Bold,
                            color = Color.Black , modifier = Modifier.clickable{

                            })
                    }
                }



            }


        }


    }


}


@Composable
fun OTPInputScreen() {
    var otp by remember { mutableStateOf("") }

    // Función para generar las celdas del OTP
    fun generateOTPCells() = (0 until 4).map { index ->
        if (index < otp.length) otp[index].toString()
        else ""
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            generateOTPCells().forEachIndexed { index, value ->
                OTPCell(
                    value = value,
                    onValueChange = { newValue ->
                        if (newValue.isNotEmpty() && otp.length < 6) {
                            otp = otp + newValue
                        } else if (newValue.isEmpty() && otp.isNotEmpty()) {
                            otp = otp.dropLast(1)
                        }
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        }
}

@Composable
fun OTPCell(
    value: String,
    onValueChange: (String) -> Unit
) {
    var textState by remember { mutableStateOf(TextFieldValue(value)) }

    BasicTextField(
        value = textState,
        onValueChange = { newValue ->
            if (newValue.text.length <= 1) {
                textState = newValue
                onValueChange(newValue.text)
            }
        },
        textStyle = MaterialTheme.typography.bodySmall.copy(color = Color.Black),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        singleLine = true,
        modifier = Modifier
            .width(70.dp)
            .height(70.dp)
            .padding(10.dp)
            .border(1.dp, Color.Gray)
            .fillMaxWidth()
            ,
    )

}