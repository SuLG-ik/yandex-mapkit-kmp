package ru.sulgik.mapkit

/**
 * A string with marked out spans.
 */
public data class SpannableString(
    /**
     * The text of the spannable string.
     */
    val text: String,
    /**
     * The spans in stored text.
     */
    val spans: List<Span>,
) {

    public data class Span(
        /**
         * The index of the beginning symbol of the span.
         */
        val begin: Int,
        /**
         * The index of the ending symbol of the span.
         */
        val end: Int,
    )
}
