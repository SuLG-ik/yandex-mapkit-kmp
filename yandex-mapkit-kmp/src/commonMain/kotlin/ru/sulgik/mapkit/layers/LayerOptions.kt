package ru.sulgik.mapkit.layers

import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

/**
 * How a tile layer behaves on the map.
 */
public data class LayerOptions(
    /**
     * Inactive layers are not displayed on the map and do not request any tiles from the tile
     * provider.
     */
    val active: Boolean = true,
    /**
     * Indicates the availability of night mode for this layer. Default: true.
     */
    val nightModeAvailable: Boolean = true,
    /**
     * Determines whether tiles are cached on persistent storage or not.
     */
    val cacheable: Boolean = true,
    /**
     * Indicates whether layer activation/deactivation should be animated.
     */
    val animateOnActivation: Boolean = true,
    /**
     * Specifies duration of tile appearing animation. Can be set to zero to disable animation.
     * Default: 400 ms.
     */
    val tileAppearingAnimationDuration: Duration = 400.milliseconds,
    /**
     * Whether to render tiles from adjacent zoom levels in place of absent or translucent tiles.
     */
    val overzoomMode: OverzoomMode = OverzoomMode.DISABLED,
    /**
     * Set this flag if layer is transparent, that is parts of underlying layers can be seen
     * through it.
     */
    val transparent: Boolean = false,
    /**
     * Determines if layer supports versioning.
     */
    val versionSupport: Boolean = false,
)
