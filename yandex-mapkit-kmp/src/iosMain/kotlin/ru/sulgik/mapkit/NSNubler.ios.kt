package ru.sulgik.mapkit

import platform.Foundation.NSNumber
import platform.Foundation.numberWithBool
import platform.Foundation.numberWithDouble
import platform.Foundation.numberWithFloat
import platform.Foundation.numberWithInt
import platform.Foundation.numberWithLong

internal fun Int.toNSNumber(): NSNumber {
    return NSNumber.numberWithInt(this)
}

internal fun Long.toNSNumber(): NSNumber {
    return NSNumber.numberWithLong(this)
}

internal fun Boolean.toNSNumber(): NSNumber {
    return NSNumber.numberWithBool(this)
}

internal fun Float.toNSNumber(): NSNumber {
    return NSNumber.numberWithFloat(this)
}

internal fun Double.toNSNumber(): NSNumber {
    return NSNumber.numberWithDouble(this)
}