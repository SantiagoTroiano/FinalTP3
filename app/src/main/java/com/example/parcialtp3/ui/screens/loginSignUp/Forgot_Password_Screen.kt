package com.example.parcialtp3.ui.screens.loginSignUp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.FacebookGoogle
import com.example.parcialtp3.ui.components.RoundedButton
import com.example.parcialtp3.ui.components.RoundedInputField
import com.example.parcialtp3.ui.components.SimpleText
import com.example.parcialtp3.ui.components.TitleText

@Composable
fun ForgotPasswordScreen(
    navController: NavHostController
){
    BackgroundScaffold(
        displayBottomNavBar = false,
        navController = navController,
        headerHeight = 187.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = { Title() },
        panelContent = { Body(navController) }
    )
}

@Composable
private fun Title() {
    TitleText(
        text = stringResource(R.string.forgot_password_title),
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(top = 18.dp)
    )
}

@Composable
private fun Body(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp)
            .padding(top = 50.dp)
    ) {
        TitleText(
            text = stringResource(R.string.forgot_reset_title),
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 18.dp),
            fontSize = 20.sp
        )
        Spacer(Modifier.height(20.dp))

        SimpleText(
            text = stringResource(R.string.forgot_description),
            textAlign = TextAlign.Start,
            fontSize = 11.sp,
            fontWeight = FontWeight.Normal
        )
        Spacer(Modifier.height(70.dp))

        RoundedInputField(
            label = stringResource(R.string.forgot_email_label),
            placeholder = stringResource(R.string.forgot_email_placeholder),
            labelPaddingLeft = 0.dp
        )

        Spacer(Modifier.height(45.dp))

        RoundedButton(
            text = stringResource(R.string.forgot_next_step),
            onClick = {},
            width = 169.dp,
            height = 32.dp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            navController = navController,
            route = "SecurityPinScreen"
        )
        Spacer(Modifier.height(110.dp))

        RoundedButton(
            text = stringResource(R.string.forgot_sign_up),
            backgroundColor = LightGreen,
            onClick = {},
            width = 169.dp,
            height = 32.dp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            navController = navController,
            route = "CreateAccountScreen"
        )

        Spacer(Modifier.height(25.dp))
        FacebookGoogle(navController)
    }
}
