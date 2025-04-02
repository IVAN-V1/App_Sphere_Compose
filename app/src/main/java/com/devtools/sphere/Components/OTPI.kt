package com.devtools.sphere.Components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devtools.sphere.ui.theme.SphereTheme
import com.devtools.sphere.ui.theme.openSansFontFamily

@Preview
@Composable
fun OTPInputScreen() {
    var otp by remember { mutableStateOf("") }

    // Función para generar las celdas del OTP
    fun generateOTPCells() = (0 until 4).map { index ->
        if (index < otp.length) otp[index].toString()
        else ""
    }


    SphereTheme {

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


}

@Composable
fun OTPCell(
    value: String,
    onValueChange: (String) -> Unit
) {
    var textState by remember { mutableStateOf(TextFieldValue(value)) }


    SphereTheme {

        TextField(
            value = textState.text,
            onValueChange = { newValue ->
                if (newValue.length <= 1) {
                    textState = TextFieldValue(newValue)
                    onValueChange(newValue)
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier
                .width(70.dp)
                .height(75.dp)
                .padding(10.dp)
                .border(3.dp, Color.Gray, shape = RoundedCornerShape(12.dp)
                ),
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.secondary,
                fontFamily = openSansFontFamily,
                fontSize = 24.sp
            )
            )
    }

}

