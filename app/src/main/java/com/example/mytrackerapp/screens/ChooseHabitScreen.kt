package com.example.mytrackerapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mytrackerapp.R
import com.example.mytrackerapp.Screen
import com.example.mytrackerapp.utils.SetText

@Composable
fun ChooseHabitScreen(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.color_blue_FD))
    ) {
        Spacer(modifier = Modifier.weight(0.01f))
        SetText(
            text = stringResource(id = R.string.choose_your_first_habit),
            color = R.color.white,
            fontSize = 30,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.weight(0.01f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(end = 30.dp, start = 30.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f).clickable {
                    navController.navigate(Screen.SetYourGoals.route)
                }
            ) {

                Box(modifier = Modifier.wrapContentSize()) {
                    // Background image (circle)
                    Image(
                        painter = painterResource(id = R.drawable.ic_ellipse),
                        contentDescription = null,
                    )

                    // Foreground image
                    Image(
                        painter = painterResource(id = R.drawable.ic_drink_water),
                        contentDescription = null, // Adjust size as needed
                    )
                }
                SetText(
                    text = stringResource(id = R.string.drinking_water),
                    color = R.color.white,
                    fontSize = 14,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
            Spacer(modifier = Modifier.weight(0.1f))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {

                Box(modifier = Modifier.wrapContentSize()) {
                    // Background image (circle)
                    Image(
                        painter = painterResource(id = R.drawable.ic_ellipse),
                        contentDescription = null,
                    )

                    // Foreground image
                    Image(
                        painter = painterResource(id = R.drawable.ic_walking),
                        contentDescription = null, // Adjust size as needed
                    )
                }
                SetText(
                    text = stringResource(id = R.string.morning_walk),
                    color = R.color.white,
                    fontSize = 14,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.weight(0.2f))

    }
}