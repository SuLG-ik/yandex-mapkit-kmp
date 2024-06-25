package ru.sulgik.mapkit.compose.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

private class ComposeLifecycleObserver() : LifecycleEventObserver {

    var onCreate: () -> Unit = {}
    var onStart: () -> Unit = {}
    var onResume: () -> Unit = {}
    var onPause: () -> Unit = {}
    var onStop: () -> Unit = {}
    var onDestroy: () -> Unit = {}

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_CREATE -> onCreate()
            Lifecycle.Event.ON_START -> onStart()
            Lifecycle.Event.ON_RESUME -> onResume()
            Lifecycle.Event.ON_PAUSE -> onPause()
            Lifecycle.Event.ON_STOP -> onStop()
            Lifecycle.Event.ON_DESTROY -> onDestroy()
            else -> {}
        }
    }

}

@Composable
internal fun LifecycleEffect(
    observer: LifecycleObserver,
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onDispose: () -> Unit,
) {
    DisposableEffect(lifecycleOwner, observer, onDispose) {
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            onDispose()
        }
    }
}

@Composable
internal fun LifecycleEffect(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onCreate: () -> Unit = {},
    onStart: () -> Unit = {},
    onResume: () -> Unit = {},
    onPause: () -> Unit = {},
    onStop: () -> Unit = {},
    onDestroy: () -> Unit = {},
    onDispose: () -> Unit = remember { {} },
) {
    val observer = remember { ComposeLifecycleObserver() }
    observer.apply {
        this.onCreate = onCreate
        this.onStart = onStart
        this.onResume = onResume
        this.onPause = onPause
        this.onStop = onStop
        this.onDestroy = onDestroy
    }
    LifecycleEffect(
        observer = observer,
        lifecycleOwner = lifecycleOwner,
        onDispose = onDispose,
    )
}