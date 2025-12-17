package com.example.parcialtp3.ui.screens.transactions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.OceanBlue
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.CabeceraTransactions
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.TransactionsMonthSection
import com.example.parcialtp3.ui.viewmodels.TransactionsViewModel


@Composable
fun TransactionsIncomeScreen(navController: NavHostController) {
    val viewModel: TransactionsViewModel = hiltViewModel()

    BackgroundScaffold(
        navController = navController,
        current = "transactions",
        headerHeight = 410.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = { TransactionsIncomeHeader(navController) },
        panelContent = {
            TransactionsMonthSection(
                viewModel = viewModel,
                typeFilter = "income"
            )
        }
    )
}

@Composable
fun TransactionsIncomeHeader(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxWidth()   // ← Antes fillMaxSize()
    ) {
        HeaderBar(
            title = stringResource(R.string.transactions_title),
            navController = navController,
            onBackClick = { navController.popBackStack() }
        )

        CabeceraTransactions(
            tarjetaBalanceText1 = stringResource(R.string.transactions_total_balance),
            tarjetaBalanceText2 = stringResource(R.string.transactions_balance_value),

            tarjeta1Direccion = "Tranasctions_Screen",
            tarjeta1Color = OceanBlue,
            tarjeta1Imagen = R.drawable.group_395_white,
            tarjeta1Texto1 = stringResource(R.string.transactions_income_label),
            tarjeta1Texto2 = stringResource(R.string.transactions_income_value),
            tarjeta1Texto1Color = Honeydew,
            tarjeta1Texto2Color = Honeydew,

            tarjeta2Direccion = "Expense_Screen",
            tarjeta2Color = Honeydew,
            tarjeta2Imagen = R.drawable.group_396,
            tarjeta2Texto1 = stringResource(R.string.transactions_expense_label),
            tarjeta2Texto2 = stringResource(R.string.transactions_expense_value),
            tarjeta2Texto1Color = Void,
            tarjeta2Texto2Color = OceanBlue,

            navController = navController
        )

        // ❌ Antes: Spacer(modifier = Modifier.weight(1f))
        // Eliminado para que el header no crezca artificialmente
    }
}
