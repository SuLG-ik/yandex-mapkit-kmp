package ru.sulgik.mapkit.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.CoroutineScope
import ru.sulgik.mapkit.map.Map
import kotlin.coroutines.CoroutineContext

/**
 * A side-effect backed by a [LaunchedEffect] which will launch [block] and provide the underlying
 * managed [YandexMap] object into the composition's [CoroutineContext]. This effect will be
 * re-launched when a different [key1] is provided.
 *
 * Note: This effect should be used with caution as the [YandexMap]'s properties is managed by the
 * [ru.sulgik.mapkit.compose.YandexMap()] composable function. However,
 * there are use cases when obtaining a raw reference to the map is desirable for extensibility
 */
@Composable
@YandexMapComposable
public fun MapEffect(
    key1: Any?,
    block: suspend CoroutineScope.(Map) -> Unit,
) {
    val map = LocalMap.current
    LaunchedEffect(key1 = key1) {
        block(map)
    }
}

/**
 * A side-effect backed by a [LaunchedEffect] which will launch [block] and provide the underlying
 * managed [YandexMap] object into the composition's [CoroutineContext]. This effect will be
 * re-launched when a different [key1] or [key2] is provided.
 *
 * Note: This effect should be used with caution as the [YandexMap]'s properties is managed by the
 * [ru.sulgik.mapkit.compose.YandexMap()] composable function. However,
 * there are use cases when obtaining a raw reference to the map is desirable for extensibility
 */
@Composable
@YandexMapComposable
public fun MapEffect(
    key1: Any?,
    key2: Any?,
    block: suspend CoroutineScope.(Map) -> Unit
) {
    val map = LocalMap.current
    LaunchedEffect(key1 = key1, key2 = key2) {
        block(map)
    }
}

/**
 * A side-effect backed by a [LaunchedEffect] which will launch [block] and provide the underlying
 * managed [YandexMap] object into the composition's [CoroutineContext]. This effect will be
 * re-launched when a different [key1], [key2] or [key3] is provided.
 *
 * Note: This effect should be used with caution as the [YandexMap]'s properties is managed by the
 * [ru.sulgik.mapkit.compose.YandexMap()] composable function. However,
 * there are use cases when obtaining a raw reference to the map is desirable for extensibility
 */
@Composable
@YandexMapComposable
public fun MapEffect(
    key1: Any?,
    key2: Any?,
    key3: Any?,
    block: suspend CoroutineScope.(Map) -> Unit
) {
    val map = LocalMap.current
    LaunchedEffect(key1 = key1, key2 = key2, key3 = key3) {
        block(map)
    }
}

/**
 * A side-effect backed by a [LaunchedEffect] which will launch [block] and provide the underlying
 * managed [YandexMap] object into the composition's [CoroutineContext]. This effect will be
 * re-launched when a different [keys] is provided.
 *
 * Note: This effect should be used with caution as the [YandexMap]'s properties is managed by the
 * [ru.sulgik.mapkit.compose.YandexMap()] composable function. However,
 * there are use cases when obtaining a raw reference to the map is desirable for extensibility
 */
@Composable
@YandexMapComposable
public fun MapEffect(
    vararg keys: Any?,
    block: suspend CoroutineScope.(Map) -> Unit
) {
    val map = LocalMap.current
    LaunchedEffect(keys = keys) {
        block(map)
    }
}