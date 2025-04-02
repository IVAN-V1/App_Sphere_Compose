package com.devtools.sphere.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devtools.sphere.ui.theme.SphereTheme

class Texts {



    @Composable
    fun Text_title(text: String, modifier: Modifier = Modifier){

        SphereTheme {

            Text(text,
                color = MaterialTheme.colorScheme.secondary,
                style =  MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

        }

    }


    @Composable
    fun titleMedium(text: String, modifier: Modifier){

        SphereTheme {

            Text(text,
                color = Color(0xFFA6A6A6),
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier
            )

        }

    }


    @Composable
    fun Text_body_medium(text: String){


        SphereTheme {

            Text(text,
                color = MaterialTheme.colorScheme.secondary,
                style =  MaterialTheme.typography.bodyMedium
            )

        }

    }


}