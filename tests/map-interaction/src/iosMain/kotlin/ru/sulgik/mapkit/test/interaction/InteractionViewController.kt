package ru.sulgik.mapkit.test.interaction

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import ru.sulgik.mapkit.MapKit

public fun interactionViewController(tapCases: Boolean): UIViewController {
    MapKit.setApiKey(FixtureKey)
    return ComposeUIViewController {
        if (tapCases) {
            MapTapFixture()
        } else {
            MapInteractionFixture()
        }
    }
}

public fun nav3ViewController(): UIViewController {
    MapKit.setApiKey(FixtureKey)
    return ComposeUIViewController { Nav3Fixture(remember { Nav3Probe() }) }
}
