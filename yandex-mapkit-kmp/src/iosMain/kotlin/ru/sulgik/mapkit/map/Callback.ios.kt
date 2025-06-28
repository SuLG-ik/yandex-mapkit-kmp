package ru.sulgik.mapkit.map

import YandexMapKit.YMKCallback as NativeCallback

public actual abstract class Callback actual constructor() {

    public fun toNative(): NativeCallback {
        return ::onTaskFinished
    }

    public actual abstract fun onTaskFinished()

}