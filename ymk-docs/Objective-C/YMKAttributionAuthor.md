---
title: "YMKAttributionAuthor"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKAttributionAuthor"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAttributionAuthor.html"
---
# YMKAttributionAuthor

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAttributionAuthor.html)

```objectivec
@interface YMKAttributionAuthor : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKAttributionAuthor *)authorWithName:(nonnull NSString *)name
                                             uri:(nullable NSString *)uri
                                           email:(nullable NSString *)email;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

```objectivec
@property (nonatomic, readonly, nullable) NSString *uri;
```

A reference to the author's site

```objectivec
@property (nonatomic, readonly, nullable) NSString *email;
```

Author's email

## Class methods

### authorWithName:uri:email:

```objectivec
+ (nonnull YMKAttributionAuthor *)authorWithName:(nonnull NSString *)name
                                             uri:(nullable NSString *)uri
                                           email:(nullable NSString *)email;
```

## Properties

### name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

### uri

```objectivec
@property (nonatomic, readonly, nullable) NSString *uri;
```

A reference to the author's site.

Optional field, can be nil.

### email

```objectivec
@property (nonatomic, readonly, nullable) NSString *email;
```

Author's email. Must contain at least one @ symbol.

Optional field, can be nil.
