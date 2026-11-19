package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.runtime.toCommon
import ru.sulgik.mapkit.runtime.toNative
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import ru.sulgik.mapkit.toNSNumber
import YandexMapKit.YMKSuggestItem as NativeSuggestItem
import YandexMapKit.YMKSuggestItemAction as NativeAction
import YandexMapKit.YMKSuggestItemBusinessContext as NativeBusinessContext
import YandexMapKit.YMKSuggestItemType as NativeSuggestItemType
import YandexMapKit.YRTKeyValuePair as NativeKeyValuePair

public fun SuggestItem.toNative(): NativeSuggestItem {
    return NativeSuggestItem.suggestItemWithType(
        type = type.toNative(),
        title = title.toNative(),
        subtitle = subtitle?.toNative(),
        tags = tags,
        searchText = searchText,
        displayText = displayText,
        uri = uri,
        link = link,
        distance = distance?.toNative(),
        isPersonal = isPersonal,
        action = action.toNative(),
        logId = logId,
        isOffline = isOffline,
        isWordItem = isWordItem,
        properties = properties.map { it.toNative() },
        center = center?.toNative(),
        businessContext = businessContext?.toNative()?.value?.toLong()?.toNSNumber(),
    )
}

@Suppress("UNCHECKED_CAST")
public fun NativeSuggestItem.toCommon(): SuggestItem {
    return SuggestItem(
        type = type.toCommon(),
        title = title.toCommon(),
        subtitle = subtitle?.toCommon(),
        tags = (tags as List<String>).toList(),
        searchText = searchText,
        displayText = displayText,
        uri = uri,
        link = link,
        distance = distance?.toCommon(),
        isPersonal = isPersonal,
        action = action.toCommon(),
        logId = logId,
        isOffline = isOffline,
        isWordItem = isWordItem,
        properties = (properties as List<NativeKeyValuePair>).map { it.toCommon() },
        center = center?.toCommon(),
        businessContext = businessContext?.let { NativeBusinessContext.byValue(it.unsignedLongValue).toCommon() },
    )
}

public fun SuggestItem.Type.toNative(): NativeSuggestItemType {
    return when (this) {
        SuggestItem.Type.UNKNOWN -> NativeSuggestItemType.YMKSuggestItemTypeUnknown
        SuggestItem.Type.TOPONYM -> NativeSuggestItemType.YMKSuggestItemTypeToponym
        SuggestItem.Type.BUSINESS -> NativeSuggestItemType.YMKSuggestItemTypeBusiness
        SuggestItem.Type.TRANSIT -> NativeSuggestItemType.YMKSuggestItemTypeTransit
        SuggestItem.Type.LINK -> NativeSuggestItemType.YMKSuggestItemTypeLink
    }
}

public fun NativeSuggestItemType.toCommon(): SuggestItem.Type {
    return when (this) {
        NativeSuggestItemType.YMKSuggestItemTypeUnknown -> SuggestItem.Type.UNKNOWN
        NativeSuggestItemType.YMKSuggestItemTypeToponym -> SuggestItem.Type.TOPONYM
        NativeSuggestItemType.YMKSuggestItemTypeBusiness -> SuggestItem.Type.BUSINESS
        NativeSuggestItemType.YMKSuggestItemTypeTransit -> SuggestItem.Type.TRANSIT
        NativeSuggestItemType.YMKSuggestItemTypeLink -> SuggestItem.Type.LINK
        else -> throw IllegalArgumentException("Unknown NativeSuggestItemType ($this)")
    }
}

public fun SuggestItem.Action.toNative(): NativeAction {
    return when (this) {
        SuggestItem.Action.SEARCH -> NativeAction.YMKSuggestItemActionSearch
        SuggestItem.Action.SUBSTITUTE -> NativeAction.YMKSuggestItemActionSubstitute
        SuggestItem.Action.FOLLOW_LINK -> NativeAction.YMKSuggestItemActionFollowLink
    }
}

public fun NativeAction.toCommon(): SuggestItem.Action {
    return when (this) {
        NativeAction.YMKSuggestItemActionSearch -> SuggestItem.Action.SEARCH
        NativeAction.YMKSuggestItemActionSubstitute -> SuggestItem.Action.SUBSTITUTE
        NativeAction.YMKSuggestItemActionFollowLink -> SuggestItem.Action.FOLLOW_LINK
        else -> throw IllegalArgumentException("Unknown NativeAction ($this)")
    }
}

public fun SuggestItem.BusinessContext.toNative(): NativeBusinessContext {
    return when (this) {
        SuggestItem.BusinessContext.BUSINESS_CONTEXT_UNKNOWN -> NativeBusinessContext.YMKSuggestItemBusinessContextBusinessContextUnknown
        SuggestItem.BusinessContext.BUSINESS_CONTEXT_ORG1 -> NativeBusinessContext.YMKSuggestItemBusinessContextBusinessContextOrg1
        SuggestItem.BusinessContext.BUSINESS_CONTEXT_RUBRIC -> NativeBusinessContext.YMKSuggestItemBusinessContextBusinessContextRubric
        SuggestItem.BusinessContext.BUSINESS_CONTEXT_CHAIN -> NativeBusinessContext.YMKSuggestItemBusinessContextBusinessContextChain
    }
}

public fun NativeBusinessContext.toCommon(): SuggestItem.BusinessContext {
    return when (this) {
        NativeBusinessContext.YMKSuggestItemBusinessContextBusinessContextUnknown -> SuggestItem.BusinessContext.BUSINESS_CONTEXT_UNKNOWN
        NativeBusinessContext.YMKSuggestItemBusinessContextBusinessContextOrg1 -> SuggestItem.BusinessContext.BUSINESS_CONTEXT_ORG1
        NativeBusinessContext.YMKSuggestItemBusinessContextBusinessContextRubric -> SuggestItem.BusinessContext.BUSINESS_CONTEXT_RUBRIC
        NativeBusinessContext.YMKSuggestItemBusinessContextBusinessContextChain -> SuggestItem.BusinessContext.BUSINESS_CONTEXT_CHAIN
        else -> throw IllegalArgumentException("Unknown NativeBusinessContext ($this)")
    }
}
