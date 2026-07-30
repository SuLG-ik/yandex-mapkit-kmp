---
title: "YMKSearchSubtitleItem"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchSubtitleItem"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchSubtitleItem.html"
---
# YMKSearchSubtitleItem

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchSubtitleItem.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchSubtitleItem : NSObject
```

Separate subtitle of a certain type.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchSubtitleItem *)subtitleItemWithType:(nonnull NSString *)type
                                                   text:(nullable NSString *)text
                                             properties:(nonnull NSArray<YRTKeyValuePair *> *)properties;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *type;
```

Subtitle type

```objectivec
@property (nonatomic, readonly, nullable) NSString *text;
```

Short summary text

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YRTKeyValuePair *> *properties;
```

Detailed subtitle info

## Class methods

### subtitleItemWithType:text:properties:

```objectivec
+ (nonnull YMKSearchSubtitleItem *)subtitleItemWithType:(nonnull NSString *)type
                                                   text:(nullable NSString *)text
                                             properties:(nonnull NSArray<YRTKeyValuePair *> *)properties;
```

## Properties

### type

```objectivec
@property (nonatomic, readonly, nonnull) NSString *type;
```

Subtitle type. For example, "exchange".

### text

```objectivec
@property (nonatomic, readonly, nullable) NSString *text;
```

Short summary text. For example, "USD 57.69/57.3".

Optional field, can be nil.

### properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YRTKeyValuePair *> *properties;
```

Detailed subtitle info. For example, [ {"key": "currency", "value": "USD"}, {"key": "buy", "value": "57.3"}, {"key": "sell", "value": "57.69"} ].
