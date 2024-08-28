# Image resources

Placemarks and clusters require image to draw it on map. MapKit use `ImageProvider` to providing
image to Map

## Wrapper-only usage

Library wrap `ImageProvider` as empty interface for common source. But in platform-specific source
set there are some methods for converting native image containers like `Bitmap`, drawable resource,
assets or `UIImage` to ImageProvider.

You should organize logic for creating `ImageProvider`s in platform-specific source and passing 
them to common code

**Android source**

=== "Drawable"
    ```kotlin
    val clusterImageProvider = ImageProvider.fromResource(context, R.drawable.ic_cluster)
    ```

=== "Bitmap"
    ```kotlin
    val clusterImageProvider = clusterBitmap.toImageProvider()
    val cluster2ImageProvider = ImageProvider.fromBitmap(bitmap)
    ```

=== "Asset"
    ```kotlin
    val clusterImageProvider = ImageProvider.fromAsset(context, "cluster_asset")
    ```

=== "File"
    ```kotlin
    val clusterImageProvider = ImageProvider.fromFile(context, "cluster_filename")
    ```

!!! info "MapKit has images caching feature and wrapper support it too"

**IOS source**

=== "UIImage"
    ```kotlin
    val clusterImageProvider = ImageProvider.fromUIImage(uiimage)
    ```

## Moko-resources

!!! info "Requires `andex-mapkit-kmp-moko`"

`yandex-mapkit-kmp-moko` module add supporting for using image resources generated
via [moko-resources](https://github.com/icerockdev/moko-resources) as ImageProvider.

Add `MOKOImageLoader` and platform-specific implementations (`AndroidMOKOImageLoader`
and `IOSMOKOImageLoader`). Require additional configuration to provide implementations.

You should create instances of `MOKOImageLoader` in platform-specific code and provide it to your 
common part using direct parameter passing or DI. 

Android implementation require `Context` instance, but ios does not require it. On iOS you can 
create function function with no `MOKOImageLoader` parameter passing and call it from your map 
control logic entry point.

=== "Android"
    ```kotlin
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val map: Map = /* ... */
            val mokoImageLoader: MOKOImageLoader = AndroidMOKOImageLoader(context)
            setupMap(map, mokoImageLoader)
            /* ... */
        }
    ```
=== "iOS"
    ```kotlin
    fun setupMap(map: Map) {
        setupMap(map, IOSMOKOImageLoader())
    }
    ```
=== "common"
    ```kotlin
    fun setupMap(map: Map, mokoImageLoader: MOKOImageLoader) {
        val clusterImageProvider = mokoImageLoader.fromResource(MR.images.cluster)
    }
    ```