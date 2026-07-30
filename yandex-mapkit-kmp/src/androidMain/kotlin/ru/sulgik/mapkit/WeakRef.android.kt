package ru.sulgik.mapkit

import java.lang.ref.WeakReference

public actual class WeakRef<T : Any> actual constructor(referent: T) {

    private val reference: WeakReference<T> = WeakReference(referent)

    public actual fun get(): T? {
        return reference.get()
    }
}
