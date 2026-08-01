package ru.sulgik.mapkit

import com.yandex.mapkit.ConflictResolutionMode as NativeConflictResolutionMode

public fun ConflictResolutionMode.toNative(): NativeConflictResolutionMode {
    return when (this) {
        ConflictResolutionMode.MINOR -> NativeConflictResolutionMode.MINOR
        ConflictResolutionMode.EQUAL -> NativeConflictResolutionMode.EQUAL
        ConflictResolutionMode.MAJOR -> NativeConflictResolutionMode.MAJOR
        ConflictResolutionMode.IGNORE -> NativeConflictResolutionMode.IGNORE
    }
}

public fun NativeConflictResolutionMode.toCommon(): ConflictResolutionMode {
    return when (this) {
        NativeConflictResolutionMode.MINOR -> ConflictResolutionMode.MINOR
        NativeConflictResolutionMode.EQUAL -> ConflictResolutionMode.EQUAL
        NativeConflictResolutionMode.MAJOR -> ConflictResolutionMode.MAJOR
        NativeConflictResolutionMode.IGNORE -> ConflictResolutionMode.IGNORE
    }
}
