package ru.sulgik.mapkit.search

import ru.sulgik.mapkit.geometry.toCommon
import ru.sulgik.mapkit.geometry.toNative
import ru.sulgik.mapkit.runtime.toCommon
import ru.sulgik.mapkit.runtime.toNative
import ru.sulgik.mapkit.toCommon
import ru.sulgik.mapkit.toNative
import com.yandex.mapkit.search.SuggestItem as NativeSuggestItem
import com.yandex.mapkit.search.SuggestItem.Action as NativeAction
import com.yandex.mapkit.search.SuggestItem.BusinessContext as NativeBusinessContext
import com.yandex.mapkit.search.SuggestItem.Type as NativeSuggestItemType

public fun SuggestItem.toNative(): NativeSuggestItem {
    return NativeSuggestItem(
        type.toNative(),
        title.toNative(),
        subtitle?.toNative(),
        tags,
        searchText,
        displayText,
        uri,
        link,
        distance?.toNative(),
        isPersonal,
        action.toNative(),
        logId,
        isOffline,
        isWordItem,
        properties.map { it.toNative() },
        center?.toNative(),
        businessContext?.toNative(),
    )
}

public fun NativeSuggestItem.toCommon(): SuggestItem {
    return SuggestItem(
        type = type.toCommon(),
        title = title.toCommon(),
        subtitle = subtitle?.toCommon(),
        tags = tags.toList(),
        searchText = searchText,
        displayText = displayText,
        uri = uri,
        link = link,
        distance = distance?.toCommon(),
        isPersonal = getIsPersonal(),
        action = action.toCommon(),
        logId = logId,
        isOffline = getIsOffline(),
        isWordItem = getIsWordItem(),
        properties = properties.map { it.toCommon() },
        center = center?.toCommon(),
        businessContext = businessContext?.toCommon(),
    )
}

public fun SuggestItem.Type.toNative(): NativeSuggestItemType {
    return when (this) {
        SuggestItem.Type.UNKNOWN -> NativeSuggestItemType.UNKNOWN
        SuggestItem.Type.TOPONYM -> NativeSuggestItemType.TOPONYM
        SuggestItem.Type.BUSINESS -> NativeSuggestItemType.BUSINESS
        SuggestItem.Type.TRANSIT -> NativeSuggestItemType.TRANSIT
        SuggestItem.Type.LINK -> NativeSuggestItemType.LINK
    }
}

public fun NativeSuggestItemType.toCommon(): SuggestItem.Type {
    return when (this) {
        NativeSuggestItemType.UNKNOWN -> SuggestItem.Type.UNKNOWN
        NativeSuggestItemType.TOPONYM -> SuggestItem.Type.TOPONYM
        NativeSuggestItemType.BUSINESS -> SuggestItem.Type.BUSINESS
        NativeSuggestItemType.TRANSIT -> SuggestItem.Type.TRANSIT
        NativeSuggestItemType.LINK -> SuggestItem.Type.LINK
    }
}

public fun SuggestItem.Action.toNative(): NativeAction {
    return when (this) {
        SuggestItem.Action.SEARCH -> NativeAction.SEARCH
        SuggestItem.Action.SUBSTITUTE -> NativeAction.SUBSTITUTE
        SuggestItem.Action.FOLLOW_LINK -> NativeAction.FOLLOW_LINK
    }
}

public fun NativeAction.toCommon(): SuggestItem.Action {
    return when (this) {
        NativeAction.SEARCH -> SuggestItem.Action.SEARCH
        NativeAction.SUBSTITUTE -> SuggestItem.Action.SUBSTITUTE
        NativeAction.FOLLOW_LINK -> SuggestItem.Action.FOLLOW_LINK
    }
}

public fun SuggestItem.BusinessContext.toNative(): NativeBusinessContext {
    return when (this) {
        SuggestItem.BusinessContext.BUSINESS_CONTEXT_UNKNOWN -> NativeBusinessContext.BUSINESS_CONTEXT_UNKNOWN
        SuggestItem.BusinessContext.BUSINESS_CONTEXT_ORG1 -> NativeBusinessContext.BUSINESS_CONTEXT_ORG1
        SuggestItem.BusinessContext.BUSINESS_CONTEXT_RUBRIC -> NativeBusinessContext.BUSINESS_CONTEXT_RUBRIC
        SuggestItem.BusinessContext.BUSINESS_CONTEXT_CHAIN -> NativeBusinessContext.BUSINESS_CONTEXT_CHAIN
    }
}

public fun NativeBusinessContext.toCommon(): SuggestItem.BusinessContext {
    return when (this) {
        NativeBusinessContext.BUSINESS_CONTEXT_UNKNOWN -> SuggestItem.BusinessContext.BUSINESS_CONTEXT_UNKNOWN
        NativeBusinessContext.BUSINESS_CONTEXT_ORG1 -> SuggestItem.BusinessContext.BUSINESS_CONTEXT_ORG1
        NativeBusinessContext.BUSINESS_CONTEXT_RUBRIC -> SuggestItem.BusinessContext.BUSINESS_CONTEXT_RUBRIC
        NativeBusinessContext.BUSINESS_CONTEXT_CHAIN -> SuggestItem.BusinessContext.BUSINESS_CONTEXT_CHAIN
    }
}
