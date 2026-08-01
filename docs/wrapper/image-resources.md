# Image resources

Placemarks, clusters and polygon patterns need an image, and MapKit takes it as an `ImageProvider`.
In common code `ImageProvider` is an opaque interface: `commonMain` has no `Bitmap` and no
`UIImage`, so the provider is built on the platform side or by one of the resource modules.

| Where the image comes from | What to use |
|---|---|
| Android resources, assets, files, a `Bitmap` | the `androidMain` factories below |
| A `UIImage` | `ImageProvider.fromUIImage` |
| Compose Multiplatform resources | [`imageProvider(Res.drawable.x)`](../compose/image-resources.md) |
| Composable content | [`imageProvider { }`](../compose/image-resources.md#composable-as-imageprovider) |
| moko-resources | [`MOKOImageLoader`](#moko-resources) |

## From platform code

Build the providers where the platform types are available and pass them into common code.

=== "Android"

    ```kotlin
    val fromDrawable = ImageProvider.fromResource(context, R.drawable.ic_cluster)
    val fromAsset = ImageProvider.fromAsset(context, "cluster.png")
    val fromFile = ImageProvider.fromFile("/path/to/cluster.png")
    val fromBitmap = ImageProvider.fromBitmap(bitmap)

    val alsoFromBitmap = bitmap.toImageProvider()
    ```

    Every factory has an overload taking MapKit's caching parameters. `fromBitmap` needs an `id`
    too, because a bitmap has no natural one:

    ```kotlin
    val cached = ImageProvider.fromResource(
        context = context,
        resourceId = R.drawable.ic_cluster,
        isCacheable = true,
    )

    val cachedBitmap = ImageProvider.fromBitmap(
        bitmap = bitmap,
        isCacheable = true,
        id = "cluster-24",
    )
    ```

    !!! info "Caching is worth turning on"
        MapKit caches an image by its id and reuses the decoded copy for every placemark that shares
        it — the difference is visible with hundreds of markers.

=== "iOS"

    ```kotlin
    val provider = ImageProvider.fromUIImage(uiImage)
    ```

    iOS MapKit takes a plain `UIImage`, so there is no id and no caching parameter — the
    Android-only ones stay in `androidMain`.

Handing them over:

=== "Kotlin (commonMain)"

    ```kotlin
    class MapIcons(
        val pin: ImageProvider,
        val cluster: ImageProvider,
    )

    fun setupMap(map: Map, icons: MapIcons) {
        map.mapObjects.addPlacemark().apply {
            geometry = Point(55.751225, 37.629540)
            setIcon(icons.pin)
        }
    }
    ```

=== "Kotlin (androidMain)"

    ```kotlin
    fun mapIcons(context: Context): MapIcons {
        return MapIcons(
            pin = ImageProvider.fromResource(context, R.drawable.pin),
            cluster = ImageProvider.fromResource(context, R.drawable.cluster),
        )
    }
    ```

=== "Kotlin (iosMain)"

    ```kotlin
    fun mapIcons(): MapIcons {
        return MapIcons(
            pin = ImageProvider.fromUIImage(UIImage.imageNamed("pin")!!),
            cluster = ImageProvider.fromUIImage(UIImage.imageNamed("cluster")!!),
        )
    }
    ```

## Animated images

`AnimatedImageProvider` feeds animated placemark icons and animated polygon patterns. Unlike
`ImageProvider`, it can be built entirely from common code:

```kotlin
val fromData = AnimatedImageProvider.fromByteArray(bytes)
val fromFile = AnimatedImageProvider.fromFile(path)

val built = AnimatedImageProvider.fromAnimatedImage(
    AnimatedImage(loopCount = 0).apply {
        addFrame(frameOne, 100.milliseconds)
        addFrame(frameTwo, 100.milliseconds)
    },
)
```

The frames are `ImageProvider`s, so they still come from the platform side. `loopCount = 0` loops
forever. Android additionally has `AnimatedImageProvider.fromResource(context, id)` and
`fromAsset(context, name)`.

## moko-resources

!!! info "Requires `yandex-mapkit-kmp-moko`"

`MOKOImageLoader` turns a moko `ImageResource` into an `ImageProvider`. The Android implementation
needs a `Context`, the iOS one does not, so the loader itself is created on the platform side and
passed into common code.

=== "Kotlin (commonMain)"

    ```kotlin
    fun setupMap(map: Map, imageLoader: MOKOImageLoader) {
        val cluster = imageLoader.fromResource(MR.images.cluster)
        val pin = imageLoader.fromResource(MR.images.pin, isCacheable = true)
    }
    ```

=== "Kotlin (androidMain)"

    ```kotlin
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setupMap(map, AndroidMOKOImageLoader(this))
        }
    }
    ```

=== "Kotlin (iosMain)"

    ```kotlin
    fun setupMap(map: Map) {
        setupMap(map, IOSMOKOImageLoader())
    }
    ```

In a composable context `yandex-mapkit-kmp-moko-compose` removes the platform step entirely — see
[Image resources in Compose](../compose/image-resources.md#moko-resources-in-compose).
