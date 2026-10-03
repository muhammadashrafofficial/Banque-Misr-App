package com.example.banquemisr

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.LocaleListCompat
import com.example.banquemisr.ui.theme.Red
@Composable
fun Header(modifier: Modifier = Modifier) {

    val appLocales = AppCompatDelegate.getApplicationLocales()
    val currentLocaleTag = appLocales.get(0)?.toLanguageTag() ?: "en"

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 64.dp)

    ) {
        Image(
            painter = painterResource(R.drawable.bm_icon),
            contentDescription = null,
            modifier = Modifier.padding(16.dp)
        )

        TextButton(
            onClick = {
                val newLanguageTag = if (currentLocaleTag == "en") "ar" else "en"
                val localeList = LocaleListCompat.forLanguageTags(newLanguageTag)

                AppCompatDelegate.setApplicationLocales(localeList)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = Color.Black),

        ) {
            Text(
                text = if (currentLocaleTag == "en") "العربيه" else "En",
                fontSize = 20.sp,
            )
        }

    }
}