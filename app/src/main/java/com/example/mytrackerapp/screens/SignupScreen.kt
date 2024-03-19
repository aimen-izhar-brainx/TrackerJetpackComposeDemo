package com.example.mytrackerapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mytrackerapp.R
import com.example.mytrackerapp.Screen
import com.example.mytrackerapp.database.entities.User
import com.example.mytrackerapp.utils.ClickableStyledText
import com.example.mytrackerapp.utils.PasswordTextField
import com.example.mytrackerapp.utils.SetButton
import com.example.mytrackerapp.utils.SetButtonWithIcon
import com.example.mytrackerapp.utils.SetImage
import com.example.mytrackerapp.utils.SetText
import com.example.mytrackerapp.utils.TextField
import com.example.mytrackerapp.viewModel.AuthViewModel

@Composable
fun SignupScreen(navController: NavController) {
    val mViewModel: AuthViewModel = hiltViewModel()

    Column() {
        SetImage(image = R.drawable.ic_back_icon, modifier = Modifier
            .padding(16.dp)
            .clickable {
                navController.popBackStack()
            })
        SetText(
            text = stringResource(id = R.string.create_your_account),
            color = R.color.black,
            fontSize = 28,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        SetButtonWithIcon(
            icon = R.drawable.ic_google_icon,
            text = stringResource(R.string.continue_with_google),
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .padding(16.dp)
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.color_skin_EC),
                    shape = RoundedCornerShape(38.dp)
                ),
            textAlign = TextAlign.Center,
            textModifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.white)),
            buttonColor = R.color.white,
            fontSize = 14, textColor = R.color.black
        ) {

        }
        SetText(
            text = stringResource(id = R.string.or_log_in_with_email),
            color = R.color.color_gray_B2,
            fontSize = 14,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )
        EmailEditText(){
            mViewModel.email.value = it
        }
        PasswordEditText() {
            mViewModel.password.value = it
        }
        SetButton(
            text = stringResource(id = R.string.sign_up),
            textAlign = TextAlign.Center,
            fontSize = 14,
            buttonColor = R.color.color_blue_FD,
            textColor = R.color.white,
            modifier = Modifier
                .fillMaxWidth()
                .height(63.dp)
                .padding(start = 16.dp, end = 16.dp,top = 16.dp)
        ) {
            mViewModel.insertUserIntoDb(User(email = mViewModel.email.value, password = mViewModel.password.value))
        }
        Spacer(modifier = Modifier.weight(0.2f))
    }

}