package com.example.sumativa1

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sumativa1.pages.CallPage
import com.example.sumativa1.pages.ContactsPage
import com.example.sumativa1.pages.ForgotPasswordPage
import com.example.sumativa1.pages.HomePage
import com.example.sumativa1.pages.LoginPage
import com.example.sumativa1.pages.RegisterPage

@Composable
fun Navigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login"){
            LoginPage(modifier, navController,authViewModel)
        }
        composable("register"){
            RegisterPage(modifier, navController,authViewModel)
        }
        composable("home"){
            HomePage(modifier, navController,authViewModel)
        }
        composable("forgot_password") {
            ForgotPasswordPage(modifier, navController, authViewModel)
        }
        composable("call") {
            CallPage(modifier, navController)
        }
        composable("contacts") {
            ContactsPage(modifier, navController)
        }
    })
}