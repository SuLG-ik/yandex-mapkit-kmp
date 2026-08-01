package ru.sulgik.mapkit

/**
 * A tile as it came from a tile provider.
 */
public data class RawTile(
    val version: Version,
    val features: Map<String, String>,
    val etag: String,
    val useCache: UseCache,
    val state: State,
    val rawData: ByteArray,
) {

    public enum class UseCache {
        YES,
        NO,
    }

    public enum class State {

        /**
         * Tile is available.
         */
        OK,

        /**
         * Tile was not modified.
         */
        NOT_MODIFIED,

        /**
         * An error occurred when processing the tile.
         */
        ERROR,
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RawTile) return false
        return version == other.version &&
            features == other.features &&
            etag == other.etag &&
            useCache == other.useCache &&
            state == other.state &&
            rawData.contentEquals(other.rawData)
    }

    override fun hashCode(): Int {
        var result = version.hashCode()
        result = 31 * result + features.hashCode()
        result = 31 * result + etag.hashCode()
        result = 31 * result + useCache.hashCode()
        result = 31 * result + state.hashCode()
        result = 31 * result + rawData.contentHashCode()
        return result
    }
}
