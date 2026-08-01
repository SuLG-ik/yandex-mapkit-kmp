package ru.sulgik.mapkit.map

/**
 * Provides an interface to set a model and its style for a placemark.
 */
public expect class Model : PlacemarkPresentation {

    /**
     * The style properties (scale, unitType, etc.) of the model placemark.
     */
    public var modelStyle: ModelStyle

    /**
     * Sets glTF data provider.
     *
     * @param onFinished Called when the model is applied.
     */
    public fun setData(gltfDataProvider: DataProviderWithId, onFinished: Callback? = null)
}
