package com.example.mytrackerapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytrackerapp.Screen
import com.example.mytrackerapp.screens.ChooseHabitScreen
import com.example.mytrackerapp.screens.LoginScreen
import com.example.mytrackerapp.screens.MainHabitScreen
import com.example.mytrackerapp.screens.MainScreen
import com.example.mytrackerapp.screens.OnBoardingScreen
import com.example.mytrackerapp.screens.ReflectScreen
import com.example.mytrackerapp.screens.SetYourGoals
import com.example.mytrackerapp.screens.SignupScreen
import com.example.mytrackerapp.screens.WakeupScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route) { MainScreen(navController) }
        composable(Screen.LoginScreen.route) { LoginScreen(navController) }
        composable(Screen.SignupScreen.route) { SignupScreen(navController) }
        composable(Screen.OnBoardingScreen.route) { OnBoardingScreen(navController) }
        composable(Screen.WakeupScreen.route) { WakeupScreen(navController) }
        composable(Screen.ReflectScreen.route) { ReflectScreen(navController) }
        composable(Screen.MainHabitScreen.route) { MainHabitScreen(navController) }
        composable(Screen.ChooseHabitScreen.route) { ChooseHabitScreen(navController) }
        composable(Screen.SetYourGoals.route) { SetYourGoals(navController) }
        /*
        composable(Screen.SettingScreen.route) { SettingScreen(navController) }
        composable(Screen.SetupProfileScreen.route) { SetupProfileScreen(navController) }*/

    }
}