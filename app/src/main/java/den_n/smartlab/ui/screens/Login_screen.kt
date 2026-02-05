package den_n.smartlab.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import den_n.smartlab.R

@Composable
fun Login_screen(navController: NavController) {
    val enterEmail = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(20.dp, 0.dp)
            .fillMaxSize(),
//        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .padding(0.dp, 50.dp, 0.dp, 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .padding(0.dp, 0.dp, 10.dp, 0.dp)
                    .size(32.dp)
                ,
                painter = painterResource(R.drawable.hello_hand),
                contentDescription = "",
            )
            Text(
                text = "Добро пожаловать!",
                fontSize = 24.sp,
            )
        }
        Text(
            text = "Войдите, чтобы пользоваться функциями приложения",
        )
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 65.dp)
            ,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "Вход по E-mail",
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                ,
                value = enterEmail.value,
                onValueChange = { newValue ->
                    enterEmail.value = newValue
                },

                placeholder = {
                    Text(text = "example@mail.ru")
                },
                shape = RoundedCornerShape(20),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                )
            )
            val emailRegex = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$")
            Button(
                onClick = {
                    navController.navigate("Email_confirm_screen")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff1A6FEE),
                ),
                shape = RoundedCornerShape(20),
                enabled = emailRegex.matches(enterEmail.value)

            ) {
                Text(
                    text = "Далее",
                    fontSize = 20.sp,
                )
            }
        }
    }
}