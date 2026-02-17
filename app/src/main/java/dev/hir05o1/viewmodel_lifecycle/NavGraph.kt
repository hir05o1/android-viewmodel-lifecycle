package dev.hir05o1.viewmodel_lifecycle

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.hir05o1.viewmodel_lifecycle.ui.counter.CounterView
import dev.hir05o1.viewmodel_lifecycle.ui.counter.CounterViewModel
import dev.hir05o1.viewmodel_lifecycle.ui.home.HomeView
import dev.hir05o1.viewmodel_lifecycle.ui.home.HomeViewModel

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    navActions: NavActions = remember(navController) {
        NavActions(navController)
    },
) {
    NavHost(
        navController = navController, startDestination = "home", modifier = modifier
    ) {
        composable("home") {
            val viewModel: HomeViewModel = viewModel()
            HomeView(viewModel = viewModel, navigateToCounter = {
                navActions.navigateToCounter()
            }, navigateToBack = { navActions.navigateToBack() })
        }
        composable("counter") {
            val viewModel: CounterViewModel = viewModel()
            CounterView(viewModel = viewModel, navigateToHome = {
                navActions.navigateToHome()
            }, navigateToBack = { navActions.navigateToBack() })
        }
    }
}
