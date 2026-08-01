package ru.sulgik.mapkit

import YandexMapKit.YMKUserData as NativeUserData

@Suppress("UNCHECKED_CAST")
public fun UserData.toNative(): NativeUserData {
    return NativeUserData.userDataWithData(data as Map<Any?, *>)
}

@Suppress("UNCHECKED_CAST")
public fun NativeUserData.toCommon(): UserData {
    return UserData(data = data as Map<String, String>)
}
