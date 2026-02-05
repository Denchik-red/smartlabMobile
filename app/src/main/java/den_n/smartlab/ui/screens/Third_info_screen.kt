package den_n.smartlab.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import den_n.smartlab.R
import den_n.smartlab.Roboto

@Composable
fun Third_info_screen(navController: NavController) {
    Column (
        modifier = Modifier
        .fillMaxHeight()
            .clickable {
                navController.navigate("Login_screen")
            },
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceBetween,

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Пропустить",
                modifier = Modifier
                    .padding(30.dp)
                    .clickable {
                        navController.navigate("Login_screen")
                    },
                color = Color(0xFF1A6FEE),
                fontSize = 20.sp,
                fontFamily = Roboto
            )
            Image(
                modifier = Modifier
                    .padding(0.dp, 30.dp, 0.dp, 0.dp)
                    .size(160.dp),
                painter = painterResource(R.drawable.plus),
                contentDescription = "plus"
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 50.dp, 0.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Мониторинг",
                color = Color(0xFF00B712),
                fontSize = 20.sp,
                fontFamily = Roboto
            )
            Text(
                text = "Наши врачи всегда наблюдают \n" +
                        "за вашими показателями здоровья",
                modifier = Modifier
                    .padding(0.dp, 30.dp),
                fontFamily = Roboto,
                textAlign = TextAlign.Center,

            )
            Row(
                modifier = Modifier
                    .padding(0.dp, 40.dp, 0.dp, 0.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ellipse_diactive),
                    contentDescription = "",
                    modifier = Modifier
                        .size(12.dp),
                )
                Image(
                    painter = painterResource(R.drawable.ellipse_diactive),
                    contentDescription = "",
                    modifier = Modifier
                        .size(12.dp),
                )
                Image(
                    painter = painterResource(R.drawable.ellipse_active),
                    contentDescription = "",
                    modifier = Modifier
                        .size(12.dp),
                )
            }

        }

        Image(
            modifier = Modifier
                .size(300.dp)
                .padding(0.dp, 0.dp, 0.dp, 30.dp),
            painter = painterResource(R.drawable.illustration_2),
            contentDescription = "",
        )

    }
}