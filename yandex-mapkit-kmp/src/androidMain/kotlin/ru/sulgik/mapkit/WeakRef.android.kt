package ru.sulgik.mapkit

import java.lang.ref.WeakReference

/**
 * A weak reference to [referent] that does not prevent it from being collected.
 *
 * MapKit does not retain the listeners passed to its subscription methods. Every subscription in
 * this SDK therefore accepts a [WeakRef] instead of the listener itself, to make that contract
 * explicit at the call site: it is your responsibility to keep a strong reference to the listener
 * for as long as the subscription has to stay alive.
 *
 * ```
 * class MyScreen {
 *     private val tapListener = MapObjectTapListener { _, _ -> true }
 *
 *     fun subscribe(mapObject: MapObject) {
 *         mapObject.addTapListener(tapListener.asWeakRef())
 *     }
 * }
 * ```
 *
 * Passing a listener that is not referenced anywhere else makes the subscription a no-op as soon as
 * the listener is collected.
 */
public actual class WeakRef<T : Any> actual constructor(referent: T) {

    private val reference: WeakReference<T> = WeakReference(referent)

    /**
     * The referent, or `null` if it has already been collected.
     */
    public actual fun get(): T? {
        return reference.get()
    }
}
