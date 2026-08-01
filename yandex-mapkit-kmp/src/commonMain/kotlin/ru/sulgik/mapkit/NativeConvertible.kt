package ru.sulgik.mapkit

/**
 * A wrapper around the [T] object of the original Yandex MapKit SDK.
 */
public interface NativeConvertible<T : Any> {

    public fun toNative(): T
}
