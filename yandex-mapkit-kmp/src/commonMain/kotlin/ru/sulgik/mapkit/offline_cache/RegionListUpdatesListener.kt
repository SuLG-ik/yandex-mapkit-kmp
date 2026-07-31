package ru.sulgik.mapkit.offline_cache

/**
 * Notifies when the list of offline regions is updated.
 */
public expect abstract class RegionListUpdatesListener() {

    public abstract fun onListUpdated()
}

public inline fun RegionListUpdatesListener(
    crossinline onListUpdated: () -> Unit,
): RegionListUpdatesListener {
    return object : RegionListUpdatesListener() {
        override fun onListUpdated() {
            onListUpdated.invoke()
        }
    }
}
