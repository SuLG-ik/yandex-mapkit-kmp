---
title: "YMKSubpolyline"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSubpolyline"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSubpolyline.html"
---
# YMKSubpolyline

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSubpolyline.html)

```objectivec
@interface YMKSubpolyline : NSObject
```

A part of a polyline.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSubpolyline *)subpolylineWithBegin:(nonnull YMKPolylinePosition *)begin
                                             end:(nonnull YMKPolylinePosition *)end;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *begin;
```

The start of the selected part of the polyline

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *end;
```

The end of the selected part of the polyline

## Class methods

### subpolylineWithBegin:end:

```objectivec
+ (nonnull YMKSubpolyline *)subpolylineWithBegin:(nonnull YMKPolylinePosition *)begin
                                             end:(nonnull YMKPolylinePosition *)end;
```

## Properties

### begin

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *begin;
```

The start of the selected part of the polyline.

### end

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *end;
```

The end of the selected part of the polyline.
