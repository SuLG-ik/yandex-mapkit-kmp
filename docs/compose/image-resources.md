# Image resources

Placemarks and clusters require image to draw it on map. MapKit use `ImageProvider` to providing
image to Map

## Compose Multiplatform

!!! info "Requires `yandex-mapkit-kmp-compose`"

### Multiplatform Resources usage

You can use generated `Res` to creating `ImageProvider` in composable context directly with:

=== "Kotlin"
    ```kotlin
    @Composable
    public fun imageProvider(resource: DrawableResource): ImageProvider
    ```

Usage example:

=== "Kotlin"
    ```kotlin
    @Composable
    fun MapScreen() {
        //...
        val clusterImage = imageProvider(Res.drawable.cluster)
        // ...
    }
    ```


### Composable as imageProvider

!!! warning "Experimental API marked as `@YandexMapsComposeExperimentalApi`."
    API is still incubating and may be changed in the future releases.

Function to creating ImageProvider via composable content.

Content is composed in compose-ui composition, so it inherits theme, density and other composition
locals of the caller, and it is re-rendered on every content state change.

Things to keep in mind:

- Image size is the size of the content measured without constraints, so content should have
  intrinsic size. `Modifier.fillMaxSize` and other constraints-dependent modifiers do not work.
- Rendering is asynchronous, so function returns `null` until content is rendered for the first
  time.
- Content is rendered inside `YandexMap` content or inside `ComposeMapObjectRendererHost`, calling
  it in other place throws `IllegalStateException`.

=== "Kotlin"
    ```kotlin
    @YandexMapsComposeExperimentalApi
    @Composable
    public fun imageProvider(content: @Composable () -> Unit): ImageProvider?
    ```

Usage example. Content is drawn as rounding rectangle with text content of clicks count.

=== "Kotlin"
    ```kotlin
    @Composable
    fun MapScreen() {
        var clicksCount by remember { mutableStateOf(0) }
        YandexMap {
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
                        .border(
                            1.dp,
                            MaterialTheme.colorScheme.outline,
                            MaterialTheme.shapes.medium
                        )
                        .padding(vertical = 5.dp, horizontal = 10.dp)
                ) {
                    Text("clicks: $clicksCount", fontSize = 12.sp)
                }
            }
        }
    }
    ```

To render content outside of `YandexMap`, for example to create image provider once and reuse it
for several map objects, wrap composable with `ComposeMapObjectRendererHost`.

=== "Kotlin"
    ```kotlin
    @Composable
    fun MapScreen() {
        ComposeMapObjectRendererHost {
            val pinImage = imageProvider {
                Box(Modifier.size(20.dp).background(Color.Red, CircleShape))
            }
            YandexMap {
                if (pinImage != null) {
                    Placemark(state = rememberPlacemarkState(point), icon = pinImage)
                }
            }
        }
    }
    ```

### Composable as cluster icon

Cluster icons are rendered by `clusterImageProvider`. Rendered images are cached by `ClusterInfo`,
so content is rendered once per distinct cluster data and is reused by all clusters with the same
data.

=== "Kotlin"
    ```kotlin
    @YandexMapsComposeExperimentalApi
    @Composable
    public fun clusterImageProvider(
        content: @Composable (ClusterInfo) -> Unit,
    ): ClusterImageProvider
    ```

Usage example with `Clustering`, that creates provider by itself.

=== "Kotlin"
    ```kotlin
    @Composable
    fun MapScreen() {
        YandexMap {
            Clustering(groups = groups) { cluster ->
                Box(
                    modifier = Modifier
                        .background(Color.LightGray, MaterialTheme.shapes.medium)
                        .padding(vertical = 5.dp, horizontal = 10.dp)
                ) {
                    Text("${cluster.size}")
                }
            }
        }
    }
    ```

## Moko-resources compose

!!! info "Requires `yandex-mapkit-kmp-moko-compose`"

`yandex-mapkit-kmp-moko-compose` module that add supporting for using image resources generated
via [moko-resources](https://github.com/icerockdev/moko-resources) as ImageProvider
with compose multiplatform integration.

Add `rememberMOKOImageLoader()` that provides platform-specific implementations for
`MOKOImageLoader`. Does not require additional configuration.

You can create `MOKOImageLoader` in common source in composable context

=== "Kotlin"
    ```kotlin
    @Composable
    fun MapScreen() {
      val mokoImageLoader = rememberMOKOImageLoader()
      val clusterImageProvider = remember { mokoImageLoader.fromResource(MR.images.cluster) }
    }
    ```