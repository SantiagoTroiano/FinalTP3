package com.example.parcialtp3.ui.screens.categories.transport

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
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.CategoryPanel
import com.example.parcialtp3.ui.components.FinanceSummaryBlock
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.MonthlyExpenseGroup

data class TransportExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun TransportScreen(
    navController: NavHostController
) {
    val marchExpenses = listOf(
        TransportExpense(
            title = stringResource(R.string.fuel),
            time = stringResource(R.string.time_18_27_march_30),
            amount = stringResource(R.string.amount_3_53)
        ),
        TransportExpense(
            title = stringResource(R.string.car_parts),
            time = stringResource(R.string.time_15_00_march_30),
            amount = stringResource(R.string.amount_28_75)
        )
    )

    val februaryExpenses = listOf(
        TransportExpense(
            title = stringResource(R.string.new_tires),
            time = stringResource(R.string.time_12_47_february_10),
            amount = stringResource(R.string.amount_373_99)
        ),
        TransportExpense(
            title = stringResource(R.string.car_wash),
            time = stringResource(R.string.time_9_50_february_09),
            amount = stringResource(R.string.amount_9_74)
        ),
        TransportExpense(
            title = stringResource(R.string.public_transport),
            time = stringResource(R.string.time_7_50_february_01),
            amount = stringResource(R.string.amount_1_24)
        )
    )

    val allMonthlyExpenses = listOf(
        MonthlyExpenseGroup(stringResource(R.string.month_march), marchExpenses),
        MonthlyExpenseGroup(stringResource(R.string.month_february), februaryExpenses)
    )

    BackgroundScaffold(
        navController = navController,
        headerHeight = 290.dp,
        headerContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                HeaderBar(
                    title = stringResource(R.string.transport),
                    navController = navController,
                    onBackClick = { navController.popBackStack() }
                )
                Spacer(modifier = Modifier.height(24.dp))
                FinanceSummaryBlock()
            }
        },
        panelContent = {
            CategoryPanel(
                monthlyExpenses = allMonthlyExpenses,
                iconResId = R.drawable.vector_transport,
                onAddExpense = {
                    navController?.navigate("transport/addExpense")
                },
                expenseData = { expense ->
                    Triple(expense.title, expense.time, expense.amount)
                }
            )
        }
    )
}
