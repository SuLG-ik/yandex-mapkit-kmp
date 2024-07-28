package ru.sulgik.mapkit.map

expect abstract class CameraCallback() {
    abstract fun onMoveFinished(completed: Boolean)
}

inline fun CameraCallback(crossinline onMoveFinished: (completed: Boolean) -> Unit): CameraCallback {
    return object : CameraCallback() {
        override fun onMoveFinished(completed: Boolean) {
            onMoveFinished.invoke(completed)
        }
    }
}