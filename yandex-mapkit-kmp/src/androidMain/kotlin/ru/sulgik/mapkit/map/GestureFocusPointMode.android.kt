package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.GestureFocusPointMode as NativeGestureFocusPointMode

fun GestureFocusPointMode.toNative(): NativeGestureFocusPointMode {
    return when (this) {
        GestureFocusPointMode.AFFECTS_TAP_GESTURES -> NativeGestureFocusPointMode.AFFECTS_TAP_GESTURES
        GestureFocusPointMode.AFFECTS_ALL_GESTURES -> NativeGestureFocusPointMode.AFFECTS_ALL_GESTURES
    }
}

fun NativeGestureFocusPointMode.toCommon(): GestureFocusPointMode {
    return when (this) {
        NativeGestureFocusPointMode.AFFECTS_TAP_GESTURES -> GestureFocusPointMode.AFFECTS_TAP_GESTURES
        NativeGestureFocusPointMode.AFFECTS_ALL_GESTURES -> GestureFocusPointMode.AFFECTS_ALL_GESTURES
    }
}