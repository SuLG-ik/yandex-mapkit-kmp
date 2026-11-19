package ru.sulgik.mapkit.compose

import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.v2.runComposeUiTest
import ru.sulgik.mapkit.test.interaction.AddListenerObject
import ru.sulgik.mapkit.test.interaction.ListenerOwnershipFixture
import ru.sulgik.mapkit.test.interaction.ListenerOwnershipTrace
import ru.sulgik.mapkit.test.interaction.ProbeListener
import ru.sulgik.mapkit.test.interaction.ReleaseCallback
import ru.sulgik.mapkit.test.interaction.ReopenWithPendingCallback
import ru.sulgik.mapkit.test.interaction.ReplaceListener
import ru.sulgik.mapkit.test.interaction.SubscribeListener
import ru.sulgik.mapkit.test.interaction.UnsubscribeListener
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalTestApi::class)
public class ListenerOwnershipTest {

    @Test
    public fun currentOwnerReceivesNativeEventsAndOldOwnerCancelsPendingWork() {
        runComposeUiTest {
            val trace = ListenerOwnershipTrace()
            runOnUiThread { setDeviceTestMapKitApiKey() }
            setContent {
                ListenerOwnershipFixture(trace, collectGarbage = { Runtime.getRuntime().gc() })
            }

            val expected = mutableListOf("fresh root owner=1", "subscribed owner=1 listener=1")
            awaitTrace(trace, expected)
            onNodeWithText(ProbeListener).performClick()
            expected += "memory probe owner=1"
            awaitTrace(trace, expected)
            onNodeWithText(AddListenerObject).performClick()
            expected += listOf("native add owner=1 listener=1", "added owner=1")
            awaitTrace(trace, expected)

            onNodeWithText(ReplaceListener).performClick()
            expected += listOf("unsubscribed owner=1 listener=1", "subscribed owner=1 listener=2")
            awaitTrace(trace, expected)
            onNodeWithText(AddListenerObject).performClick()
            expected += listOf("native add owner=1 listener=2", "retired listener held owner=1", "added owner=1")
            awaitTrace(trace, expected)

            onNodeWithText(UnsubscribeListener).performClick()
            expected += "unsubscribed owner=1 listener=2"
            awaitTrace(trace, expected)
            onNodeWithText(AddListenerObject).performClick()
            expected += listOf("retired listener held owner=1", "added owner=1")
            awaitTrace(trace, expected)
            onNodeWithText(SubscribeListener).performClick()
            expected += "subscribed owner=1 listener=3"
            awaitTrace(trace, expected)

            onNodeWithText(ReopenWithPendingCallback).performClick()
            expected += "pending owner=1 listener=3"
            val remount = listOf(
                "unsubscribed owner=1 listener=3",
                "cancelled owner=1 listener=3",
                "fresh root owner=2",
                "subscribed owner=2 listener=1",
            )
            awaitTrace(trace, expected, remount)
            onNodeWithText(ReleaseCallback).performClick()
            awaitTrace(trace, expected, remount, listOf("released pending callback"))
            onNodeWithText(AddListenerObject).performClick()
            awaitTrace(
                trace,
                expected,
                remount,
                listOf("released pending callback", "native add owner=2 listener=1", "added owner=2"),
            )
        }
    }

    private fun ComposeUiTest.awaitTrace(
        trace: ListenerOwnershipTrace,
        prefix: List<String>,
        remount: List<String> = emptyList(),
        suffix: List<String> = emptyList(),
    ) {
        val length = prefix.size + remount.size + suffix.size
        try {
            waitUntil(timeoutMillis = 10_000L) { trace.events.size >= length }
        } catch (failure: Throwable) {
            throw AssertionError("Waiting for ${prefix + remount + suffix}. Events: ${trace.events}", failure)
        }
        runOnIdle {
            val events = trace.events.toList()
            assertEquals(prefix, events.take(prefix.size), "Events: $events")
            assertEquals(remount.sorted(), events.drop(prefix.size).take(remount.size).sorted(), "Events: $events")
            assertEquals(suffix, events.drop(prefix.size + remount.size), "Events: $events")
        }
    }
}
