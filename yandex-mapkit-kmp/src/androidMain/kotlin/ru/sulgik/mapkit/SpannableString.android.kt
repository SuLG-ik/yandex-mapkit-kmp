package ru.sulgik.mapkit

import com.yandex.mapkit.SpannableString as NativeSpannableString

public fun SpannableString.toNative(): NativeSpannableString {
    return NativeSpannableString(text, spans.map { it.toNative() })
}

public fun NativeSpannableString.toCommon(): SpannableString {
    return SpannableString(text = text, spans = spans.map { it.toCommon() })
}

public fun SpannableString.Span.toNative(): NativeSpannableString.Span {
    return NativeSpannableString.Span(begin, end)
}

public fun NativeSpannableString.Span.toCommon(): SpannableString.Span {
    return SpannableString.Span(begin = begin, end = end)
}
