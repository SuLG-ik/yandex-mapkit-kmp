package ru.sulgik.mapkit.map

expect abstract class Callback() {
    abstract fun onTaskFinished()
}

inline fun Callback(crossinline onTaskFinished: () -> Unit): Callback {
    return object : Callback() {
        override fun onTaskFinished() {
            onTaskFinished.invoke()
        }
    }
}