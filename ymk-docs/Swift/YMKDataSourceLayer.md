---
title: "YMKDataSourceLayer"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDataSourceLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDataSourceLayer.html"
---
# YMKDataSourceLayer

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDataSourceLayer.html)

```swift
class YMKDataSourceLayer : NSObject
```

## Summary

### Instance methods

```swift
func clear()
```

Clears all cached tiles and starts new requests for tiles that are displayed

```swift
func setStyleWithId(_ id: Int, style: String) -> Bool
```

Applies JSON style transformation to the layer

```swift
func resetStyles()
```

Resets all JSON style transformations applied to the layer

```swift
func setLayerLoadedListenerWith(_ layerLoadedListener: (any YMKLayerLoadedListener)?)
```

Sets layer loaded listener

```swift
func remove()
```

Removes the data source layer from the parent layer

```swift
func setDataSourceListenerWith(_ dataSourceListener: (any YMKDataSourceListener)?)
```

Sets data source listener

### Properties

```swift
var isActive: Bool { get set }
```

Manages visibility of the layer

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### clear()

```swift
func clear()
```

Clears all cached tiles and starts new requests for tiles that are displayed.

### setStyleWithId(_:style:)

```swift
func setStyleWithId(_ id: Int, style: String) -> Bool
```

Applies JSON style transformation to the layer. Replaces previous styling with the specified ID (if such exists). Stylings are applied in an ascending order. Set to empty string to clear previous styling with the specified ID. Returns true if the style was successfully parsed and false otherwise. If the returned value is false, the current style remains unchanged.

### resetStyles()

```swift
func resetStyles()
```

Resets all JSON style transformations applied to the layer.

### setLayerLoadedListenerWith(_:)

```swift
func setLayerLoadedListenerWith(_ layerLoadedListener: (any YMKLayerLoadedListener)?)
```

Sets layer loaded listener.

The class does not retain the object in the 'layerLoadedListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### remove()

```swift
func remove()
```

Removes the data source layer from the parent layer. The object becomes invalid after that.

### setDataSourceListenerWith(_:)

```swift
func setDataSourceListenerWith(_ dataSourceListener: (any YMKDataSourceListener)?)
```

Sets data source listener. Use it to invalidate data source. Temporary solution until https://st.yandex-team.ru/MAPSMOBCORE-20531 is done

The class does not retain the object in the 'dataSourceListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

## Properties

### isActive

```swift
var isActive: Bool { get set }
```

Manages visibility of the layer.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
