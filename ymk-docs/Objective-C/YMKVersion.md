---
title: "YMKVersion"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKVersion"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKVersion.html"
---
# YMKVersion

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKVersion.html)

```objectivec
@interface YMKVersion : NSObject
```

Dot-separated version string. Alphabetical symbols are ignored without errors.

Examples of correct versions: "1.2.3", "2.0.0-2", "2014.04.25", "42".

## Summary

### Class methods

```objectivec
+ (nonnull YMKVersion *)versionWithStr:(nonnull NSString *)str;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *str;
```

Version string

## Class methods

### versionWithStr:

```objectivec
+ (nonnull YMKVersion *)versionWithStr:(nonnull NSString *)str;
```

## Properties

### str

```objectivec
@property (nonatomic, readonly, nonnull) NSString *str;
```

Version string.
