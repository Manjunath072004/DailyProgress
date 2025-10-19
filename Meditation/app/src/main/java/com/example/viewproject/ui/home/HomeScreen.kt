package com.example.viewproject.ui.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.viewproject.R
import com.example.viewproject.ui.components.CButton
import com.example.viewproject.ui.theme.AlegreyaFontFamily
import com.example.viewproject.ui.theme.AlegreyaSansFontFamily

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Surface(
        color = Color(0xFF253334),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            // -------- Top Bar --------
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Welcome Back 👋",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight(600),
                        color = Color.White
                    )
                )

                IconButton(onClick = { /* TODO: Open profile/settings */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_frame_person_24),
                        contentDescription = "Profile",
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }

            Text(
                text = "Discover your calm space today.",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = AlegreyaSansFontFamily,
                    color = Color(0xB2FFFFFF)
                ),
                modifier = Modifier.padding(bottom = 20.dp)
            )

            // -------- Featured Image / Banner --------
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                shape = MaterialTheme.shapes.medium,
                colors = CardDefaults.cardColors(containerColor = Color(0xFF7C9A92))
            ) {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.bg1),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0x40000000))
                    )

                    Text(
                        text = "Meditate to Relax",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = AlegreyaFontFamily,
                            fontWeight = FontWeight(700),
                            color = Color.White
                        ),
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // -------- List of Sessions --------
            val sessions = remember {
                listOf(
                    "Morning Energy Boost",
                    "Calm Your Mind",
                    "Sleep Better",
                    "Reduce Anxiety",
                    "Focus Meditation",
                )
            }

            Text(
                text = "Popular Sessions",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = AlegreyaSansFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(sessions) { session ->
                    SessionCard(sessionName = session)
                }
            }

            // -------- Logout Button --------
            CButton(
                text = "Log Out",
                onClick = {
                    navController.navigate("welcome") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            )
        }
    }
}

@Composable
fun SessionCard(sessionName: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color(0xFF7C9A92))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = sessionName,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = AlegreyaSansFontFamily,
                    color = Color.White
                )
            )

            Icon(
                painter = painterResource(id = R.drawable.outline_music_note_24),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}
