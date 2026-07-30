---
title: "YMKMasstransitPaymentMedia"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitPaymentMedia"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitPaymentMedia.html"
---
# YMKMasstransitPaymentMedia

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitPaymentMedia.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitPaymentMedia : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitPaymentMedia *)paymentMediaWithId:(nonnull NSString *)id
                                                      name:(nullable NSString *)name
                                                      type:( YMKMasstransitPaymentMediaMediaType)type;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

string which identifies the current media, can be used to select icons im maps application

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

Localized name of the media, which is used for payment

```objectivec
@property (nonatomic, readonly) YMKMasstransitPaymentMediaMediaType type;
```

Type of media, which is used for payment

## Class methods

### paymentMediaWithId:name:type:

```objectivec
+ (nonnull YMKMasstransitPaymentMedia *)paymentMediaWithId:(nonnull NSString *)id
                                                      name:(nullable NSString *)name
                                                      type:( YMKMasstransitPaymentMediaMediaType)type;
```

## Properties

### id

```objectivec
@property (nonatomic, readonly, nonnull) NSString *id;
```

string which identifies the current media, can be used to select icons im maps application.

### name

```objectivec
@property (nonatomic, readonly, nullable) NSString *name;
```

Localized name of the media, which is used for payment.

Optional field, can be nil.

### type

```objectivec
@property (nonatomic, readonly) YMKMasstransitPaymentMediaMediaType type;
```

Type of media, which is used for payment.
