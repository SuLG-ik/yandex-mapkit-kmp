package ru.sulgik.mapkit.layers

/**
 * The data behind a layer.
 */
public expect open class BaseDataSource {

    /**
     * Stores id of data source.
     */
    public val id: String

    /**
     * Tells if this **BaseDataSource** is valid or not.
     */
    public val isValid: Boolean
}
