package ru.sulgik.mapkit.storage

import YandexMapKit.YMKStorageManagerClearCallback
import YandexMapKit.YMKStorageManagerSizeCallback
import YandexMapKit.YRTUnderlyingErrorKey
import platform.Foundation.NSError
import ru.sulgik.mapkit.LiveMap
import ru.sulgik.mapkit.asWeakRef
import ru.sulgik.mapkit.runtime.DiskWriteAccessError
import ru.sulgik.mapkit.runtime.Error
import ru.sulgik.mapkit.runtime.LocalError
import ru.sulgik.mapkit.toNSNumber
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNull
import kotlin.test.assertSame
import kotlin.test.assertTrue
import YandexMapKit.YMKStorageErrorListenerProtocol as NativeStorageErrorListener
import YandexMapKit.YMKStorageManager as NativeStorageManager
import YandexMapKit.YRTDiskWriteAccessError as NativeDiskWriteAccessError

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
        val failure = NativeDiskWriteAccessError()
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
        val failure = NativeDiskWriteAccessError()

        storage.addStorageErrorListener(listener.asWeakRef())
        assertSame(listener.toNative(), nativeStorage.currentErrorListener)
        checkNotNull(nativeStorage.currentErrorListener).onStorageErrorWithError(failure)

        storage.removeStorageErrorListener(listener.asWeakRef())
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

private class RecordingStorage : NativeStorageManager() {

    val sizeRequests = mutableListOf<String>()
    var requestedLimit: Long? = null
        private set
    var currentErrorListener: NativeStorageErrorListener? = null
        private set
    private var pendingSize: YMKStorageManagerSizeCallback? = null
    private var pendingClear: YMKStorageManagerClearCallback? = null

    override fun addStorageErrorListenerWithErrorListener(errorListener: NativeStorageErrorListener) {
        currentErrorListener = errorListener
    }

    override fun removeStorageErrorListenerWithErrorListener(errorListener: NativeStorageErrorListener) {
        assertSame(currentErrorListener, errorListener, "Native unsubscribe uses adapter identity")
        currentErrorListener = null
    }

    override fun computeSizeWithSizeCallback(sizeCallback: YMKStorageManagerSizeCallback) {
        requestSize("compute", sizeCallback)
    }

    override fun setMaxTileStorageSizeWithLimit(limit: Long, sizeCallback: YMKStorageManagerSizeCallback) {
        requestedLimit = limit
        requestSize("set", sizeCallback)
    }

    override fun maxTileStorageSizeWithSizeCallback(sizeCallback: YMKStorageManagerSizeCallback) {
        requestSize("get", sizeCallback)
    }

    override fun resetMaxTileStorageSizeWithSizeCallback(sizeCallback: YMKStorageManagerSizeCallback) {
        requestSize("reset", sizeCallback)
    }

    override fun clearWithClearCallback(clearCallback: YMKStorageManagerClearCallback) {
        check(pendingClear == null)
        pendingClear = clearCallback
    }

    fun completeClear() {
        val callback = checkNotNull(pendingClear)
        pendingClear = null
        callback()
    }

    fun completeSize(bytes: Long?) {
        takeSizeCallback()(bytes?.toNSNumber(), null)
    }

    fun failSize(error: NativeDiskWriteAccessError) {
        takeSizeCallback()(
            null,
            NSError.errorWithDomain("mapkit-storage-test", 1, mapOf<Any?, Any>(YRTUnderlyingErrorKey to error)),
        )
    }

    private fun requestSize(operation: String, callback: YMKStorageManagerSizeCallback) {
        check(pendingSize == null)
        sizeRequests += operation
        pendingSize = callback
    }

    private fun takeSizeCallback(): YMKStorageManagerSizeCallback {
        val callback = checkNotNull(pendingSize)
        pendingSize = null
        return callback
    }

    override fun isValid(): Boolean {
        return true
    }
}
