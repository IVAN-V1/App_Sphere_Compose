package com.devtools.sphere.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.devtools.sphere.Components.OnboardingScreen
import com.devtools.sphere.ui.theme.SphereTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable

@Preview
fun start_View(nextView: () -> Unit = {}) {


    SphereTheme {


        Box(
            modifier = Modifier
                .padding(16.dp)
                .background(color = MaterialTheme.colorScheme.primary)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {

                Spacer(modifier = Modifier.height(32.dp))
                Text("Skip", Modifier.padding(start = 16.dp))

                OnboardingScreen(nextView)


            }

        }

    }


}



