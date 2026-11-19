package ru.sulgik.mapkit.annotations

import com.yandex.mapkit.annotations.AnnotationLanguage as NativeAnnotationLanguage

public fun AnnotationLanguage.toNative(): NativeAnnotationLanguage {
    return when (this) {
        AnnotationLanguage.RUSSIAN -> NativeAnnotationLanguage.RUSSIAN
        AnnotationLanguage.ENGLISH -> NativeAnnotationLanguage.ENGLISH
        AnnotationLanguage.FRENCH -> NativeAnnotationLanguage.FRENCH
        AnnotationLanguage.TURKISH -> NativeAnnotationLanguage.TURKISH
        AnnotationLanguage.UKRAINIAN -> NativeAnnotationLanguage.UKRAINIAN
        AnnotationLanguage.ITALIAN -> NativeAnnotationLanguage.ITALIAN
        AnnotationLanguage.HEBREW -> NativeAnnotationLanguage.HEBREW
        AnnotationLanguage.SERBIAN -> NativeAnnotationLanguage.SERBIAN
        AnnotationLanguage.LATVIAN -> NativeAnnotationLanguage.LATVIAN
        AnnotationLanguage.FINNISH -> NativeAnnotationLanguage.FINNISH
        AnnotationLanguage.ROMANIAN -> NativeAnnotationLanguage.ROMANIAN
        AnnotationLanguage.KYRGYZ -> NativeAnnotationLanguage.KYRGYZ
        AnnotationLanguage.KAZAKH -> NativeAnnotationLanguage.KAZAKH
        AnnotationLanguage.LITHUANIAN -> NativeAnnotationLanguage.LITHUANIAN
        AnnotationLanguage.ESTONIAN -> NativeAnnotationLanguage.ESTONIAN
        AnnotationLanguage.GEORGIAN -> NativeAnnotationLanguage.GEORGIAN
        AnnotationLanguage.UZBEK -> NativeAnnotationLanguage.UZBEK
        AnnotationLanguage.ARMENIAN -> NativeAnnotationLanguage.ARMENIAN
        AnnotationLanguage.AZERBAIJANI -> NativeAnnotationLanguage.AZERBAIJANI
        AnnotationLanguage.TATAR -> NativeAnnotationLanguage.TATAR
        AnnotationLanguage.ARABIC -> NativeAnnotationLanguage.ARABIC
        AnnotationLanguage.PORTUGUESE -> NativeAnnotationLanguage.PORTUGUESE
        AnnotationLanguage.LATIN_AMERICAN_SPANISH -> NativeAnnotationLanguage.LATIN_AMERICAN_SPANISH
        AnnotationLanguage.BASHKIR -> NativeAnnotationLanguage.BASHKIR
    }
}

public fun NativeAnnotationLanguage.toCommon(): AnnotationLanguage {
    return when (this) {
        NativeAnnotationLanguage.RUSSIAN -> AnnotationLanguage.RUSSIAN
        NativeAnnotationLanguage.ENGLISH -> AnnotationLanguage.ENGLISH
        NativeAnnotationLanguage.FRENCH -> AnnotationLanguage.FRENCH
        NativeAnnotationLanguage.TURKISH -> AnnotationLanguage.TURKISH
        NativeAnnotationLanguage.UKRAINIAN -> AnnotationLanguage.UKRAINIAN
        NativeAnnotationLanguage.ITALIAN -> AnnotationLanguage.ITALIAN
        NativeAnnotationLanguage.HEBREW -> AnnotationLanguage.HEBREW
        NativeAnnotationLanguage.SERBIAN -> AnnotationLanguage.SERBIAN
        NativeAnnotationLanguage.LATVIAN -> AnnotationLanguage.LATVIAN
        NativeAnnotationLanguage.FINNISH -> AnnotationLanguage.FINNISH
        NativeAnnotationLanguage.ROMANIAN -> AnnotationLanguage.ROMANIAN
        NativeAnnotationLanguage.KYRGYZ -> AnnotationLanguage.KYRGYZ
        NativeAnnotationLanguage.KAZAKH -> AnnotationLanguage.KAZAKH
        NativeAnnotationLanguage.LITHUANIAN -> AnnotationLanguage.LITHUANIAN
        NativeAnnotationLanguage.ESTONIAN -> AnnotationLanguage.ESTONIAN
        NativeAnnotationLanguage.GEORGIAN -> AnnotationLanguage.GEORGIAN
        NativeAnnotationLanguage.UZBEK -> AnnotationLanguage.UZBEK
        NativeAnnotationLanguage.ARMENIAN -> AnnotationLanguage.ARMENIAN
        NativeAnnotationLanguage.AZERBAIJANI -> AnnotationLanguage.AZERBAIJANI
        NativeAnnotationLanguage.TATAR -> AnnotationLanguage.TATAR
        NativeAnnotationLanguage.ARABIC -> AnnotationLanguage.ARABIC
        NativeAnnotationLanguage.PORTUGUESE -> AnnotationLanguage.PORTUGUESE
        NativeAnnotationLanguage.LATIN_AMERICAN_SPANISH -> AnnotationLanguage.LATIN_AMERICAN_SPANISH
        NativeAnnotationLanguage.BASHKIR -> AnnotationLanguage.BASHKIR
    }
}
