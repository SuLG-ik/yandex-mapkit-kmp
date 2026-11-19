package ru.sulgik.mapkit.search

import platform.Foundation.NSError
import platform.Foundation.NSLocalizedDescriptionKey
import ru.sulgik.mapkit.geometry.Geometry
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toNative
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertSame
import kotlin.test.assertTrue
import YandexMapKit.YMKBaseMetadataProtocol as NativeBaseMetadata
import YandexMapKit.YMKGeoObject as NativeGeoObject
import YandexMapKit.YMKGeoObjectCollection as NativeCollection
import YandexMapKit.YMKGeoObjectCollectionItem as NativeCollectionItem
import YandexMapKit.YMKSearchDisplayType as NativeDisplayType
import YandexMapKit.YMKSearchMetadata as NativeMetadata
import YandexMapKit.YMKSearchResponse as NativeResponse
import YandexMapKit.YRTTypeDictionary as NativeTypeDictionary

public class SearchAdapterTest {

    @Test
    public fun options_preserve_optional_fields_and_combined_type_bits() {
        val options = SearchOptions(
            searchTypes = SearchType.BIZ.value or SearchType.GEO.value,
            resultPageSize = 4,
            snippets = 2,
            userPosition = Point(55.75, 37.62),
            origin = "search-test",
            geometry = true,
            disableSpellingCorrection = true,
        )
        assertEquals(options, options.toNative().toCommon())
        assertEquals(SearchOptions(), SearchOptions().toNative().toCommon())
    }

    @Test
    public fun native_response_handler_preserves_names_coordinates_and_empty_results() {
        val position = Point(55.75, 37.62)
        val native = response(position)
        val replies = mutableListOf<Response>()
        val listener = SearchListener({ replies.add(it) }, { error("Unexpected error: ${it.description}") })
        val request = SearchRequest(listener).toNative()
        request(native, null)
        request(response(), null)

        val reply = replies.single()
        val obj = checkNotNull(reply.collection.children.single().obj)
        assertSame(native, reply.toNative())
        assertEquals("Library", obj.name)
        assertEquals(position, obj.geometry.single().point)
        assertTrue(reply.isOffline)
        SearchRequest(listener).toNative()(response(), null)
        assertTrue(replies.last().collection.children.isEmpty())
    }

    @Test
    public fun native_error_and_disposal_do_not_deliver_results() {
        val nativeError = NSError(
            domain = "SearchTest",
            code = 42,
            userInfo = mapOf(NSLocalizedDescriptionKey to "Network unavailable"),
        )
        val failures = mutableListOf<SearchError>()
        val replies = mutableListOf<Response>()
        val listener = SearchListener({ replies.add(it) }, { failures.add(it) })
        val request = SearchRequest(listener).toNative()
        request(null, nativeError)
        request(response(), null)

        val failure = failures.single()
        assertSame(nativeError, failure.toNative())
        assertEquals("Network unavailable", failure.description)
        assertNull(failure.error)
        assertTrue(replies.isEmpty())

        val obsolete = SearchRequest(listener)
        val obsoleteCallback = obsolete.toNative()
        obsolete.dispose()
        obsoleteCallback(response(), null)
        obsoleteCallback(null, nativeError)
        assertEquals(1, failures.size)
        assertTrue(replies.isEmpty())
    }

    private fun response(position: Point? = null): NativeResponse {
        val dictionary = NativeTypeDictionary(values = emptyList<NativeBaseMetadata>())
        val children = if (position == null) {
            emptyList()
        } else {
            val obj = NativeGeoObject.geoObjectWithName(
                name = "Library",
                descriptionText = null,
                geometry = listOf(Geometry(point = position).toNative()),
                boundingBox = null,
                attributionMap = emptyMap<Any?, Any?>(),
                metadataContainer = dictionary,
                aref = emptyList<String>(),
            )
            listOf(NativeCollectionItem.itemWithObj(obj))
        }
        return NativeResponse.responseWithMetadata(
            metadata = NativeMetadata.searchMetadataWithFound(
                found = children.size.toLong(),
                displayType = NativeDisplayType.YMKSearchDisplayTypeMultiple,
                boundingBox = null,
                sort = null,
                toponym = null,
                toponymResultMetadata = null,
                businessResultMetadata = null,
                reqid = "",
                context = "",
                requestText = "Library",
                correctedRequestText = null,
                requestBoundingBox = null,
            ),
            collection = NativeCollection.geoObjectCollectionWithBoundingBox(null, dictionary, children),
            isOffline = true,
        )
    }
}
