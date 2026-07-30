---
title: "Player"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / Player"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/Player.html"
---
# Player

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/Player.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

`interface Player`

Panorama player that is used to open panoramas.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `openPanorama(@NonNull java.lang.String panoramaId)`<br>Opens the panorama with the given ID. |
| `void` | `openUserPanoramaWithLocalDataSource(@NonNull PanoramaDescription panoramaDescription, @NonNull TileImageFactory tileImageProvider, @NonNull IconImageFactory iconImageProvider, @NonNull UserPanoramaEventListener userPanoramaEventListener)`<br>Opens the panorama from the local datasource. |
| `void` | `openUserPanoramaWithNetworkDataSource(@NonNull PanoramaDescription panoramaDescription, @NonNull TileUrlProvider tileUrlProvider, @NonNull IconUrlProvider iconUrlProvider, @NonNull UserPanoramaEventListener userPanoramaEventListener)`<br>Opens the panorama from the network datasource. |
| `java.lang.String` | `panoramaId()`<br>Opened the panorama with the given ID. |
| `Point` | `position()`<br>Geo position of current panorama. |
| `void` | `lookAt(@NonNull Point position)`<br>Sets the view direction to the center of the given geo position. |
| `Direction` | `direction()`<br>View direction of the opened panorama. |
| `void` | `setDirection(@NonNull Direction direction)`<br>Sets the view direction bearing and tilt. |
| `Span` | `span()`<br>View span of the opened panorama. |
| `void` | `setSpan(@NonNull Span span)`<br>Sets the view area span. |
| `void` | `reset()`<br>Closes the opened panorama and stops all player actions. |
| `java.util.List<HistoricalPanorama>` | `historicalPanoramas()` |
| `void` | `enableZoom()`<br>Enables player zoom controls. |
| `void` | `disableZoom()`<br>Disables player zoom controls. |
| `boolean` | `zoomEnabled()`<br>Checks if zoom controls are enabled. |
| `void` | `enableMove()`<br>Shows transition arrows and allows switching panoramas. |
| `void` | `disableMove()`<br>Hides transition arrows and disallows switching panoramas. |
| `boolean` | `moveEnabled()`<br>Checks if switching panoramas is enabled. |
| `void` | `enableRotation()`<br>Allows the user to rotate panoramas. |
| `void` | `disableRotation()`<br>Disallows the user to rotate panoramas. |
| `boolean` | `rotationEnabled()`<br>Checks if player rotation is enabled. |
| `void` | `enableMarkers()`<br>Allows markers (house numbers, railway stations, airports) to be shown. |
| `void` | `disableMarkers()`<br>Disallows markers (house numbers, railway stations, airports) to be shown. |
| `boolean` | `markersEnabled()`<br>Checks if markers are enabled. |
| `void` | `enableCompanies()`<br>Allows companies (company names and icons) to be shown. |
| `void` | `disableCompanies()`<br>Disallows companies (company names and icons) to be shown. |
| `boolean` | `companiesEnabled()`<br>Checks if companies are enabled. |
| `void` | `addPanoramaChangeListener(@NonNull PanoramaChangeListener panoramaChangeListener)`<br>Adds a panorama change listener. |
| `void` | `removePanoramaChangeListener(@NonNull PanoramaChangeListener panoramaChangeListener)`<br>Removes the panorama change listener. |
| `void` | `addDirectionChangeListener(@NonNull DirectionChangeListener directionChangeListener)`<br>Adds direction listener. |
| `void` | `removeDirectionChangeListener(@NonNull DirectionChangeListener directionChangeListener)`<br>Removes the direction listener. |
| `void` | `addSpanChangeListener(@NonNull SpanChangeListener spanChangeListener)`<br>Adds span listener. |
| `void` | `removeSpanChangeListener(@NonNull SpanChangeListener spanChangeListener)`<br>Removes span listener. |
| `void` | `addCompanyTapListener(@NonNull CompanyTapListener companyTapListener)`<br>Adds company tap listener. |
| `void` | `removeCompanyTapListener(@NonNull CompanyTapListener companyTapListener)`<br>Removes company tap listener. |
| `void` | `addErrorListener(@NonNull ErrorListener errorListener)`<br>Adds error listener. |
| `void` | `removeErrorListener(@NonNull ErrorListener errorListener)`<br>Removes error listener. |
| `void` | `enableLoadingWheel()`<br>Allows showing loading wheels. |
| `void` | `disableLoadingWheel()`<br>Disallows showing loading wheels. |
| `boolean` | `loadingWheelEnabled()`<br>Checks if loading wheels can be shown while the panorama is opening. |
| `Logo` | `getLogo()`<br>Yandex logo object. |
| `void` | `onMemoryWarning()`<br>Called when a memory warning happens. |
| `boolean` | `isValid()`<br>Tells if this **Player** is valid or not. |

## Methods

### openPanorama

```java
void openPanorama(@NonNull java.lang.String panoramaId)
```

Opens the panorama with the given ID.

| Parameters |   |
| --- | --- |
| `panoramaId` | The panoramaId that specifies the panorama to open. You can get the panoramaId by using the PanoramaService methods. |

### openUserPanoramaWithLocalDataSource

```java
void openUserPanoramaWithLocalDataSource(@NonNull PanoramaDescription panoramaDescription,
                                         @NonNull TileImageFactory tileImageProvider,
                                         @NonNull IconImageFactory iconImageProvider,
                                         @NonNull UserPanoramaEventListener userPanoramaEventListener)
```

Opens the panorama from the local datasource.

The class maintains a strong reference to the object in the 'tileImageProvider' parameter until it (the class) is invalidated.

The class maintains a strong reference to the object in the 'iconImageProvider' parameter until it (the class) is invalidated.

The class does not retain the object in the 'userPanoramaEventListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `panoramaDescription` | Initialize this struct to open panorama |
| `tileImageProvider` | The tile datasource |
| `iconImageProvider` | The icon datasource |
| `userPanoramaEventListener` | The user panorama notification listener |

### openUserPanoramaWithNetworkDataSource

```java
void openUserPanoramaWithNetworkDataSource(@NonNull PanoramaDescription panoramaDescription,
                                           @NonNull TileUrlProvider tileUrlProvider,
                                           @NonNull IconUrlProvider iconUrlProvider,
                                           @NonNull UserPanoramaEventListener userPanoramaEventListener)
```

Opens the panorama from the network datasource.

The class maintains a strong reference to the object in the 'tileUrlProvider' parameter until it (the class) is invalidated.

The class maintains a strong reference to the object in the 'iconUrlProvider' parameter until it (the class) is invalidated.

The class does not retain the object in the 'userPanoramaEventListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `panoramaDescription` | Initialize this struct to open panorama |
| `tileUrlProvider` | The network tile datasource |
| `iconUrlProvider` | The netwokr icon datasource |
| `userPanoramaEventListener` | The user panorama notification listener |

### panoramaId

```java
@NonNull
java.lang.String panoramaId()
```

Opened the panorama with the given ID.

**Returns**

PanoramaId of the currently opened panorama. Empty if no panorama is open.

### position

```java
@NonNull
Point position()
```

Geo position of current panorama.

**Returns**

Geo position of the currently opened panorama. Empty if no panorama is open.

### lookAt

```java
void lookAt(@NonNull Point position)
```

Sets the view direction to the center of the given geo position.

| Parameters |   |
| --- | --- |
| `position` | The position to look at. |

### direction

```java
@NonNull
Direction direction()
```

View direction of the opened panorama.

**Returns**

View direction of the opened panorama. Empty if no panorama is open.

### setDirection

```java
void setDirection(@NonNull Direction direction)
```

Sets the view direction bearing and tilt.

| Parameters |   |
| --- | --- |
| `direction` | View direction. |

### span

```java
@NonNull
Span span()
```

View span of the opened panorama.

**Returns**

Current view span of the opened panorama. May be different from the span provided by the setSpan(span) method.

### setSpan

```java
void setSpan(@NonNull Span span)
```

Sets the view area span.

Invalid values are adjusted by the player to the closest valid values.

| Parameters |   |
| --- | --- |
| `span` | View area span. May be adjusted by the player. |

### reset

```java
void reset()
```

Closes the opened panorama and stops all player actions.

### historicalPanoramas

```java
@NonNull
java.util.List<HistoricalPanorama> historicalPanoramas()
```

**Returns**

panoramas published earlier at the current panorama position. Result is updated on the [mapkit.places.panorama.PanoramaChangeListener](PanoramaChangeListener.md) callback

### enableZoom

```java
void enableZoom()
```

Enables player zoom controls.

### disableZoom

```java
void disableZoom()
```

Disables player zoom controls.

### zoomEnabled

```java
boolean zoomEnabled()
```

Checks if zoom controls are enabled.

### enableMove

```java
void enableMove()
```

Shows transition arrows and allows switching panoramas.

### disableMove

```java
void disableMove()
```

Hides transition arrows and disallows switching panoramas.

### moveEnabled

```java
boolean moveEnabled()
```

Checks if switching panoramas is enabled.

### enableRotation

```java
void enableRotation()
```

Allows the user to rotate panoramas.

### disableRotation

```java
void disableRotation()
```

Disallows the user to rotate panoramas.

### rotationEnabled

```java
boolean rotationEnabled()
```

Checks if player rotation is enabled.

### enableMarkers

```java
void enableMarkers()
```

Allows markers (house numbers, railway stations, airports) to be shown.

### disableMarkers

```java
void disableMarkers()
```

Disallows markers (house numbers, railway stations, airports) to be shown.

### markersEnabled

```java
boolean markersEnabled()
```

Checks if markers are enabled.

### enableCompanies

```java
void enableCompanies()
```

Allows companies (company names and icons) to be shown.

### disableCompanies

```java
void disableCompanies()
```

Disallows companies (company names and icons) to be shown.

### companiesEnabled

```java
boolean companiesEnabled()
```

Checks if companies are enabled.

### addPanoramaChangeListener

```java
void addPanoramaChangeListener(@NonNull PanoramaChangeListener panoramaChangeListener)
```

Adds a panorama change listener.

The class does not retain the object in the 'panoramaChangeListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `panoramaChangeListener` | Panorama change listener. |

### removePanoramaChangeListener

```java
void removePanoramaChangeListener(@NonNull PanoramaChangeListener panoramaChangeListener)
```

Removes the panorama change listener.

| Parameters |   |
| --- | --- |
| `panoramaChangeListener` | The panorama change listener to remove. |

### addDirectionChangeListener

```java
void addDirectionChangeListener(@NonNull DirectionChangeListener directionChangeListener)
```

Adds direction listener.

The class does not retain the object in the 'directionChangeListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `directionChangeListener` | Panorama direction listener. |

### removeDirectionChangeListener

```java
void removeDirectionChangeListener(@NonNull DirectionChangeListener directionChangeListener)
```

Removes the direction listener.

| Parameters |   |
| --- | --- |
| `directionChangeListener` | The panorama direction listener to remove. |

### addSpanChangeListener

```java
void addSpanChangeListener(@NonNull SpanChangeListener spanChangeListener)
```

Adds span listener.

The class does not retain the object in the 'spanChangeListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `spanChangeListener` | Panorama span listener. |

### removeSpanChangeListener

```java
void removeSpanChangeListener(@NonNull SpanChangeListener spanChangeListener)
```

Removes span listener.

| Parameters |   |
| --- | --- |
| `spanChangeListener` | The span listener to remove. |

### addCompanyTapListener

```java
void addCompanyTapListener(@NonNull CompanyTapListener companyTapListener)
```

Adds company tap listener.

The class does not retain the object in the 'companyTapListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `companyTapListener` | Company tap listener. |

### removeCompanyTapListener

```java
void removeCompanyTapListener(@NonNull CompanyTapListener companyTapListener)
```

Removes company tap listener.

| Parameters |   |
| --- | --- |
| `companyTapListener` | The company tap listener to remove. |

### addErrorListener

```java
void addErrorListener(@NonNull ErrorListener errorListener)
```

Adds error listener.

The class does not retain the object in the 'errorListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `errorListener` | Listeners that notify when a panorama failed to open. |

### removeErrorListener

```java
void removeErrorListener(@NonNull ErrorListener errorListener)
```

Removes error listener.

| Parameters |   |
| --- | --- |
| `errorListener` | The listener to remove. |

### enableLoadingWheel

```java
void enableLoadingWheel()
```

Allows showing loading wheels.

### disableLoadingWheel

```java
void disableLoadingWheel()
```

Disallows showing loading wheels.

### loadingWheelEnabled

```java
boolean loadingWheelEnabled()
```

Checks if loading wheels can be shown while the panorama is opening.

### getLogo

```java
@NonNull
Logo getLogo()
```

Yandex logo object.

### onMemoryWarning

```java
void onMemoryWarning()
```

Called when a memory warning happens.

### isValid

```java
boolean isValid()
```

Tells if this **Player** is valid or not.

Any other method (except for this one) called on an invalid **Player** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
