package ru.cybereagleowl.modernfestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope
import ru.cybereagleowl.modernfestapp.ui.theme.ModernFestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authLauncher.launch(arrayListOf(VKScope.WALL, VKScope.PHOTOS))
        /*setContent {
            ModernFestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }*/
    }

    private val authLauncher = VK.login(this) { result: VKAuthenticationResult ->
        setContent {
            ModernFestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    when (result) {
                        is VKAuthenticationResult.Success -> {
                            // User passed authorization
                            Greeting("User passed authorization")
                        }
                        is VKAuthenticationResult.Failed -> {
                            // User didn't pass authorization
                            Greeting("User didn't pass authorization")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ModernFestAppTheme {
        Greeting("Android")
    }
}