package ru.sulgik.mapkit.storage

import ru.sulgik.mapkit.LiveMap
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.runtime.DiskWriteAccessError
import ru.sulgik.mapkit.runtime.Error
import ru.sulgik.mapkit.runtime.LocalError
import java.lang.ref.WeakReference
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNull
import kotlin.test.assertSame
import kotlin.test.assertTrue
import com.yandex.mapkit.storage.StorageErrorListener as NativeStorageErrorListener
import com.yandex.mapkit.storage.StorageManager as NativeStorageManager
import com.yandex.runtime.DiskWriteAccessError as NativeDiskWriteAccessError

public class StorageManagerContractTest {

    @Test
    public fun storage_wrapper_preserves_byte_counts_and_delivers_typed_errors() {
        val nativeStorage = RecordingStorage()
        val storage = nativeStorage.toCommon()
        val results = mutableListOf<Pair<Long?, Error?>>()
        val onSize: (Long?, Error?) -> Unit = { size, error -> results += size to error }
        val limit = 5L * 1024 * 1024 * 1024

        storage.computeSize(onSize)
        assertEquals(emptyList(), results)
        nativeStorage.completeSize(12L)
        storage.setMaxTileStorageSize(limit, onSize)
        assertEquals(limit, nativeStorage.requestedLimit)
        nativeStorage.completeSize(limit)
        storage.maxTileStorageSize(onSize)
        val failure = object : NativeDiskWriteAccessError {
            override fun isValid(): Boolean {
                return true
            }
        }
        nativeStorage.failSize(failure)
        storage.resetMaxTileStorageSize(onSize)
        nativeStorage.completeSize(null)

        assertEquals(listOf("compute", "set", "get", "reset"), nativeStorage.sizeRequests)
        assertEquals(4, results.size)
        assertEquals(12L to null, results[0])
        assertEquals(limit to null, results[1])
        assertNull(results[2].first)
        val mapped = assertIs<DiskWriteAccessError>(results[2].second)
        assertSame(failure, mapped.toNative())
        assertEquals(null to null, results[3])

        var completions = 0
        storage.clear { completions++ }
        assertEquals(0, completions)
        nativeStorage.completeClear()
        assertEquals(1, completions)
    }

    @Test
    public fun storage_error_subscription_can_be_removed_using_a_new_weak_reference() {
        val nativeStorage = RecordingStorage()
        val storage = nativeStorage.toCommon()
        val received = mutableListOf<LocalError>()
        val listener = StorageErrorListener { received += it }
        val failure = object : NativeDiskWriteAccessError {
            override fun isValid(): Boolean {
                return true
            }
        }

        val adapter = listener.toNative()
        storage.addStorageErrorListener(listener.asWeakRef())
        val registered = checkNotNull(nativeStorage.currentErrorListener?.get())
        assertSame(adapter, registered)
        registered.onStorageError(failure)

        storage.removeStorageErrorListener(listener.asWeakRef())
        assertSame(adapter, listener.toNative())
        assertNull(nativeStorage.currentErrorListener)
        val mapped = assertIs<DiskWriteAccessError>(received.single())
        assertSame(failure, mapped.toNative())
    }

    @Test
    public fun sdk_provides_a_valid_storage_manager_handle() {
        LiveMap.onMap {
            val kit = LiveMap.mapKit()
            val manager = kit.storageManager
            assertTrue(manager.isValid)
            assertEquals(manager, manager.toNative().toCommon())
        }
    }
}

private class RecordingStorage : NativeStorageManager {

    val sizeRequests = mutableListOf<String>()
    var requestedLimit: Long? = null
        private set
    var currentErrorListener: WeakReference<NativeStorageErrorListener>? = null
        private set
    private var pendingSize: NativeStorageManager.SizeListener? = null
    private var pendingClear: NativeStorageManager.ClearListener? = null

    override fun addStorageErrorListener(errorListener: WeakReference<NativeStorageErrorListener>) {
        currentErrorListener = errorListener
    }

    override fun removeStorageErrorListener(errorListener: WeakReference<NativeStorageErrorListener>) {
        val registered = checkNotNull(currentErrorListener?.get())
        val removed = checkNotNull(errorListener.get())
        assertSame(registered, removed, "Native unsubscribe uses adapter identity")
        currentErrorListener = null
    }

    override fun computeSize(sizeListener: NativeStorageManager.SizeListener) {
        requestSize("compute", sizeListener)
    }

    override fun setMaxTileStorageSize(limit: Long, sizeListener: NativeStorageManager.SizeListener) {
        requestedLimit = limit
        requestSize("set", sizeListener)
    }

    override fun maxTileStorageSize(sizeListener: NativeStorageManager.SizeListener) {
        requestSize("get", sizeListener)
    }

    override fun resetMaxTileStorageSize(sizeListener: NativeStorageManager.SizeListener) {
        requestSize("reset", sizeListener)
    }

    override fun clear(clearListener: NativeStorageManager.ClearListener) {
        check(pendingClear == null)
        pendingClear = clearListener
    }

    fun completeClear() {
        val callback = checkNotNull(pendingClear)
        pendingClear = null
        callback.onClearCompleted()
    }

    fun completeSize(bytes: Long?) {
        takeSizeCallback().onSuccess(bytes)
    }

    fun failSize(error: NativeDiskWriteAccessError) {
        takeSizeCallback().onError(error)
    }

    private fun requestSize(operation: String, callback: NativeStorageManager.SizeListener) {
        check(pendingSize == null)
        sizeRequests += operation
        pendingSize = callback
    }

    private fun takeSizeCallback(): NativeStorageManager.SizeListener {
        val callback = checkNotNull(pendingSize)
        pendingSize = null
        return callback
    }

    override fun isValid(): Boolean {
        return true
    }
}
