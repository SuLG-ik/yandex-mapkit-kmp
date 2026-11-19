@file:OptIn(ExperimentalForeignApi::class)

package ru.sulgik.mapkit.test.interaction

import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSThread
import platform.UIKit.UIViewController
import platform.darwin.DISPATCH_TIME_NOW
import platform.darwin.dispatch_semaphore_create
import platform.darwin.dispatch_semaphore_signal
import platform.darwin.dispatch_semaphore_wait
import platform.darwin.dispatch_time
import ru.sulgik.mapkit.MapKit

public fun pendingTileLayerViewController(): UIViewController {
    MapKit.setApiKey(FixtureKey)
    val gate = IosTileWorkerGate()
    return ComposeUIViewController { PendingTileLayerFixture(gate) }
}

private class IosTileWorkerGate : TileWorkerGate {

    private val releaseSignal = checkNotNull(dispatch_semaphore_create(0L))

    override fun awaitRelease(): TileWorkerState {
        if (NSThread.isMainThread) {
            return TileWorkerState.MainThread
        }
        val timeout = dispatch_time(DISPATCH_TIME_NOW, PendingTileWorkerTimeoutMillis * 1_000_000L)
        return if (dispatch_semaphore_wait(releaseSignal, timeout) == 0L) {
            TileWorkerState.Released
        } else {
            TileWorkerState.TimedOut
        }
    }

    override fun release() {
        dispatch_semaphore_signal(releaseSignal)
    }
}
