package ru.sulgik.mapkit.sample.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.ripple
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.platform.inspectable
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.coroutineScope

@Composable
fun CombinedFilledTonalIconButton(
    onPress: () -> Unit,
    onPressRelease: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = IconButtonDefaults.filledShape,
    color: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = contentColorFor(color),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit,
) = CombinedSurface(
    onPress = onPress,
    onPressRelease = onPressRelease,
    modifier = modifier.semantics { role = Role.Button },
    shape = shape,
    color = color,
    shadowElevation = 4.dp,
    contentColor = contentColor,
    interactionSource = interactionSource
) {
    Box(
        modifier = Modifier.size(40.dp),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Composable
@NonRestartableComposable
fun CombinedSurface(
    onPress: () -> Unit,
    onPressRelease: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    color: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = contentColorFor(color),
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    border: BorderStroke? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit,
) {
    val absoluteElevation = LocalAbsoluteTonalElevation.current + tonalElevation
    CompositionLocalProvider(
        LocalContentColor provides contentColor,
        LocalAbsoluteTonalElevation provides absoluteElevation
    ) {
        Box(
            modifier = modifier
                .size(50.dp)
                .surface(
                    shape = shape,
                    backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                        elevation = absoluteElevation
                    ),
                    border = border,
                    shadowElevation = shadowElevation
                ).tapClickable(
                    interactionSource = interactionSource,
                    onPress = onPress,
                    onPressRelease = onPressRelease,
                    indication = ripple(),
                ),
            propagateMinConstraints = true
        ) {
            content()
        }
    }
}


private fun Modifier.surface(
    shape: Shape,
    backgroundColor: Color,
    border: BorderStroke?,
    shadowElevation: Dp,
) = this.shadow(shadowElevation, shape, clip = false)
    .then(if (border != null) Modifier.border(border, shape) else Modifier)
    .background(color = backgroundColor, shape = shape)
    .clip(shape)


fun Modifier.tapClickable(
    interactionSource: MutableInteractionSource,
    indication: Indication?,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onPress: () -> Unit,
    onPressRelease: () -> Unit,
) = inspectable(
    inspectorInfo = debugInspectorInfo {
        name = "clickable"
        properties["interactionSource"] = interactionSource
        properties["indication"] = indication
        properties["enabled"] = enabled
        properties["onClickLabel"] = onClickLabel
        properties["role"] = role
        properties["onPress"] = onPress
        properties["onPressRelease"] = onPressRelease
    }
) {
    Modifier
        .indication(interactionSource, indication)
        .hoverable(enabled = enabled, interactionSource = interactionSource)
        .pointerInput(enabled, interactionSource) {
            coroutineScope {
                detectTapGestures(
                    onPress = {
                        val press = PressInteraction.Press(it)
                        try {
                            onPress()
                            interactionSource.emit(press)
                            awaitRelease()
                            onPressRelease()
                            interactionSource.emit(PressInteraction.Release(press))
                        } catch (e: CancellationException) {
                            onPressRelease()
                            interactionSource.emit(PressInteraction.Release(press))
                        }
                    }
                )
            }
        }
        .focusable(enabled = enabled, interactionSource = interactionSource)
}