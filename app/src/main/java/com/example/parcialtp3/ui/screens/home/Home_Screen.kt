package com.example.parcialtp3.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.*
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.FinanceSummaryBlock
import com.example.parcialtp3.ui.poppinsFamily
import com.example.parcialtp3.ui.viewmodels.TransactionsViewModel

data class HomeTransaction(
    val iconRes: Int,
    val title: Int,
    val subtitle: Int,
    val category: Int,
    val amount: Int
)

@Composable
fun HomeScreen(navController: NavHostController) {

    val viewModel: TransactionsViewModel = hiltViewModel()

    val transactions = listOf(
        HomeTransaction(
            R.drawable.icon_salary,
            R.string.home_tx_salary,
            R.string.home_tx_time_salary,
            R.string.home_tx_category_monthly,
            R.string.home_tx_amount_salary
        ),
        HomeTransaction(
            R.drawable.icon_groceries,
            R.string.home_tx_groceries,
            R.string.home_tx_time_groceries,
            R.string.home_tx_category_pantry,
            R.string.home_tx_amount_groceries
        ),
        HomeTransaction(
            R.drawable.icon_rent,
            R.string.home_tx_rent,
            R.string.home_tx_time_rent,
            R.string.home_tx_category_rent,
            R.string.home_tx_amount_rent
        )
    )

    var selectedFilter by remember { mutableStateOf("Monthly") }

    Box(modifier = Modifier.fillMaxSize()) {

        BackgroundScaffold(
            current = "HomeScreen",
            navController = navController,
            headerHeight = 320.dp,
            headerContent = {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    Spacer(modifier = Modifier.height(1.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column {
                            Text(
                                text = stringResource(R.string.home_hi_welcome_back),
                                color = Void,
                                fontFamily = poppinsFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = stringResource(R.string.home_good_morning),
                                color = Void,
                                fontFamily = poppinsFamily,
                                fontSize = 13.sp
                            )
                        }

                        Image(
                            painter = painterResource(id = R.drawable.icon_notification),
                            contentDescription = stringResource(R.string.home_notifications_cd),
                            modifier = Modifier
                                .size(32.dp)
                                .clickable { navController.navigate("notifications") }
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    FinanceSummaryBlock(
                        modifier = Modifier.clickable {
                            navController.navigate("account_balance")
                        }
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                }
            },

            panelContent = {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {

                    Surface(
                        color = CaribbeanGreen,
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier.weight(1f)
                            ) {

                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.size(90.dp)
                                ) {

                                    Box(
                                        modifier = Modifier
                                            .matchParentSize()
                                            .clip(CircleShape)
                                    ) {
                                        Row(Modifier.matchParentSize()) {
                                            Box(
                                                Modifier
                                                    .weight(1f)
                                                    .fillMaxHeight()
                                                    .background(Honeydew)
                                            )
                                            Box(
                                                Modifier
                                                    .weight(1f)
                                                    .fillMaxHeight()
                                                    .background(OceanBlue)
                                            )
                                        }
                                    }

                                    Box(
                                        contentAlignment = Alignment.Center,
                                        modifier = Modifier
                                            .size(78.dp)
                                            .clip(CircleShape)
                                            .background(CaribbeanGreen)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.vector_car),
                                            contentDescription = "Savings Icon",
                                            modifier = Modifier.size(40.dp)
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    stringResource(R.string.home_savings_on_goals),
                                    color = Void,
                                    fontFamily = poppinsFamily
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .width(1.5.dp)
                                    .height(70.dp)
                                    .background(Honeydew.copy(alpha = 0.8f))
                            )

                            Column(
                                modifier = Modifier
                                    .weight(2f)
                                    .padding(start = 10.dp),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_salary),
                                        contentDescription = "Revenue Icon",
                                        modifier = Modifier.size(22.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))

                                    Column {
                                        Text(
                                            stringResource(R.string.home_revenue_last_week),
                                            color = Void,
                                            fontFamily = poppinsFamily
                                        )
                                        Text(
                                            stringResource(R.string.home_revenue_amount),
                                            color = FenceGreen,
                                            fontFamily = poppinsFamily
                                        )
                                    }
                                }

                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1.dp)
                                        .background(Honeydew.copy(alpha = 0.5f))
                                )

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painter = painterResource(id = R.drawable.vector_food),
                                        contentDescription = "Food Icon",
                                        modifier = Modifier.size(22.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))

                                    Column {
                                        Text(
                                            stringResource(R.string.home_food_last_week),
                                            color = Void,
                                            fontFamily = poppinsFamily
                                        )
                                        Text(
                                            stringResource(R.string.home_food_amount),
                                            color = OceanBlue,
                                            fontFamily = poppinsFamily
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                            .background(
                                color = LightGreen,
                                shape = RoundedCornerShape(24.dp)
                            )
                            .padding(horizontal = 6.dp, vertical = 6.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            listOf(
                                stringResource(R.string.home_filter_daily),
                                stringResource(R.string.home_filter_weekly),
                                stringResource(R.string.home_filter_monthly),
                            ).forEach { label ->

                                val isSelected = selectedFilter == label

                                Surface(
                                    color = if (isSelected) CaribbeanGreen else Color.Transparent,
                                    shape = RoundedCornerShape(20.dp),
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(46.dp)
                                        .clickable { selectedFilter = label }
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Text(
                                            text = label,
                                            color = Void,
                                            fontFamily = poppinsFamily,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                            fontSize = 14.sp
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // REEMPLAZA LAZY COLUMN POR COLUMN
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp, bottom = 100.dp)
                    ) {

                        transactions.forEach { t ->

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Box(
                                    modifier = Modifier
                                        .size(44.dp)
                                        .clip(CircleShape)
                                        .background(
                                            if (stringResource(t.amount).startsWith("-"))
                                                LightBlue.copy(alpha = 0.3f)
                                            else LightGreen
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        painter = painterResource(id = t.iconRes),
                                        contentDescription = stringResource(t.title),
                                        modifier = Modifier.size(22.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.width(14.dp))

                                Column(
                                    modifier = Modifier.weight(1.3f)
                                ) {
                                    Text(
                                        text = stringResource(t.title),
                                        color = Void,
                                        fontFamily = poppinsFamily,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 15.sp
                                    )

                                    Spacer(modifier = Modifier.height(2.dp))

                                    Text(
                                        text = stringResource(t.subtitle),
                                        color = OceanBlue,
                                        fontFamily = poppinsFamily,
                                        fontSize = 12.sp
                                    )
                                }

                                Box(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .height(36.dp)
                                        .background(CaribbeanGreen.copy(alpha = 0.5f))
                                )

                                Box(
                                    modifier = Modifier
                                        .weight(0.8f)
                                        .fillMaxHeight(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = stringResource(t.category),
                                        color = FenceGreen,
                                        fontFamily = poppinsFamily,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }

                                Box(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .height(36.dp)
                                        .background(CaribbeanGreen.copy(alpha = 0.5f))
                                )

                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxHeight(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = stringResource(t.amount),
                                        color = if (stringResource(t.amount).startsWith("-"))
                                            OceanBlue else FenceGreen,
                                        fontFamily = poppinsFamily,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 15.sp
                                    )
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(Honeydew.copy(alpha = 0.6f))
                            )
                        }
                    }
                }
            }
        )
    }
}
