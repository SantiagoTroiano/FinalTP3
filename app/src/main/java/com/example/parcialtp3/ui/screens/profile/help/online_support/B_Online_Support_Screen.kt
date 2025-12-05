package com.example.parcialtp3.ui.screens.profile.help.online_support

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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

/* =========================== DATA ============================ */

private enum class ChatTab { ASSISTANT, HELP_CENTER }

private data class ChatMessage(
    val id: String,
    val text: String,
    val time: String,
    val fromMe: Boolean
)

/* =========================== SCREEN ============================ */

@Composable
fun B_Online_Support_Screen(
    navController: NavHostController,
) {
    var tab by remember { mutableStateOf(ChatTab.ASSISTANT) }
    var input by remember { mutableStateOf("") }

    val msg1 = stringResource(R.string.msg_1)
    val msg2 = stringResource(R.string.msg_2)
    val msg3 = stringResource(R.string.msg_3)
    val msg4 = stringResource(R.string.msg_4)
    val msg5 = stringResource(R.string.msg_5)
    val msg6 = stringResource(R.string.msg_6)
    val msg7 = stringResource(R.string.msg_7)

    val messages = remember(tab) {
        listOf(
            ChatMessage("1", msg1, "14:00", false),
            ChatMessage("2", msg2, "14:00", false),
            ChatMessage("3", msg3, "14:01", true),
            ChatMessage("4", msg4, "14:03", false),
            ChatMessage("5", msg5, "14:03", false),
            ChatMessage("6", msg6, "14:05", true),
            ChatMessage("7", msg7, "14:06", false),
        )
    }


    BackgroundScaffold(
        navController = navController,
        headerHeight = 200.dp,
        whiteHeight = Dp.Unspecified,
        headerContent = {
            HeaderBar(
                title = stringResource(R.string.online_support_title),
                navController = navController,
                onBackClick = { navController.popBackStack() },
            )
        },
        panelContent = {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            ) {
                Spacer(Modifier.height(12.dp))

                ChatTabs(
                    selected = tab,
                    onSelect = { tab = it },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(12.dp))

                val listState = rememberLazyListState()
                LaunchedEffect(messages.size) {
                    if (messages.isNotEmpty()) listState.scrollToItem(messages.lastIndex)
                }

                Box(modifier = Modifier.weight(1f)) {
                    LazyColumn(
                        state = listState,
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(vertical = 8.dp)
                    ) {
                        items(messages, key = { it.id }) { msg ->
                            MessageBubble(message = msg)
                        }

                        item {
                            Spacer(Modifier.height(4.dp))
                            EndPill(text = "14:06  |  ${stringResource(R.string.online_support_chat_ended)}")
                        }
                    }
                }

                Spacer(Modifier.height(8.dp))

                ChatInputBar(
                    value = input,
                    onValueChange = { input = it },
                    onAttach = {},
                    onVoice = {},
                    onSend = {}
                )

                Spacer(Modifier.height(16.dp))
            }
        }
    )
}

/* ========================= COMPONENTES ========================= */

@Composable
private fun ChatTabs(
    selected: ChatTab,
    onSelect: (ChatTab) -> Unit,
    modifier: Modifier = Modifier,
    height: Dp = 46.dp,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(Honeydew)
            .height(height)
            .padding(6.dp)
    ) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            @Composable
            fun TabItem(tab: ChatTab, label: String) {
                val isSel = selected == tab
                Surface(
                    color = if (isSel) CaribbeanGreen else Color.Transparent,
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable { onSelect(tab) }
                ) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(
                            text = label,
                            fontFamily = poppinsFamily,
                            fontWeight = if (isSel) FontWeight.SemiBold else FontWeight.Medium,
                            color = Void,
                            fontSize = 13.sp
                        )
                    }
                }
            }

            TabItem(ChatTab.ASSISTANT, stringResource(R.string.online_support_tab_assistant))
            TabItem(ChatTab.HELP_CENTER, stringResource(R.string.online_support_tab_help_center))
        }
    }
}

@Composable
private fun MessageBubble(message: ChatMessage) {
    val bubbleColor = if (message.fromMe) CaribbeanGreen else LightGreen

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (message.fromMe) Alignment.End else Alignment.Start
    ) {
        Surface(
            color = bubbleColor,
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier.widthIn(min = 80.dp, max = 280.dp)
        ) {
            Text(
                text = message.text,
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                color = Void,
                fontFamily = poppinsFamily,
                fontSize = 13.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Spacer(Modifier.height(4.dp))
        Text(
            text = message.time,
            color = Void.copy(alpha = .6f),
            fontFamily = poppinsFamily,
            fontSize = 11.sp,
            modifier = Modifier.padding(horizontal = 6.dp)
        )
    }
}

@Composable
private fun EndPill(text: String) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(LightGreen)
        ) {
            Text(
                text = text,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                color = Void.copy(alpha = .75f),
                fontFamily = poppinsFamily,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun ChatInputBar(
    value: String,
    onValueChange: (String) -> Unit,
    onAttach: () -> Unit,
    onVoice: () -> Unit,
    onSend: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = CaribbeanGreen,
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ActionSquare(
                icon = R.drawable.icon_camera_honeydew,
                onClick = onAttach,
                container = Honeydew,
                content = CaribbeanGreen
            )

            Spacer(Modifier.width(8.dp))

            Surface(
                color = Color.White,
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier
                    .weight(1f)
                    .height(44.dp)
            ) {
                androidx.compose.foundation.text.BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    singleLine = true,
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontFamily = poppinsFamily,
                        fontSize = 13.sp,
                        color = Void
                    ),
                    cursorBrush = androidx.compose.ui.graphics.SolidColor(Void),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    decorationBox = { inner ->
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart) {
                            if (value.isEmpty()) {
                                Text(
                                    stringResource(R.string.online_support_write_here),
                                    fontFamily = poppinsFamily,
                                    color = Void.copy(alpha = .5f),
                                    fontSize = 13.sp
                                )
                            }
                            inner()
                        }
                    }
                )
            }

            Spacer(Modifier.width(8.dp))

            ActionSquare(
                icon = R.drawable.icon_microphone_honeydew,
                onClick = onVoice,
                container = Honeydew,
                content = CaribbeanGreen
            )
            Spacer(Modifier.width(6.dp))
            ActionSquare(
                icon = R.drawable.icon_send_honeydew,
                onClick = onSend,
                container = Honeydew,
                content = CaribbeanGreen
            )
        }
    }
}

@Composable
private fun ActionSquare(
    icon: Int,
    onClick: () -> Unit,
    container: Color = Honeydew,
    content: Color = CaribbeanGreen
) {
    Surface(
        color = container,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .size(35.dp)
            .clickable { onClick() }
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        }
    }
}
