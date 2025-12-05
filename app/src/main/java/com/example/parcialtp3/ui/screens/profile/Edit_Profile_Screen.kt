package com.example.parcialtp3.ui.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.DisplayName
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.ImagenFlotadora
import com.example.parcialtp3.ui.components.RoundedButton
import com.example.parcialtp3.ui.components.RoundedInputField
import com.example.parcialtp3.ui.components.SettingsSwitchRow
import com.example.parcialtp3.ui.components.SimpleText

@Composable
fun Edit_Profile_Screen(
    navController: NavHostController,
    viewModel: ThemeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val pushNotificationsEnabled = remember { mutableStateOf(true) }
    val darkThemeState = viewModel.darkThemeEnabled.collectAsState()

    BackgroundScaffold(
        navController = navController,
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                title = stringResource(R.string.edit_profile_title),
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

                Spacer(Modifier.height(30.dp))

                SimpleText(
                    text = stringResource(R.string.edit_profile_account_settings),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp)
                )

                Spacer(Modifier.height(25.dp))

                // Username
                RoundedInputField(
                    label = stringResource(R.string.edit_profile_username),
                    placeholder = "John Smith",
                    onTextChanged = {}
                )

                Spacer(Modifier.height(20.dp))

                // Phone
                RoundedInputField(
                    label = stringResource(R.string.edit_profile_phone),
                    placeholder = "+44 555 5555 55",
                    onTextChanged = {}
                )

                Spacer(Modifier.height(20.dp))

                // Email
                RoundedInputField(
                    label = stringResource(R.string.edit_profile_email),
                    placeholder = "example@example.com",
                    onTextChanged = {}
                )

                Spacer(Modifier.height(35.dp))

                SettingsSwitchRow(
                    label = stringResource(R.string.edit_profile_push_notifications),
                    checked = pushNotificationsEnabled.value,
                    onCheckedChange = { pushNotificationsEnabled.value = it }
                )

                SettingsSwitchRow(
                    label = stringResource(R.string.edit_profile_turn_dark_theme),
                    checked = darkThemeState.value,
                    onCheckedChange = { viewModel.toggleTheme(it) }
                )

                Spacer(Modifier.height(20.dp))

                RoundedButton(
                    text = stringResource(R.string.edit_profile_update_button),
                    width = 207.dp,
                    height = 45.dp,
                    backgroundColor = CaribbeanGreen,
                    onClick = {},
                    navController = navController
                )
            }
        }
    )

    ImagenFlotadora(135.dp, R.drawable.profile_picture)
}
