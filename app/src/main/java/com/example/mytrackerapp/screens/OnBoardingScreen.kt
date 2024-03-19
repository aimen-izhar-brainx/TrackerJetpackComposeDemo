package com.example.mytrackerapp.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mytrackerapp.R
import com.example.mytrackerapp.Screen
import com.example.mytrackerapp.utils.SetButton
import com.example.mytrackerapp.utils.SetImage
import com.example.mytrackerapp.utils.SetText
import kotlinx.coroutines.delay

@Composable
fun OnBoardingScreen(navController: NavController) {
    var currentImage by remember { mutableStateOf(R.drawable.ic_onboarding1) }
    var currentText by remember {
        mutableStateOf(R.string.track_your_goal)
    }
    var currentDescription by remember {
        mutableStateOf(R.string.dont_worry_if_you_have_trouble)
    }

    val translationX = remember { Animatable(0f) }
    val bitmap1 = painterResource(id = R.drawable.ic_onboarding1)
    val bitmap2 = painterResource(id = R.drawable.ic_onboarding2)

    val text1 = stringResource(id = R.string.track_your_goal)
    val text2 = stringResource(id = R.string.get_burn)

    val description1 = stringResource(id = R.string.dont_worry_if_you_have_trouble)
    val description2 = stringResource(id = R.string.lets_keep_burining)

    val textResource by rememberUpdatedState(newValue = if (currentText == R.string.track_your_goal) text1 else text2)
    val descriptionResource by rememberUpdatedState(newValue = if (currentDescription == R.string.dont_worry_if_you_have_trouble) description1 else description2)
    val imagePainter by rememberUpdatedState(if (currentImage == R.drawable.ic_onboarding1) bitmap1 else bitmap2)

    LaunchedEffect(Unit) {
        translationX.animateTo(1f)
        delay(5000) // 10-second delay
        currentImage =
            if (currentImage == R.drawable.ic_onboarding1) R.drawable.ic_onboarding2 else R.drawable.ic_onboarding1

        currentText =
            if (currentText == R.string.track_your_goal) R.string.get_burn else R.string.track_your_goal

        currentDescription =
            if (currentDescription == R.string.dont_worry_if_you_have_trouble) R.string.lets_keep_burining else R.string.dont_worry_if_you_have_trouble
    }

    Box() {
        AnimatedVisibility(
            visible = true,
            enter = slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(durationMillis = 10000)
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(durationMillis = 10000)
            )
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = imagePainter,
                    contentDescription = "Image",
                    modifier = Modifier.offset(x = translationX.value.dp)
                )
                SetText(
                    text = textResource,
                    color = R.color.black,
                    fontSize = 20,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .offset(x = translationX.value.dp)
                        .padding(16.dp)

                )

                SetText(
                    text = descriptionResource,
                    color = R.color.color_gray_B2,
                    fontSize = 20,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .offset(x = translationX.value.dp)
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)

                )
                Spacer(modifier = Modifier.weight(1f))


                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    SetImage(
                        image = R.drawable.ic_next_button,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                navController.navigate(Screen.LoginScreen.route)
                            }
                    )
                }
            }

        }
    }
}