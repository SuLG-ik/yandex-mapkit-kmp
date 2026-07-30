---
title: "YMKObjectEvent"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKObjectEvent"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKObjectEvent.html"
---
# YMKObjectEvent

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKObjectEvent.html)

```objectivec
@interface YMKObjectEvent : NSObject
```

Base abstract class for an object event. Layers that produce object event callbacks need to provide derived event classes.

## Summary

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
