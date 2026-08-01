package ru.sulgik.mapkit

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import YandexMapKit.YMKAttribution as NativeAttribution
import YandexMapKit.YMKAttributionAuthor as NativeAuthor
import YandexMapKit.YMKAttributionLink as NativeLink
import YandexMapKit.YMKImageSize as NativeImageSize
import YandexMapKit.YMKRawTile as NativeRawTile
import YandexMapKit.YMKRawTileState as NativeState
import YandexMapKit.YMKRawTileUseCache as NativeUseCache
import YandexMapKit.YMKSpannableStringSpan as NativeSpan
import YandexMapKit.YMKUserData as NativeUserData
import YandexMapKit.YMKVersion as NativeVersion

public class NativeBackedConverterTest {

    @Test
    public fun `raw tile keeps every field in its own native field`() {
        val tile = RawTile(
            version = Version("42"),
            features = mapOf("a" to "1", "b" to "2"),
            etag = "etag",
            useCache = RawTile.UseCache.NO,
            state = RawTile.State.NOT_MODIFIED,
            rawData = byteArrayOf(1, 2, 3),
        )

        val native = tile.toNative()

        assertEquals("42", native.version.str)
        assertEquals<Map<*, *>>(mapOf("a" to "1", "b" to "2"), native.features)
        assertEquals("etag", native.etag)
        assertEquals(NativeUseCache.YMKRawTileUseCacheNo, native.useCache)
        assertEquals(NativeState.YMKRawTileStateNotModified, native.state)
        assertContentEquals(byteArrayOf(1, 2, 3), native.rawData.toByteArray())

        assertEquals(tile, native.toCommon())
    }

    @Test
    public fun `raw tile reads every field back from its own native field`() {
        val common = NativeRawTile.rawTileWithVersion(
            version = NativeVersion.versionWithStr("7"),
            features = mapOf("k" to "v"),
            etag = "tag",
            useCache = NativeUseCache.YMKRawTileUseCacheYes,
            state = NativeState.YMKRawTileStateError,
            rawData = byteArrayOf(9).toNSData(),
        ).toCommon()

        assertEquals(Version("7"), common.version)
        assertEquals(mapOf("k" to "v"), common.features)
        assertEquals("tag", common.etag)
        assertEquals(RawTile.UseCache.YES, common.useCache)
        assertEquals(RawTile.State.ERROR, common.state)
        assertContentEquals(byteArrayOf(9), common.rawData)
    }

    @Test
    public fun `spannable string keeps the text and the span bounds apart`() {
        val string = SpannableString(
            text = "hello world",
            spans = listOf(SpannableString.Span(begin = 0, end = 5), SpannableString.Span(begin = 6, end = 11)),
        )

        val native = string.toNative()

        @Suppress("UNCHECKED_CAST")
        val spans = native.spans as List<NativeSpan>

        assertEquals("hello world", native.text)
        assertEquals(2, spans.size)
        assertEquals(0L, spans[0].begin)
        assertEquals(5L, spans[0].end)
        assertEquals(6L, spans[1].begin)
        assertEquals(11L, spans[1].end)

        assertEquals(string, native.toCommon())
    }

    @Test
    public fun `spannable string span keeps begin apart from end`() {
        val common = NativeSpan.spanWithBegin(3L, 8L).toCommon()

        assertEquals(3, common.begin)
        assertEquals(8, common.end)
    }

    @Test
    public fun `image keeps the url template the sizes and the tags apart`() {
        val image = Image(
            urlTemplate = "https://example.com/%s",
            sizes = listOf(Image.ImageSize(size = "M", width = 64, height = 128)),
            tags = listOf("logo", "avatar"),
        )

        val native = image.toNative()

        @Suppress("UNCHECKED_CAST")
        val sizes = native.sizes as List<NativeImageSize>

        assertEquals("https://example.com/%s", native.urlTemplate)
        assertEquals(1, sizes.size)
        assertEquals("M", sizes[0].size)
        assertEquals(64, sizes[0].width?.intValue)
        assertEquals(128, sizes[0].height?.intValue)
        assertEquals(listOf("logo", "avatar"), native.tags)

        assertEquals(image, native.toCommon())
    }

    @Test
    public fun `image size keeps a missing width and height null`() {
        val common = NativeImageSize.sizeWithSize("S", null, null).toCommon()

        assertEquals("S", common.size)
        assertEquals(null, common.width)
        assertEquals(null, common.height)
    }

    @Test
    public fun `user data carries the dictionary`() {
        val native = UserData(mapOf("id" to "1", "name" to "test")).toNative()

        assertEquals<Map<*, *>>(mapOf("id" to "1", "name" to "test"), native.data)
        assertEquals(UserData(mapOf("id" to "1", "name" to "test")), native.toCommon())
    }

    @Test
    public fun `attribution keeps the author the link and the avatar apart`() {
        val attribution = Attribution(
            author = Attribution.Author(name = "author", uri = "https://author", email = "a@b.c"),
            link = Attribution.Link(href = "https://link"),
            avatarImage = Image("https://avatar", emptyList(), emptyList()),
        )

        val native = attribution.toNative()

        assertEquals("author", native.author?.name)
        assertEquals("https://author", native.author?.uri)
        assertEquals("a@b.c", native.author?.email)
        assertEquals("https://link", native.link?.href)
        assertEquals("https://avatar", native.avatarImage?.urlTemplate)

        assertEquals(attribution, native.toCommon())
    }

    @Test
    public fun `attribution keeps the optional fields null`() {
        val common = NativeAttribution.attributionWithAuthor(null, null, null).toCommon()

        assertEquals(null, common.author)
        assertEquals(null, common.link)
        assertEquals(null, common.avatarImage)
    }

    @Test
    public fun `attribution author keeps a missing uri and email null`() {
        val common = NativeAuthor.authorWithName("name", null, null).toCommon()

        assertEquals("name", common.name)
        assertEquals(null, common.uri)
        assertEquals(null, common.email)
    }

    @Test
    public fun `attribution link carries the href`() {
        assertEquals("https://link", NativeLink.linkWithHref("https://link").toCommon().href)
        assertEquals("https://link", Attribution.Link("https://link").toNative().href)
    }

    @Test
    public fun `user data reads the dictionary back`() {
        val common = NativeUserData.userDataWithData(mapOf("a" to "b")).toCommon()

        assertEquals(mapOf("a" to "b"), common.data)
    }
}
