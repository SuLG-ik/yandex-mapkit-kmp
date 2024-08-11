package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.PointOfView as NativePointOfView

public fun PointOfView.toNative(): NativePointOfView {
    return when (this) {
        PointOfView.SCREEN_CENTER -> NativePointOfView.SCREEN_CENTER
        PointOfView.ADAPT_TO_FOCUS_POINT_HORIZONTALLY -> NativePointOfView.ADAPT_TO_FOCUS_POINT_HORIZONTALLY
    }
}

public fun NativePointOfView.toCommon(): PointOfView {
    return when (this) {
        NativePointOfView.SCREEN_CENTER -> PointOfView.SCREEN_CENTER
        NativePointOfView.ADAPT_TO_FOCUS_POINT_HORIZONTALLY -> PointOfView.ADAPT_TO_FOCUS_POINT_HORIZONTALLY
    }
}