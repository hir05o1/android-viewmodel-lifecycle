package dev.hir05o1.viewmodel_lifecycle.ui.counter

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import dev.hir05o1.viewmodel_lifecycle.R
import dev.hir05o1.viewmodel_lifecycle.ui.theme.ViewModelLifecycleTheme
import dev.hir05o1.viewmodel_lifecycle.util.LifecycleLogger

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CounterView(
    modifier: Modifier = Modifier,
    viewModel: CounterViewModel = CounterViewModel(),
    navigateToHome: () -> Unit,
    navigateToBack: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()
    val buttonTextStyle = MaterialTheme.typography.headlineLarge
    val countTextStyle = MaterialTheme.typography.displayLarge

    LifecycleLogger("CounterView")

    Scaffold(modifier = modifier, topBar = {
        CenterAlignedTopAppBar(title = { Text(text = "カウンター画面") }, navigationIcon = {
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
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = uiState.count.toString(),
                style = countTextStyle,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                Button(onClick = viewModel::decrement) {
                    Text(text = "-1", style = buttonTextStyle)
                }
                Button(onClick = viewModel::increment) {
                    Text(text = "+1", style = buttonTextStyle)
                }
            }
            Button(onClick = navigateToHome) {
                Text(text = "ホーム画面へ遷移する")
            }
        }
    }
}

@Preview(name = "Counter", showSystemUi = true)
@Composable
private fun PreviewCounterView() {
    ViewModelLifecycleTheme {
        CounterView(navigateToHome = {}, navigateToBack = {})
    }
}
