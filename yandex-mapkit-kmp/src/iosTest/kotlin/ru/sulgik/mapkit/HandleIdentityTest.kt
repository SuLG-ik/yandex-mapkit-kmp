package ru.sulgik.mapkit

import ru.sulgik.mapkit.geometry.LinearRing
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.geometry.Polyline
import ru.sulgik.mapkit.geometry.toCommon
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

public class HandleIdentityTest {

    private val points = listOf(Point(55.75, 37.61), Point(59.93, 30.31))

    @Test
    public fun `two handles around the same native object are equal and share a hash code`() {
        val native = Polyline(points).toNative()

        val first = native.toCommon()
        val second = native.toCommon()

        assertEquals(first, second)
        assertEquals(first.hashCode(), second.hashCode())
    }

    @Test
    public fun `handles around different native objects are not equal`() {
        assertNotEquals(Polyline(points), Polyline(points))
    }

    @Test
    public fun `handles of different types are not equal`() {
        val polyline: Any = Polyline(points)
        val ring: Any = LinearRing(points)

        assertNotEquals(polyline, ring)
        assertNotEquals(ring, polyline)
    }
}
