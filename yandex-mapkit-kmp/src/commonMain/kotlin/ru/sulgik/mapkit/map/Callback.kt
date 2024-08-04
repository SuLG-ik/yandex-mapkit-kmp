package ru.sulgik.mapkit.map

public expect abstract class Callback() {
    public abstract fun onTaskFinished()
}

public inline fun Callback(crossinline onTaskFinished: () -> Unit): Callback {
    return object : Callback() {
        override fun onTaskFinished() {
            onTaskFinished.invoke()
        }
    }
}