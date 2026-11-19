package ru.sulgik.mapkit.test.interaction

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import ru.sulgik.mapkit.MapKit

private var lifecycleKeySet = false

public fun lifecycleViewController(scenario: MapLifecycleScenario): UIViewController {
    if (!lifecycleKeySet) {
        MapKit.setApiKey(FixtureKey)
        lifecycleKeySet = true
    }
    return ComposeUIViewController { MapLifecycleFixture(scenario) }
}
