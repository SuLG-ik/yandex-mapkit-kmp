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
    This API contains many limitations and different behaviour on platforms. Highly not recommended
    to use, require help by community to improve rendering on iOS and API in general.

Function to creating ImageProvider via composable content.

In this case exists some limitations:

- It does not composing content all of the time. It take a single snapshot and use it as 
  ImageProvider.
- Parameter size is ignored on Android. On iOS it is used as content size to take a snapshot.
  Will be remove in the future after finding another way to render composable content to snapshot.
- To recreate ImageProvider, content, size or keys (in other variants of this function) should be 
  changed

=== "Kotlin"
    ```kotlin
    @YandexMapsComposeExperimentalApi
    @Composable
    public expect fun imageProvider(
        size: DpSize,
        content: @Composable () -> Unit
    ): ImageProvider
    ```

Usage example. Content is drawn as rounding rectangle with text content of clicks count.

=== "Kotlin"
    ```kotlin
    @Composable
    fun MapScreen() {
        var clicksCount by remember { mutableStateOf(0) }
        val density = LocalDensity.current
        val contentSize = with(density) { DpSize(75.dp, 10.dp + 12.sp.toDp()) }
        val clicksImageProvider = imageProvider(size = contentSize, clicksCount) {
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