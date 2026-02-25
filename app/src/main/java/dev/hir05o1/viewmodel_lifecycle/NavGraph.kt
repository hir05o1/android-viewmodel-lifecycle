package dev.hir05o1.viewmodel_lifecycle

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import dev.hir05o1.viewmodel_lifecycle.ui.counter.CounterView
import dev.hir05o1.viewmodel_lifecycle.ui.counter.CounterViewModel
import dev.hir05o1.viewmodel_lifecycle.ui.home.HomeView
import dev.hir05o1.viewmodel_lifecycle.ui.home.HomeViewModel
import dev.hir05o1.viewmodel_lifecycle.ui.login.LoginViewModel
import dev.hir05o1.viewmodel_lifecycle.ui.login.screen.LoginStep1Screen
import dev.hir05o1.viewmodel_lifecycle.ui.login.screen.LoginStep2Screen

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
        navigation(
            startDestination = "login_step1", route = "login_flow"
        ) {
            composable("login_step1") {
                // この NavGraph 内で共有される ViewModel を取得
                val parentEntry = remember(it) {
                    navController.getBackStackEntry("login_flow")
                }
                val loginViewModel: LoginViewModel = viewModel(parentEntry)
                Log.d("ViewModel", "LoginViewModel1: ${loginViewModel.hashCode()}")
                LoginStep1Screen(viewModel = loginViewModel, navigateToLogin2 = {
                    navActions.navigateToLoginStep2()
                }, navigateToBack = {
                    navActions.navigateToBack()
                })
            }

            composable("login_step2") {
                val parentEntry = remember(it) {
                    navController.getBackStackEntry("login_flow")
                }
                val loginViewModel: LoginViewModel = viewModel(parentEntry)
                Log.d("ViewModel", "LoginViewModel2: ${loginViewModel.hashCode()}")

                LoginStep2Screen(viewModel = loginViewModel, navigateToHome = {
                    navActions.navigateToHomeFromLogin()
                }, navigateToBack = {
                    navActions.navigateToBack()
                })
            }
        }
        composable("home") {
            val viewModel: HomeViewModel = viewModel()
            HomeView(viewModel = viewModel, navigateToCounter = {
                navActions.navigateToCounter()
            }, navigateToBack = { navActions.navigateToBack() },
                navigateToLogin = {navActions.navigateToLoginFlow()}
            )
        }
        composable("counter") {
            val viewModel: CounterViewModel = viewModel()
            CounterView(viewModel = viewModel, navigateToHome = {
                navActions.navigateToHome()
            }, navigateToBack = { navActions.navigateToBack() })
        }
    }
}
