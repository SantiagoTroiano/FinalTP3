package com.example.parcialtp3.ui.screens.categories.saving

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
fun Wedding_Expense_Screen(
    navController: NavHostController
) {
    BackgroundScaffold(
        navController = navController,
        headerHeight = 180.dp,
        headerContent = {
            HeaderBar(
                title = stringResource(R.string.add_savings),
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
                    label = stringResource(R.string.date),
                    value = stringResource(R.string.november_15_2024),
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
                                contentDescription = null,
                                tint = FenceGreen,
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                RoundedInputRow(
                    label = stringResource(R.string.category),
                    value = stringResource(R.string.wedding),
                    valueColor = Cyprus,
                    trailing = {
                        Icon(
                            painter = painterResource(id = R.drawable.vector_down),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                RoundedInputRow(
                    label = stringResource(R.string.amount),
                    value = stringResource(R.string.amount_87_32),
                    valueColor = Void
                )

                Spacer(modifier = Modifier.height(16.dp))

                RoundedInputRow(
                    label = stringResource(R.string.expense_title),
                    value = stringResource(R.string.wedding_deposit),
                    valueColor = Void
                )

                Spacer(modifier = Modifier.height(16.dp))

                MessageBox(label = stringResource(R.string.enter_message))

                Spacer(modifier = Modifier.height(24.dp))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    PrimaryButton(
                        text = stringResource(R.string.save),
                        onClick = { }
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    )
}
