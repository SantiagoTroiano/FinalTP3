package com.example.parcialtp3.ui.screens.profile.setting

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.components.SuccessScreen

@Composable
fun D_Password_Settings_Screen() {
    SuccessScreen(
        message = stringResource(R.string.password_changed_success),
        iconRes = R.drawable.icon_check_progress1
    )
}

@Preview(showBackground = true, showSystemUi = true, name = "Password changed")
@Composable
private fun PreviewFingerprintEliminate() {
    D_Password_Settings_Screen()
}
