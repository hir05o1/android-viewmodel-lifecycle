package dev.hir05o1.viewmodel_lifecycle.ui.login.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import dev.hir05o1.viewmodel_lifecycle.R
import dev.hir05o1.viewmodel_lifecycle.ui.login.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginStep2Screen(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToBack: () -> Unit,
    viewModel: LoginViewModel
) {
    Scaffold(
        modifier = modifier, topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "ログインステップ2") }, navigationIcon = {
                IconButton(
                    onClick = navigateToBack
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_baseline_arrow_back),
                        contentDescription = "戻る",
                    )
                }
            })
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    viewModel.completeLogin()
                    navigateToHome()
                }) {
                Text(text = "次の画面へ")
            }
        }
    }
}
