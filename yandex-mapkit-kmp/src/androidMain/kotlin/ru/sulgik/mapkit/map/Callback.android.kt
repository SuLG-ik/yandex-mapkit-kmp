package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.Callback as NativeCallback

public actual abstract class Callback actual constructor() {

    private val nativeCallback = NativeCallback { onTaskFinished() }

    public fun toNative(): NativeCallback {
        return nativeCallback
    }

    public actual abstract fun onTaskFinished()
}