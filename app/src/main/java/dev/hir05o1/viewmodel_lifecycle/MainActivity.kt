package dev.hir05o1.viewmodel_lifecycle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.hir05o1.viewmodel_lifecycle.ui.counter.CounterView
import dev.hir05o1.viewmodel_lifecycle.ui.theme.ViewModelLifecycleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewModelLifecycleTheme {
                CounterView()
            }
        }
    }
}
