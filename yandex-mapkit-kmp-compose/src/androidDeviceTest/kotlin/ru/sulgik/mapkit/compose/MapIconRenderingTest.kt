package ru.sulgik.mapkit.compose

import android.graphics.Bitmap
import android.os.SystemClock
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import ru.sulgik.mapkit.test.interaction.IconInk
import ru.sulgik.mapkit.test.interaction.IconRenderingBackdrop
import ru.sulgik.mapkit.test.interaction.IconRenderingCase
import ru.sulgik.mapkit.test.interaction.MapIconRenderingFixture
import kotlin.math.abs
import kotlin.math.roundToInt
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import kotlin.test.fail
import android.graphics.Color as AndroidColor

public class MapIconRenderingTest {

    @Test
    public fun placemarkIconFollowsFramesRequestsAndDisposal() {
        verifyLiveIcon(clustered = false)
    }

    @Test
    public fun clusterIconFollowsFramesRequestsAndDisposal() {
        verifyLiveIcon(clustered = true)
    }

    private fun verifyLiveIcon(clustered: Boolean) {
        ActivityScenario.launch(ComponentActivity::class.java).use { scenario ->
            val fixture = IconFixtureDriver(scenario)
            fixture.mount(clustered)
            var previousWidth = 0f
            IconRenderingCase.entries.forEach { case ->
                val image = fixture.awaitImage(case)
                when (case) {
                    IconRenderingCase.Narrow -> previousWidth = image.widthFraction
                    IconRenderingCase.Wide -> assertTrue(
                        image.widthFraction >= previousWidth * 1.65f,
                        "Wide icon ${image.widthFraction} must grow beyond the narrow icon $previousWidth",
                    )
                    else -> Unit
                }
                if (case != IconRenderingCase.Recreated) fixture.advance()
            }
        }
    }
}

private class IconFixtureDriver(private val scenario: ActivityScenario<ComponentActivity>) {

    private val instrumentation = InstrumentationRegistry.getInstrumentation()
    private var viewport: LayoutCoordinates? = null
    private var advanceControl: LayoutCoordinates? = null
    private var status = "unmounted"

    fun mount(clustered: Boolean) {
        scenario.onActivity { activity ->
            setDeviceTestMapKitApiKey()
            activity.setContent {
                MapIconRenderingFixture(
                    clustered = clustered,
                    onMapLayout = { viewport = it },
                    onAdvanceLayout = { advanceControl = it },
                    onStatus = { status = it },
                )
            }
        }
    }

    fun advance() {
        val target = assertNotNull(onActivity {
            val control = advanceControl?.takeIf { it.isAttached } ?: return@onActivity null
            control.localToScreen(Offset(control.size.width / 2f, control.size.height / 2f))
        })
        val start = SystemClock.uptimeMillis()
        for (action in listOf(MotionEvent.ACTION_DOWN, MotionEvent.ACTION_UP)) {
            val event = MotionEvent.obtain(start, SystemClock.uptimeMillis(), action, target.x, target.y, 0)
            try {
                instrumentation.sendPointerSync(event)
            } finally {
                event.recycle()
            }
        }
    }

    fun awaitImage(case: IconRenderingCase): IconRow {
        val deadline = SystemClock.uptimeMillis() + 12_000L
        var lastStatus = "unmounted"
        var lastImage: IconRow? = null
        var matchingFrames = 0
        while (SystemClock.uptimeMillis() < deadline) {
            val (current, bounds) = onActivity {
                val layout = viewport?.takeIf { it.isAttached }
                status to layout?.let { Viewport(it.localToScreen(Offset.Zero), it.size.width, it.size.height) }
            }
            lastStatus = current
            if (current == case.name && bounds != null) {
                val screenshot = instrumentation.uiAutomation.takeScreenshot()
                val row = screenshot?.probeAndRecycle(bounds, case.ink)
                lastImage = row
                if (row != null && row.matches(case.ink)) {
                    matchingFrames++
                    if (matchingFrames >= 3) return row
                } else {
                    matchingFrames = 0
                }
            }
            SystemClock.sleep(60L)
        }
        fail("Expected ${case.name} with ${case.ink}. Last stage: $lastStatus. Native map sample: $lastImage")
    }

    private fun <T> onActivity(read: () -> T): T {
        var result: Result<T>? = null
        scenario.onActivity { result = runCatching(read) }
        return assertNotNull(result).getOrThrow()
    }
}

private data class Viewport(val origin: Offset, val width: Int, val height: Int)

private data class IconRow(
    val first: Float?,
    val widthFraction: Float,
    val colors: Set<IconInk>,
    val background: Int,
) {

    fun matches(ink: IconInk?): Boolean {
        if (!background.isClose(IconRenderingBackdrop.toArgb(), tolerance = 32)) return false
        if (ink == null) return colors.isEmpty()
        return colors == setOf(ink) && first != null && first in 0.012f..0.075f && widthFraction in 0.065f..0.36f
    }
}

private fun Bitmap.probeAndRecycle(viewport: Viewport, expected: IconInk?): IconRow? {
    val readable = if (config == Bitmap.Config.HARDWARE) copy(Bitmap.Config.ARGB_8888, false) else this
    try {
        return readable?.probe(viewport, expected)
    } finally {
        if (readable !== this) readable?.recycle()
        recycle()
    }
}

private fun Bitmap.probe(viewport: Viewport, expected: IconInk?): IconRow? {
    val width = viewport.width
    if (width <= 0 || viewport.height <= 0) return null
    if (!viewport.origin.x.isFinite() || !viewport.origin.y.isFinite()) return null
    val left = viewport.origin.x.roundToInt()
    val row = (viewport.origin.y + viewport.height / 2f).roundToInt()
    if (left < 0 || left + width > this.width || row !in 0 until height) return null
    val pixels = IntArray(width)
    getPixels(pixels, 0, width, left, row, width, 1)
    val inks = mutableSetOf<IconInk>()
    var first: Int? = null
    var count = 0
    for (pixel in width / 4 until width * 9 / 10) {
        val ink = IconInk.entries.firstOrNull { pixels[pixel].isClose(it.color.toArgb(), tolerance = 54) } ?: continue
        inks.add(ink)
        if (ink == expected) {
            if (first == null) first = pixel
            count++
        }
    }
    return IconRow(
        first = first?.let { it.toFloat() / width - 0.5f },
        widthFraction = count.toFloat() / width,
        colors = inks,
        background = pixels[(width * 0.508f).roundToInt()],
    )
}

private fun Int.isClose(other: Int, tolerance: Int): Boolean {
    return abs(AndroidColor.red(this) - AndroidColor.red(other)) <= tolerance &&
        abs(AndroidColor.green(this) - AndroidColor.green(other)) <= tolerance &&
        abs(AndroidColor.blue(this) - AndroidColor.blue(other)) <= tolerance
}
