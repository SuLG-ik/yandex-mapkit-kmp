package ru.sulgik.mapkit

import platform.Foundation.NSNumber
import platform.Foundation.numberWithBool
import platform.Foundation.numberWithDouble
import platform.Foundation.numberWithFloat
import platform.Foundation.numberWithInt
import platform.Foundation.numberWithLong

fun Int.toNSNumber(): NSNumber {
    return NSNumber.numberWithInt(this)
}

fun Long.toNSNumber(): NSNumber {
    return NSNumber.numberWithLong(this)
}

fun Boolean.toNSNumber(): NSNumber {
    return NSNumber.numberWithBool(this)
}

fun Float.toNSNumber(): NSNumber {
    return NSNumber.numberWithFloat(this)
}

fun Double.toNSNumber(): NSNumber {
    return NSNumber.numberWithDouble(this)
}