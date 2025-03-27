package com.devtools.sphere.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devtools.sphere.R
import com.devtools.sphere.ui.theme.SphereTheme


class Buttons {

    @Composable
    fun ButtonLogin(text: String, onClick: () -> Unit) {


        SphereTheme {

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                onClick = onClick ,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            ) {

                Text(
                    text,
                    color = Color.White,
                    fontSize = 16.sp,
                )

            }


        }

    }


    @Composable
    fun buttonWithIcon(text: String, icon: Int ) {

        SphereTheme {

            // Botón Google
            OutlinedButton(
                onClick = { /* Google Sign-In */ },
                modifier = Modifier.fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),

                ) {

                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "Google",
                    modifier = Modifier.size(24.dp), // Ajusta el tamaño según sea necesario
                    tint = Color.Unspecified // Evita que el icono se tiña de blanco
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sign in with Google", color = Color.Black)
            }


        }



    }


}


