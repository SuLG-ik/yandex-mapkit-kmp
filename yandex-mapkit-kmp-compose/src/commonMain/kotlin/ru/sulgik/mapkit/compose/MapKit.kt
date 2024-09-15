package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import ru.sulgik.mapkit.MapKit
import ru.sulgik.mapkit.compose.utils.LifecycleEffect

@Composable
public expect fun rememberAndInitializeMapKit(): MapKit

@Composable
public fun rememberMapKit(): MapKit {
    return remember { MapKit.getInstance() }
}

@Composable
public fun MapKit.bindToLifecycleOwner(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current) {
    LifecycleEffect(
        lifecycleOwner = lifecycleOwner,
        onStart = this::onStart,
        onStop = this::onStop,
        onDispose = this::onStop,
    )
}