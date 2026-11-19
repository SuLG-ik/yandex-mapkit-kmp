package ru.sulgik.mapkit.test.interaction

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import ru.sulgik.mapkit.MapKit

public fun cameraViewController(mode: String): UIViewController {
    MapKit.setApiKey(FixtureKey)
    val cameraMode = CameraRegressionMode.valueOf(mode)
    return ComposeUIViewController {
        CameraRegressionFixture(cameraMode, zoomDirection = CameraZoomDirection.Out, gestureFrameRate = 30)
    }
}
