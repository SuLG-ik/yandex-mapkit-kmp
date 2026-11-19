package ru.sulgik.mapkit.storage

import ru.sulgik.mapkit.LiveMap
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.runtime.Error
import kotlin.concurrent.atomics.AtomicReference
import kotlin.concurrent.atomics.ExperimentalAtomicApi
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertSame
import kotlin.test.assertTrue
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlin.time.TimeSource

public class StorageManagerContractTest {

    @OptIn(ExperimentalAtomicApi::class)
    @Test
    public fun sdk_storage_size_callback_returns_a_real_byte_count() {
        LiveMap.onMap {
            val manager = LiveMap.mapKit().storageManager
            assertTrue(manager.isValid)
            assertEquals(manager, manager.toNative().toCommon())

            val result = AtomicReference<Pair<Long?, Error?>?>(null)
            manager.computeSize { bytes, error -> result.store(bytes to error) }

            val deadline = TimeSource.Monotonic.markNow() + 5.seconds
            while (result.load() == null && !deadline.hasPassedNow()) {
                LiveMap.drainMainQueue(25.milliseconds)
            }
            val (bytes, error) = assertNotNull(result.load(), "Native storage size callback did not complete")
            assertNull(error, "Native storage size query failed")
            assertTrue(assertNotNull(bytes) >= 0L)
        }
    }

    @Test
    public fun sdk_accepts_subscribe_and_unsubscribe_for_the_same_storage_listener() {
        LiveMap.onMap {
            val manager = LiveMap.mapKit().storageManager
            val listener = StorageErrorListener { }
            val adapter = listener.toNative()

            manager.addStorageErrorListener(listener.asWeakRef())
            manager.removeStorageErrorListener(listener.asWeakRef())

            assertSame(adapter, listener.toNative())
            assertTrue(manager.isValid)
        }
    }
}
