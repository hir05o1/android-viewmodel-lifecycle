package dev.hir05o1.viewmodel_lifecycle.ui.home

import androidx.compose.foundation.background
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.hir05o1.viewmodel_lifecycle.R
import dev.hir05o1.viewmodel_lifecycle.ui.theme.ViewModelLifecycleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
    navigateToCounter: () -> Unit,
    navigateToBack: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        modifier = modifier, topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "ホーム画面") }, navigationIcon = {
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
                .padding(innerPadding)
                .background(color = uiState.bgColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = viewModel::updateBgColor
            ) {
                Text(text = "背景色を更新")
            }
            Button(
                onClick = navigateToCounter
            ) {
                Text(text = "カウンター画面へ遷移")
            }
        }
    }
}

@Composable
@Preview
private fun HomeViewPreview() {
    ViewModelLifecycleTheme { HomeView(navigateToCounter = {}, navigateToBack = {}) }
}
