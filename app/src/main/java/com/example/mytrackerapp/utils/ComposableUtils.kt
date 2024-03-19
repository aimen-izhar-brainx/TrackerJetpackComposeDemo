package com.example.mytrackerapp.utils

import android.widget.Space
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrackerapp.R

@Composable
fun SetImage(image: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "",
        modifier = modifier
    )
}

@Composable
fun SetButton(
    text: String,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    textAlign: TextAlign,
    fontSize: Int,
    buttonColor: Int,
    textColor: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(38.dp),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = buttonColor))
    )
    {
        Text(
            text = text,
            color = colorResource(id = textColor),
            modifier = textModifier,
            textAlign = textAlign,
            fontSize = fontSize.sp
        )
    }
}

@Composable
fun SetButtonWithIcon(
    icon: Int,
    text: String,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    textAlign: TextAlign,
    fontSize: Int,
    buttonColor: Int,
    textColor: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(38.dp),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = buttonColor))
    )
    {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "drawable_icons",
            )
            //Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = text,
                color = colorResource(id = textColor),
                modifier = textModifier,
                textAlign = textAlign,
                fontSize = fontSize.sp
            )
        }
    }
}

@Composable
fun SetText(
    text: String,
    modifier: Modifier = Modifier,
    color: Int,
    fontSize: Int,
    textAlign: TextAlign,
    fontWeight: FontWeight? = null
) {
    Text(
        text = text, color = colorResource(color),
        modifier = modifier, fontSize = fontSize.sp, textAlign = textAlign,
        fontWeight = fontWeight ?: FontWeight.Normal
    )
}

@Composable
fun SetButtonWithBorder(
    text: String,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    textAlign: TextAlign,
    fontSize: Int,
    buttonColor: Int,
    textColor: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(38.dp),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = buttonColor))
    )
    {
        Text(
            text = text,
            color = colorResource(id = textColor),
            modifier = textModifier,
            textAlign = textAlign,
            fontSize = fontSize.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(
    cursorColor: Int = R.color.color_blue_FD,
    unfocusColor: Int = R.color.color_gray_F7,
    focusColor: Int = R.color.color_blue_FD,
    textSize: Int = 14,
    modifier: Modifier,
    placeholderText: Int,
    cornerSize: Int = 0,
    keyboardType: KeyboardType,
    containerColor : Int = R.color.color_gray_F7,
    onValueChange: (TextFieldValue) -> Unit
) {
    val emailValue = remember { mutableStateOf(TextFieldValue()) }
    OutlinedTextField(
        value = emailValue.value,
        onValueChange = {
            emailValue.value = it
            onValueChange(it)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = colorResource(id = containerColor),
            cursorColor = colorResource(id = cursorColor),
            focusedBorderColor = colorResource(
                id = focusColor
            ),
            unfocusedBorderColor = colorResource(
                id = unfocusColor
            ),
        ),
        textStyle = TextStyle(
            fontSize = textSize.sp,
        ),
        modifier = modifier,
        placeholder = { Text(text = stringResource(id = placeholderText)) },
        shape = RoundedCornerShape(cornerSize.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)


    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    cursorColor: Int = R.color.color_blue_FD,
    unfocusColor: Int = R.color.color_gray_F7,
    focusColor: Int = R.color.color_blue_FD,
    textSize: Int = 14,
    modifier: Modifier,
    placeholderText: Int = R.string.password,
    cornerSize: Int = 0,
    keyboardType: KeyboardType = KeyboardType.Password,
    onValueChange: (TextFieldValue) -> Unit
) {
    val passwordValue = remember { mutableStateOf(TextFieldValue()) }
    var passwordVisible = rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        value = passwordValue.value,
        onValueChange = {
            passwordValue.value = it
            onValueChange(it)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = colorResource(id = R.color.color_gray_F7),
            cursorColor = colorResource(id = cursorColor),
            focusedBorderColor = colorResource(
                id = unfocusColor
            ),
            unfocusedBorderColor = colorResource(
                id = unfocusColor
            ),
        ),
        textStyle = TextStyle(
            fontSize = textSize.sp,
        ),
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = modifier,
        trailingIcon = {
            val image = if (passwordVisible.value)
                R.drawable.ic_password_visible
            else R.drawable.ic_password_invisible

            // Please provide localized description for accessibility services
            val description = if (passwordVisible.value) "Hide password" else "Show password"

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(painter = painterResource(image), description)
            }
        },
        placeholder = { Text(text = stringResource(id = placeholderText)) },
        shape = RoundedCornerShape(cornerSize.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)


    )
}

@Composable
fun ClickableStyledText(
    simpleText: String,
    annotatedString: String,
    fontSize: Int,
    textAlign: TextAlign,
    textColor: Int,
    annotatedTextColor: Int,
    modifier: Modifier,

    onClick: () -> Unit
) {
    val annotatedText = annotatedString(simpleText, annotatedString, annotatedTextColor)
    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            // Check if the clicked part has the "clickable" annotation
            val annotation = annotatedText.getStringAnnotations(annotatedString, offset, offset)
                .firstOrNull()

            if (annotation != null) {
                onClick.invoke()
            }
        },
        style = TextStyle(
            fontSize = fontSize.sp,
            textAlign = textAlign,
            color = colorResource(id = textColor),
        ),
        modifier = modifier
    )
}

@Composable
private fun annotatedString(
    startString: String,
    annotatedString: String,
    annotatedTextColor: Int
): AnnotatedString {
    val annotatedText = AnnotatedString.Builder(startString).apply {
        withStyle(
            style = SpanStyle(
                color = colorResource(id = annotatedTextColor),
                textDecoration = TextDecoration.None
            )
        ) {
            append(annotatedString)
            addStringAnnotation(annotatedString, "", length - 9, length)
        }
    }.toAnnotatedString()
    return annotatedText
}


@Composable
fun BackPressHandler(
    backPressedDispatcher: OnBackPressedDispatcher? =
        LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher,
    onBackPressed: () -> Unit
) {
    val currentOnBackPressed by rememberUpdatedState(newValue = onBackPressed)

    val backCallback = remember {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                currentOnBackPressed()
            }
        }
    }

    DisposableEffect(key1 = backPressedDispatcher) {
        backPressedDispatcher?.addCallback(backCallback)

        onDispose {
            backCallback.remove()
        }
    }
}