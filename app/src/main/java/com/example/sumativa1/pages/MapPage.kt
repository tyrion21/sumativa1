package com.example.sumativa1.pages

import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.example.sumativa1.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

@Composable
fun MapPage(modifier: Modifier = Modifier, navController: NavController) {
    val context = LocalContext.current
    var map by remember { mutableStateOf<GoogleMap?>(null) }

    LaunchedEffect(Unit) {
        val activity = context as FragmentActivity
        val mapFragment = activity.supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback { googleMap ->
            map = googleMap
            val sydney = LatLng(-34.0, 151.0)
            googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        })
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Map Page", fontSize = 32.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("home")
        }) {
            Text(text = "Go to Home")
        }
    }
}