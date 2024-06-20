package ru.sulgik.mapkit.map

import YandexMapKit.YMKCallback

actual abstract class Callback actual constructor() : YMKCallback {

    actual abstract fun onTaskFinished()

    override fun invoke() {
        onTaskFinished()
    }
}