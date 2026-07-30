package ru.sulgik.mapkit

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

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
public expect class WeakRef<T : Any>(referent: T) {

    /**
     * The referent, or `null` if it has already been collected.
     */
    public fun get(): T?
}

/**
 * Wraps this object into a [WeakRef] to pass it to a subscription method.
 */
public fun <T : Any> T.asWeakRef(): WeakRef<T> {
    return WeakRef(this)
}

/**
 * Runs [block] with the referent and returns its result, or returns `null` if the referent has
 * already been collected.
 */
@OptIn(ExperimentalContracts::class)
public inline fun <T : Any, R> WeakRef<T>.withValue(block: (T) -> R): R? {
    contract { callsInPlace(block, InvocationKind.AT_MOST_ONCE) }
    return get()?.let(block)
}
