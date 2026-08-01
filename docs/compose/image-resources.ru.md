# Изображения

!!! info "Требуется `yandex-mapkit-kmp-compose`"

В общем коде `ImageProvider` нельзя собрать из `Bitmap` или `UIImage` — Compose-модуль закрывает этот
пробел тремя источниками: ресурс Compose Multiplatform, composable-содержимое и moko-resources.

## Ресурсы Compose Multiplatform

```kotlin
@Composable
public fun imageProvider(resource: DrawableResource): ImageProvider
```

```kotlin
@Composable
fun MapScreen() {
    val pin = imageProvider(Res.drawable.pin_red)
    val cluster = imageProvider(Res.drawable.cluster)

    YandexMap(modifier = Modifier.fillMaxSize()) {
        Placemark(state = rememberPlacemarkState(point), icon = pin)
    }
}
```

Ресурс декодируется один раз на композицию и кешируется, так что вызывать это в цикле нормально.

## Composable как `ImageProvider`

!!! warning "Экспериментальный API, помечен `@YandexMapsComposeExperimentalApi`"
    Он ещё вызревает и может измениться в будущих релизах.

```kotlin
@YandexMapsComposeExperimentalApi
@Composable
public fun imageProvider(content: @Composable () -> Unit): ImageProvider?
```

Содержимое компонуется в композиции Compose UI, поэтому наследует тему, плотность и composition
locals вызывающего кода и перерисовывается при каждом изменении своего состояния.

О чём стоит помнить:

- Размер изображения — это размер содержимого, измеренного **без ограничений**, поэтому у
  содержимого должен быть собственный размер. `Modifier.fillMaxSize()` и другие модификаторы,
  зависящие от ограничений, не работают.
- Отрисовка асинхронная, поэтому функция возвращает `null`, пока содержимое не отрисовано в первый
  раз.
- Содержимое рисуется внутри содержимого `YandexMap` или внутри `ComposeMapObjectRendererHost`;
  вызов в другом месте бросает `IllegalStateException`.

Перегрузка `Placemark` с блоком `content` делает это за вас и добавляет метку только тогда, когда
содержимое готово:

```kotlin
@Composable
fun MapScreen() {
    var clicksCount by remember { mutableStateOf(0) }
    YandexMap(modifier = Modifier.fillMaxSize()) {
        Placemark(
            state = rememberPlacemarkState(point),
            onTap = {
                clicksCount++
                true
            },
        ) {
            Box(
                modifier = Modifier
                    .background(Color.LightGray, MaterialTheme.shapes.medium)
                    .border(1.dp, MaterialTheme.colorScheme.outline, MaterialTheme.shapes.medium)
                    .padding(vertical = 5.dp, horizontal = 10.dp),
            ) {
                Text("clicks: $clicksCount", fontSize = 12.sp)
            }
        }
    }
}
```

Чтобы отрисовать содержимое вне `YandexMap` — например, собрать один провайдер и переиспользовать
его для нескольких объектов — оберните composable в `ComposeMapObjectRendererHost`:

```kotlin
@Composable
fun MapScreen() {
    ComposeMapObjectRendererHost {
        val pinImage = imageProvider {
            Box(Modifier.size(20.dp).background(Color.Red, CircleShape))
        }
        YandexMap(modifier = Modifier.fillMaxSize()) {
            if (pinImage != null) {
                Placemark(state = rememberPlacemarkState(point), icon = pinImage)
            }
        }
    }
}
```

## Composable как иконка кластера

Иконки кластеров рисует `clusterImageProvider`. Отрисованные изображения кешируются по
`ClusterInfo`, поэтому содержимое рисуется один раз на каждый различный кластер и переиспользуется
всеми кластерами с теми же данными.

```kotlin
@YandexMapsComposeExperimentalApi
@Composable
public fun clusterImageProvider(
    content: @Composable (ClusterInfo) -> Unit,
): ClusterImageProvider
```

У `Clustering` есть перегрузка, которая создаёт провайдер сама:

```kotlin
@Composable
fun MapScreen() {
    YandexMap(modifier = Modifier.fillMaxSize()) {
        Clustering(groups = groups) { cluster ->
            Box(
                modifier = Modifier
                    .background(Color.LightGray, MaterialTheme.shapes.medium)
                    .padding(vertical = 5.dp, horizontal = 10.dp),
            ) {
                Text("${cluster.size}")
            }
        }
    }
}
```

`ClusterImageProvider.setIcon` публичен, поэтому composable-иконки работают и из собственного
`ClusterListener` — например, вместе с `MapEffect` и императивным кодом MapKit. Иконка
устанавливается сразу после отрисовки содержимого и обновляется при каждом изменении его состояния.

```kotlin
@Composable
fun MapScreen() {
    YandexMap(modifier = Modifier.fillMaxSize()) {
        val clusterIcon = clusterImageProvider { cluster ->
            ClusterIcon(size = cluster.size)
        }
        val clusterListener = remember(clusterIcon) {
            ClusterListener { cluster -> clusterIcon.setIcon(cluster) }
        }
        MapEffect(clusterListener) { map ->
            map.mapObjects.addClusterizedPlacemarkCollection(clusterListener.asWeakRef())
        }
    }
}
```

## moko-resources в Compose

!!! info "Требуется `yandex-mapkit-kmp-moko-compose`"

`rememberMOKOImageLoader()` собирает платформенную реализацию `MOKOImageLoader`, так что создавать
что-либо на платформе и передавать вниз не нужно.

```kotlin
@Composable
fun MapScreen() {
    val imageLoader = rememberMOKOImageLoader()
    val cluster = remember { imageLoader.fromResource(MR.images.cluster) }

    YandexMap(modifier = Modifier.fillMaxSize()) {
        Clustering(group = ClusterGroup(points = points, icon = cluster), icon = cluster)
    }
}
```

Путь без Compose и то, как изображения попадают в обёртку без обоих модулей, описано на странице
[Изображения](../wrapper/image-resources.md).
