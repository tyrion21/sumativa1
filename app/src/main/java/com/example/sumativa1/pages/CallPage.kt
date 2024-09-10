package com.example.sumativa1.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sumativa1.R

@Composable
fun CallPage(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Llamar", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(16.dp))

        PhoneNumberItem(phoneNumber = "+569-5456-7890")
        PhoneNumberItem(phoneNumber = "+569-7765-4321")

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = {
            navController.navigate("home")
        }) {
            Text(text = "Volver a la Página Inicial")
        }
    }
}

@Composable
fun PhoneNumberItem(phoneNumber: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = phoneNumber, fontSize = 20.sp)

        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_call),
                contentDescription = "Llamar",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { /* Acción de llamada */ },
                tint = Color.Green
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_stop),
                contentDescription = "Detener",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { /* Acción de detener */ },
                tint = Color.Red
            )
        }
    }
}

