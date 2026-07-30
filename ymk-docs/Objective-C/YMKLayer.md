---
title: "YMKLayer"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLayer.html"
---
# YMKLayer

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLayer.html)

```objectivec
@interface YMKLayer : NSObject
```

Interface for working with the layer.

## Summary

### Instance methods

```objectivec
- (void)remove;
```

Removes the layer from the map

```objectivec
- (nonnull YMKDataSourceLayer *)dataSourceLayer;
```

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### remove

```objectivec
- (void)remove;
```

Removes the layer from the map. The object becomes invalid after that.

### dataSourceLayer

```objectivec
- (nonnull YMKDataSourceLayer *)dataSourceLayer;
```

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
