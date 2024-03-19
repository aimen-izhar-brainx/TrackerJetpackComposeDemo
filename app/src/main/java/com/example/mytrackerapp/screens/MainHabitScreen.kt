package com.example.mytrackerapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mytrackerapp.R
import com.example.mytrackerapp.Screen
import com.example.mytrackerapp.utils.SetText

@Composable
fun MainHabitScreen(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.color_blue_FD))
    ) {
        Spacer(modifier = Modifier.weight(0.01f))
        SetText(
            text = stringResource(id = R.string.what_habit_do_you_hope_achieve),
            color = R.color.white,
            fontSize = 30,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.weight(0.1f))

        Card(
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.color_blue_9D),
            ), modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp).clickable {
                    navController.navigate(Screen.ChooseHabitScreen.route)
                }
        ) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier.fillMaxSize()
            ) {
                SetText(
                    text = stringResource(id = R.string.i_want_to_build_good_habits),
                    color = R.color.white, // Adjust color as needed
                    fontSize = 14,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)

                )
            }
        }

        Card(
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.color_blue_9D),
            ), modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp).clickable {
                    navController.navigate(Screen.ChooseHabitScreen.route)

                }
        ) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier.fillMaxSize()
            ) {
                SetText(
                    text = stringResource(id = R.string.i_want_to_be_organized),
                    color = R.color.white, // Adjust color as needed
                    fontSize = 14,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)

                )
            }
        }

        Card(
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.color_blue_9D),
            ), modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp).clickable {
                    navController.navigate(Screen.ChooseHabitScreen.route)

                }
        ) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier.fillMaxSize()
            ) {
                SetText(
                    text = stringResource(id = R.string.not_ready_to_answer),
                    color = R.color.white, // Adjust color as needed
                    fontSize = 14,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)

                )
            }
        }
        Spacer(modifier = Modifier.weight(0.01f))

    }

}