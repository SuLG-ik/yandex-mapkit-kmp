package ru.sulgik.mapkit.annotations

import YandexMapKit.YMKAnnotationLanguage as NativeAnnotationLanguage

public fun AnnotationLanguage.toNative(): NativeAnnotationLanguage {
    return when (this) {
        AnnotationLanguage.RUSSIAN -> NativeAnnotationLanguage.YMKAnnotationLanguageRussian
        AnnotationLanguage.ENGLISH -> NativeAnnotationLanguage.YMKAnnotationLanguageEnglish
        AnnotationLanguage.FRENCH -> NativeAnnotationLanguage.YMKAnnotationLanguageFrench
        AnnotationLanguage.TURKISH -> NativeAnnotationLanguage.YMKAnnotationLanguageTurkish
        AnnotationLanguage.UKRAINIAN -> NativeAnnotationLanguage.YMKAnnotationLanguageUkrainian
        AnnotationLanguage.ITALIAN -> NativeAnnotationLanguage.YMKAnnotationLanguageItalian
        AnnotationLanguage.HEBREW -> NativeAnnotationLanguage.YMKAnnotationLanguageHebrew
        AnnotationLanguage.SERBIAN -> NativeAnnotationLanguage.YMKAnnotationLanguageSerbian
        AnnotationLanguage.LATVIAN -> NativeAnnotationLanguage.YMKAnnotationLanguageLatvian
        AnnotationLanguage.FINNISH -> NativeAnnotationLanguage.YMKAnnotationLanguageFinnish
        AnnotationLanguage.ROMANIAN -> NativeAnnotationLanguage.YMKAnnotationLanguageRomanian
        AnnotationLanguage.KYRGYZ -> NativeAnnotationLanguage.YMKAnnotationLanguageKyrgyz
        AnnotationLanguage.KAZAKH -> NativeAnnotationLanguage.YMKAnnotationLanguageKazakh
        AnnotationLanguage.LITHUANIAN -> NativeAnnotationLanguage.YMKAnnotationLanguageLithuanian
        AnnotationLanguage.ESTONIAN -> NativeAnnotationLanguage.YMKAnnotationLanguageEstonian
        AnnotationLanguage.GEORGIAN -> NativeAnnotationLanguage.YMKAnnotationLanguageGeorgian
        AnnotationLanguage.UZBEK -> NativeAnnotationLanguage.YMKAnnotationLanguageUzbek
        AnnotationLanguage.ARMENIAN -> NativeAnnotationLanguage.YMKAnnotationLanguageArmenian
        AnnotationLanguage.AZERBAIJANI -> NativeAnnotationLanguage.YMKAnnotationLanguageAzerbaijani
        AnnotationLanguage.TATAR -> NativeAnnotationLanguage.YMKAnnotationLanguageTatar
        AnnotationLanguage.ARABIC -> NativeAnnotationLanguage.YMKAnnotationLanguageArabic
        AnnotationLanguage.PORTUGUESE -> NativeAnnotationLanguage.YMKAnnotationLanguagePortuguese
        AnnotationLanguage.LATIN_AMERICAN_SPANISH -> NativeAnnotationLanguage.YMKAnnotationLanguageLatinAmericanSpanish
        AnnotationLanguage.BASHKIR -> NativeAnnotationLanguage.YMKAnnotationLanguageBashkir
    }
}

public fun NativeAnnotationLanguage.toCommon(): AnnotationLanguage {
    return when (this) {
        NativeAnnotationLanguage.YMKAnnotationLanguageRussian -> AnnotationLanguage.RUSSIAN
        NativeAnnotationLanguage.YMKAnnotationLanguageEnglish -> AnnotationLanguage.ENGLISH
        NativeAnnotationLanguage.YMKAnnotationLanguageFrench -> AnnotationLanguage.FRENCH
        NativeAnnotationLanguage.YMKAnnotationLanguageTurkish -> AnnotationLanguage.TURKISH
        NativeAnnotationLanguage.YMKAnnotationLanguageUkrainian -> AnnotationLanguage.UKRAINIAN
        NativeAnnotationLanguage.YMKAnnotationLanguageItalian -> AnnotationLanguage.ITALIAN
        NativeAnnotationLanguage.YMKAnnotationLanguageHebrew -> AnnotationLanguage.HEBREW
        NativeAnnotationLanguage.YMKAnnotationLanguageSerbian -> AnnotationLanguage.SERBIAN
        NativeAnnotationLanguage.YMKAnnotationLanguageLatvian -> AnnotationLanguage.LATVIAN
        NativeAnnotationLanguage.YMKAnnotationLanguageFinnish -> AnnotationLanguage.FINNISH
        NativeAnnotationLanguage.YMKAnnotationLanguageRomanian -> AnnotationLanguage.ROMANIAN
        NativeAnnotationLanguage.YMKAnnotationLanguageKyrgyz -> AnnotationLanguage.KYRGYZ
        NativeAnnotationLanguage.YMKAnnotationLanguageKazakh -> AnnotationLanguage.KAZAKH
        NativeAnnotationLanguage.YMKAnnotationLanguageLithuanian -> AnnotationLanguage.LITHUANIAN
        NativeAnnotationLanguage.YMKAnnotationLanguageEstonian -> AnnotationLanguage.ESTONIAN
        NativeAnnotationLanguage.YMKAnnotationLanguageGeorgian -> AnnotationLanguage.GEORGIAN
        NativeAnnotationLanguage.YMKAnnotationLanguageUzbek -> AnnotationLanguage.UZBEK
        NativeAnnotationLanguage.YMKAnnotationLanguageArmenian -> AnnotationLanguage.ARMENIAN
        NativeAnnotationLanguage.YMKAnnotationLanguageAzerbaijani -> AnnotationLanguage.AZERBAIJANI
        NativeAnnotationLanguage.YMKAnnotationLanguageTatar -> AnnotationLanguage.TATAR
        NativeAnnotationLanguage.YMKAnnotationLanguageArabic -> AnnotationLanguage.ARABIC
        NativeAnnotationLanguage.YMKAnnotationLanguagePortuguese -> AnnotationLanguage.PORTUGUESE
        NativeAnnotationLanguage.YMKAnnotationLanguageLatinAmericanSpanish -> AnnotationLanguage.LATIN_AMERICAN_SPANISH
        NativeAnnotationLanguage.YMKAnnotationLanguageBashkir -> AnnotationLanguage.BASHKIR
        else -> throw IllegalArgumentException("Unknown NativeAnnotationLanguage ($this)")
    }
}
