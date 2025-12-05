package com.example.parcialtp3.ui.screens.categories.rent

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

data class RentExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun RentScreen(
    navController: NavHostController
) {
    val aprilExpenses = listOf(
        RentExpense(
            title = stringResource(R.string.rent),
            time = stringResource(R.string.rent_time_april),
            amount = stringResource(R.string.amount_674_40)
        )
    )

    val marchExpenses = listOf(
        RentExpense(
            title = stringResource(R.string.rent),
            time = stringResource(R.string.rent_time_march),
            amount = stringResource(R.string.amount_674_40)
        )
    )

    val februaryExpenses = listOf(
        RentExpense(
            title = stringResource(R.string.rent),
            time = stringResource(R.string.rent_time_february),
            amount = stringResource(R.string.amount_674_40)
        )
    )

    val januaryExpenses = listOf(
        RentExpense(
            title = stringResource(R.string.rent),
            time = stringResource(R.string.rent_time_january),
            amount = stringResource(R.string.amount_674_40)
        )
    )

    val allMonthlyExpenses = listOf(
        MonthlyExpenseGroup(stringResource(R.string.april), aprilExpenses),
        MonthlyExpenseGroup(stringResource(R.string.march), marchExpenses),
        MonthlyExpenseGroup(stringResource(R.string.february), februaryExpenses),
        MonthlyExpenseGroup(stringResource(R.string.january), januaryExpenses)
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
                    title = stringResource(R.string.rent),
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
                iconResId = R.drawable.vector_rent,
                onAddExpense = {
                    navController?.navigate("rent/addExpense")
                },
                expenseData = { expense ->
                    Triple(expense.title, expense.time, expense.amount)
                }
            )
        }
    )
}
