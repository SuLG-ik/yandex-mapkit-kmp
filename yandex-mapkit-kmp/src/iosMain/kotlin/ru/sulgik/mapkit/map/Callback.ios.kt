package ru.sulgik.mapkit.map

import YandexMapKit.YMKCallback as NativeCallback

actual abstract class Callback actual constructor() {

    private val nativeCallback = object : NativeCallback {
        override fun invoke() {
            onTaskFinished()
        }
    }

    fun toNative(): NativeCallback {
        return nativeCallback
    }

    actual abstract fun onTaskFinished()

}