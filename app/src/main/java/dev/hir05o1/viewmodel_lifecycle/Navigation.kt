package dev.hir05o1.viewmodel_lifecycle

import androidx.navigation.NavController

class NavActions(
    private val navController: NavController
) {
    fun navigateToBack() {
        navController.popBackStack()
    }

    fun navigateToCounter() {
        navController.navigate(route = "counter")
    }

    fun navigateToHome() {
        navController.navigate(route = "home")
    }

    fun navigateToLoginStep1() {
        navController.navigate(route = "login_step1")
    }

    fun navigateToLoginStep2() {
     navController.navigate(route = "login_step2")
    }

    fun navigateToLoginFlow() {
        navController.navigate(route = "login_flow")
    }

    fun navigateToHomeFromLogin() {
        navController.navigate(route = "home") {
            popUpTo(route = "login_flow") {
                inclusive = true
            }
        }
    }
}
