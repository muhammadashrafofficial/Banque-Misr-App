package com.example.banquemisr

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FooterItem(image: Int, text: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier.size(80.dp),
        )
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            fontSize = 16.sp,
        )
    }
}

@Composable
fun Footer(modifier: Modifier = Modifier) {

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        FooterItem(
            image = R.drawable.our_products,
            text = stringResource(R.string.our_products),
            modifier = Modifier
                .weight(1f)
        )
        FooterItem(
            image = R.drawable.exchange_rate,
            text = stringResource(R.string.exchange_rate),
            modifier = Modifier

                .weight(1f)
        )
        FooterItem(
            image = R.drawable.security_tips,
            text = stringResource(R.string.security_tips),
            modifier = Modifier
                .weight(1f)
        )
        FooterItem(
            image = R.drawable.nearest_branch_or_atm,
            text = stringResource(R.string.nearest_branch_or_atm),
            modifier = Modifier
                .weight(1f)
        )
    }

}