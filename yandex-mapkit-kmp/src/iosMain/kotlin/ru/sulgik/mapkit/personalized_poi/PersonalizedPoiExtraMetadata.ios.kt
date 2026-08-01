package ru.sulgik.mapkit.personalized_poi

import YandexMapKit.YMKPersonalizedPoiExtraMetadata as NativePersonalizedPoiExtraMetadata
import YandexMapKit.YMKPersonalizedPoiExtraMetadataEntry as NativeEntry

public fun PersonalizedPoiExtraMetadata.toNative(): NativePersonalizedPoiExtraMetadata {
    return NativePersonalizedPoiExtraMetadata.personalizedPoiExtraMetadataWithData(
        data.map { it.toNative() },
    )
}

@Suppress("UNCHECKED_CAST")
public fun NativePersonalizedPoiExtraMetadata.toCommon(): PersonalizedPoiExtraMetadata {
    return PersonalizedPoiExtraMetadata(data = (data as List<NativeEntry>).map { it.toCommon() })
}

public fun PersonalizedPoiExtraMetadata.Entry.toNative(): NativeEntry {
    return NativeEntry.personalizedPoiExtraMetadataEntryWithKey(key = key, value = value)
}

public fun NativeEntry.toCommon(): PersonalizedPoiExtraMetadata.Entry {
    return PersonalizedPoiExtraMetadata.Entry(key = key, value = value)
}
