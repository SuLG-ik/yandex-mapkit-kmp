package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.geometry.Geometry
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.runtime.network.NetworkError
import java.lang.reflect.Proxy
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertSame
import kotlin.test.assertTrue
import com.yandex.mapkit.GeoObject as NativeGeoObject
import com.yandex.mapkit.GeoObjectCollection as NativeCollection
import com.yandex.mapkit.geometry.Geometry as NativeGeometry
import com.yandex.mapkit.search.Response as NativeResponse
import com.yandex.mapkit.search.SearchManager as NativeSearchManager
import com.yandex.mapkit.search.SearchOptions as NativeSearchOptions
import com.yandex.mapkit.search.Session as NativeSession
import com.yandex.mapkit.search.Session.SearchListener as NativeSearchListener
import com.yandex.runtime.network.NetworkError as NativeNetworkError

public class SearchAdapterTest {

    @Test
    public fun submit_forwards_geometry_and_options_and_delivers_named_coordinates_once() {
        val transport = SearchTransport()
        val position = Point(55.75, 37.62)
        val geometry = Geometry(point = position)
        val options = SearchOptions(
            searchTypes = SearchType.BIZ.value or SearchType.GEO.value,
            resultPageSize = 4,
            snippets = 2,
            userPosition = position,
            origin = "search-test",
            geometry = true,
            disableSpellingCorrection = true,
        )
        val replies = mutableListOf<Response>()
        val listener = SearchListener({ replies.add(it) }, { error("Unexpected error: ${it.error}") })
        val session = transport.manager.toCommon().submit("Library", geometry, options, listener)

        assertEquals("Library", transport.text)
        assertEquals(geometry, transport.geometry)
        assertEquals(options, transport.options)
        assertSame(transport.session, session.toNative())

        val nativeResponse = response(position)
        transport.listener.onSearchResponse(nativeResponse)
        transport.listener.onSearchResponse(response())
        val reply = replies.single()
        assertSame(nativeResponse, reply.toNative())
        val obj = checkNotNull(reply.collection.children.single().obj)
        assertEquals("Library", obj.name)
        assertEquals(position, obj.geometry.single().point)
        assertTrue(reply.isOffline)
    }

    @Test
    public fun empty_success_and_native_failure_are_distinct() {
        val transport = SearchTransport()
        val positions = Geometry(point = Point(55.75, 37.62))
        val replies = mutableListOf<Response>()
        val failures = mutableListOf<SearchError>()
        val listener = SearchListener({ replies.add(it) }, { failures.add(it) })
        assertSame(listener.toNative(), listener.toNative())

        transport.manager.toCommon().submit("empty", positions, SearchOptions(), listener)
        transport.listener.onSearchResponse(response())
        assertTrue(replies.single().collection.children.isEmpty())
        assertTrue(failures.isEmpty())

        transport.manager.toCommon().submit("failure", positions, SearchOptions(), listener)
        val networkFailure = object : NativeNetworkError {
            override fun isValid(): Boolean {
                return true
            }
        }
        transport.listener.onSearchError(networkFailure)
        transport.listener.onSearchResponse(response())
        assertSame(networkFailure, failures.single().toNative())
        assertTrue(assertIs<NetworkError>(failures.single().error).isValid)
        assertEquals(1, replies.size)
    }

    @Test
    public fun cancelling_a_round_tripped_session_filters_inline_and_late_callbacks() {
        val transport = SearchTransport()
        val geometry = Geometry(point = Point(55.75, 37.62))
        var deliveries = 0
        val listener = SearchListener({ deliveries++ }, { deliveries++ })
        val session = transport.manager.toCommon().submit("old", geometry, SearchOptions(), listener)
        val alias = session.toNative().toCommon()
        val obsoleteCallback = transport.listener

        transport.onCancel = { obsoleteCallback.onSearchResponse(response()) }
        alias.cancel()
        obsoleteCallback.onSearchResponse(response())
        assertEquals(1, transport.cancellations)
        assertEquals(0, deliveries)

        transport.manager.toCommon().submit("new", geometry, SearchOptions(), listener)
        transport.listener.onSearchResponse(response())
        assertEquals(1, deliveries)
    }

    private fun response(position: Point? = null): NativeResponse {
        val children = if (position == null) {
            emptyList()
        } else {
            val obj = object : NativeGeoObject() {
                override fun getName(): String {
                    return "Library"
                }

                override fun getGeometry(): List<NativeGeometry> {
                    return listOf(Geometry(point = position).toNative())
                }
            }
            listOf(NativeCollection.Item.fromObj(obj))
        }
        val collection = object : NativeCollection() {
            override fun getChildren(): List<NativeCollection.Item> {
                return children
            }
        }
        return object : NativeResponse() {
            override fun getCollection(): NativeCollection {
                return collection
            }

            override fun getIsOffline(): Boolean {
                return true
            }
        }
    }
}

private class SearchTransport {

    lateinit var listener: NativeSearchListener
    lateinit var text: String
    lateinit var geometry: Geometry
    lateinit var options: SearchOptions
    var cancellations: Int = 0
        private set
    var onCancel: () -> Unit = {}

    val session: NativeSession = proxy(NativeSession::class.java) { method, _ ->
        check(method == "cancel")
        cancellations++
        onCancel()
        null
    }

    val manager: NativeSearchManager = proxy(NativeSearchManager::class.java) { method, args ->
        check(method == "submit")
        text = args[0] as String
        geometry = (args[1] as NativeGeometry).toCommon()
        options = (args[2] as NativeSearchOptions).toCommon()
        listener = args[3] as NativeSearchListener
        session
    }

    private fun <T : Any> proxy(
        type: Class<T>,
        onInvoke: (method: String, args: Array<out Any?>) -> Any?,
    ): T {
        return type.cast(
            Proxy.newProxyInstance(type.classLoader, arrayOf(type)) { proxy, method, args ->
                when (method.name) {
                    "equals" -> proxy === args?.single()
                    "hashCode" -> System.identityHashCode(proxy)
                    else -> onInvoke(method.name, args.orEmpty())
                }
            },
        )
    }
}
