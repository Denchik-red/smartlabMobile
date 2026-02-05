package den_n.smartlab.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import den_n.smartlab.R

@Composable
fun Load_screen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFA1CAFF),
                        Color(0xFF2254F5),
                        Color(0xFF2254F5),
                        Color(0xFF2254F5),
                        Color(0xFFA1CAFF),
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
            .clickable {
                navController.navigate("first_info_screen")
            },
        contentAlignment = Alignment.Center

    ) {
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .size(213.dp),
                painter = painterResource(R.drawable.smartlab_text),
                contentDescription = "",
                )
            Image(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 0.dp, 0.dp)
                    .size(39.dp),
                painter = painterResource(R.drawable.smartlab_shape),
                contentDescription = "",

            )
        }
    }
}