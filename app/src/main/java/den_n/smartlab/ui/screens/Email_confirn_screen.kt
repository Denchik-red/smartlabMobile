package den_n.smartlab.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import den_n.smartlab.R
import den_n.smartlab.Roboto
import kotlinx.coroutines.delay

@Composable
fun Email_confirm_screen(navController: NavController) {

    Box(
        modifier = Modifier
            .padding(20.dp)
            .size(50.dp)
            .offset(0.dp, 0.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF5F5F9))
            .clickable{
                navController.navigate("Login_screen")
            }
        ,
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.back_icon),
            contentDescription = null,
            modifier = Modifier
                .size(32.dp)
            ,
        )
    }
    Column(
        modifier = Modifier
            .padding(top = 250.dp)
            .fillMaxSize()
            .clickable{
                navController.navigate("Create_password_screen")
            }
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            text = "Введите код из E-mail",
            fontSize = 20.sp,
            fontWeight = FontWeight.W100,
            fontFamily = Roboto,
        )
        InputNumberFields()

    }
}

@Composable
fun InputNumberFields(
) {
    val digits = remember { mutableStateListOf("", "", "", "") }
    val focusRequester = remember { List(4) { FocusRequester() } }
    Row(
        modifier = Modifier
            .padding(top = 20.dp)
        ,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        repeat(4) {index ->
            BasicTextField(

                modifier = Modifier
                    .size(48.dp)
                    .focusRequester(focusRequester[index])
                    .onPreviewKeyEvent {event ->
                        if (event.key == Key.Backspace &&
                            event.type == KeyEventType.KeyDown &&
                            digits[index].isEmpty() &&
                            index > 0) {
                            focusRequester[index-1].requestFocus()
                            digits[index-1] = ""
                            return@onPreviewKeyEvent true
                        } else {
                            return@onPreviewKeyEvent false
                        }

                    }

                ,

                        value = digits[index],
                onValueChange = {newValue ->
                    if (newValue.length <= 1 && newValue.isDigitsOnly()) {
                        digits[index] = newValue
                        if (index < 3 && !newValue.isEmpty()) {
                            focusRequester[index+1].requestFocus()
                        }
                    }
                },
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                ),

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFFE1E1E1))
                        ,
                        contentAlignment = Alignment.Center
                    ) {
                        innerTextField()
                    }
                }

            )
        }
    }
    ResendBtn()
}

@Composable
fun ResendBtn() {
    var timeEnough by remember { mutableStateOf(10) }
    LaunchedEffect(timeEnough) {
        if (timeEnough > 0) {
            delay(1000)
            timeEnough--
        }
    }
    val resandBtnEnable by remember {derivedStateOf { timeEnough > 0 } }

    if (resandBtnEnable) {
        Text(
            text = "Отправить код повторно можно \n будет через " + timeEnough.toString() + " секунд",
            modifier = Modifier
                .padding(10.dp)
            ,
            color = Color(0xff939396),
            fontSize = 15.sp,

        )
    } else {
        Text(
            text = "Отправить код повторно",
            modifier = Modifier
                .padding(20.dp)
                .clickable {
                    timeEnough = 60
                }
            ,
            color = Color(0xff939396)
        )
    }

}