---
title: "YMKIconStyle"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKIconStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKIconStyle.html"
---
# YMKIconStyle

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKIconStyle.html)

```swift
class YMKIconStyle : NSObject
```

The style of created icons.

## Summary

### Class methods

```swift
 init(anchor: NSValue?,
 rotationType: NSNumber?,
      zIndex: NSNumber?,
        flat: NSNumber?,
     visible: NSNumber?,
       scale: NSNumber?,
     opacity: Float,
 tappableArea: YMKRect?)
```

### Instance methods

```swift
init()
```

### Properties

```swift
@NSCopying var anchor: NSValue? { get set }
```

An anchor is used to alter image placement

```swift
@NSCopying var rotationType: NSNumber? { get set }
```

Icon rotation type

```swift
@NSCopying var zIndex: NSNumber? { get set }
```

Z-index of the icon, relative to the placemark's z-index

```swift
@NSCopying var flat: NSNumber? { get set }
```

If true, the icon is displayed on the map surface

```swift
@NSCopying var visible: NSNumber? { get set }
```

Sets icon visibility

```swift
@NSCopying var scale: NSNumber? { get set }
```

Scale of the icon

```swift
var opacity: Float { get set }
```

Opacity of the icon

```swift
var tappableArea: YMKRect? { get set }
```

Tappable area on the icon

## Class methods

### init(anchor:rotationType:zIndex:flat:visible:scale:opacity:tappableArea:)

```swift
 init(anchor: NSValue?,
 rotationType: NSNumber?,
      zIndex: NSNumber?,
        flat: NSNumber?,
     visible: NSNumber?,
       scale: NSNumber?,
     opacity: Float,
 tappableArea: YMKRect?)
```

## Instance methods

### init()

```swift
init()
```

## Properties

### anchor

```swift
@NSCopying var anchor: NSValue? { get set }
```

An anchor is used to alter image placement. Normalized: (0.0f, 0.0f) denotes the top left image corner; (1.0f, 1.0f) denotes bottom right. Default is (0.5f, 0.5f).

Optional field, can be nil.

### rotationType

```swift
@NSCopying var rotationType: NSNumber? { get set }
```

Icon rotation type. Default: NoRotation.

Optional field, can be nil.

### zIndex

```swift
@NSCopying var zIndex: NSNumber? { get set }
```

Z-index of the icon, relative to the placemark's z-index.

Optional field, can be nil.

### flat

```swift
@NSCopying var flat: NSNumber? { get set }
```

If true, the icon is displayed on the map surface. If false, the icon is displayed on the screen surface. Default: false.

Optional field, can be nil.

### visible

```swift
@NSCopying var visible: NSNumber? { get set }
```

Sets icon visibility. Default: true.

Optional field, can be nil.

### scale

```swift
@NSCopying var scale: NSNumber? { get set }
```

Scale of the icon. Default: 1.0f.

Optional field, can be nil.

### opacity

```swift
var opacity: Float { get set }
```

Opacity of the icon

### tappableArea

```swift
var tappableArea: YMKRect? { get set }
```

Tappable area on the icon. Coordinates are measured the same way as anchor coordinates. If rect is empty or invalid, the icon will not process taps. By default, icons process all taps.

Optional field, can be nil.
