package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.Model as NativeModel

/**
 * Provides an interface to set a model and its style for a placemark.
 */
public actual class Model internal constructor(
    private val nativeModel: NativeModel,
) : PlacemarkPresentation(nativeModel) {

    override fun toNative(): NativeModel {
        return nativeModel
    }

    /**
     * The style properties (scale, unitType, etc.) of the model placemark.
     */
    public actual var modelStyle: ModelStyle
        get() = nativeModel.modelStyle.toCommon()
        set(value) {
            nativeModel.modelStyle = value.toNative()
        }

    /**
     * Sets glTF data provider.
     *
     * @param onFinished Called when the model is applied.
     */
    public actual fun setData(gltfDataProvider: DataProviderWithId, onFinished: Callback?) {
        nativeModel.setData(gltfDataProvider.toNative(), onFinished?.toNative())
    }
}

public fun NativeModel.toCommon(): Model {
    return Model(this)
}
