package ru.sulgik.mapkit.layers

public enum class OverzoomMode {

    /**
     * Overzoom is fully disabled.
     */
    DISABLED,

    /**
     * If a tile is absent or translucent, tiles from lower or higher zooms will be shown.
     */
    ENABLED,

    /**
     * Same as [ENABLED], plus it fetches tiles well below absent or translucent tiles that don't have any overzoom tiles to replace them with.
     */
    WITH_PREFETCH,
}
