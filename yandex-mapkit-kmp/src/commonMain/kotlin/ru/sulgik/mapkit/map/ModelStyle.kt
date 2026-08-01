package ru.sulgik.mapkit.map

/**
 * The style properties of a model placemark.
 */
public data class ModelStyle(
    /**
     * Scale the model by this value.
     */
    val scale: Float = 1f,
    /**
     * Unit type of the model.
     */
    val unitType: UnitType = UnitType.UNIT,
    /**
     * Defines should it be rendered with buildings from ground layer.
     */
    val renderMode: RenderMode = RenderMode.USER_MODEL,
    /**
     * Name of variant to render model with.
     */
    val variantName: String? = null,
) {

    public enum class UnitType {

        /**
         * The model is given in units.
         */
        UNIT,

        NORMALIZED,

        /**
         * The model is given in meters.
         */
        METER,
    }

    public enum class RenderMode {

        /**
         * Model should be rendered with buildings from ground layer.
         */
        BUILDING,

        /**
         * Model should be rendered within separate sublayer.
         */
        USER_MODEL,
    }
}
