
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devtools.sphere.Core.Navigation.NavigationWrapper
import com.devtools.sphere.ui.theme.SphereTheme
import com.devtools.sphere.R;



@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun SplashView() {

    SphereTheme {

        Scaffold(

            modifier = Modifier.fillMaxSize(),


            topBar = {

                TopAppBar(

                    title = {

                        Text("")
                    },

                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        titleContentColor = MaterialTheme.colorScheme.secondary,
                    ),

                    )


            }

        )

        { innerPadding ->


            Box(
                modifier = Modifier.padding(innerPadding).
                fillMaxSize().
                background(MaterialTheme.colorScheme.secondary),
               contentAlignment = Alignment.Center,


                ) {


                Column(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.Center,
                    Alignment.CenterHorizontally,


                    ) {


                }

                Image(
                    painter = painterResource(id = R.drawable.sphere),
                    contentDescription = null,
                    modifier = Modifier.size(150.dp)
                )

            }

        }


    }


}







