package ru.sulgik.mapkit.test.interaction

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import platform.Foundation.NSProcessInfo
import platform.UIKit.UIViewController
import ru.sulgik.mapkit.MapKit
import kotlin.native.runtime.GC
import kotlin.native.runtime.NativeRuntimeApi

public fun interactionViewController(tapCases: Boolean): UIViewController {
    MapKit.setApiKey(FixtureKey)
    val arguments = NSProcessInfo.processInfo.arguments
    return ComposeUIViewController {
        when {
            ListenerOwnershipArgument in arguments -> ListenerOwnershipFixture(collectGarbage = ::collectGarbage)
            PaneScenarioArgument in arguments -> MapPanesFixture()
            PlacemarkIconRenderingArgument in arguments -> MapIconRenderingFixture(clustered = false)
            ClusterIconRenderingArgument in arguments -> MapIconRenderingFixture(clustered = true)
            tapCases -> MapTapFixture()
            else -> MapInteractionFixture()
        }
    }
}

public fun nav3ViewController(): UIViewController {
    MapKit.setApiKey(FixtureKey)
    return ComposeUIViewController { Nav3Fixture(remember { Nav3Probe() }) }
}

public fun objectMembershipViewController(): UIViewController {
    MapKit.setApiKey(FixtureKey)
    return ComposeUIViewController { MapObjectMembershipFixture() }
}

@OptIn(NativeRuntimeApi::class)
private fun collectGarbage() {
    GC.collect()
}
