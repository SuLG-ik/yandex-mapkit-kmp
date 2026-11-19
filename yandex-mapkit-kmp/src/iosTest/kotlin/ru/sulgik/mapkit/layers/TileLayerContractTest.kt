package ru.sulgik.mapkit.layers

import ru.sulgik.mapkit.RawTile
import ru.sulgik.mapkit.TileId
import ru.sulgik.mapkit.Version
import ru.sulgik.mapkit.tiles.TileProvider
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import kotlin.io.encoding.Base64
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

public class TileLayerContractTest {

    @Test
    public fun local_provider_forwards_request_metadata_and_serves_all_tile_states() {
        val pixel = Base64.decode(
            "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR4nGP4z8DwHwAFAAH/iZk9HQAAAABJRU5ErkJggg==",
        )
        val tileId = TileId(x = 5, y = 9, z = 4)
        val version = Version("tile-version-007")
        val features = mapOf("layer" to "terrain", "variant" to "day")
        val nativeFeatures = features.mapKeys<String, String, Any?> { it.key }
        val requests = mutableListOf<String>()
        val provider = TileProvider { actualId, actualVersion, actualFeatures, etag ->
            assertEquals(tileId, actualId)
            assertEquals(version, actualVersion)
            assertEquals(features, actualFeatures)
            requests += etag
            when (etag) {
                "" -> RawTile(version, features, "local-pixel", RawTile.UseCache.YES, RawTile.State.OK, pixel)
                "local-pixel" -> RawTile(version, features, etag, RawTile.UseCache.YES, RawTile.State.NOT_MODIFIED, byteArrayOf())
                else -> RawTile(version, features, "", RawTile.UseCache.NO, RawTile.State.ERROR, byteArrayOf())
            }
        }
        val native = provider.toNative()
        assertSame(native, provider.toNative())

        val success = native.loadWithTileId(tileId.toNative(), version.toNative(), nativeFeatures, "").toCommon()
        val unchanged = native.loadWithTileId(tileId.toNative(), version.toNative(), nativeFeatures, "local-pixel").toCommon()
        val error = native.loadWithTileId(tileId.toNative(), version.toNative(), nativeFeatures, "missing-tile").toCommon()

        assertEquals(RawTile(version, features, "local-pixel", RawTile.UseCache.YES, RawTile.State.OK, pixel), success)
        assertEquals(
            RawTile(version, features, "local-pixel", RawTile.UseCache.YES, RawTile.State.NOT_MODIFIED, byteArrayOf()),
            unchanged,
        )
        assertEquals(RawTile(version, features, "", RawTile.UseCache.NO, RawTile.State.ERROR, byteArrayOf()), error)
        assertEquals(listOf("", "local-pixel", "missing-tile"), requests)
    }
}
