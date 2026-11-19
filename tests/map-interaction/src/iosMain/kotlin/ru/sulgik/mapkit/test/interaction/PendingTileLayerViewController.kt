@file:OptIn(ExperimentalForeignApi::class)

package ru.sulgik.mapkit.test.interaction

import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSCondition
import platform.Foundation.NSDate
import platform.Foundation.NSThread
import platform.Foundation.dateWithTimeIntervalSinceNow
import platform.UIKit.UIViewController
import ru.sulgik.mapkit.MapKit

public fun pendingTileLayerViewController(): UIViewController {
    MapKit.setApiKey(FixtureKey)
    val gate = IosTileWorkerGate()
    return ComposeUIViewController { PendingTileLayerFixture(gate) }
}

private class IosTileWorkerGate : TileWorkerGate {

    private val releaseCondition = NSCondition()
    private var released = false

    override fun awaitRelease(): TileWorkerResult {
        if (NSThread.isMainThread) {
            return TileWorkerResult.MainThread
        }
        val deadline = NSDate.dateWithTimeIntervalSinceNow(PendingTileWorkerTimeoutMillis / 1_000.0)
        releaseCondition.lock()
        try {
            while (!released) {
                if (!releaseCondition.waitUntilDate(deadline) && !released) {
                    return TileWorkerResult.TimedOut
                }
            }
            return TileWorkerResult.Released
        } finally {
            releaseCondition.unlock()
        }
    }

    override fun release() {
        releaseCondition.lock()
        try {
            released = true
            releaseCondition.broadcast()
        } finally {
            releaseCondition.unlock()
        }
    }
}
