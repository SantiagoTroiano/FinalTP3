package com.example.parcialtp3.ui.screens.launch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcialtp3.R
import com.example.parcialtp3.ui.CaribbeanGreen
import com.example.parcialtp3.ui.FenceGreen
import com.example.parcialtp3.ui.Honeydew
import com.example.parcialtp3.ui.LightGreen
import com.example.parcialtp3.ui.Void
import com.example.parcialtp3.ui.poppinsFamily

@Composable
fun LaunchScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Honeydew),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(id = R.drawable.ic_grafico),
                contentDescription = stringResource(R.string.launch_logo_cd),
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = stringResource(R.string.launch_title),
                fontSize = 58.sp,
                fontWeight = FontWeight.Bold,
                color = CaribbeanGreen,
                fontFamily = poppinsFamily
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.launch_description),
                fontSize = 14.sp,
                color = Void,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 40.dp),
                fontFamily = poppinsFamily
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    navController.navigate("OnBoardingPagerScreen?next=WelcomeScreen") {
                        popUpTo("launch") { inclusive = true }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = CaribbeanGreen),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(48.dp)
            ) {
                Text(
                    stringResource(R.string.launch_login),
                    fontSize = 25.sp,
                    color = Void,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("OnBoardingPagerScreen?next=CreateAccountScreen") {
                        popUpTo("launch") { inclusive = true }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = LightGreen),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(48.dp)
            ) {
                Text(
                    stringResource(R.string.launch_signup),
                    fontSize = 25.sp,
                    color = FenceGreen,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = stringResource(R.string.launch_forgot_password),
                color = Void,
                fontSize = 13.sp,
                fontFamily = poppinsFamily,
                modifier = Modifier.clickable {
                    navController.navigate("ForgotPasswordScreen")
                }
            )
        }
    }
}
