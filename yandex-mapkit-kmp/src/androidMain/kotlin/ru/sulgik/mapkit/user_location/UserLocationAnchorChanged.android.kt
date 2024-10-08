package ru.sulgik.mapkit.user_location

import ru.sulgik.mapkit.layers.ObjectEvent
import com.yandex.mapkit.user_location.UserLocationAnchorChanged as NativeUserLocationAnchorChanged

public actual class UserLocationAnchorChanged internal constructor(
    private val nativeUserLocationAnchorChanged: NativeUserLocationAnchorChanged,
) : ObjectEvent(nativeUserLocationAnchorChanged) {

    override fun toNative(): NativeUserLocationAnchorChanged {
        return nativeUserLocationAnchorChanged
    }

    public actual val anchorType: UserLocationAnchorType
        get() = nativeUserLocationAnchorChanged.anchorType.toCommon()

}

public fun NativeUserLocationAnchorChanged.toCommon(): UserLocationAnchorChanged {
    return UserLocationAnchorChanged(this)
}