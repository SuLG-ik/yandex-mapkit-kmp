package ru.sulgik.mapkit

import ru.sulgik.mapkit.runtime.Error
import ru.sulgik.mapkit.runtime.LocalError
import ru.sulgik.mapkit.runtime.toCommon
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import com.yandex.runtime.LocalError as NativeLocalError

public class HandleIdentityTest {

    @Test
    public fun `two handles around the same native object are equal and share a hash code`() {
        val native = ValidLocalError()

        val first = native.toCommon()
        val second = native.toCommon()

        assertEquals(first, second)
        assertEquals(first.hashCode(), second.hashCode())
    }

    @Test
    public fun `handles around different native objects are not equal`() {
        assertNotEquals(ValidLocalError().toCommon(), ValidLocalError().toCommon())
    }

    @Test
    public fun `a base wrapper and a subtype wrapper around the same native object are not equal`() {
        val native = ValidLocalError()

        val base = Error(native)
        val subtype: LocalError = native.toCommon()

        assertNotEquals<Error>(base, subtype)
        assertNotEquals<Error>(subtype, base)
    }

    @Test
    public fun `equality of an invalid handle does not call into the native object`() {
        val native = ThrowingLocalError()

        val first = native.toCommon()
        val second = native.toCommon()

        assertEquals(first, second)
        assertEquals(first.hashCode(), second.hashCode())
    }
}

private class ValidLocalError : NativeLocalError {

    override fun isValid(): Boolean {
        return true
    }
}

private class ThrowingLocalError : NativeLocalError {

    override fun isValid(): Boolean {
        throw IllegalStateException("Any method called on an invalid object throws")
    }
}
