package ru.sulgik.mapkit.compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.atomicfu.locks.reentrantLock
import kotlinx.atomicfu.locks.withLock
import ru.sulgik.mapkit.map.MapWindow

internal class MapWindowOwner(private val callback: ((MapWindow?) -> Unit)? = null) {

    private val lock = reentrantLock()
    internal var mapWindow: MapWindow? by mutableStateOf(null)
        private set

    internal fun setMapWindow(mapWindow: MapWindow?) {
        lock.withLock {
            if (this.mapWindow == null && mapWindow == null) return
            if (this.mapWindow == mapWindow) return
            if (this.mapWindow != null && mapWindow != null) {
                error("YandexMapController may only be associated with one MapView at a time")
            }
            this.mapWindow = mapWindow
            callback?.invoke(mapWindow)
        }
    }

    internal inline fun <T> withLock(block: (MapWindow?) -> T): T {
        return lock.withLock {
            block(mapWindow)
        }
    }

}