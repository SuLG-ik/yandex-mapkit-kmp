---
title: "YMKBaseDataSource"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBaseDataSource"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBaseDataSource.html"
---
# YMKBaseDataSource

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBaseDataSource.html)

```objectivec
@interface YMKBaseDataSource : NSObject
```

## Summary

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Stores id of data source

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Properties

### id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

Stores id of data source.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
