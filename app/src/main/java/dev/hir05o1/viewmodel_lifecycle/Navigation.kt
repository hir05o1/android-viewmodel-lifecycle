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
}
