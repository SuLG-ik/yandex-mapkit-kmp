@file:OptIn(ExperimentalForeignApi::class)

package ru.sulgik.mapkit

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.convert
import kotlinx.cinterop.usePinned
import platform.Foundation.NSData
import platform.Foundation.create
import platform.posix.memcpy

internal fun ByteArray.toNSData(): NSData {
    if (isEmpty()) {
        return NSData()
    }
    return usePinned {
        NSData.create(bytes = it.addressOf(0), length = size.convert())
    }
}

internal fun NSData.toByteArray(): ByteArray {
    val size = length.toInt()
    val result = ByteArray(size)
    if (size == 0) {
        return result
    }
    result.usePinned {
        memcpy(it.addressOf(0), bytes, length)
    }
    return result
}
