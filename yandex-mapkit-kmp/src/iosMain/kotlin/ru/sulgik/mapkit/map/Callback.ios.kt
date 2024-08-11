package ru.sulgik.mapkit.map

import YandexMapKit.YMKCallback as NativeCallback

public actual abstract class Callback actual constructor() {

    private val nativeCallback = object : NativeCallback {
        override fun invoke() {
            onTaskFinished()
        }
    }

    public fun toNative(): NativeCallback {
        return nativeCallback
    }

    public actual abstract fun onTaskFinished()

}