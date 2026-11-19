package ru.sulgik.mapkit.test.interaction

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import ru.sulgik.mapkit.MapKit

public fun interactionViewController(): UIViewController {
    MapKit.setApiKey(FixtureKey)
    return ComposeUIViewController { MapInteractionFixture() }
}

public fun iconRenderingViewController(clustered: Boolean): UIViewController {
    MapKit.setApiKey(FixtureKey)
    return ComposeUIViewController { MapIconRenderingFixture(clustered) }
}
