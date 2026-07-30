---
title: "YMKPlacemarkPresentation"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPlacemarkPresentation"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPlacemarkPresentation.html"
---
# YMKPlacemarkPresentation

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPlacemarkPresentation.html)

```objectivec
@interface YMKPlacemarkPresentation : NSObject
```

A general interface for placemark presentation objects

## Summary

### Instance methods

```objectivec
- (void)remove;
```

Removes the presentation

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

Removes the presentation. This method invalidates object.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
