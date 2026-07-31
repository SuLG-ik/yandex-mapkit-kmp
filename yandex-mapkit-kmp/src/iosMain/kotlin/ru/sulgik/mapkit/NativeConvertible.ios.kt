package ru.sulgik.mapkit

/**
 * Unwraps the referent into the object expected by the subscription methods of the original Yandex
 * MapKit SDK, or returns `null` if it has already been collected.
 *
 * The SDK stores such objects as `__weak` pointers, so the caller stays responsible for keeping the
 * referent alive.
 */
public fun <T, N : Any> WeakRef<T>.toNative(): N?
        where T : Any, T : NativeConvertible<N> {
    return get()?.toNative()
}
