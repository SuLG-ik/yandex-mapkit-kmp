package ru.sulgik.mapkit.compose

import android.os.Bundle
import android.os.Looper
import android.os.SystemClock
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.test.core.app.ActivityScenario
import ru.sulgik.mapkit.test.interaction.PendingTileLayerFixture
import ru.sulgik.mapkit.test.interaction.PendingTileLayerTrace
import ru.sulgik.mapkit.test.interaction.PendingTileWorkerTimeoutMillis
import ru.sulgik.mapkit.test.interaction.TileWorkerGate
import ru.sulgik.mapkit.test.interaction.TileWorkerResult
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.test.Test
import kotlin.test.assertEquals

public class PendingTileLayerTestActivity : ComponentActivity() {

    internal val trace = PendingTileLayerTrace()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDeviceTestMapKitApiKey()
        val gate = AndroidTileWorkerGate()
        setContent { PendingTileLayerFixture(gate, trace) }
    }
}

public class PendingTileLayerTest {

    @Test
    public fun removesNativeLayerBeforeReturningItsPendingTile() {
        ActivityScenario.launch(PendingTileLayerTestActivity::class.java).use { scenario ->
            val deadline = SystemClock.elapsedRealtime() + 40_000L
            var actual = emptyList<String>()
            while (SystemClock.elapsedRealtime() < deadline) {
                scenario.onActivity { actual = it.trace.events.toList() }
                if (actual.any { it.startsWith("failed") || it == "finished" }) {
                    break
                }
                SystemClock.sleep(25L)
            }
            assertEquals(
                listOf(
                    "native request entered",
                    "layer removed while pending",
                    "workers released",
                    "replacement layer loaded",
                    "finished",
                ),
                actual,
            )
        }
    }
}

private class AndroidTileWorkerGate : TileWorkerGate {

    private val releaseSignal = CountDownLatch(1)

    override fun awaitRelease(): TileWorkerResult {
        if (Looper.getMainLooper().thread === Thread.currentThread()) {
            return TileWorkerResult.MainThread
        }
        return try {
            if (releaseSignal.await(PendingTileWorkerTimeoutMillis, TimeUnit.MILLISECONDS)) {
                TileWorkerResult.Released
            } else {
                TileWorkerResult.TimedOut
            }
        } catch (_: InterruptedException) {
            Thread.currentThread().interrupt()
            TileWorkerResult.Interrupted
        }
    }

    override fun release() {
        releaseSignal.countDown()
    }
}
