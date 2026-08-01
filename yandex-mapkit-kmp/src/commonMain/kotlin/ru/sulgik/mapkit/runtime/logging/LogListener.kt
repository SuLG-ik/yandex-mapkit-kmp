package ru.sulgik.mapkit.runtime.logging

/**
 * Receives the log messages of MapKit.
 */
public expect abstract class LogListener() {

    /**
     * Called when a new log message is received.
     */
    public abstract fun onMessageReceived(message: LogMessage)
}

public inline fun LogListener(
    crossinline onMessageReceived: (message: LogMessage) -> Unit,
): LogListener {
    return object : LogListener() {
        override fun onMessageReceived(message: LogMessage) {
            onMessageReceived.invoke(message)
        }
    }
}
