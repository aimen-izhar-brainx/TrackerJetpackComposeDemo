package com.example.mytrackerapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mytrackerapp.R
import com.example.mytrackerapp.Screen
import com.example.mytrackerapp.ui.theme.MyTrackerAppTheme
import com.example.mytrackerapp.utils.SetButton
import com.example.mytrackerapp.utils.SetImage
import com.example.mytrackerapp.utils.SetText

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.color_blue_FD)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SetImage(
            R.drawable.main_logo, Modifier
                .size(142.dp, 142.dp)
        )
        SetText(
            text = stringResource(R.string.welcome_to_main_habits), modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp), R.color.white, 30, TextAlign.Center
        )
        SetText(
            text = stringResource(R.string.explore_the_app),
            color = R.color.white,
            fontSize = 16,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
        )
        SetImage(
            image = R.drawable.yoga_women_icon,
            modifier = Modifier
                .size(300.dp, 300.dp)
        )
        SetButton(
            text = stringResource(R.string.get_started),
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(16.dp),
            textAlign = TextAlign.Center,
            textModifier = Modifier.background(colorResource(id = R.color.color_skin_EC)),
            buttonColor = R.color.color_skin_EC,
            fontSize = 14, textColor = R.color.black
        ) {
            navController.navigate(Screen.OnBoardingScreen.route)
        }
    }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyTrackerAppTheme {
    }
}