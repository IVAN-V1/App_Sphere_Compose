package com.devtools.sphere

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.devtools.sphere.Core.Navigation.NavigationWrapper
import com.devtools.sphere.ui.theme.SphereTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(Color(0xFFFFFFFF).toArgb(), Color.Transparent.toArgb()),
            navigationBarStyle =  SystemBarStyle.light(Color(0xFFFFFFFF).toArgb(), Color.Transparent.toArgb()),

        )

        val spashScreen = installSplashScreen()
        spashScreen.setKeepOnScreenCondition{true}



       CoroutineScope(Dispatchers.IO).launch {

           delay(2000)
           spashScreen.setKeepOnScreenCondition{false}
       }




        setContent {
            SphereTheme {

                NavigationWrapper().Navigation()

            }


        }

    }
}

