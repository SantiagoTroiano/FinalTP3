package com.example.parcialtp3.ui.screens.categories.groceries

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

data class GroceriesExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun GroceriesScreen(
    navController: NavHostController
) {
    val marchExpenses = listOf(
        GroceriesExpense(
            title = stringResource(R.string.pantry),
            time = stringResource(R.string.time_17_00_march_24),
            amount = stringResource(R.string.amount_minus_26_00)
        ),
        GroceriesExpense(
            title = stringResource(R.string.snacks),
            time = stringResource(R.string.time_17_02_march_24),
            amount = stringResource(R.string.amount_minus_18_35)
        )
    )

    val februaryExpenses = listOf(
        GroceriesExpense(
            title = stringResource(R.string.canned_food),
            time = stringResource(R.string.time_18_30_feb_28),
            amount = stringResource(R.string.amount_minus_15_40)
        ),
        GroceriesExpense(
            title = stringResource(R.string.veggies),
            time = stringResource(R.string.time_18_31_feb_28),
            amount = stringResource(R.string.amount_minus_12_13)
        ),
        GroceriesExpense(
            title = stringResource(R.string.groceries),
            time = stringResource(R.string.time_18_31_feb_28_b),
            amount = stringResource(R.string.amount_minus_27_20)
        )
    )

    val allMonthlyExpenses = listOf(
        MonthlyExpenseGroup(stringResource(R.string.march), marchExpenses),
        MonthlyExpenseGroup(stringResource(R.string.february), februaryExpenses)
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
                    title = stringResource(R.string.groceries),
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
                iconResId = R.drawable.vector_groceries,
                onAddExpense = {
                    navController.navigate("groceries/addExpense")
                },
                expenseData = { expense ->
                    Triple(expense.title, expense.time, expense.amount)
                }
            )
        }
    )
}
