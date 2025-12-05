package com.example.parcialtp3.ui.screens.categories.entertainment

// NUEVOS IMPORTS
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

data class EntertainmentExpense(
    val title: String,
    val time: String,
    val amount: String
)

@Composable
fun A_Entertainment_Screen(
    navController: NavHostController
) {
    val aprilExpenses = listOf(
        EntertainmentExpense(stringResource(R.string.cinema),
            stringResource(R.string._20_15_april_29), "-$30,00"),
        EntertainmentExpense(stringResource(R.string.netflix),
            stringResource(R.string._16_15_april_12), "-$12,27"),
        EntertainmentExpense(stringResource(R.string.karaoke),
            stringResource(R.string._18_00_april_05), "-$10,00"),
    )
    val marchExpenses = listOf(
        EntertainmentExpense(stringResource(R.string.video_game),
            stringResource(R.string._20_50_march_24), "-$60,20"),
        EntertainmentExpense(stringResource(R.string.netflix),
            stringResource(R.string._16_15_march_12), "-$12,27"),
    )

    // 1. Agrupa tus datos en la nueva data class
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
                    title = stringResource(R.string.entertainment),
                    navController = navController,
                    onBackClick = { navController.popBackStack() }
                )
                Spacer(modifier = Modifier.height(24.dp))
                FinanceSummaryBlock()
            }
        },
        panelContent = {
            // 2. Llama al nuevo CategoryPanel
            CategoryPanel(
                monthlyExpenses = allMonthlyExpenses,
                iconResId = R.drawable.vector_enter,
                onAddExpense = {
                    navController?.navigate("entertainment/addExpense")
                },
                // 3. Dile al panel cómo leer tus datos
                expenseData = { expense ->
                    Triple(expense.title, expense.time, expense.amount)
                }
            )
        }
    )
}
