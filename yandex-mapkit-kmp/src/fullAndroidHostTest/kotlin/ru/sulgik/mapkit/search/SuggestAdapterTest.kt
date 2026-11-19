package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.LocalizedValue
import ru.sulgik.mapkit.SpannableString
import ru.sulgik.mapkit.geometry.BoundingBox
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.runtime.KeyValuePair
import ru.sulgik.mapkit.runtime.network.NetworkError
import ru.sulgik.mapkit.runtime.toNative
import ru.sulgik.mapkit.toNative
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertIs
import kotlin.test.assertSame
import kotlin.test.assertTrue
import com.yandex.mapkit.LocalizedValue as NativeLocalizedValue
import com.yandex.mapkit.SpannableString as NativeSpannableString
import com.yandex.mapkit.geometry.BoundingBox as NativeBoundingBox
import com.yandex.mapkit.geometry.Point as NativePoint
import com.yandex.mapkit.search.SuggestItem as NativeSuggestItem
import com.yandex.mapkit.search.SuggestOptions as NativeSuggestOptions
import com.yandex.mapkit.search.SuggestResponse as NativeSuggestResponse
import com.yandex.mapkit.search.SuggestSession as NativeSuggestSession
import com.yandex.mapkit.search.SuggestSession.SuggestListener as NativeSuggestListener
import com.yandex.mapkit.search.SuggestType as NativeSuggestType
import com.yandex.runtime.KeyValuePair as NativeKeyValuePair
import com.yandex.runtime.network.NetworkError as NativeNetworkError

public class SuggestAdapterTest {

    @Test
    public fun rapid_queries_replace_callbacks_and_preserve_bounds_and_options() {
        val transport = SuggestTransport()
        val session = transport.toCommon()
        val alias = session.toNative().toCommon()
        val options = SuggestOptions(
            suggestTypes = SuggestType.GEO.value or SuggestType.BIZ.value or SuggestType.COORDS.value,
            userPosition = Point(55.75, 37.62),
            suggestWords = true,
            strictBounds = true,
        )
        val replies = mutableListOf<SuggestResponse>()
        val listener = SuggestListener({ replies.add(it) }, { error("Unexpected error: ${it.error}") })

        assertSame(transport, session.toNative())
        assertEquals(session, alias)
        assertSame(listener.toNative(), listener.toNative())
        assertEquals(SuggestOptions(), SuggestOptions().toNative().toCommon())
        assertEquals(
            NativeSuggestType.values().associate { it.name to it.value },
            SuggestType.entries.associate { it.name to it.value },
        )

        session.suggest("A", bounds, options, listener)
        val first = transport.callbacks.single()
        transport.onSuggest = { first.onResponse(response("A").toHostNative()) }
        alias.suggest("AB", bounds, options, listener)
        val second = transport.callbacks.last()
        second.onResponse(response("AB").toHostNative())
        first.onResponse(response("A").toHostNative())
        second.onResponse(SuggestResponse(emptyList()).toHostNative())

        assertEquals(listOf("A", "AB"), transport.texts)
        assertEquals(bounds, transport.window)
        assertEquals(options, transport.options)
        assertEquals(listOf(response("AB")), replies)
    }

    @Test
    public fun reset_filters_synchronous_and_late_delivery_and_reopening_accepts_empty_results() {
        val transport = SuggestTransport()
        val session = transport.toCommon()
        val alias = session.toNative().toCommon()
        val replies = mutableListOf<SuggestResponse>()
        val failures = mutableListOf<SearchError>()
        val listener = SuggestListener({ replies.add(it) }, { failures.add(it) })
        val failure = object : NativeNetworkError {
            override fun isValid(): Boolean {
                return true
            }
        }

        session.suggest("clear this", bounds, SuggestOptions(), listener)
        val cleared = transport.callbacks.last()
        transport.onReset = { cleared.onError(failure) }
        alias.reset()
        cleared.onResponse(response("clear this").toHostNative())

        alias.suggest("close this", bounds, SuggestOptions(), listener)
        val closed = transport.callbacks.last()
        transport.onReset = { closed.onResponse(response("close this").toHostNative()) }
        session.reset()
        closed.onError(failure)

        val reopened = SuggestTransport()
        val next = reopened.toCommon()
        next.suggest("empty result", bounds, SuggestOptions(), listener)
        reopened.callbacks.last().onResponse(SuggestResponse(emptyList()).toHostNative())
        next.suggest("failed", bounds, SuggestOptions(), listener)
        val failed = reopened.callbacks.last()
        failed.onError(failure)
        failed.onResponse(response("failed").toHostNative())

        assertEquals(2, transport.resets)
        assertEquals(listOf(SuggestResponse(emptyList())), replies)
        assertSame(failure, failures.single().toNative())
        assertTrue(assertIs<NetworkError>(failures.single().error).isValid)
    }

    @Test
    public fun failed_native_submission_releases_callback_without_stopping_next_query() {
        val transport = SuggestTransport()
        val session = transport.toCommon()
        val replies = mutableListOf<SuggestResponse>()
        val listener = SuggestListener({ replies.add(it) }, { error("Unexpected error: ${it.error}") })
        transport.onSuggest = { error("Injected request failure") }

        assertFailsWith<IllegalStateException> {
            session.suggest("A", bounds, SuggestOptions(), listener)
        }
        transport.callbacks.single().onResponse(response("A").toHostNative())
        transport.onSuggest = {}
        session.suggest("AB", bounds, SuggestOptions(), listener)
        transport.callbacks.last().onResponse(response("AB").toHostNative())

        assertEquals(listOf(response("AB")), replies)
    }
}

private val bounds = BoundingBox(Point(55.7, 37.5), Point(55.8, 37.7))

private class SuggestTransport : NativeSuggestSession {

    val callbacks = mutableListOf<NativeSuggestListener>()
    val texts = mutableListOf<String>()
    var window: BoundingBox? = null
        private set
    var options: SuggestOptions? = null
        private set
    var resets: Int = 0
        private set
    var onSuggest: () -> Unit = {}
    var onReset: () -> Unit = {}

    override fun suggest(
        text: String,
        window: NativeBoundingBox,
        suggestOptions: NativeSuggestOptions,
        suggestListener: NativeSuggestListener,
    ) {
        texts.add(text)
        this.window = window.toCommon()
        options = suggestOptions.toCommon()
        callbacks.add(suggestListener)
        onSuggest()
    }

    override fun reset() {
        resets++
        onReset()
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

private fun SuggestResponse.toHostNative(): NativeSuggestResponse {
    val fixture = items.map(::HostSuggestItem)
    return object : NativeSuggestResponse() {
        override fun getItems(): List<NativeSuggestItem> {
            return fixture
        }
    }
}

private class HostSuggestItem(private val fixture: SuggestItem) : NativeSuggestItem() {

    override fun getType(): NativeSuggestItem.Type {
        return fixture.type.toNative()
    }

    override fun getTitle(): NativeSpannableString {
        return fixture.title.toHostNative()
    }

    override fun getSubtitle(): NativeSpannableString? {
        return fixture.subtitle?.toHostNative()
    }

    override fun getTags(): List<String> {
        return fixture.tags
    }

    override fun getSearchText(): String {
        return fixture.searchText
    }

    override fun getDisplayText(): String? {
        return fixture.displayText
    }

    override fun getUri(): String? {
        return fixture.uri
    }

    override fun getLink(): String? {
        return fixture.link
    }

    override fun getDistance(): NativeLocalizedValue? {
        return fixture.distance?.toNative()
    }

    override fun getIsPersonal(): Boolean {
        return fixture.isPersonal
    }

    override fun getAction(): NativeSuggestItem.Action {
        return fixture.action.toNative()
    }

    override fun getLogId(): String? {
        return fixture.logId
    }

    override fun getIsOffline(): Boolean {
        return fixture.isOffline
    }

    override fun getIsWordItem(): Boolean {
        return fixture.isWordItem
    }

    override fun getProperties(): List<NativeKeyValuePair> {
        return fixture.properties.map { it.toNative() }
    }

    override fun getCenter(): NativePoint? {
        return fixture.center?.toNative()
    }

    override fun getBusinessContext(): NativeSuggestItem.BusinessContext? {
        return fixture.businessContext?.toNative()
    }
}

private fun SpannableString.toHostNative(): NativeSpannableString {
    val fixture = this
    return object : NativeSpannableString() {
        override fun getText(): String {
            return fixture.text
        }

        override fun getSpans(): List<NativeSpannableString.Span> {
            return fixture.spans.map { it.toNative() }
        }
    }
}
