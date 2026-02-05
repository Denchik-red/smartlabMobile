package den_n.smartlab.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import den_n.smartlab.util.SecureStorage
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun Create_password_screen() {

    val context = LocalContext.current
//    val context: Context? = null
//    SecureStorage.setAuthPassword(context, "1111")
//    SecureStorage.cleanAuthPassword(context)
    val isPasswordAlreadyTaken by remember { mutableStateOf(SecureStorage.getAuthPassword(context) != null) }
    val passwordSimbolCount = 4
    val enterPassword = remember { mutableStateListOf<Int>()}
    val firstPassword = remember { mutableStateOf<String>("")}
    val showError = remember { mutableStateOf<String>("") }

    LaunchedEffect(enterPassword.size >= passwordSimbolCount) {
        if (enterPassword.size >= passwordSimbolCount) {

            if (isPasswordAlreadyTaken) {
                if (SecureStorage.getAuthPassword(context) == convertListToString(enterPassword.toList())) {
                    showError.value = "Вход выполнен успешно"
                } else {
                    showError.value = "Пароль неправельный"
                    delay(2000)
                    enterPassword.clear()
                    showError.value = ""
                }
            } else {
                if (firstPassword.value.isEmpty()) {
                    firstPassword.value = convertListToString(enterPassword.toList())
                    enterPassword.clear()
                } else {
                    if (firstPassword.value == convertListToString(enterPassword.toList())) {
                        SecureStorage.setAuthPassword(context, firstPassword.value)
                        showError.value = "Пароль сохранен"

                    } else {
                        showError.value = "Пароли не совпадают"
                        delay(3000)
                        enterPassword.clear()
                        firstPassword.value = ""
                        showError.value = ""
                    }
                }
            }
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
            ,
            horizontalArrangement = Arrangement.End,
        ) {
            Text(
                text = "Пропустить",
                modifier = Modifier
                    .padding(20.dp)
                ,
                fontSize = 18.sp,
                color = Color(0xff1A6FEE)
            )
        }
//        Text(convertListToString(enterPassword.toList()))
//        Text(firstPassword.value.isEmpty().toString())


        if (isPasswordAlreadyTaken) {
            Text(
                text = "Введите пароль",
                modifier = Modifier
                    .padding(top = 40.dp)
                ,
                fontSize = 24.sp,
            )
        } else {
            Text(
                text = if (firstPassword.value.isEmpty()) "Создайте пароль" else "Введите рароль еще раз",
                modifier = Modifier
                    .padding(top = 40.dp)
                ,
                fontSize = 24.sp,
            )
            Text(
                text = "Для защиты ваших персональных данных",
                modifier = Modifier
                    .padding(top = 15.dp)
                ,
                fontSize = 15.sp,
                color = Color(0xff939396)
            )
        }
        if (showError.value.isNotEmpty()) {
            Text(
                text = showError.value,
            )
        }


        Row {
            repeat(passwordSimbolCount) { index ->
                Box(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .padding(start = 10.dp)
                        .size(15.dp)
                        .background(
                            color = if (enterPassword.size > index) Color(0xff1A6FEE) else Color.Transparent,
                            shape = CircleShape,
                        )
                        .border(
                            width = 2.dp,
                            color = Color(0xFF1A6FEE),
                            shape = CircleShape
                        )
                    ,
                ){}
            }
        }
        Keyboard(passwordSimbolCount, enterPassword)
    }
}

fun convertListToString(list: List<Int>): String {
    var string = ""
    list.forEach { elem ->
        string = string.plus(elem.toString())
    }
    return string
}

@Composable
fun Keyboard(passwordSimbolCount: Int,  enterPassword: SnapshotStateList<Int>) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
        ,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        repeat(3) { row ->
            Row(
                modifier = Modifier
                ,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                repeat(3) {  col ->
                    Button(
                        onClick = {
                            if (enterPassword.size < passwordSimbolCount) {
                                enterPassword.add( (2-row)*3+col+1 )
                            }
                        },
                        modifier = Modifier
                            .shadow(
                                elevation = 7.dp,
                                shape = CircleShape,
                            )

                            .size(80.dp)

                        ,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xffF5F5F9),
                        ),

                        ) {
                        Text(
                            text = ((2-row)*3+col+1).toString(),
                            color = Color.Black,
                            fontSize = 23.sp,
                        )
                    }
                }
            }

        }
        Row(
            modifier = Modifier
            ,
            horizontalArrangement = Arrangement.spacedBy(20.dp)

        ) {
            Box(
                modifier = Modifier
                    .size(80.dp),
            ) {}
            Button(
                onClick = {
                    if (enterPassword.size < passwordSimbolCount) {
                        enterPassword.add(0)
                    }
                },
                modifier = Modifier
                    .size(80.dp)
                    .shadow(
                        elevation = 7.dp,
                        shape = CircleShape,
                    )
                ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffF5F5F9),
                )
            ) {
                Text(
                    text = "0",
                    color = Color.Black,
                    fontSize = 23.sp,
                )

            }

            Button(
                onClick = {
                    if (enterPassword.size > 0) {
                        enterPassword.removeAt(enterPassword.lastIndex)
                    }
                },
                modifier = Modifier
                    .size(80.dp)
                    .shadow(
                        elevation = 7.dp,
                        shape = CircleShape,
                    )
                ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffF5F5F9),
                )
            ) {
                Text(
                    text = "⌫",
                    color = Color.Black,
                    fontSize = 23.sp,
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))

    }
}