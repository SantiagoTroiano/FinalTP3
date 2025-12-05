package com.example.parcialtp3.ui.screens.categories.medicine

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

data class MedicineExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun A_Medicine_Screen(
    navController: NavHostController
) {
    val aprilExpenses = listOf(
        MedicineExpense(
            title = stringResource(R.string.acetaminophen),
            time = stringResource(R.string.time_18_27_april_30),
            amount = stringResource(R.string.amount_minus_2_00)
        )
    )
    val marchExpenses = listOf(
        MedicineExpense(
            title = stringResource(R.string.vitamin_c),
            time = stringResource(R.string.time_15_00_march_30),
            amount = stringResource(R.string.amount_minus_1_00)
        ),
        MedicineExpense(
            title = stringResource(R.string.muscle_pain_cream),
            time = stringResource(R.string.time_12_47_march_10),
            amount = stringResource(R.string.amount_minus_0_50)
        )
    )
    val februaryExpenses = listOf(
        MedicineExpense(
            title = stringResource(R.string.aspirin),
            time = stringResource(R.string.time_9_50_feb_09),
            amount = stringResource(R.string.amount_minus_3_00)
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
                    title = stringResource(R.string.medicine),
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
                iconResId = R.drawable.vector_medicine,
                onAddExpense = {
                    navController.navigate("medicine/addExpense")
                },
                expenseData = { expense ->
                    Triple(expense.title, expense.time, expense.amount)
                }
            )
        }
    )
}
