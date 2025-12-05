package com.example.parcialtp3.ui.screens.profile.security

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.components.SuccessScreen

@Composable
fun C_Change_Pin_Success_Screen() {
    SuccessScreen(
        message = stringResource(R.string.pin_changed_success),
        iconRes = R.drawable.icon_check_progress1,
    )
}

@Preview(showBackground = true, showSystemUi = true, name = "Success")
@Composable
private fun PreviewSuccess() {
    C_Change_Pin_Success_Screen()
}
