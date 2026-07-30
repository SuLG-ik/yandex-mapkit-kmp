---
title: "YRTI18nManager"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YRTI18nManager"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTI18nManager.html"
---
# YRTI18nManager

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTI18nManager.html)

```objectivec
@interface YRTI18nManager : NSObject
```

Localization manager.

## Summary

### Instance methods

```objectivec
- (nonnull NSString *)localizeDistanceWithDistance:(NSInteger)distance;
```

Converts a distance value to the current locale

```objectivec
- (nonnull NSString *)localizeDurationWithDuration:(NSInteger)duration;
```

Converts a duration to the current locale

```objectivec
- (nonnull NSString *)localizeSpeedWithSpeed:(double)speed;
```

Converts speed to the current locale

```objectivec
- (nonnull NSString *)localizeDataSizeWithDataSize:(long long)dataSize;
```

Converts data size to the current locale

```objectivec
- (nonnull YRTCanonicalUnit *)canonicalSpeedWithSpeed:(double)speed;
```

Represents the speed with the value and unit of measurement separated

```objectivec
- (nonnull NSString *)localizeCanonicalUnitWithCanonicalUnit:
    (nonnull YRTCanonicalUnit *)canonicalUnit;
```

Localizes a value represented by canonical units

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YRTI18nPrefs *prefs;
```

Localization preferences

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YRTSystemOfMeasurement som;
```

System of measurement used

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YRTTimeFormat timeFormat;
```

Preferred time format

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### localizeDistanceWithDistance:

```objectivec
- (nonnull NSString *)localizeDistanceWithDistance:(NSInteger)distance;
```

Converts a distance value to the current locale.

### localizeDurationWithDuration:

```objectivec
- (nonnull NSString *)localizeDurationWithDuration:(NSInteger)duration;
```

Converts a duration to the current locale.

### localizeSpeedWithSpeed:

```objectivec
- (nonnull NSString *)localizeSpeedWithSpeed:(double)speed;
```

Converts speed to the current locale.

### localizeDataSizeWithDataSize:

```objectivec
- (nonnull NSString *)localizeDataSizeWithDataSize:(long long)dataSize;
```

Converts data size to the current locale.

### canonicalSpeedWithSpeed:

```objectivec
- (nonnull YRTCanonicalUnit *)canonicalSpeedWithSpeed:(double)speed;
```

Represents the speed with the value and unit of measurement separated.

### localizeCanonicalUnitWithCanonicalUnit:

```objectivec
- (nonnull NSString *)localizeCanonicalUnitWithCanonicalUnit:
    (nonnull YRTCanonicalUnit *)canonicalUnit;
```

Localizes a value represented by canonical units.

## Properties

### prefs

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YRTI18nPrefs *prefs;
```

Localization preferences.

### som

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YRTSystemOfMeasurement som;
```

System of measurement used.

### timeFormat

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YRTTimeFormat timeFormat;
```

Preferred time format.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
