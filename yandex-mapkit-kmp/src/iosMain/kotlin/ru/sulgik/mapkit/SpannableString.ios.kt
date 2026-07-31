package ru.sulgik.mapkit

import YandexMapKit.YMKSpannableString as NativeSpannableString
import YandexMapKit.YMKSpannableStringSpan as NativeSpan

public fun SpannableString.toNative(): NativeSpannableString {
    return NativeSpannableString.spannableStringWithText(
        text = text,
        spans = spans.map { it.toNative() },
    )
}

@Suppress("UNCHECKED_CAST")
public fun NativeSpannableString.toCommon(): SpannableString {
    return SpannableString(
        text = text,
        spans = (spans as List<NativeSpan>).map { it.toCommon() },
    )
}

public fun SpannableString.Span.toNative(): NativeSpan {
    return NativeSpan.spanWithBegin(begin = begin.toLong(), end = end.toLong())
}

public fun NativeSpan.toCommon(): SpannableString.Span {
    return SpannableString.Span(begin = begin.toInt(), end = end.toInt())
}
