package ru.sulgik.mapkit.personalized_poi

import com.yandex.mapkit.personalized_poi.PersonalizedPoiExtraMetadata as NativePersonalizedPoiExtraMetadata
import com.yandex.mapkit.personalized_poi.PersonalizedPoiExtraMetadataEntry as NativeEntry

public fun PersonalizedPoiExtraMetadata.toNative(): NativePersonalizedPoiExtraMetadata {
    return NativePersonalizedPoiExtraMetadata(data.map { it.toNative() })
}

public fun NativePersonalizedPoiExtraMetadata.toCommon(): PersonalizedPoiExtraMetadata {
    return PersonalizedPoiExtraMetadata(data = data.map { it.toCommon() })
}

public fun PersonalizedPoiExtraMetadata.Entry.toNative(): NativeEntry {
    return NativeEntry(key, value)
}

public fun NativeEntry.toCommon(): PersonalizedPoiExtraMetadata.Entry {
    return PersonalizedPoiExtraMetadata.Entry(key = key, value = value)
}
