package dev.hir05o1.viewmodel_lifecycle

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.hir05o1.viewmodel_lifecycle.ui.theme.ViewModelLifecycleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("Lifecycle", "MainActivity - onCreate")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewModelLifecycleTheme {
                NavGraph()
            }
        }
    }

    override fun onStart() {
        Log.i("Lifecycle-Activity", "MainActivity - onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i("Lifecycle-Activity", "MainActivity - onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i("Lifecycle-Activity", "MainActivity - onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i("Lifecycle-Activity", "MainActivity - onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("Lifecycle-Activity", "MainActivity - onDestroy")
        Log.d("Lifecycle-Activity", "isChangingConfigurations: $isChangingConfigurations")
        Log.d("Lifecycle-Activity", "isFinishing: $isFinishing")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.i("Lifecycle-Activity", "MainActivity - onRestart")
        super.onRestart()
    }
}
