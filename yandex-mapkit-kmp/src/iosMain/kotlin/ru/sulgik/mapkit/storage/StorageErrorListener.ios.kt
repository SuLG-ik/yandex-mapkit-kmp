package ru.sulgik.mapkit.storage

import platform.darwin.NSObject
import ru.sulgik.mapkit.NativeConvertible
import ru.sulgik.mapkit.runtime.LocalError
import ru.sulgik.mapkit.runtime.toCommon
import YandexMapKit.YMKStorageErrorListenerProtocol as NativeStorageErrorListener
import YandexMapKit.YRTLocalError as NativeLocalError

/**
 * Notifies about local storage errors.
 */
public actual abstract class StorageErrorListener actual constructor() : NativeConvertible<NativeStorageErrorListener> {

    private val nativeListener = object : NativeStorageErrorListener, NSObject() {
        override fun onStorageErrorWithError(error: NativeLocalError) {
            onStorageError(error.toCommon())
        }
    }

    override fun toNative(): NativeStorageErrorListener {
        return nativeListener
    }

    /**
     * Possible error types: [ru.sulgik.mapkit.runtime.DiskCorruptError] if local storage is
     * corrupted, [ru.sulgik.mapkit.runtime.DiskFullError] if there is no space left.
     */
    public actual abstract fun onStorageError(error: LocalError)
}
