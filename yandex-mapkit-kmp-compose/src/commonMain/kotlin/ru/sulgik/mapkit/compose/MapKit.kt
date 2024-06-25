package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner
import ru.sulgik.mapkit.MapKit
import ru.sulgik.mapkit.compose.utils.LifecycleEffect

@Composable
expect fun rememberAndInitializeMapKit(): MapKit

@Composable
fun rememberMapKit(): MapKit {
    return remember { MapKit.getInstance() }
}

@Composable
fun MapKit.bindToLifecycleOwner(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current) {
    LifecycleEffect(
        lifecycleOwner = lifecycleOwner,
        onStart = this::onStart,
        onStop = this::onStop,
        onDispose = this::onStop,
    )
}

@Composable
fun MapKit.bindToComposition() {
    DisposableEffect(this) {
        onStart()
        onDispose(::onStop)
    }
}