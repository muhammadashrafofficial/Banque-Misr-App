package com.example.banquemisr

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banquemisr.ui.theme.Red


@Composable
fun MiddlePart(modifier: Modifier = Modifier) {

    var emailField by rememberSaveable() { mutableStateOf("") }
    var passwordField by rememberSaveable() { mutableStateOf("") }
    var isPasswordVisible by rememberSaveable() { mutableStateOf(false) }

    val isLoginEnabled = emailField.isNotBlank() && passwordField.isNotBlank()

    OutlinedTextField(
        value = emailField,
        onValueChange = { emailField = it },
        label = { Text(stringResource(R.string.email)) },
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),

        )

    OutlinedTextField(
        value = passwordField,
        onValueChange = { passwordField = it },
        label = { Text("Password") },
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val icon =
                if (isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility
            val description = if (isPasswordVisible) "Hide password" else "Show password"
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(imageVector = icon, contentDescription = description)
            }
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

    Column(

    )
    {
        Text(
            text = stringResource(R.string.forgot),
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.padding(top = 16.dp)
        )

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Red, contentColor = Color.White),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(top = 32.dp)
                .fillMaxWidth(),
            enabled = isLoginEnabled,
        ) {
            Text(
                text = stringResource(R.string.login),
                fontSize = 24.sp,
            )
        }

        Text(
            text = buildAnnotatedString {

                append(
                    stringResource(
                        R.string.need_help
                    )
                )

                withStyle(
                    style = SpanStyle(
                        color = Red,
                        fontWeight = FontWeight.SemiBold,
                        textDecoration = TextDecoration.Underline
                    )
                ) {

                    append(
                        stringResource(
                            R.string.contact_us
                        )
                    )
                }
            },

            modifier = Modifier.padding(top = 20.dp)
        )


        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 56.dp, bottom = 16.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )
    }
}
