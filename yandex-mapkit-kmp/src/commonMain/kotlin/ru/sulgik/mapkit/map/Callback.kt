package ru.sulgik.mapkit.map

expect abstract class Callback() {

    abstract fun onTaskFinished()

}


private class LambdaCallback(val onTaskFinished: () -> Unit) :
    Callback() {
    override fun onTaskFinished() {
        onTaskFinished.invoke()
    }

}

fun Callback(onTaskFinished: () -> Unit): Callback {
    return LambdaCallback(onTaskFinished)
}