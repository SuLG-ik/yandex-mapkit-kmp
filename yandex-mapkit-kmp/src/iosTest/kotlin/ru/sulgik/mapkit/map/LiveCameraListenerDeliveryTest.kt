package ru.sulgik.mapkit.map

import ru.sulgik.mapkit.LiveMap
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.geometry.Point
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlin.time.TimeSource

public class LiveCameraListenerDeliveryTest {

    @Test
    public fun `programmatic movement delivers a camera listener event`() {
        LiveMap.onMap { map ->
            val expected = CameraPosition(Point(59.9375, 30.3086), 14f, 30f, 20f)
            var finishedPosition: CameraPosition? = null
            val listener = CameraListener { _, position, reason, finished ->
                if (reason == CameraUpdateReason.APPLICATION && finished) {
                    finishedPosition = position
                }
            }
            map.addCameraListener(listener.asWeakRef())
            try {
                map.move(expected)
                val start = TimeSource.Monotonic.markNow()
                while (finishedPosition == null && start.elapsedNow() < 2.seconds) {
                    LiveMap.drainMainQueue(50.milliseconds)
                }
                val received = assertNotNull(finishedPosition, "The registered listener received no finished event")
                assertEquals(expected.target.latitude.value, received.target.latitude.value, 1e-6)
                assertEquals(expected.target.longitude.value, received.target.longitude.value, 1e-6)
                assertEquals(expected.zoom, received.zoom)
            } finally {
                map.removeCameraListener(listener.asWeakRef())
            }
        }
    }
}
