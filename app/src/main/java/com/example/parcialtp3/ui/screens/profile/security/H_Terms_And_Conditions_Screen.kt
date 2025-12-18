package com.example.parcialtp3.ui.screens.profile.security

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
// import androidx.compose.foundation.rememberScrollState <-- NO ES NECESARIO
import androidx.compose.foundation.shape.RoundedCornerShape
// import androidx.compose.foundation.verticalScroll <-- ESTE ERA EL CAUSANTE DEL CRASH
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.*
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar

@Composable
fun H_Terms_And_Conditions_Screen(
    navController: NavHostController,
    onOpenLink: (String) -> Unit = {},
    onAccept: () -> Unit = {}
)
{
    var accepted by remember { mutableStateOf(false) }
    // val scroll = rememberScrollState() <-- ELIMINADO

    val link = stringResource(R.string.terms_link)

    BackgroundScaffold(
        navController = navController,
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                navController = navController,
                title = stringResource(R.string.terms_title),
                onBackClick = { navController.popBackStack() }
            )
        },
        panelContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .navigationBarsPadding()
                    .padding(bottom = 16.dp)
            ) {
                Spacer(Modifier.height(8.dp))

                Surface(
                    shape = RoundedCornerShape(24.dp),
                    color = Honeydew
                ) {
                    // AQUÍ ESTABA EL ERROR:
                    // Quitamos .verticalScroll(scroll) porque el BackgroundScaffold ya tiene scroll.
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.terms_header),
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            ),
                            color = Void
                        )

                        Spacer(Modifier.height(8.dp))

                        ParagraphSmall(stringResource(R.string.terms_paragraph_1))

                        NumberedListCompactSmall(
                            listOf(
                                stringResource(R.string.terms_item_1),
                                stringResource(R.string.terms_item_2),
                                stringResource(R.string.terms_item_3),
                                stringResource(R.string.terms_item_4)
                            )
                        )

                        ParagraphSmall(stringResource(R.string.terms_paragraph_2))

                        BulletedListCompactSmall(
                            listOf(
                                stringResource(R.string.terms_bullet_1),
                                stringResource(R.string.terms_bullet_2)
                            )
                        )

                        ParagraphSmall(stringResource(R.string.terms_paragraph_3))

                        val annotated = buildAnnotatedString {
                            append(stringResource(R.string.terms_read_more_prefix) + " ")
                            withStyle(
                                SpanStyle(
                                    color = CaribbeanGreen,
                                    fontWeight = FontWeight.SemiBold
                                )
                            ) { append(link) }
                        }

                        Text(
                            text = annotated,
                            style = MaterialTheme.typography.bodySmall,
                            color = Void,
                            modifier = Modifier.clickable { onOpenLink(link) }
                        )
                    }
                }

                Spacer(Modifier.height(12.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Checkbox(
                        checked = accepted,
                        onCheckedChange = { accepted = it },
                        colors = CheckboxDefaults.colors(checkedColor = CaribbeanGreen)
                    )
                    Text(
                        text = stringResource(R.string.terms_accept_checkbox),
                        style = MaterialTheme.typography.bodySmall,
                        color = Void
                    )
                }

                Spacer(Modifier.height(12.dp))

                Button(
                    onClick = onAccept,
                    enabled = accepted,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(0.5f)
                        .height(44.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = CaribbeanGreen,
                        contentColor = Void,
                        disabledContainerColor = LightGreen,
                        disabledContentColor = Void.copy(alpha = 0.6f)
                    )
                ) {
                    Text(
                        text = stringResource(R.string.terms_accept_button),
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }
        }
    )
}

@Composable
private fun ParagraphSmall(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall,
        color = Void,
        lineHeight = 16.sp
    )
    Spacer(Modifier.height(8.dp))
}

@Composable
private fun NumberedListCompactSmall(items: List<String>) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        items.forEachIndexed { idx, itemText ->
            Text(
                text = "${idx + 1}. $itemText",
                style = MaterialTheme.typography.bodySmall,
                color = Void
            )
        }
    }
    Spacer(Modifier.height(8.dp))
}

@Composable
private fun BulletedListCompactSmall(items: List<String>) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        items.forEach { itemText ->
            Text(
                text = "• $itemText",
                style = MaterialTheme.typography.bodySmall,
                color = Void
            )
        }
    }
    Spacer(Modifier.height(8.dp))
}
