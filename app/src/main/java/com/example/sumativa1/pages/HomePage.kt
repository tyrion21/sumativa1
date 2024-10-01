package com.example.sumativa1.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sumativa1.AuthState
import com.example.sumativa1.AuthViewModel

@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    val authState = authViewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Unauthenticated -> navController.navigate("login")
            else -> Unit
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pagina Inicial", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CardItem(text = "Llamar", color = Color.Red) {
                navController.navigate("call")
            }
            CardItem(text = "Contactos", color = Color.Blue) {
                navController.navigate("contacts")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CardItem(text = "Emergencia", color = Color.Yellow){
            }
            CardItem(text = "Mapa", color = Color.Green) {
                navController.navigate("map")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = {
            authViewModel.signout()
        }) {
            Text(text = "Cerrar Sesión")
        }
    }
}

@Composable
fun CardItem(text: String, color: Color, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .size(150.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(color)
        ) {
            Text(text = text, fontSize = 20.sp, color = Color.White)
        }
    }
}