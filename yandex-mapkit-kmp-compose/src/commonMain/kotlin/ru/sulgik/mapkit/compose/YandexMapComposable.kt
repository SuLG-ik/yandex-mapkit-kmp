package ru.sulgik.mapkit.compose

import androidx.compose.runtime.ComposableTargetMarker

/**
 * Marks declarations that runs in custom MapComposition, outside compose-ui composition context.
 *
 * In composable marked with it there no access to compose-ui composables.
 */
@Retention(AnnotationRetention.BINARY)
@ComposableTargetMarker(description = "Yandex Map Composable")
@Target(
    AnnotationTarget.FILE,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.TYPE,
    AnnotationTarget.TYPE_PARAMETER,
)
public annotation class YandexMapComposable