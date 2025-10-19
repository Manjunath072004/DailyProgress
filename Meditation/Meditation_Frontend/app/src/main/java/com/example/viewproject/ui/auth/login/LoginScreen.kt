package com.example.viewproject.ui.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.viewproject.ui.components.CButton
import com.example.viewproject.ui.components.CTextField
import com.example.viewproject.ui.components.DontHaveAccountRow
import com.example.viewproject.ui.theme.AlegreyaFontFamily
import com.example.viewproject.ui.theme.AlegreyaSansFontFamily
import com.example.viewproject.ui.auth.login.LoginViewModel
import kotlinx.coroutines.launch
import com.example.viewproject.R

@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState
    val coroutineScope = rememberCoroutineScope()

    Surface(
        color = Color(0xFF253334),
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            // Background Image
            Image(
                painter = painterResource(id = R.drawable.bg1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .align(Alignment.BottomCenter)
            )

            // UI Content
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {

                // Logo
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 54.dp)
                        .height(100.dp)
                        .align(Alignment.Start)
                        .offset(x = (-20).dp)
                )

                // Title
                Text(
                    text = "Sign In",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color.White
                    ),
                    modifier = Modifier.align(Alignment.Start)
                )

                Text(
                    text = "Sign in now to access your exercises and saved music.",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = AlegreyaSansFontFamily,
                        color = Color(0xB2FFFFFF)
                    ),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(bottom = 24.dp)
                )

                // Email TextField
                CTextField(
                    hint = "Email Address",
                    value = uiState.email,
                    onValueChange = { viewModel.onEmailChange(it) }
                )

                // Password TextField
                CTextField(
                    hint = "Password",
                    value = uiState.password,
                    onValueChange = { viewModel.onPasswordChange(it) }
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Sign In Button
                CButton(
                    text = if (uiState.isLoading) "Signing In..." else "Sign In",
                    onClick = {
                        coroutineScope.launch {
                            viewModel.login()
                        }
                    }
                )

                DontHaveAccountRow(
                    onSignupTap = {
                        navController.navigate("signup")
                    }
                )

                // Error Message
                uiState.error?.let {
                    Text(
                        text = it,
                        color = Color.Red,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                // Navigate to Home if login is successful
                if (uiState.isLoggedIn) {
                    LaunchedEffect(Unit) {
                        navController.navigate("home") {
                            popUpTo("login") { inclusive = true }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}
