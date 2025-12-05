package com.example.parcialtp3.ui.screens.profile.security

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.components.SuccessScreen

@Composable
fun G_Fingerprint_Screen() {
    SuccessScreen(
        message = stringResource(R.string.fingerprint_changed_message),
        iconRes = R.drawable.icon_check_progress1
    )
}

@Preview(showBackground = true, showSystemUi = true, name = "Fingerprint Eliminate")
@Composable
private fun PreviewFingerprintEliminate() {
    G_Fingerprint_Screen()
}
