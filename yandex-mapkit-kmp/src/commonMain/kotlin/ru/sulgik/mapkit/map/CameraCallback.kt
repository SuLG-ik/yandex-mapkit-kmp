package ru.sulgik.mapkit.map

public expect abstract class CameraCallback() {
    public abstract fun onMoveFinished(completed: Boolean)
}

public inline fun CameraCallback(crossinline onMoveFinished: (completed: Boolean) -> Unit): CameraCallback {
    return object : CameraCallback() {
        override fun onMoveFinished(completed: Boolean) {
            onMoveFinished.invoke(completed)
        }
    }
}