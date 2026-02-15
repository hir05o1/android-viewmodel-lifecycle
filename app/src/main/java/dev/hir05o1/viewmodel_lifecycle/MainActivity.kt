package dev.hir05o1.viewmodel_lifecycle

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.hir05o1.viewmodel_lifecycle.ui.counter.CounterView
import dev.hir05o1.viewmodel_lifecycle.ui.theme.ViewModelLifecycleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("Lifecycle", "MainActivity - onCreate")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewModelLifecycleTheme {
                CounterView()
            }
        }
    }

    override fun onStart() {
        Log.i("Lifecycle", "MainActivity - onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i("Lifecycle", "MainActivity - onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i("Lifecycle", "MainActivity - onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i("Lifecycle", "MainActivity - onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("Lifecycle", "MainActivity - onDestroy")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.i("Lifecycle", "MainActivity - onRestart")
        super.onRestart()
    }
}
