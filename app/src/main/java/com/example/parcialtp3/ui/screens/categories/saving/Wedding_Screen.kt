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

data class WeddingDeposit(
    val title: String,
    val time: String,
    val amount: String,
    @DrawableRes val iconRes: Int
)

@Composable
fun WeddingScreen(
    navController: NavHostController
) {
    val weddingIcon = R.drawable.vector_wedding

    val novemberDeposits = listOf(
        WeddingDeposit(
            title = stringResource(R.string.wedding_deposit),
            time = stringResource(R.string.november_15_time),
            amount = stringResource(R.string.amount_87_32),
            iconRes = weddingIcon
        )
    )

    val septemberDeposits = listOf(
        WeddingDeposit(
            title = stringResource(R.string.wedding_deposit),
            time = stringResource(R.string.september_30_time),
            amount = stringResource(R.string.amount_22_99),
            iconRes = weddingIcon
        ),
        WeddingDeposit(
            title = stringResource(R.string.wedding_deposit),
            time = stringResource(R.string.september_15_time),
            amount = stringResource(R.string.amount_185_94),
            iconRes = weddingIcon
        )
    )

    val monthSections = mapOf(
        stringResource(R.string.november) to novemberDeposits,
        stringResource(R.string.september) to septemberDeposits
    )

    BackgroundScaffold(
        navController = navController,
        headerHeight = 120.dp,
        headerContent = {
            HeaderBar(
                title = stringResource(R.string.wedding),
                navController = navController,
                onBackClick = { navController.popBackStack() }
            )
        },
        panelContent = {
            Column(Modifier.fillMaxWidth()) {
                Spacer(Modifier.height(16.dp))
                SavingsTargetSummaryGeneric(
                    title = stringResource(R.string.wedding),
                    iconRes = weddingIcon,
                    goalAmount = stringResource(R.string.goal_34700),
                    savedAmount = stringResource(R.string.saved_296_25),
                    progressPercent = 0.10f,
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
                        navController.navigate("wedding/addSavings")
                    }
                )
            }
        }
    )
}
