---
title: "YMKNavigationSerialization"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKNavigationSerialization"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationSerialization.html"
---
# YMKNavigationSerialization

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationSerialization.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKNavigationSerialization : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull NSData *)serialize:(nonnull YMKNavigation *)navigation;
```

Serializes a given instance of Navigation

```objectivec
+ (nullable YMKNavigation *)deserialize:(nonnull NSData *)serializedNavigation;
```

Deserializes a given instance of Navigation

## Class methods

### serialize:

```objectivec
+ (nonnull NSData *)serialize:(nonnull YMKNavigation *)navigation;
```

Serializes a given instance of Navigation.

### deserialize:

```objectivec
+ (nullable YMKNavigation *)deserialize:(nonnull NSData *)serializedNavigation;
```

Deserializes a given instance of Navigation. Navigation will be in the suspended mode. Returns null if deserialization failed.
