package com.devtools.sphere.Components

import android.R.attr.text
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devtools.sphere.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.devtools.sphere.Model.OnboardingPage
import com.devtools.sphere.ui.theme.SphereTheme


@Composable
fun OnboardingScreen(nextView: () -> Unit = {}) {
    var currentIndex by remember { mutableIntStateOf(0) }

    val pages = listOf(
        OnboardingPage(
            imageRes = R.drawable.img_1, // Reemplaza con tu imagen
            title = "Now reading books \n will be easier",
            description = "Discover new worlds, join a vibrant reading community. Start your reading adventure effortlessly with us."
        ),
        OnboardingPage(
            imageRes = R.drawable.soulmate, // Reemplaza con otra imagen
            title = "Your Bookish Soulmate \n Awaits",
            description = "Let us be your guide to the perfect read. Discover books tailored to your tastes for a truly rewarding experience."
        ),

        OnboardingPage(
            imageRes = R.drawable.aventure, // Reemplaza con otra imagen
            title = "Start Your Adventure",
            description = "Ready to embark on a quest for inspiration and knowledge? Your adventure begins now. Let's go!"
        )
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LazyRow {


            item {
                val item = pages[currentIndex]
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.height(400.dp).fillMaxWidth()
                )
            }

        }


        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = pages[currentIndex].title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = pages[currentIndex].description,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(16.dp))


        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            pages.forEachIndexed { index, _ ->
                Canvas(modifier = Modifier.size(15.dp).padding(4.dp)) {
                    drawCircle(
                        color = if (index == currentIndex) Color.Black else Color.Gray,
                        radius = if (index == currentIndex)  size.minDimension / 2 else size.minDimension / 3
                    )
                }
            }

        }



        Button(
            modifier = Modifier.fillMaxWidth().
            height(60.dp),

            onClick = {

                currentIndex = (currentIndex + 1) % pages.size

                if (currentIndex == pages.size - 1) {
                   nextView()
                }

            },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            shape = MaterialTheme.shapes.medium
        ) {

            Text(
                "Continue",
                color = MaterialTheme.colorScheme.primary
            )

        }



        Spacer(modifier = Modifier.height(16.dp))


        Button(
            modifier = Modifier.fillMaxWidth().
            height(60.dp),
            onClick = {  },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary),
            shape = MaterialTheme.shapes.medium
        ) {

            Text(
                "Sign in",
                color = MaterialTheme.colorScheme.
                secondary
            )

        }

    }
}






