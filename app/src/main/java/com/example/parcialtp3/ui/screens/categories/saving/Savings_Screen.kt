package com.example.parcialtp3.ui.screens.categories.saving

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.components.AddCategoryDialog
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.CategoryGridItem
import com.example.parcialtp3.ui.components.FinanceSummaryBlock
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.components.PrimaryButton

data class SavingCategoryUi(
    val id: String,
    val title: String,
    val iconRes: Int,
    val isPrimary: Boolean = false,
    val direccion: String
)

@Composable
fun SavingsScreen(
    navController: NavHostController
) {

    var showAddCategoryDialog by remember { mutableStateOf(false) }

    val primaryColor = Color(0xFF006BFF)
    val secondaryColor = Color(0xFF87C8FF)

    val categories = listOf(
        SavingCategoryUi(
            "travel",
            title = stringResource(R.string.travel),
            iconRes = R.drawable.vector_plane,
            isPrimary = true,
            direccion = "travel"
        ),
        SavingCategoryUi(
            "new_house",
            title = stringResource(R.string.new_house),
            iconRes = R.drawable.vector_newhouse,
            direccion = "newHouse"
        ),
        SavingCategoryUi(
            "car",
            title = stringResource(R.string.car),
            iconRes = R.drawable.vector_car,
            direccion = "car"
        ),
        SavingCategoryUi(
            "wedding",
            title = stringResource(R.string.wedding),
            iconRes = R.drawable.vector_wedding,
            direccion = "wedding"
        ),
    )

    if (showAddCategoryDialog) {
        AddCategoryDialog(
            onDismissRequest = { showAddCategoryDialog = false },
            onConfirm = { categoryName ->
                showAddCategoryDialog = false
            }
        )
    }

    BackgroundScaffold(
        navController = navController,
        headerHeight = 290.dp,
        headerContent = {
            Column {
                HeaderBar(
                    title = stringResource(R.string.savings),
                    navController = navController,
                    onBackClick = { navController.popBackStack() }
                )
                Spacer(modifier = Modifier.height(12.dp))
                FinanceSummaryBlock()
            }
        },
        panelContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 18.dp)
                    .padding(bottom = 120.dp) // para que no lo tape el BottomNav
            ) {

                categories.chunked(3).forEach { rowItems ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        rowItems.forEach { item ->
                            Box(modifier = Modifier.weight(1f)) {
                                CategoryGridItem(
                                    title = item.title,
                                    iconRes = item.iconRes,
                                    backgroundColor = if (item.isPrimary) primaryColor else secondaryColor,
                                    onClick = { navController.navigate(item.direccion) }
                                )
                            }
                        }

                        repeat(3 - rowItems.size) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                }

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    PrimaryButton(
                        text = stringResource(R.string.add_more),
                        onClick = { showAddCategoryDialog = true }
                    )
                }
            }
        }

    )
}
