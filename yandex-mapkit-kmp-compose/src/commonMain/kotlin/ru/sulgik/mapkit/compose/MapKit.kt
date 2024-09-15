package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import ru.sulgik.mapkit.MapKit
import ru.sulgik.mapkit.compose.utils.LifecycleEffect

/**
 * Remember global MapKit instance and initialize it on Android
 */
@Composable
public expect fun rememberAndInitializeMapKit(): MapKit

/**
 * Remember global MapKit instance
 */
@Composable
public fun rememberMapKit(): MapKit {
    return remember { MapKit.getInstance() }
}

/**
 * Bind calling [MapKit.onStart] and [MapKit.onStop] to [LifecycleOwner] and composition
 */
@Composable
public fun MapKit.bindToLifecycleOwner(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current) {
    LifecycleEffect(
        lifecycleOwner = lifecycleOwner,
        onStart = this::onStart,
        onStop = this::onStop,
        onDispose = this::onStop,
    )
}