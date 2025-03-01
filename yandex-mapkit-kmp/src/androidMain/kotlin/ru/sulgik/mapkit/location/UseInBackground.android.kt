package ru.sulgik.mapkit.location

import com.yandex.mapkit.location.UseInBackground as NativeUseInBackground

public fun UseInBackground.toNative(): NativeUseInBackground {
    return when (this) {
        UseInBackground.ALLOW -> NativeUseInBackground.ALLOW
        UseInBackground.DISALLOW -> NativeUseInBackground.DISALLOW
    }
}

public fun NativeUseInBackground.toCommon(): UseInBackground {
    return when (this) {
        NativeUseInBackground.ALLOW -> UseInBackground.ALLOW
        NativeUseInBackground.DISALLOW -> UseInBackground.DISALLOW
    }
}