package ru.sulgik.mapkit.map

expect abstract class CameraCallback() {

    abstract fun onMoveFinished(completed: Boolean)

}

private class LambdaCameraCallback(val onMoveFinished: (completed: Boolean) -> Unit) :
    CameraCallback() {

    override fun onMoveFinished(completed: Boolean) {
        onMoveFinished.invoke(completed)
    }

}

fun CameraCallback(onMoveFinished: (completed: Boolean) -> Unit): CameraCallback {
    return LambdaCameraCallback(onMoveFinished)
}