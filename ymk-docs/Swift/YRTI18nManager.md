---
title: "YRTI18nManager"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YRTI18nManager"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YRTI18nManager.html"
---
# YRTI18nManager

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YRTI18nManager.html)

```swift
class YRTI18nManager : NSObject
```

Localization manager.

## Summary

### Instance methods

```swift
func localizeDistance(withDistance distance: Int) -> String
```

Converts a distance value to the current locale

```swift
func localizeDuration(withDuration duration: Int) -> String
```

Converts a duration to the current locale

```swift
func localizeSpeed(withSpeed speed: Double) -> String
```

Converts speed to the current locale

```swift
func localizeDataSize(withDataSize dataSize: Int64) -> String
```

Converts data size to the current locale

```swift
func canonicalSpeed(withSpeed speed: Double) -> YRTCanonicalUnit
```

Represents the speed with the value and unit of measurement separated

```swift
func localizeCanonicalUnit(with canonicalUnit: YRTCanonicalUnit) -> String
```

Localizes a value represented by canonical units

### Properties

```swift
var prefs: YRTI18nPrefs { get set }
```

Localization preferences

```swift
var som: YRTSystemOfMeasurement { get set }
```

System of measurement used

```swift
var timeFormat: YRTTimeFormat { get set }
```

Preferred time format

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### localizeDistance(withDistance:)

```swift
func localizeDistance(withDistance distance: Int) -> String
```

Converts a distance value to the current locale.

### localizeDuration(withDuration:)

```swift
func localizeDuration(withDuration duration: Int) -> String
```

Converts a duration to the current locale.

### localizeSpeed(withSpeed:)

```swift
func localizeSpeed(withSpeed speed: Double) -> String
```

Converts speed to the current locale.

### localizeDataSize(withDataSize:)

```swift
func localizeDataSize(withDataSize dataSize: Int64) -> String
```

Converts data size to the current locale.

### canonicalSpeed(withSpeed:)

```swift
func canonicalSpeed(withSpeed speed: Double) -> YRTCanonicalUnit
```

Represents the speed with the value and unit of measurement separated.

### localizeCanonicalUnit(with:)

```swift
func localizeCanonicalUnit(with canonicalUnit: YRTCanonicalUnit) -> String
```

Localizes a value represented by canonical units.

## Properties

### prefs

```swift
var prefs: YRTI18nPrefs { get set }
```

Localization preferences.

### som

```swift
var som: YRTSystemOfMeasurement { get set }
```

System of measurement used.

### timeFormat

```swift
var timeFormat: YRTTimeFormat { get set }
```

Preferred time format.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
