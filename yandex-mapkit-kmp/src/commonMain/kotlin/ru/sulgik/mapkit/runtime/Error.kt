package ru.sulgik.mapkit.runtime

/**
 * The base type of every error MapKit reports.
 */
public expect open class Error {

    /**
     * Tells if this **Error** is valid or not.
     */
    public val isValid: Boolean
}
