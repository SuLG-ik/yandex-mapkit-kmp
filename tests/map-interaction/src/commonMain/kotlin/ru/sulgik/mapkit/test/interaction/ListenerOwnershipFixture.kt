package ru.sulgik.mapkit.test.interaction

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.compose.MapControllerEffect
import ru.sulgik.mapkit.compose.YandexMap
import ru.sulgik.mapkit.compose.bindToLifecycleOwner
import ru.sulgik.mapkit.compose.rememberAndInitializeMapKit
import ru.sulgik.mapkit.compose.rememberYandexMapController
import ru.sulgik.mapkit.map.MapObjectCollection
import ru.sulgik.mapkit.map.MapObjectCollectionListener
import ru.sulgik.mapkit.map.MapType

internal const val ListenerOwnershipArgument = "--listener-ownership"
internal const val ListenerOwnershipTraceTag = "listener-ownership-trace"
internal const val ProbeListener = "Recompose with memory pressure"
internal const val AddListenerObject = "Add object"
internal const val ReplaceListener = "Replace listener"
internal const val UnsubscribeListener = "Unsubscribe listener"
internal const val SubscribeListener = "Subscribe listener"
internal const val ReopenWithPendingCallback = "Queue callback and reopen"
internal const val ReleaseCallback = "Release pending callback"

internal class ListenerOwnershipTrace {
    val events = mutableStateListOf<String>()
    var pendingWork by mutableStateOf<CompletableDeferred<Unit>?>(null)
}

@Composable
internal fun ListenerOwnershipFixture(
    trace: ListenerOwnershipTrace = remember { ListenerOwnershipTrace() },
    collectGarbage: () -> Unit,
) {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    var owner by remember { mutableIntStateOf(1) }

    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        key(owner) {
            OwnedMap(owner, trace, collectGarbage, reopen = { owner++ })
        }
        if (trace.pendingWork != null) {
            Action(ReleaseCallback) {
                checkNotNull(trace.pendingWork).complete(Unit)
                trace.pendingWork = null
                trace.events.add("released pending callback")
            }
        }
        BasicText(
            text = trace.events.joinToString(" | "),
            modifier = Modifier.testTag(ListenerOwnershipTraceTag),
            maxLines = 1,
        )
    }
}

@Composable
private fun OwnedMap(
    owner: Int,
    trace: ListenerOwnershipTrace,
    collectGarbage: () -> Unit,
    reopen: () -> Unit,
) {
    val controller = rememberYandexMapController()
    var collection by remember { mutableStateOf<MapObjectCollection?>(null) }
    YandexMap(controller = controller, modifier = Modifier.size(128.dp))
    MapControllerEffect(controller, dispose = { collection = null }) { window ->
        window.map.mapType = MapType.NONE
        val root = window.map.mapObjects
        val previousTag = root.userData
        check(previousTag == null) { "Owner $owner received a map root tagged $previousTag. Events: ${trace.events}" }
        val tag = "listener ownership root $owner"
        root.userData = tag
        check(root.userData == tag) { "Could not tag the native map root for owner $owner" }
        trace.events.add("fresh root owner=$owner")
        collection = root.addCollection()
    }
    collection?.let { attached ->
        CollectionControls(owner, attached, trace, collectGarbage, reopen)
    }
}

@Composable
private fun CollectionControls(
    owner: Int,
    collection: MapObjectCollection,
    trace: ListenerOwnershipTrace,
    collectGarbage: () -> Unit,
    reopen: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    var nextRevision by remember { mutableIntStateOf(1) }
    var revision by remember { mutableIntStateOf(1) }
    var probe by remember { mutableIntStateOf(0) }
    var pauseNextCallback by remember { mutableStateOf(false) }
    val retired = remember { RetiredListener() }

    if (revision != 0) {
        val identity = "owner=$owner listener=$revision"
        val listener = remember(collection, identity) {
            MapObjectCollectionListener(
                onMapObjectAdded = { mapObject ->
                    if (pauseNextCallback) {
                        pauseNextCallback = false
                        val pending = checkNotNull(trace.pendingWork)
                        val oldObject = mapObject.asWeakRef()
                        scope.launch(start = CoroutineStart.UNDISPATCHED) {
                            trace.events.add("pending $identity")
                            try {
                                pending.await()
                                trace.events.add("unexpected late callback $identity")
                                oldObject.get()?.let { if (it.isValid) it.isVisible = false }
                            } catch (cancelled: CancellationException) {
                                trace.events.add("cancelled $identity")
                                throw cancelled
                            }
                        }
                    } else {
                        trace.events.add("native add $identity")
                    }
                },
                onMapObjectRemoved = {},
            )
        }
        DisposableEffect(collection, listener) {
            collection.addListener(listener.asWeakRef())
            trace.events.add("subscribed $identity")
            onDispose {
                if (collection.isValid) collection.removeListener(listener.asWeakRef())
                trace.events.add("unsubscribed $identity")
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            Action(ReplaceListener, Modifier.weight(1f)) {
                retired.listener = listener
                revision = ++nextRevision
            }
            Action(UnsubscribeListener, Modifier.weight(1f)) {
                retired.listener = listener
                revision = 0
            }
        }
        Action(ReopenWithPendingCallback) {
            check(trace.pendingWork == null)
            trace.pendingWork = CompletableDeferred()
            pauseNextCallback = true
            collection.addPlacemark()
            reopen()
        }
    } else {
        Action(SubscribeListener) { revision = ++nextRevision }
    }
    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Action(AddListenerObject, Modifier.weight(1f)) {
            val retiredListener = retired.listener
            val placemark = collection.addPlacemark()
            if (retiredListener != null) {
                check(retired.listener === retiredListener)
                retired.listener = null
                trace.events.add("retired listener held owner=$owner")
            }
            collection.remove(placemark)
            trace.events.add("added owner=$owner")
        }
        Action(ProbeListener, Modifier.weight(1f)) { probe++ }
    }
    LaunchedEffect(probe) {
        if (probe != 0) {
            val pressure = List(8) { index -> ByteArray(256 * 1024).apply { this[lastIndex] = index.toByte() } }
            collectGarbage()
            check(pressure.sumOf { it.last().toInt() } == 28)
            trace.events.add("memory probe owner=$owner")
        }
    }
}

private class RetiredListener {
    var listener: MapObjectCollectionListener? = null
}

@Composable
private fun Action(label: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier.fillMaxWidth().height(48.dp)
            .testTag(label)
            .clickable(role = Role.Button, onClick = onClick)
            .padding(horizontal = 8.dp),
        contentAlignment = Alignment.CenterStart,
    ) {
        BasicText(text = label)
    }
}
