# Image resources

!!! info "Requires `yandex-mapkit-kmp-compose`"

In common code an `ImageProvider` cannot be built from a `Bitmap` or a `UIImage` — the Compose
module fills that gap with three sources: a Compose Multiplatform resource, composable content, and
moko-resources.

## Compose Multiplatform resources

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

The resource is decoded once per composition and cached, so calling it in a loop is fine.

## Composable as `ImageProvider`

!!! warning "Experimental API, marked `@YandexMapsComposeExperimentalApi`"
    It is still incubating and may change in a future release.

```kotlin
@YandexMapsComposeExperimentalApi
@Composable
public fun imageProvider(content: @Composable () -> Unit): ImageProvider?
```

The content is composed in the Compose UI composition, so it inherits the theme, the density and the
composition locals of the caller, and it is re-rendered whenever its state changes.

Things to keep in mind:

- The image size is the size of the content measured **without constraints**, so the content must
  have an intrinsic size. `Modifier.fillMaxSize()` and other constraint-dependent modifiers do not
  work.
- Rendering is asynchronous, so the function returns `null` until the content has been rendered for
  the first time.
- The content is rendered inside `YandexMap` content or inside `ComposeMapObjectRendererHost`;
  calling it anywhere else throws `IllegalStateException`.

The `Placemark` overload with a `content` block does this for you and adds the placemark only once
the content is ready:

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

To render content outside `YandexMap` — to build one provider and reuse it for several objects —
wrap the composable in `ComposeMapObjectRendererHost`:

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

## Composable as cluster icon

Cluster icons are rendered by `clusterImageProvider`. Rendered images are cached by `ClusterInfo`, so
the content is rendered once per distinct cluster and reused by every cluster with the same data.

```kotlin
@YandexMapsComposeExperimentalApi
@Composable
public fun clusterImageProvider(
    content: @Composable (ClusterInfo) -> Unit,
): ClusterImageProvider
```

`Clustering` has an overload that creates the provider itself:

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

`ClusterImageProvider.setIcon` is public, so composable icons also work from a custom
`ClusterListener` — with `MapEffect` and imperative MapKit code, for example. The icon is set as
soon as the content is rendered and updated on every content state change.

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

## moko-resources in Compose

!!! info "Requires `yandex-mapkit-kmp-moko-compose`"

`rememberMOKOImageLoader()` builds the platform implementation of `MOKOImageLoader`, so nothing has
to be created on the platform side and passed down.

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

The non-Compose path, and how images reach the wrapper without either module, is on
[Image resources](../wrapper/image-resources.md).
