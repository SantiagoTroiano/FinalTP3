

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

data class CarDeposit(
    val title: String,
    val time: String,
    val amount: String,
    @DrawableRes val iconRes: Int
)

@Composable
fun CarScreen(
    navController: NavHostController
) {
    val carIcon = R.drawable.vector_car

    val aprilDeposits = listOf(
        CarDeposit(
            title = stringResource(R.string.car_deposit),
            time = stringResource(R.string.time_july_5_1416),
            amount = stringResource(R.string.amount_387_32),
            iconRes = carIcon
        ),
        CarDeposit(
            title = stringResource(R.string.car_deposit),
            time = stringResource(R.string.time_may_30_2145),
            amount = stringResource(R.string.amount_122_99),
            iconRes = carIcon
        ),
        CarDeposit(
            title = stringResource(R.string.house_deposit),
            time = stringResource(R.string.time_may_05_1425),
            amount = stringResource(R.string.amount_85_94),
            iconRes = carIcon
        )
    )

    val monthSections = mapOf(
        stringResource(R.string.april) to aprilDeposits
    )

    BackgroundScaffold(
        navController = navController,
        headerHeight = 120.dp,
        headerContent = {
            HeaderBar(
                title = stringResource(R.string.car),
                navController = navController,
                onBackClick = { navController.popBackStack() }
            )
        },
        panelContent = {
            Column(Modifier.fillMaxWidth()) {
                Spacer(Modifier.height(16.dp))

                SavingsTargetSummaryGeneric(
                    title = stringResource(R.string.car),
                    iconRes = carIcon,
                    goalAmount = stringResource(R.string.goal_14390),
                    savedAmount = stringResource(R.string.saved_596_25),
                    progressPercent = 0.15f,
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
                        navController?.navigate("car/addSavings")
                    }
                )
            }
        }
    )
}
