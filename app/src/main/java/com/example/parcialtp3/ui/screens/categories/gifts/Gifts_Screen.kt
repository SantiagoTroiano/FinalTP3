package com.example.parcialtp3.ui.screens.categories.gifts

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

data class GiftExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun GiftsScreen(
    navController: NavHostController
) {
    val aprilExpenses = listOf(
        GiftExpense(stringResource(R.string.perfume),
            stringResource(R.string._10_27_april_28), stringResource(R.string._30_00)),
        GiftExpense(stringResource(R.string.make_up),
            stringResource(R.string._16_28_april_15), stringResource(R.string._60_35)
        )
    )
    val marchExpenses = listOf(
        GiftExpense(stringResource(R.string.teddy_bear),
            stringResource(R.string._8_30_march_10), stringResource(R.string._20_00)
        ),
        GiftExpense(stringResource(R.string.cooking_lessons),
            stringResource(R.string._14_24_march_02), stringResource(R.string._128_00)
        )
    )
    val februaryExpenses = listOf(
        GiftExpense(stringResource(R.string.toys_for_dani),
            stringResource(R.string._11_15_february_18), stringResource(R.string._50_20)
        )
    )

    val allMonthlyExpenses = listOf(
        MonthlyExpenseGroup(stringResource(R.string.april), aprilExpenses),
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
                    title = stringResource(R.string.gifts),
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
                iconResId = R.drawable.vector_gift,
                onAddExpense = {
                    navController?.navigate("gifts/addExpense")
                },
                expenseData = { expense ->
                    Triple(expense.title, expense.time, expense.amount)
                }
            )
        }
    )
}