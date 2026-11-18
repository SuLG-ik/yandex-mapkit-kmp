package ru.sulgik.mapkit.compose

import ru.sulgik.mapkit.MapKit
import ru.sulgik.mapkit.test.interaction.FixtureKey

private var apiKeySet = false

internal fun setDeviceTestMapKitApiKey() {
    if (!apiKeySet) {
        MapKit.setApiKey(FixtureKey)
        apiKeySet = true
    }
}
