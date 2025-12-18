package com.example.parcialtp3.ui.screens.categories.saving

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.SavingsDepositPanel
import com.example.parcialtp3.ui.components.SavingsTargetSummaryGeneric

data class NewHouseDeposit(
    val title: String,
    val time: String,
    val amount: String,
    @DrawableRes val iconRes: Int
)

@Composable
fun NewHouseScreen(
    navController: NavHostController
) {
    val houseIcon = R.drawable.vector_newhouse

    val aprilDeposits = listOf(
        NewHouseDeposit(
            title = stringResource(R.string.house_deposit),
            time = stringResource(R.string.time_19_56_april_5),
            amount = stringResource(R.string.amount_477_77),
            iconRes = houseIcon
        )
    )

    val januaryDeposits = listOf(
        NewHouseDeposit(
            title = stringResource(R.string.house_deposit),
            time = stringResource(R.string.time_20_25_january_16),
            amount = stringResource(R.string.amount_102_67),
            iconRes = houseIcon
        ),
        NewHouseDeposit(
            title = stringResource(R.string.house_deposit),
            time = stringResource(R.string.time_15_56_january_02),
            amount = stringResource(R.string.amount_45_04),
            iconRes = houseIcon
        )
    )

    val monthSections = linkedMapOf(
        stringResource(R.string.april) to aprilDeposits,
        stringResource(R.string.january) to januaryDeposits
    )

    BackgroundScaffold(
        navController = navController,
        headerHeight = 120.dp,
        headerContent = {
            HeaderBar(
                title = stringResource(R.string.new_house),
                navController = navController,
                onBackClick = { navController.popBackStack() }
            )
        },
        panelContent = {
            Column(Modifier.fillMaxWidth()) {
                Spacer(Modifier.height(16.dp))
                SavingsTargetSummaryGeneric(
                    title = stringResource(R.string.new_house),
                    iconRes = houseIcon,
                    goalAmount = stringResource(R.string.amount_569_200),
                    savedAmount = stringResource(R.string.amount_625_48),
                    progressPercent = 0.30f,
                    progressColor = CaribbeanGreen,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                SavingsDepositPanel(
                    monthSections = monthSections,
                    title = { it.title },
                    time = { it.time },
                    amount = { it.amount },
                    iconRes = { it.iconRes },
                    onAddSavingsClick = {
                        navController?.navigate("newHouse/addSavings")
                    }
                )
            }
        }
    )
}
