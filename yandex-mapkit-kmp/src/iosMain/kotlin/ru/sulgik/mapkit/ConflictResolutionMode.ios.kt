package ru.sulgik.mapkit

import YandexMapKit.YMKConflictResolutionMode as NativeConflictResolutionMode

public fun ConflictResolutionMode.toNative(): NativeConflictResolutionMode {
    return when (this) {
        ConflictResolutionMode.MINOR -> NativeConflictResolutionMode.YMKConflictResolutionModeMinor
        ConflictResolutionMode.EQUAL -> NativeConflictResolutionMode.YMKConflictResolutionModeEqual
        ConflictResolutionMode.MAJOR -> NativeConflictResolutionMode.YMKConflictResolutionModeMajor
        ConflictResolutionMode.IGNORE -> NativeConflictResolutionMode.YMKConflictResolutionModeIgnore
    }
}

public fun NativeConflictResolutionMode.toCommon(): ConflictResolutionMode {
    return when (this) {
        NativeConflictResolutionMode.YMKConflictResolutionModeMinor -> ConflictResolutionMode.MINOR
        NativeConflictResolutionMode.YMKConflictResolutionModeEqual -> ConflictResolutionMode.EQUAL
        NativeConflictResolutionMode.YMKConflictResolutionModeMajor -> ConflictResolutionMode.MAJOR
        NativeConflictResolutionMode.YMKConflictResolutionModeIgnore -> ConflictResolutionMode.IGNORE
        else -> throw IllegalArgumentException("Unknown NativeConflictResolutionMode ($this)")
    }
}
