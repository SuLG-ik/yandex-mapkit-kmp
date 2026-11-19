package ru.sulgik.mapkit.test.interaction

import androidx.compose.ui.window.ComposeUIViewController
import platform.Foundation.NSProcessInfo
import platform.UIKit.UIViewController
import ru.sulgik.mapkit.MapKit
import kotlin.native.runtime.GC
import kotlin.native.runtime.NativeRuntimeApi

public fun interactionViewController(tapCases: Boolean): UIViewController {
    MapKit.setApiKey(FixtureKey)
    val listenerOwnership = ListenerOwnershipArgument in NSProcessInfo.processInfo.arguments
    return ComposeUIViewController {
        when {
            listenerOwnership -> ListenerOwnershipFixture(collectGarbage = ::collectGarbage)
            tapCases -> MapTapFixture()
            else -> MapInteractionFixture()
        }
    }
}

@OptIn(NativeRuntimeApi::class)
private fun collectGarbage() {
    GC.collect()
}
