package com.example.mytrackerapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mytrackerapp.R
import com.example.mytrackerapp.utils.SetImage
import com.example.mytrackerapp.utils.SetText
import com.example.mytrackerapp.utils.TextField

@Composable
fun SetYourGoals(navController: NavController) {
    val selectedBoxIndex = remember { mutableStateOf(-1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = colorResource(id = R.color.color_blue_FD))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            SetImage(image = R.drawable.ic_drinkin_goals_icon)
            SetText(
                text = "Set your goals",
                color = R.color.white,
                fontSize = 30,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 20.dp)
            )
        }
        SetText(
            text = "Set your goals",
            color = R.color.white,
            fontSize = 14,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 20.dp)
        )
        EditText()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            ColoredBox(
                index = 0,
                selectedBoxIndex = selectedBoxIndex,
                modifier = Modifier.weight(1f), "Daily"
            )
            ColoredBox(
                index = 1,
                selectedBoxIndex = selectedBoxIndex,
                modifier = Modifier.weight(1f), "Weekly"
            )
            ColoredBox(
                index = 2,
                selectedBoxIndex = selectedBoxIndex,
                modifier = Modifier.weight(1f), "Monthly"
            )
        }
        SetText(
            text = "Repeat Everyday",
            color = R.color.white,
            fontSize = 20,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
    }
}

@Composable
fun EditText() {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                16.dp
            ),
        cornerSize = 15,
        placeholderText = R.string.enter_glasses_of_water,
        keyboardType = KeyboardType.Text,
        containerColor = R.color.color_blue_9D
    ) {
    }
}

@Composable
fun ColoredBox(index: Int, selectedBoxIndex: MutableState<Int>, modifier: Modifier, text: String) {
    val isSelected = selectedBoxIndex.value == index
    val backgroundColor = if (isSelected) colorResource(id = R.color.color_blue_9D) else Color.White
    Box(
        modifier = modifier
            .height(32.dp)
            .padding(end = 8.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(30.dp)
            )
            .clickable(
                onClick = { selectedBoxIndex.value = index },
                indication = null,
                interactionSource = remember { MutableInteractionSource() }),
        contentAlignment = Alignment.Center
    ) {

        SetText(
            text = text,
            color = if (isSelected) R.color.white else R.color.color_gray_B2,
            fontSize = 14,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}