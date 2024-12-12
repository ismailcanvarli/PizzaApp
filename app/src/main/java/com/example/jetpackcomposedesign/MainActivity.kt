package com.example.jetpackcomposedesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedesign.ui.theme.DarkFirstColor
import com.example.jetpackcomposedesign.ui.theme.FirstColor
import com.example.jetpackcomposedesign.ui.theme.FirstTextColor
import com.example.jetpackcomposedesign.ui.theme.JetpackComposeDesignTheme
import com.example.jetpackcomposedesign.ui.theme.SecondTextColor
import com.example.jetpackcomposedesign.ui.theme.pacifico

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDesignTheme {
                HomeScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(darkTheme: Boolean = isSystemInDarkTheme()) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = stringResource(
                id = R.string.app_name),
                fontFamily = pacifico) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = if (darkTheme) DarkFirstColor else FirstColor,
                titleContentColor = FirstTextColor
            )
        )
    }) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = R.string.app_name),
                color = FirstColor,
                fontWeight = FontWeight.Bold,
                fontSize = 34.sp
            )

            Image(
                painter = painterResource(id = R.drawable.pizza_image),
                contentDescription = "Pizza resmi",
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                myChip(stringResource(id = R.string.peynirYazi))
                myChip("Sausage")
                myChip("Olive")
                myChip("Pepper")
            }

            Text(
                text = "20 min",
                color = SecondTextColor,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )

            Text(
                text = "Delivery",
                color = FirstColor,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )

            Text(
                text = "Meat lover, get ready to meet your pizza!",
                color = SecondTextColor,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )

            // Row içinde iki tane Text ve bir tane Button var.
            // left = start, right = end
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$12.99",
                    color = FirstColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 34.sp
                )

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = FirstColor,
                        contentColor = FirstTextColor
                    )
                ) {
                    Text(
                        text = "ADD TO CART",
                        color = FirstTextColor,
                        fontSize = 18.sp)
                }
            }
        }
    }
}

// Burada tekrar eden fonksiyanları birleştirdik.
@Composable
fun myChip(buttonName: String) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = FirstColor,
            contentColor = FirstTextColor
        )
    ) {
        Text(text = buttonName, color = FirstTextColor)
    }
}

@Preview(showBackground = true, locale = "tr")
@Composable
fun HomeScreenPreview() {
    JetpackComposeDesignTheme {
        HomeScreen()
    }
}
