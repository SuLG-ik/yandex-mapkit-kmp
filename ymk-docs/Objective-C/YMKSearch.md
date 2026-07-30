---
title: "YMKSearch"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearch"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearch.html"
---
# YMKSearch

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearch.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearch : NSObject
```

## Summary

### Instance methods

```objectivec
- (nonnull YMKSearchLayer *)createSearchLayerWithMapWindow:
    (nonnull YMKMapWindow *)mapWindow;
```

Gets the search_layer object

```objectivec
- (nonnull YMKSearchManager *)createSearchManagerWithSearchManagerType:
    (YMKSearchManagerType)searchManagerType;
```

Creates a manager that allows to search for various geographical objects using a variety of parameters

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### createSearchLayerWithMapWindow:

```objectivec
- (nonnull YMKSearchLayer *)createSearchLayerWithMapWindow:
    (nonnull YMKMapWindow *)mapWindow;
```

Gets the search_layer object.

### createSearchManagerWithSearchManagerType:

```objectivec
- (nonnull YMKSearchManager *)createSearchManagerWithSearchManagerType:
    (YMKSearchManagerType)searchManagerType;
```

Creates a manager that allows to search for various geographical objects using a variety of parameters.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
