package dev.hir05o1.viewmodel_lifecycle.util

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavBackStackEntry
import kotlin.jvm.java

@Composable
fun LifecycleLogger(screenName: String) {
    val lifecycleOwner = LocalLifecycleOwner.current
    Log.d("Lifecycle-view", "ViewのlifecycleOwner class: ${lifecycleOwner::class.java.simpleName}")
    val viewModelStoreOwner = LocalViewModelStoreOwner.current
    Log.d(
        "Lifecycle-ViewModel",
        "viewModelStoreOwner class: ${viewModelStoreOwner?.javaClass?.simpleName}"
    )
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            Log.i("Lifecycle-View", "$screenName: $event")
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}
