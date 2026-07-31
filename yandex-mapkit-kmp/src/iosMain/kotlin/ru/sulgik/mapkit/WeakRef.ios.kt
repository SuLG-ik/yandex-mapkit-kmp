package ru.sulgik.mapkit

import kotlin.experimental.ExperimentalNativeApi
import kotlin.native.ref.WeakReference

@OptIn(ExperimentalNativeApi::class)
public actual class WeakRef<T : Any> actual constructor(referent: T) {

    private val reference: WeakReference<T> = WeakReference(referent)

    public actual fun get(): T? {
        return reference.value
    }
}
