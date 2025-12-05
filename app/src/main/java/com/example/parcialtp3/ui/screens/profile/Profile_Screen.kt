package com.example.parcialtp3.ui.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.DisplayName
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.ImagenFlotadora
import com.example.parcialtp3.ui.components.ProfileOption
import com.example.parcialtp3.ui.components.RoundedButton

@Composable
fun Profile_Screen(navController: NavHostController) {
    val showDialog = remember { mutableStateOf(false) }

    BackgroundScaffold(
        navController = navController,
        current = "profile",
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                title = stringResource(R.string.profile_title),
                navController = navController,
                onBackClick = { navController.popBackStack() }
            )
        },
        panelContent = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(Modifier.height(50.dp))

                DisplayName("25030024", "John Smith")

                Spacer(Modifier.height(20.dp))

                ProfileOption(
                    iconRes = R.drawable.icon_profile,
                    label = stringResource(R.string.profile_edit_profile),
                    onClick = { navController.navigate("edit_profile") }
                )
                ProfileOption(
                    iconRes = R.drawable.icon_security,
                    label = stringResource(R.string.profile_security),
                    onClick = { navController.navigate("security") }
                )
                ProfileOption(
                    iconRes = R.drawable.icon_setting,
                    label = stringResource(R.string.profile_setting),
                    onClick = { navController.navigate("settings") }
                )
                ProfileOption(
                    iconRes = R.drawable.icon_help,
                    label = stringResource(R.string.profile_help),
                    onClick = { navController.navigate("help_center") }
                )
                ProfileOption(
                    iconRes = R.drawable.icon_logout,
                    label = stringResource(R.string.profile_logout),
                    onClick = { showDialog.value = true }
                )
            }
        }
    )

    ImagenFlotadora(135.dp, R.drawable.profile_picture)

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            confirmButton = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    RoundedButton(
                        text = stringResource(R.string.profile_end_session_yes),
                        width = 207.dp,
                        height = 45.dp,
                        backgroundColor = CaribbeanGreen,
                        textColor = Color.White,
                        onClick = { showDialog.value = false },
                        navController = navController
                    )

                    Spacer(Modifier.height(10.dp))

                    RoundedButton(
                        text = stringResource(R.string.profile_cancel),
                        width = 207.dp,
                        height = 45.dp,
                        backgroundColor = LightGreen,
                        textColor = Void,
                        onClick = { showDialog.value = false },
                        navController = navController
                    )
                }
            },
            title = {
                Text(
                    text = stringResource(R.string.profile_end_session_title),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Void,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            text = {
                Text(
                    text = stringResource(R.string.profile_end_session_message),
                    textAlign = TextAlign.Center,
                    color = Void,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            containerColor = Color.White
        )
    }
}
