# Изображения

Меткам, кластерам и заливкам полигонов нужно изображение, и MapKit принимает его как
`ImageProvider`. В общем коде `ImageProvider` — непрозрачный интерфейс: в `commonMain` нет ни
`Bitmap`, ни `UIImage`, поэтому провайдер собирается на платформе или одним из ресурсных модулей.

| Откуда изображение | Что использовать |
|---|---|
| Ресурсы, ассеты, файлы, `Bitmap` на Android | фабрики `androidMain` ниже |
| `UIImage` | `ImageProvider.fromUIImage` |
| Ресурсы Compose Multiplatform | [`imageProvider(Res.drawable.x)`](../compose/image-resources.md) |
| Composable-содержимое | [`imageProvider { }`](../compose/image-resources.md#composable-как-imageprovider) |
| moko-resources | [`MOKOImageLoader`](#moko-resources) |

## Из платформенного кода

Собирайте провайдеры там, где доступны платформенные типы, и передавайте их в общий код.

=== "Android"

    ```kotlin
    val fromDrawable = ImageProvider.fromResource(context, R.drawable.ic_cluster)
    val fromAsset = ImageProvider.fromAsset(context, "cluster.png")
    val fromFile = ImageProvider.fromFile("/path/to/cluster.png")
    val fromBitmap = ImageProvider.fromBitmap(bitmap)

    val alsoFromBitmap = bitmap.toImageProvider()
    ```

    У каждой фабрики есть перегрузка с параметрами кеширования MapKit. `fromBitmap` требует ещё и
    `id`, потому что у растра нет естественного идентификатора:

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

    !!! info "Кеширование стоит включать"
        MapKit кеширует изображение по идентификатору и переиспользует декодированную копию для всех
        меток, которые им пользуются — на сотнях маркеров разница заметна.

=== "iOS"

    ```kotlin
    val provider = ImageProvider.fromUIImage(uiImage)
    ```

    iOS MapKit принимает обычный `UIImage`, поэтому здесь нет ни идентификатора, ни параметра
    кеширования — они остались только в `androidMain`.

Передача в общий код:

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

## Анимированные изображения

`AnimatedImageProvider` питает анимированные иконки меток и анимированные заливки полигонов. В
отличие от `ImageProvider`, его можно собрать целиком из общего кода:

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

Кадры — это `ImageProvider`, так что они всё равно приходят с платформы. `loopCount = 0` означает
бесконечный цикл. На Android дополнительно есть `AnimatedImageProvider.fromResource(context, id)` и
`fromAsset(context, name)`.

## moko-resources

!!! info "Требуется `yandex-mapkit-kmp-moko`"

`MOKOImageLoader` превращает `ImageResource` из moko в `ImageProvider`. Android-реализации нужен
`Context`, iOS-реализации — нет, поэтому сам загрузчик создаётся на платформе и передаётся в общий
код.

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

В composable-контексте `yandex-mapkit-kmp-moko-compose` убирает платформенный шаг целиком — см.
[Изображения в Compose](../compose/image-resources.md#moko-resources-в-compose).
