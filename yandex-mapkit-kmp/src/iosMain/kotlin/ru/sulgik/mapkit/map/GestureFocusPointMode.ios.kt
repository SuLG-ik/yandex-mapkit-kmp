package ru.sulgik.mapkit.map

import YandexMapKit.YMKGestureFocusPointMode as NativeGestureFocusPointMode

fun GestureFocusPointMode.toNative(): NativeGestureFocusPointMode {
    return when (this) {
        GestureFocusPointMode.AFFECTS_TAP_GESTURES -> NativeGestureFocusPointMode.YMKGestureFocusPointModeAffectsTapGestures
        GestureFocusPointMode.AFFECTS_ALL_GESTURES -> NativeGestureFocusPointMode.YMKGestureFocusPointModeAffectsAllGestures
    }
}

fun NativeGestureFocusPointMode.toCommon(): GestureFocusPointMode {
    return when (this) {
        NativeGestureFocusPointMode.YMKGestureFocusPointModeAffectsTapGestures -> GestureFocusPointMode.AFFECTS_TAP_GESTURES
        NativeGestureFocusPointMode.YMKGestureFocusPointModeAffectsAllGestures -> GestureFocusPointMode.AFFECTS_ALL_GESTURES
        else -> throw IllegalArgumentException("Unknown NativeGestureFocusPointMode ($this)")
    }
}