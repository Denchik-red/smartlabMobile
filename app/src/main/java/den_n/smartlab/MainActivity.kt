package den_n.smartlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import den_n.smartlab.ui.screens.Create_password_screen
import den_n.smartlab.ui.screens.Email_confirm_screen
import den_n.smartlab.ui.screens.First_info_screen
import den_n.smartlab.ui.screens.Second_info_screen
import den_n.smartlab.ui.screens.Third_info_screen
import den_n.smartlab.ui.screens.Load_screen
import den_n.smartlab.ui.screens.Login_screen

val Roboto = FontFamily(Font(R.font.roboto))
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "Create_password_screen"
            ) {
                composable("Load_screen") { Load_screen(navController) }
                composable("First_info_screen") { First_info_screen(navController) }
                composable("Second_info_screen") { Second_info_screen(navController) }
                composable("Third_info_screen") { Third_info_screen(navController) }
                composable("Login_screen") { Login_screen(navController) }
                composable("Email_confirm_screen") { Email_confirm_screen(navController) }
                composable("Create_password_screen") { Create_password_screen() }
            }
        }
    }
}

