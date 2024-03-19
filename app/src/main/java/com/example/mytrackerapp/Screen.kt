package com.example.mytrackerapp

sealed class Screen (val route:String) {
    object MainScreen : Screen("main_screen")
    object LoginScreen : Screen("login_screen")
    object SignupScreen : Screen("signup_screen")
    object OnBoardingScreen : Screen("onboarding_screen")
    object WakeupScreen : Screen("wake_up_screen")
    object ReflectScreen : Screen("reflect_screen")
    object MainHabitScreen : Screen("main_habit")
    object ChooseHabitScreen : Screen("choose_habit_screen")
    object SetYourGoals : Screen("set_goals_screen")
    object SettingScreen : Screen("setting_screen")
    object SetupProfileScreen :Screen("setup_profile_screen")
}