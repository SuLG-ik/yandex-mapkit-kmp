---
title: "YMKAddressRecord"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKAddressRecord"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAddressRecord.html"
---
# YMKAddressRecord

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAddressRecord.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKAddressRecord : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKAddressRecord *)addressRecordWithTitle:(nonnull NSString *)title
                                         description:(nullable NSString *)description
                                             comment:(nullable NSString *)comment
                                             address:(nullable NSString *)address
                                            geometry:(nullable YMKGeometry *)geometry
                                                 uri:(nullable NSString *)uri;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *title;
```

```objectivec
@property (nonatomic, readonly, nullable) NSString *description;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSString *comment;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSString *address;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) YMKGeometry *geometry;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSString *uri;
```

Optional field, can be nil

## Class methods

### addressRecordWithTitle:description:comment:address:geometry:uri:

```objectivec
+ (nonnull YMKAddressRecord *)addressRecordWithTitle:(nonnull NSString *)title
                                         description:(nullable NSString *)description
                                             comment:(nullable NSString *)comment
                                             address:(nullable NSString *)address
                                            geometry:(nullable YMKGeometry *)geometry
                                                 uri:(nullable NSString *)uri;
```

## Properties

### title

```objectivec
@property (nonatomic, readonly, nonnull) NSString *title;
```

### description

```objectivec
@property (nonatomic, readonly, nullable) NSString *description;
```

Optional field, can be nil.

### comment

```objectivec
@property (nonatomic, readonly, nullable) NSString *comment;
```

Optional field, can be nil.

### address

```objectivec
@property (nonatomic, readonly, nullable) NSString *address;
```

Optional field, can be nil.

### geometry

```objectivec
@property (nonatomic, readonly, nullable) YMKGeometry *geometry;
```

Optional field, can be nil.

### uri

```objectivec
@property (nonatomic, readonly, nullable) NSString *uri;
```

Optional field, can be nil.
