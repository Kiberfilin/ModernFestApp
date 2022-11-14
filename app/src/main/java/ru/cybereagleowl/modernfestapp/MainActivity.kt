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
import androidx.navigation.compose.rememberNavController
import ru.cybereagleowl.core_api.providers.facades.AppWithFacade
import ru.cybereagleowl.core_api.providers.facades.ProvidersFacade
import ru.cybereagleowl.modernfestapp.di.FacadeComponent
import ru.cybereagleowl.modernfestapp.navigation.ModernFestAppNavHost
import ru.cybereagleowl.modernfestapp.ui.theme.ModernFestAppTheme

class MainActivity : ComponentActivity() {
    lateinit var diRoot: ProvidersFacade
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        diRoot = FacadeComponent.init(this)
        //authLauncher.launch(arrayListOf(VKScope.WALL, VKScope.PHOTOS))
        setContent {
            ModernFestAppTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ModernFestAppNavHost(
                        navController = navController,
                        facade = diRoot,
                        activity = this
                    )
                }
            }
        }
    }

    /*private val authLauncher = VK.login(this) { result: VKAuthenticationResult ->
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
*/
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ModernFestAppTheme {
        //Greeting("Android")
        //NewsStub()
    }
}

/*
Navigation draft:

* Home
    -Concerts
    -News
* Media
    -Photo
    -Video
* Information
* Settings
    -Settings
    -Profile
    -About
 */
