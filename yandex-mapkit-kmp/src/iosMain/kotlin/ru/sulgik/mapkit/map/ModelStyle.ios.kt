package ru.sulgik.mapkit.map

import YandexMapKit.YMKModelStyle as NativeModelStyle
import YandexMapKit.YMKModelStyleRenderMode as NativeRenderMode
import YandexMapKit.YMKModelStyleUnitType as NativeUnitType

public fun ModelStyle.toNative(): NativeModelStyle {
    return NativeModelStyle.modelStyleWithScale(
        scale = scale,
        unitType = unitType.toNative(),
        renderMode = renderMode.toNative(),
        variantName = variantName,
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

public fun ModelStyle.UnitType.toNative(): NativeUnitType {
    return when (this) {
        ModelStyle.UnitType.UNIT -> NativeUnitType.YMKModelStyleUnitTypeUnit
        ModelStyle.UnitType.NORMALIZED -> NativeUnitType.YMKModelStyleUnitTypeNormalized
        ModelStyle.UnitType.METER -> NativeUnitType.YMKModelStyleUnitTypeMeter
    }
}

public fun NativeUnitType.toCommon(): ModelStyle.UnitType {
    return when (this) {
        NativeUnitType.YMKModelStyleUnitTypeUnit -> ModelStyle.UnitType.UNIT
        NativeUnitType.YMKModelStyleUnitTypeNormalized -> ModelStyle.UnitType.NORMALIZED
        NativeUnitType.YMKModelStyleUnitTypeMeter -> ModelStyle.UnitType.METER
        else -> throw IllegalArgumentException("Unknown NativeUnitType ($this)")
    }
}

public fun ModelStyle.RenderMode.toNative(): NativeRenderMode {
    return when (this) {
        ModelStyle.RenderMode.BUILDING -> NativeRenderMode.YMKModelStyleRenderModeBuilding
        ModelStyle.RenderMode.USER_MODEL -> NativeRenderMode.YMKModelStyleRenderModeUserModel
    }
}

public fun NativeRenderMode.toCommon(): ModelStyle.RenderMode {
    return when (this) {
        NativeRenderMode.YMKModelStyleRenderModeBuilding -> ModelStyle.RenderMode.BUILDING
        NativeRenderMode.YMKModelStyleRenderModeUserModel -> ModelStyle.RenderMode.USER_MODEL
        else -> throw IllegalArgumentException("Unknown NativeRenderMode ($this)")
    }
}
