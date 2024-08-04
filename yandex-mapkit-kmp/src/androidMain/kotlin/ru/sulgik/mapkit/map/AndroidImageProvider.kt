package ru.sulgik.mapkit.map

import android.content.Context
import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import com.yandex.runtime.image.ImageProvider as NativeImageProvider

public class AndroidImageProvider internal constructor(
    private val nativeImageProvider: NativeImageProvider,
) : ImageProvider {
    override fun toNative(): NativeImageProvider {
        return nativeImageProvider
    }
}

public fun NativeImageProvider.toCommon(): ImageProvider {
    return AndroidImageProvider(this)
}

public fun Bitmap.toImageProvider(): ImageProvider {
    return NativeImageProvider.fromBitmap(this).toCommon()
}

public fun Bitmap.toImageProvider(
    isCacheable: Boolean,
    id: String,
): ImageProvider {
    return NativeImageProvider.fromBitmap(this, isCacheable, id).toCommon()
}

public fun ImageProvider.Companion.fromAsset(context: Context, assetName: String): ImageProvider {
    return NativeImageProvider.fromAsset(context, assetName).toCommon()
}

public fun ImageProvider.Companion.fromAsset(
    context: Context,
    assetName: String,
    isCacheable: Boolean,
): ImageProvider {
    return NativeImageProvider.fromAsset(context, assetName, isCacheable).toCommon()
}

public fun ImageProvider.Companion.fromResource(
    context: Context,
    @DrawableRes resourceId: Int,
): ImageProvider {
    return NativeImageProvider.fromResource(context, resourceId).toCommon()
}

public fun ImageProvider.Companion.fromResource(
    context: Context,
    @DrawableRes resourceId: Int,
    isCacheable: Boolean,
): ImageProvider {
    return NativeImageProvider.fromResource(context, resourceId, isCacheable).toCommon()
}

public fun ImageProvider.Companion.fromFile(fileName: String): ImageProvider {
    return NativeImageProvider.fromFile(fileName).toCommon()
}

public fun ImageProvider.Companion.fromFile(
    fileName: String,
    isCacheable: Boolean,
): ImageProvider {
    return NativeImageProvider.fromFile(fileName, isCacheable).toCommon()
}
