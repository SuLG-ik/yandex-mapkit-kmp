package ru.sulgik.mapkit

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import com.yandex.mapkit.Attribution as NativeAttribution
import com.yandex.mapkit.Image as NativeImage
import com.yandex.mapkit.RawTile as NativeRawTile
import com.yandex.mapkit.SpannableString as NativeSpannableString
import com.yandex.mapkit.UserData as NativeUserData
import com.yandex.mapkit.Version as NativeVersion

public class NativeBackedConverterTest {

    @BeforeTest
    public fun setUp() {
        MapKitRuntime.ensureLoaded()
    }

    @Test
    public fun raw_tile_keeps_every_field_in_its_own_native_field() {
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
        assertEquals(mapOf("a" to "1", "b" to "2"), native.features)
        assertEquals("etag", native.etag)
        assertEquals(NativeRawTile.UseCache.NO, native.useCache)
        assertEquals(NativeRawTile.State.NOT_MODIFIED, native.state)
        assertContentEquals(byteArrayOf(1, 2, 3), native.rawData)

        assertEquals(tile, native.toCommon())
    }

    @Test
    public fun raw_tile_reads_every_field_back_from_its_own_native_field() {
        val common = NativeRawTile(
            NativeVersion("7"),
            mapOf("k" to "v"),
            "tag",
            NativeRawTile.UseCache.YES,
            NativeRawTile.State.ERROR,
            byteArrayOf(9),
        ).toCommon()

        assertEquals(Version("7"), common.version)
        assertEquals(mapOf("k" to "v"), common.features)
        assertEquals("tag", common.etag)
        assertEquals(RawTile.UseCache.YES, common.useCache)
        assertEquals(RawTile.State.ERROR, common.state)
        assertContentEquals(byteArrayOf(9), common.rawData)
    }

    @Test
    public fun spannable_string_keeps_the_text_and_the_span_bounds_apart() {
        val string = SpannableString(
            text = "hello world",
            spans = listOf(SpannableString.Span(begin = 0, end = 5), SpannableString.Span(begin = 6, end = 11)),
        )

        val native = string.toNative()

        assertEquals("hello world", native.text)
        assertEquals(2, native.spans.size)
        assertEquals(0, native.spans[0].begin)
        assertEquals(5, native.spans[0].end)
        assertEquals(6, native.spans[1].begin)
        assertEquals(11, native.spans[1].end)

        assertEquals(string, native.toCommon())
    }

    @Test
    public fun spannable_string_span_keeps_begin_apart_from_end() {
        val common = NativeSpannableString.Span(3, 8).toCommon()

        assertEquals(3, common.begin)
        assertEquals(8, common.end)
    }

    @Test
    public fun image_keeps_the_url_template_the_sizes_and_the_tags_apart() {
        val image = Image(
            urlTemplate = "https://example.com/%s",
            sizes = listOf(Image.ImageSize(size = "M", width = 64, height = 128)),
            tags = listOf("logo", "avatar"),
        )

        val native = image.toNative()

        assertEquals("https://example.com/%s", native.urlTemplate)
        assertEquals(1, native.sizes.size)
        assertEquals("M", native.sizes[0].size)
        assertEquals(64, native.sizes[0].width)
        assertEquals(128, native.sizes[0].height)
        assertEquals(listOf("logo", "avatar"), native.tags)

        assertEquals(image, native.toCommon())
    }

    @Test
    public fun image_size_keeps_a_missing_width_and_height_null() {
        val common = NativeImage.ImageSize("S", null, null).toCommon()

        assertEquals("S", common.size)
        assertEquals(null, common.width)
        assertEquals(null, common.height)
    }

    @Test
    public fun user_data_carries_the_dictionary() {
        val native = UserData(mapOf("id" to "1", "name" to "test")).toNative()

        assertEquals(mapOf("id" to "1", "name" to "test"), native.data)
        assertEquals(UserData(mapOf("id" to "1", "name" to "test")), native.toCommon())
    }

    @Test
    public fun attribution_keeps_the_author_the_link_and_the_avatar_apart() {
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
    public fun attribution_keeps_the_optional_fields_null() {
        val common = NativeAttribution(null, null, null).toCommon()

        assertEquals(null, common.author)
        assertEquals(null, common.link)
        assertEquals(null, common.avatarImage)
    }

    @Test
    public fun attribution_author_keeps_a_missing_uri_and_email_null() {
        val common = NativeAttribution.Author("name", null, null).toCommon()

        assertEquals("name", common.name)
        assertEquals(null, common.uri)
        assertEquals(null, common.email)
    }

    @Test
    public fun user_data_reads_the_dictionary_back() {
        val common = NativeUserData(mapOf("a" to "b")).toCommon()

        assertEquals(mapOf("a" to "b"), common.data)
    }
}
