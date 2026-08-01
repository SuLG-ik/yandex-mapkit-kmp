package ru.sulgik.mapkit.layers

/**
 * Notifies when the data behind a layer changed.
 */
public expect abstract class DataSourceListener() {

    public abstract fun onDataSourceUpdated(dataSource: BaseDataSource)
}

public inline fun DataSourceListener(
    crossinline onDataSourceUpdated: (dataSource: BaseDataSource) -> Unit,
): DataSourceListener {
    return object : DataSourceListener() {
        override fun onDataSourceUpdated(dataSource: BaseDataSource) {
            onDataSourceUpdated.invoke(dataSource)
        }
    }
}
