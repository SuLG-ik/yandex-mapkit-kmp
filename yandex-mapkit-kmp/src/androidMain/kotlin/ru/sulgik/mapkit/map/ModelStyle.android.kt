package ru.sulgik.mapkit.map

import com.yandex.mapkit.map.ModelStyle as NativeModelStyle

public fun ModelStyle.toNative(): NativeModelStyle {
    return NativeModelStyle(
        scale,
        unitType.toNative(),
        renderMode.toNative(),
        variantName,
    )
}

public fun NativeModelStyle.toCommon(): ModelStyle {
    return ModelStyle(
        scale = scale,
        unitType = unitType.toCommon(),
        renderMode = renderMode.toCommon(),
        variantName = variantName,
    )
}

public fun ModelStyle.UnitType.toNative(): NativeModelStyle.UnitType {
    return when (this) {
        ModelStyle.UnitType.UNIT -> NativeModelStyle.UnitType.UNIT
        ModelStyle.UnitType.NORMALIZED -> NativeModelStyle.UnitType.NORMALIZED
        ModelStyle.UnitType.METER -> NativeModelStyle.UnitType.METER
    }
}

public fun NativeModelStyle.UnitType.toCommon(): ModelStyle.UnitType {
    return when (this) {
        NativeModelStyle.UnitType.UNIT -> ModelStyle.UnitType.UNIT
        NativeModelStyle.UnitType.NORMALIZED -> ModelStyle.UnitType.NORMALIZED
        NativeModelStyle.UnitType.METER -> ModelStyle.UnitType.METER
    }
}

public fun ModelStyle.RenderMode.toNative(): NativeModelStyle.RenderMode {
    return when (this) {
        ModelStyle.RenderMode.BUILDING -> NativeModelStyle.RenderMode.BUILDING
        ModelStyle.RenderMode.USER_MODEL -> NativeModelStyle.RenderMode.USER_MODEL
    }
}

public fun NativeModelStyle.RenderMode.toCommon(): ModelStyle.RenderMode {
    return when (this) {
        NativeModelStyle.RenderMode.BUILDING -> ModelStyle.RenderMode.BUILDING
        NativeModelStyle.RenderMode.USER_MODEL -> ModelStyle.RenderMode.USER_MODEL
    }
}
