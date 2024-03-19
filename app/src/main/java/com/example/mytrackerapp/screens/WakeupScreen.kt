package com.example.mytrackerapp.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.commandiron.wheel_picker_compose.WheelTimePicker
import com.commandiron.wheel_picker_compose.core.TimeFormat
import com.commandiron.wheel_picker_compose.core.WheelPickerDefaults
import com.example.mytrackerapp.R
import com.example.mytrackerapp.Screen
import com.example.mytrackerapp.utils.SetButton
import com.example.mytrackerapp.utils.SetText

@Composable
fun WakeupScreen(navController: NavController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.color_blue_FD))
    ) {

        Spacer(modifier = Modifier.weight(0.01f))
        SetText(
            text = stringResource(id = R.string.whats_time_do_you_usually_wake_up),
            color = R.color.white,
            fontSize = 30,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.weight(0.1f))

        WheelTimePicker(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            timeFormat = TimeFormat.AM_PM,
            size = DpSize(300.dp, 150.dp),
            rowCount = 3,
            textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp),
            textColor = colorResource(id = R.color.white),
            selectorProperties = WheelPickerDefaults.selectorProperties(
                enabled = false,
                shape = RoundedCornerShape(0.dp),
                color = colorResource(id = R.color.color_gray_B2).copy(alpha = 0.2f),
                border = BorderStroke(2.dp, Color(0xFFf1faee))
            )
        ) { snappedDateTime ->
            Toast.makeText(context, snappedDateTime.toString(), Toast.LENGTH_LONG).show()
        }

        SetButton(
            text = stringResource(id = R.string.get_started),
            textAlign = TextAlign.Center,
            fontSize = 14,
            buttonColor = R.color.white,
            textColor = R.color.black,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(start = 16.dp, end = 16.dp,top = 16.dp, bottom = 16.dp)
        ) {
            navController.navigate(Screen.MainHabitScreen.route)

        }
    }
}