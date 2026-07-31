package ru.sulgik.mapkit

/**
 * A wrapper around the [T] object of the original Yandex MapKit SDK.
 */
public interface NativeConvertible<T : Any> {

    public fun toNative(): T
}

/**
 * Unwraps the referent into the object expected by the subscription methods of the original Yandex
 * MapKit SDK, or returns `null` if it has already been collected.
 *
 * The SDK stores such objects as `__weak` pointers, so the caller stays responsible for keeping the
 * referent alive.
 */
public fun <T : NativeConvertible<N>, N : Any> WeakRef<T>.toNative(): N? {
    return get()?.toNative()
}
