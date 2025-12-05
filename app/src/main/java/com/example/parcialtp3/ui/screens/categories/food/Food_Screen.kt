package com.example.parcialtp3.ui.screens.categories.food

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

data class FoodExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun FoodScreen(
    navController: NavHostController
) {
    val aprilExpenses = listOf(
        FoodExpense(stringResource(R.string.dinner), stringResource(R.string._18_27_april_30), stringResource(R.string._26_00)),
        FoodExpense(stringResource(R.string.delivery_pizza), stringResource(R.string._15_00_april_24), stringResource(R.string._18_35)),
        FoodExpense(stringResource(R.string.lunch),
            stringResource(R.string._12_30_april_15), stringResource(R.string._15_40)
        ),
        FoodExpense(stringResource(R.string.brunch),
            stringResource(R.string._9_30_april_08), stringResource(R.string._12_13)
        ),
    )
    val marchExpenses = listOf(
        FoodExpense(stringResource(R.string.dinner),
            stringResource(R.string._20_50_march_31), stringResource(R.string._27_20)
        )
    )


    val allMonthlyExpenses = listOf(
        MonthlyExpenseGroup("April", aprilExpenses),
        MonthlyExpenseGroup("March", marchExpenses)
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
                    title = "Food",
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
                iconResId = R.drawable.vector_food,
                onAddExpense = {
                    navController?.navigate("food/addExpense")
                },
                expenseData = { expense ->
                    Triple(expense.title, expense.time, expense.amount)
                }
            )
        }
    )
}