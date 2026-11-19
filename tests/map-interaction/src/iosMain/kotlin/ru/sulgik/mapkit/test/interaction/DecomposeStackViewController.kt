package ru.sulgik.mapkit.test.interaction

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import ru.sulgik.mapkit.MapKit

public fun decomposeStackViewController(): UIViewController {
    MapKit.setApiKey(FixtureKey)
    return ComposeUIViewController { DecomposeStackFixture() }
}
