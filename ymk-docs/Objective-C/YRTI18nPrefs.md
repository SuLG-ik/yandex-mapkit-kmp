---
title: "YRTI18nPrefs"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YRTI18nPrefs"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTI18nPrefs.html"
---
# YRTI18nPrefs

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTI18nPrefs.html)

```objectivec
@interface YRTI18nPrefs : NSObject
```

Localization preferences.

## Summary

### Class methods

```objectivec
+ (nonnull YRTI18nPrefs *)i18nPrefsWithSom:( YRTSystemOfMeasurement)som
                                timeFormat:( YRTTimeFormat)timeFormat;
```

### Properties

```objectivec
@property (nonatomic, readonly) YRTSystemOfMeasurement som;
```

System of measurement (metric or imperial)

```objectivec
@property (nonatomic, readonly) YRTTimeFormat timeFormat;
```

Time format (12- or 24-hour)

## Class methods

### i18nPrefsWithSom:timeFormat:

```objectivec
+ (nonnull YRTI18nPrefs *)i18nPrefsWithSom:( YRTSystemOfMeasurement)som
                                timeFormat:( YRTTimeFormat)timeFormat;
```

## Properties

### som

```objectivec
@property (nonatomic, readonly) YRTSystemOfMeasurement som;
```

System of measurement (metric or imperial).

### timeFormat

```objectivec
@property (nonatomic, readonly) YRTTimeFormat timeFormat;
```

Time format (12- or 24-hour).
