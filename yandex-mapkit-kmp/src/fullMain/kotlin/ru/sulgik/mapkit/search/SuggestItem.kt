package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.LocalizedValue
import ru.sulgik.mapkit.SpannableString
import ru.sulgik.mapkit.geometry.Point
import ru.sulgik.mapkit.runtime.KeyValuePair

/**
 * One item returned by MapKit Geosuggest.
 *
 * @property type Kind of suggested object.
 * @property title Short object name with highlighted spans.
 * @property subtitle Toponym hierarchy or business address, when supplied.
 * @property tags Additional type or category information.
 * @property searchText Text to search for.
 * @property displayText User-facing replacement for a technical [searchText].
 * @property uri Element URI, when applicable.
 * @property link Web or deep link, when applicable.
 * @property distance Formatted distance from the user's position, when supplied.
 * @property isPersonal Whether this suggestion respects personalization.
 * @property action What to do when the user selects the item.
 * @property logId Identifier for request logging, when supplied.
 * @property isOffline Whether the item came from offline search.
 * @property isWordItem Whether the item is a word suggestion.
 * @property properties Additional named values, in native order.
 * @property center Position of the object, when known.
 * @property businessContext Detailed business subtype, when supplied.
 */
public data class SuggestItem(
    val type: Type,
    val title: SpannableString,
    val subtitle: SpannableString?,
    val tags: List<String>,
    val searchText: String,
    val displayText: String?,
    val uri: String?,
    val link: String?,
    val distance: LocalizedValue?,
    val isPersonal: Boolean,
    val action: Action,
    val logId: String?,
    val isOffline: Boolean,
    val isWordItem: Boolean,
    val properties: List<KeyValuePair>,
    val center: Point?,
    val businessContext: BusinessContext?,
) {
    /** Kind of suggested object. */
    public enum class Type {
        UNKNOWN,
        TOPONYM,
        BUSINESS,
        TRANSIT,
        LINK,
    }

    /** Action to perform when the user selects an item. */
    public enum class Action {
        /** Search immediately for [SuggestItem.searchText]. */
        SEARCH,

        /** Replace the text of the current query for further editing. */
        SUBSTITUTE,

        /** Exit the suggest session and open [SuggestItem.link]. */
        FOLLOW_LINK,
    }

    /** Detailed subtype of [Type.BUSINESS]. */
    public enum class BusinessContext {
        BUSINESS_CONTEXT_UNKNOWN,
        BUSINESS_CONTEXT_ORG1,
        BUSINESS_CONTEXT_RUBRIC,
        BUSINESS_CONTEXT_CHAIN,
    }
}
