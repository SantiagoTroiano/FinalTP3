package com.example.parcialtp3.ui.screens.profile.help.online_support

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.components.BackgroundScaffold
import com.example.parcialtp3.ui.components.HeaderBar
import com.example.parcialtp3.ui.poppinsFamily

/* =========================== DATA (mock) ============================ */

private data class SupportChatUi(
    val id: String,
    val title: String,
    val subtitle: String,
    val rightPillText: String
)

/* =========================== SCREEN ============================ */

@Composable
fun A_Online_Support_Screen(
    navController: NavHostController,
    onStartNewChat: () -> Unit = {},
    onOpenChat: (String) -> Unit = {}
) {
    BackgroundScaffold(
        navController = navController,
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                title = stringResource(R.string.online_support_title),
                navController = navController,
                onBackClick = { navController.popBackStack() }
            )
        },
        panelContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Spacer(Modifier.height(12.dp))

                // Active
                SectionTitle(text = stringResource(R.string.online_support_active_chats))
                Spacer(Modifier.height(10.dp))

                ChatRow(
                    chat = SupportChatUi(
                        id = "active-1",
                        title = stringResource(R.string.online_support_support_assistant),
                        subtitle = stringResource(R.string.online_support_sub_support_hello),
                        rightPillText = stringResource(R.string.online_support_2min)
                    ),
                    onClick = onOpenChat
                )

                Spacer(Modifier.height(18.dp))

                // Ended
                SectionTitle(text = stringResource(R.string.online_support_ended_chats))
                Spacer(Modifier.height(10.dp))

                val ended = listOf(
                    SupportChatUi(
                        id = "end-1",
                        title = stringResource(R.string.online_support_help_center),
                        subtitle = stringResource(R.string.online_support_sub_account_ready),
                        rightPillText = stringResource(R.string.online_support_feb_08)
                    ),
                    SupportChatUi(
                        id = "end-2",
                        title = stringResource(R.string.online_support_support_assistant),
                        subtitle = stringResource(R.string.online_support_sub_support_hello),
                        rightPillText = stringResource(R.string.online_support_dec_24)
                    ),
                    SupportChatUi(
                        id = "end-3",
                        title = stringResource(R.string.online_support_support_assistant),
                        subtitle = stringResource(R.string.online_support_sub_support_hello),
                        rightPillText = stringResource(R.string.online_support_sep_10)
                    ),
                    SupportChatUi(
                        id = "end-4",
                        title = stringResource(R.string.online_support_help_center),
                        subtitle = stringResource(R.string.online_support_sub_how_are_you),
                        rightPillText = stringResource(R.string.online_support_june_12)
                    )
                )

                ended.forEachIndexed { index, chat ->
                    ChatRow(chat = chat, onClick = onOpenChat)
                    if (index != ended.lastIndex) {
                        Spacer(Modifier.height(12.dp))
                    }
                }

                Spacer(Modifier.height(24.dp))

                Button(
                    onClick = onStartNewChat,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .align(Alignment.CenterHorizontally)
                        .height(48.dp),
                    shape = RoundedCornerShape(28.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = CaribbeanGreen,
                        contentColor = Void
                    )
                ) {
                    Text(
                        text = stringResource(R.string.online_support_start_another_chat),
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(Modifier.height(24.dp))
            }
        }
    )
}

/* ========================= COMPONENTES ========================= */

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        color = Void,
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    )
}

@Composable
private fun ChatRow(
    chat: SupportChatUi,
    onClick: (String) -> Unit
) {
    Surface(
        color = LightGreen,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 72.dp)
            .clickable { onClick(chat.id) }
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Honeydew),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_bonsupport_caribbeangreen),
                    contentDescription = null,
                    modifier = Modifier.size(45.dp)
                )
            }

            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = chat.title,
                    color = Void,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = chat.subtitle,
                    color = Void.copy(alpha = .85f),
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(Modifier.width(8.dp))

            DatePill(text = chat.rightPillText)
        }
    }
}

@Composable
private fun DatePill(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Honeydew)
            .padding(horizontal = 10.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Void.copy(alpha = .8f),
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp
        )
    }
}
