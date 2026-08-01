package ru.sulgik.mapkit.compose

import androidx.compose.runtime.AbstractApplier
import androidx.compose.runtime.ComposeNode
import androidx.compose.runtime.Composition
import androidx.compose.runtime.Recomposer
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * A map node is attached to the map as soon as the applier inserts it, so everything it needs to
 * be complete has to reach it through its factory. The `update` block of a `ComposeNode` does not
 * run before that, which is why the map object states are handed to their nodes as a constructor
 * argument instead of being assigned from `update`.
 */
public class MapNodeInsertOrderTest {

    @Test
    public fun updateDoesNotRunBeforeTheNodeIsAttached() {
        val log = mutableListOf<String>()
        composeSingleNode(log)
        assertEquals(listOf("attach carriedByFactory"), log)
    }

    private fun composeSingleNode(log: MutableList<String>) {
        val applier = ProbeApplier(ProbeNode("root"), log)
        Composition(applier, Recomposer(EmptyCoroutineContext)).setContent {
            ComposeNode<ProbeNode, ProbeApplier>(
                factory = { ProbeNode("carriedByFactory") },
                update = { update("assignedByUpdate") { this.name = it } },
            )
        }
    }

    private class ProbeNode(var name: String)

    private class ProbeApplier(
        root: ProbeNode,
        private val log: MutableList<String>,
    ) : AbstractApplier<ProbeNode>(root) {

        override fun insertTopDown(index: Int, instance: ProbeNode) {
        }

        override fun insertBottomUp(index: Int, instance: ProbeNode) {
            log.add("attach ${instance.name}")
        }

        override fun remove(index: Int, count: Int) {
        }

        override fun move(from: Int, to: Int, count: Int) {
        }

        override fun onClear() {
        }
    }
}
