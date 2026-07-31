package ru.sulgik.mapkit

import java.lang.ref.WeakReference

/**
 * A wrapper around the [T] object of the original Yandex MapKit SDK.
 */
public interface NativeConvertible<T : Any> {

    public fun toNative(): T
}

/**
 * Converts this reference into the weak reference expected by the subscription methods of the
 * original Yandex MapKit SDK.
 *
 * If the referent has already been collected, the returned reference is empty as well, so the
 * subscription it is passed to never fires.
 */
public fun <T : NativeConvertible<N>, N : Any> WeakRef<T>.toNative(): WeakReference<N> {
    return WeakReference<N>(get()?.toNative())
}
