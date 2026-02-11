package den_n.smartlab.ui.screens

import android.R.attr.contentDescription
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Create_card_screen() {
//    val clientInformation = remember { mutableStateListOf( mutableStateOf(""),  mutableStateOf(""),  mutableStateOf(""),  mutableStateOf(""),  mutableStateOf("")) }

    Create_card()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenu() {
    val options = listOf("Мужской", "Женский")
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(options[0]) }

    Box(modifier = Modifier.padding(16.dp)) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = selectedOption,
                onValueChange = {},
                readOnly = true,
                label = { Text("Выберите пол") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.fillMaxWidth().menuAnchor()
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.exposedDropdownSize()
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            selectedOption = selectionOption
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun Create_card() {
    val name = remember { mutableStateOf("") }
    val otchestvo = remember { mutableStateOf("") }
    val surname = remember { mutableStateOf("") }
    val birthDate = remember { mutableStateOf("") }

    Scaffold(
        topBar = { Header_skip() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(top = 20.dp)
            ,
        ) {
            Text(
                text = "В картах пациентов будут храниться результаты анализов вас и ваших близких.",
                modifier = Modifier
                    .padding(20.dp, 0.dp)
                ,
                color = Color(0xff939396)
            )

            Text(
                text = "Без карты пациента вы не сможете заказать анализы.",
                modifier = Modifier
                    .padding(20.dp, 10.dp)
                ,
                color = Color(0xff939396)
            )


            InputField(
                onTextChange = { newValue ->
                    name.value = newValue
                },
                text = name.value,
                placeholder = "Имя"
            )
            InputField(
                onTextChange = { newValue ->
                    otchestvo.value = newValue
                },
                text = otchestvo.value,
                placeholder = "Отчество"
            )
            InputField(
                onTextChange = { newValue ->
                    surname.value = newValue
                },
                text = surname.value,
                placeholder = "Фамилия"
            )
            InputField(
                onTextChange = { newValue ->
                    birthDate.value = newValue
                },
                text = birthDate.value,
                placeholder = "Дата Рождения"
            )

            ExposedDropdownMenu()

            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff1A6FEE),
                ),
                shape = RoundedCornerShape(20),

            ) {
                Text(
                    text = "Далее",
                    fontSize = 20.sp,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header_skip() {
    TopAppBar(
        modifier = Modifier
            .padding(5.dp)
        ,
        title = {
            Text(
                text = "Создание карты пациента",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
            )
        },
        actions = {
            Text(
                text = "Пропустить",
                modifier = Modifier
                    .padding(end = 20.dp)
                ,
                fontSize = 18.sp,
                color = Color(0xff1A6FEE)
            )
        }

    )
}

@Composable
fun InputField(
    onTextChange: (String) -> Unit,
    text: String,
    placeholder: String,
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .border(
                width = 1.dp,
                color = Color(0xffB8C1CC),
                shape = MaterialTheme.shapes.small
            )
//            .background(Color(0xffF5F5F9))
        ,
        onValueChange = {newValue ->  onTextChange(newValue)},
        value = text,
        placeholder = {
            Text(
                text = placeholder,
                color = Color.Gray
            )
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )


    )
}






















@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppScaffold() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Мое приложение") },
                navigationIcon = {
                    IconButton(onClick = { /* Обработка нажатия */ }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Меню")
                    }
                },
            )        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* действие */ }) {
                Text(text = "+")
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Привет, Jetpack Compose!")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationTopAppBarExample() {
    var currentScreen by remember { mutableStateOf("Home") }
    val screens = listOf("Home", "Profile", "Settings")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(currentScreen) },
                navigationIcon = {
                    if (currentScreen != "Home") {
                        IconButton(onClick = { currentScreen = "Home" }) {
                            Icon(
                                Icons.Default.ArrowBack,
                                contentDescription = "Назад"
                            )
                        }
                    }
                },
                actions = {
                    IconButton(onClick = { /* Уведомления */ }) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "Поиск"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (currentScreen) {
                "Home" -> HomeScreen { currentScreen = it }
                "Profile" -> ProfileScreen()
                "Settings" -> SettingsScreen()
            }
        }
    }
}

@Composable
fun HomeScreen(onNavigate: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Домашний экран")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onNavigate("Profile") }) {
            Text("Перейти в профиль")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { onNavigate("Settings") }) {
            Text("Настройки")
        }
    }
}

@Composable
fun ProfileScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Профиль пользователя")
    }
}

@Composable
fun SettingsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Настройки приложения")
    }
}