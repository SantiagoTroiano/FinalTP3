package com.example.parcialtp3.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isSpecified
import androidx.navigation.NavHostController
import com.example.parcialtp3.ui.ThemeAwareColors

@Composable
fun BackgroundScaffold(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    headerHeight: Dp = 220.dp,
    whiteHeight: Dp = Dp.Unspecified,
    overlapRoundness: Dp = 48.dp,
    overlapOffset: Dp = 8.dp,
    headerContent: @Composable () -> Unit = {},
    panelContent: @Composable () -> Unit = {},
    current: String = "",
    displayBottomNavBar: Boolean = true
) {
    val themeColors = ThemeAwareColors.getColors()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(themeColors.headerBackground)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(headerHeight),
                contentAlignment = Alignment.TopCenter
            ) {
                Box(modifier = Modifier.padding(top = 60.dp)) {
                    headerContent()
                }
            }

            val panelModifier =
                if (whiteHeight.isSpecified) {
                    Modifier.fillMaxWidth().height(whiteHeight)
                } else {
                    Modifier.fillMaxWidth().wrapContentHeight()
                }

            Surface(
                color = themeColors.contentBackground,
                shape = RoundedCornerShape(topStart = overlapRoundness, topEnd = overlapRoundness),
                modifier = panelModifier.offset(y = -overlapOffset)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    panelContent()
                }
            }

            Spacer(modifier = Modifier.height(120.dp))
        }

        if (displayBottomNavBar) {
            Surface(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(),
                color = Color.Transparent,
                shadowElevation = 12.dp
            ) {
                BottomNavBar(navController = navController, current = current)
            }
        }
    }
}
