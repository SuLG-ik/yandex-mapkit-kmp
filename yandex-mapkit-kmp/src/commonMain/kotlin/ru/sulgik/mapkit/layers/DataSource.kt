package ru.sulgik.mapkit.layers

/**
 * A data source that is fed with a single blob.
 */
public expect class DataSource : BaseDataSource {

    /**
     * Updates all data.
     */
    public fun setData(data: ByteArray)
}
