package ru.sulgik.mapkit.map

import YandexMapKit.YMKPointOfView as NativePointOfView

public fun PointOfView.toNative(): NativePointOfView {
    return when (this) {
        PointOfView.SCREEN_CENTER -> NativePointOfView.YMKPointOfViewScreenCenter
        PointOfView.ADAPT_TO_FOCUS_POINT_HORIZONTALLY -> NativePointOfView.YMKPointOfViewAdaptToFocusPointHorizontally
    }
}

public fun NativePointOfView.toCommon(): PointOfView {
    return when (this) {
        NativePointOfView.YMKPointOfViewScreenCenter -> PointOfView.SCREEN_CENTER
        NativePointOfView.YMKPointOfViewAdaptToFocusPointHorizontally -> PointOfView.ADAPT_TO_FOCUS_POINT_HORIZONTALLY
        else -> throw IllegalArgumentException("Unknown NativePointOfView ($this)")
    }
}