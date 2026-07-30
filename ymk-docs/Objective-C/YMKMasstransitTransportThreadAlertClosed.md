---
title: "YMKMasstransitTransportThreadAlertClosed"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitTransportThreadAlertClosed"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransportThreadAlertClosed.html"
---
# YMKMasstransitTransportThreadAlertClosed

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransportThreadAlertClosed.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitTransportThreadAlertClosed : NSObject
```

Thread is not operational on that day.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitTransportThreadAlertClosed *)closedWithDummy:( BOOL)dummy;
```

### Properties

```objectivec
@property (nonatomic, readonly) BOOL dummy;
```

Dummy field which is used here because IDL does not support structs without fields

## Class methods

### closedWithDummy:

```objectivec
+ (nonnull YMKMasstransitTransportThreadAlertClosed *)closedWithDummy:( BOOL)dummy;
```

## Properties

### dummy

```objectivec
@property (nonatomic, readonly) BOOL dummy;
```

Dummy field which is used here because IDL does not support structs without fields.
