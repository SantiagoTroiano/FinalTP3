import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

data class CategoryUi(
    val id: String,
    val title: String,
    val iconRes: Int,
    val isPrimary: Boolean = false,
    val direccion: String
)

@Composable
fun CategoriesScreen(
    navController: NavHostController
) {
    var showAddCategoryDialog by remember { mutableStateOf(false) }

    val primaryColor = Color(0xFF006BFF)
    val secondaryColor = Color(0xFF87C8FF)

    val categories = listOf(
        CategoryUi("food", stringResource(R.string.category_food), R.drawable.vector_food, true, direccion = "food"),
        CategoryUi("transport", stringResource(R.string.category_transport), R.drawable.vector_transport, direccion = "transport"),
        CategoryUi("medicine", stringResource(R.string.category_medicine), R.drawable.vector_medicine, direccion = "medicine"),
        CategoryUi("groceries", stringResource(R.string.category_groceries), R.drawable.vector_groceries, direccion = "groceries"),
        CategoryUi("rent", stringResource(R.string.category_rent), R.drawable.vector_rent, direccion = "rent"),
        CategoryUi("gifts", stringResource(R.string.category_gifts), R.drawable.vector_gift, direccion = "gifts"),
        CategoryUi("savings", stringResource(R.string.category_savings), R.drawable.vector_savings, direccion = "savings"),
        CategoryUi("entertainment", stringResource(R.string.category_entertainment), R.drawable.vector_enter, direccion = "entertainment"),
        CategoryUi("new_category", stringResource(R.string.category_more), R.drawable.vector_more, direccion = "more")
    )

    if (showAddCategoryDialog) {
        AddCategoryDialog(
            onDismissRequest = { showAddCategoryDialog = false },
            onConfirm = { showAddCategoryDialog = false }
        )
    }

    BackgroundScaffold(
        navController = navController,
        current = "categories",
        headerHeight = 290.dp,

        headerContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                HeaderBar(
                    title = stringResource(R.string.categories),
                    navController = navController,
                    onBackClick = { navController.popBackStack() }
                )

                Spacer(modifier = Modifier.height(12.dp))
                FinanceSummaryBlock()
            }
        },

        panelContent = {

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 18.dp)
            ) {

                val rows = categories.chunked(3)

                rows.forEach { row ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 14.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        row.forEach { item ->

                            CategoryGridItem(
                                title = item.title,
                                iconRes = item.iconRes,
                                backgroundColor = if (item.isPrimary) primaryColor else secondaryColor,
                                modifier = Modifier.weight(1f),
                                onClick = {
                                    if (item.id == "new_category") {
                                        showAddCategoryDialog = true
                                    } else {
                                        navController.navigate(item.direccion)
                                    }
                                }
                            )
                        }

                        // Relleno para completar espacios si la fila tiene menos de 3 elementos
                        if (row.size < 3) {
                            repeat(3 - row.size) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }
        }

    )
}
