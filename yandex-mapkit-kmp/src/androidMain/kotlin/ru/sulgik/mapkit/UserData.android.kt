package ru.sulgik.mapkit

import com.yandex.mapkit.UserData as NativeUserData

public fun UserData.toNative(): NativeUserData {
    return NativeUserData(data)
}

public fun NativeUserData.toCommon(): UserData {
    return UserData(data = data)
}
