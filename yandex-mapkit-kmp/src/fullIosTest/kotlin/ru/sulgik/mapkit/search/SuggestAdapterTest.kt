package ru.sulgik.mapkit.search

import platform.Foundation.NSError
import ru.sulgik.mapkit.LiveMap
import ru.sulgik.mapkit.LocalizedValue
import ru.sulgik.mapkit.SpannableString
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.runtime.KeyValuePair
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertSame
import kotlin.test.assertTrue
import YandexMapKit.YMKSuggestResponse as NativeSuggestResponse

public class SuggestAdapterTest {

    @Test
    public fun native_structs_preserve_mask_order_optional_values_and_highlight_spans() {
        val options = SuggestOptions(
            suggestTypes = SuggestType.GEO.value or SuggestType.BIZ.value or SuggestType.COORDS.value,
            userPosition = Point(55.75, 37.62),
            suggestWords = true,
            strictBounds = true,
        )
        assertEquals(options, options.toNative().toCommon())
        assertEquals(SuggestOptions(), SuggestOptions().toNative().toCommon())

        val item = response("AB").items.single()
        val sparseItem = item.copy(
            type = SuggestItem.Type.TOPONYM,
            subtitle = null,
            displayText = null,
            uri = null,
            link = null,
            distance = null,
            logId = null,
            center = null,
            businessContext = null,
            properties = emptyList(),
            action = SuggestItem.Action.SUBSTITUTE,
        )
        val results = SuggestResponse(listOf(item, sparseItem))
        assertEquals(results, results.toNative().toCommon())
    }

    @Test
    public fun native_handlers_drop_older_and_reset_callbacks_and_report_failure_once() {
        val requests = SuggestRequests()
        val replies = mutableListOf<SuggestResponse>()
        val failures = mutableListOf<SearchError>()
        val listener = SuggestListener({ replies.add(it) }, { failures.add(it) })
        val callbacks = mutableListOf<(NativeSuggestResponse?, NSError?) -> Unit>()
        val error = NSError(
            domain = "SuggestTest",
            code = 42,
            userInfo = null,
        )
        assertSame(listener.toNative(), listener.toNative())

        requests.submit(listener) { callbacks.add(it.toNative()) }
        requests.submit(listener) {
            callbacks.single()(response("A").toNative(), null)
            callbacks.add(it.toNative())
        }
        callbacks[1](response("AB").toNative(), null)
        callbacks[0](null, error)

        requests.submit(listener) { callbacks.add(it.toNative()) }
        requests.dispose()
        callbacks.last()(response("cleared").toNative(), null)

        requests.submit(listener) { callbacks.add(it.toNative()) }
        requests.dispose()
        callbacks.last()(null, error)

        val reopened = SuggestRequests()
        reopened.submit(listener) { callbacks.add(it.toNative()) }
        callbacks.last()(SuggestResponse(emptyList()).toNative(), null)
        reopened.submit(listener) { callbacks.add(it.toNative()) }
        callbacks.last()(null, error)
        callbacks.last()(response("after-failure").toNative(), null)

        assertEquals(2, replies.size)
        assertEquals(response("AB"), replies.first())
        assertTrue(replies.last().items.isEmpty())
        assertSame(error, failures.single().toNative())
        assertEquals(error.localizedDescription, failures.single().description)
        assertNull(failures.single().error)
    }

    @Test
    public fun resetting_a_native_session_alias_discards_the_original_pending_listener() {
        LiveMap.onMap {
            val manager = Search.getInstance().createSearchManager(SearchManagerType.ONLINE)
            val session = manager.createSuggestSession()
            val native = session.toNative()
            val alias = native.toCommon()
            val requests = native.requestState()
            val callbacks = mutableListOf<(NativeSuggestResponse?, NSError?) -> Unit>()
            val replies = mutableListOf<SuggestResponse>()
            val listener = SuggestListener({ replies.add(it) }, { error("Unexpected suggest error") })

            assertEquals(session, alias)
            requests.submit(listener) { callbacks.add(it.toNative()) }
            alias.reset()
            callbacks.single()(response("before alias reset").toNative(), null)
            assertTrue(replies.isEmpty())

            native.requestState().submit(listener) { callbacks.add(it.toNative()) }
            callbacks.last()(response("after alias reset").toNative(), null)
            assertEquals(listOf(response("after alias reset")), replies)
        }
    }
}

private fun response(text: String): SuggestResponse {
    return SuggestResponse(
        listOf(
            SuggestItem(
                type = SuggestItem.Type.BUSINESS,
                title = SpannableString(text, listOf(SpannableString.Span(0, 1))),
                subtitle = SpannableString("Main Street", emptyList()),
                tags = listOf("library", "local"),
                searchText = text,
                displayText = "A library",
                uri = "ymapsbm1://org",
                link = "https://example.com",
                distance = LocalizedValue(125.0, "125 m"),
                isPersonal = true,
                action = SuggestItem.Action.SEARCH,
                logId = "local-fixture",
                isOffline = false,
                isWordItem = true,
                properties = listOf(KeyValuePair("key", "value"), KeyValuePair("key", "second")),
                center = Point(55.75, 37.62),
                businessContext = SuggestItem.BusinessContext.BUSINESS_CONTEXT_ORG1,
            ),
        ),
    )
}
