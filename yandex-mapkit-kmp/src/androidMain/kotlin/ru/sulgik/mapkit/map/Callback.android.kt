package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.Callback as NativeCallback

actual abstract class Callback actual constructor() {

    private val nativeCallback = NativeCallback { onTaskFinished() }

    fun toNative(): NativeCallback {
        return nativeCallback
    }

    actual abstract fun onTaskFinished()
}