package ru.sulgik.mapkit.offline_cache

/**
 * The download state of an offline region.
 */
public enum class RegionState {

    /**
     * Available for download on the server.
     */
    AVAILABLE,

    /**
     * Download in progress.
     */
    DOWNLOADING,

    /**
     * Download is paused.
     */
    PAUSED,

    /**
     * Cache data installation is finished.
     */
    COMPLETED,

    /**
     * The region was completed but there is a newer version on the server.
     */
    OUTDATED,

    /**
     * The region was removed from regions list and will never be updated.
     */
    UNSUPPORTED,

    /**
     * The region is significantly outdated or it contains invalid data.
     */
    NEED_UPDATE,
}
