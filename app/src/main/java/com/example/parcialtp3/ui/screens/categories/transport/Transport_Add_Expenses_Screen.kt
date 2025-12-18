package com.example.parcialtp3.ui.screens.categories.transport

// NUEVOS IMPORTS
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Cyprus
import com.example.parcialtp3.ui.FenceGreen
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.MessageBox
import com.example.parcialtp3.ui.components.PrimaryButton
import com.example.parcialtp3.ui.components.RoundedInputRow

@Composable
fun TransportAddExpenseScreen(
    navController: NavHostController
) {
    BackgroundScaffold(
        navController = navController,
        headerHeight = 180.dp,
        headerContent = {
            HeaderBar(
                title = stringResource(R.string.add_expenses),
                navController = navController,
                onBackClick = { navController.popBackStack() }
            )
        },
        panelContent = {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {

                RoundedInputRow(
                    label = stringResource(R.string.date_label),
                    value = stringResource(R.string.date_march_30_2024),
                    valueColor = Void,
                    trailing = {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(CaribbeanGreen),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.vector_calendar),
                                contentDescription = "calendar",
                                tint = FenceGreen,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                RoundedInputRow(
                    label = stringResource(R.string.category_label),
                    value = stringResource(R.string.select_category),
                    valueColor = Cyprus,
                    trailing = {
                        Icon(
                            painter = painterResource(id = R.drawable.vector_down),
                            contentDescription = "down",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                RoundedInputRow(
                    label = stringResource(R.string.amount_label),
                    value = stringResource(R.string.amount_3_53),
                    valueColor = Void
                )

                Spacer(modifier = Modifier.height(16.dp))

                RoundedInputRow(
                    label = stringResource(R.string.expense_title_label),
                    value = stringResource(R.string.fuel),
                    valueColor = Void
                )

                Spacer(modifier = Modifier.height(16.dp))

                MessageBox(
                    label = stringResource(R.string.enter_message)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    PrimaryButton(
                        text = stringResource(R.string.save),
                        onClick = { /* guardar */ }
                    )
                }
            }
        }
    )
}

