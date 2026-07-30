---
title: "YMKSuggestResponse"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSuggestResponse"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSuggestResponse.html"
---
# YMKSuggestResponse

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSuggestResponse.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSuggestResponse : NSObject
```

A suggest response

## Summary

### Class methods

```objectivec
+ (nonnull YMKSuggestResponse *)suggestResponseWithItems:(nonnull NSArray<YMKSuggestItem *> *)items;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSuggestItem *> *items;
```

Suggest items

## Class methods

### suggestResponseWithItems:

```objectivec
+ (nonnull YMKSuggestResponse *)suggestResponseWithItems:(nonnull NSArray<YMKSuggestItem *> *)items;
```

## Properties

### items

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSuggestItem *> *items;
```

Suggest items.
