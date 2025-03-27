package com.devtools.sphere.Components

import android.R.attr.textStyle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.devtools.sphere.R


class TextFields {


    @Composable
    fun textfield_normal() {

        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFAFAFA)),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFAFAFA),
                unfocusedBorderColor = Color(0xFFFAFAFA),
            ),
            textStyle  = TextStyle(color = MaterialTheme.colorScheme.secondary),


            )
    }

    @Composable
    fun textfield_With_Icon() {

        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFAFAFA)),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.outline_phone_24), // Reemplaza con tu ícono
                    contentDescription = null,
                    tint = Color(0xFF8F8C8C)
                )
            },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFAFAFA),
                unfocusedBorderColor = Color(0xFFFAFAFA),
            ),
            textStyle  = TextStyle(color = MaterialTheme.colorScheme.secondary),
            )
    }


    @Composable
    fun textfield_password() {

        val passwordVisible = remember { mutableStateOf(false) }

        var password by rememberSaveable { mutableStateOf("") }

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFAFAFA)),
            shape = RoundedCornerShape(12.dp),
            textStyle  = TextStyle(color = MaterialTheme.colorScheme.secondary),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                    visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image =
                    if (passwordVisible.value) R.drawable.baseline_remove else R.drawable.invisible_90

                IconButton(onClick = { passwordVisible.value = !passwordVisible.value },
                        modifier = Modifier.size(24.dp)
                ) {
                    Icon(painter = painterResource(id = image), contentDescription = null,
                        tint = Color(0xFF8F8C8C)
                    )

                }

            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFFAFAFA),
                unfocusedBorderColor = Color(0xFFFAFAFA),
            ),
        )
    }






}