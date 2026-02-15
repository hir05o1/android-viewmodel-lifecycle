package dev.hir05o1.viewmodel_lifecycle.ui.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CounterView(
    modifier: Modifier = Modifier, viewModel: CounterViewModel = CounterViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val buttonTextStyle = MaterialTheme.typography.headlineLarge
    val countTextStyle = MaterialTheme.typography.displayLarge

    Scaffold(modifier = modifier) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxSize(),
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
        }
    }
}

@Preview(name = "Counter", showSystemUi = true)
@Composable
private fun PreviewCounterView() {
    CounterView()
}
