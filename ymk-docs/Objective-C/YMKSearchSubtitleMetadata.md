---
title: "YMKSearchSubtitleMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchSubtitleMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchSubtitleMetadata.html"
---
# YMKSearchSubtitleMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchSubtitleMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchSubtitleMetadata : NSObject <YMKBaseMetadata>
```

Subtitle snippet.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchSubtitleMetadata *)subtitleMetadataWithSubtitleItems:(nonnull NSArray<YMKSearchSubtitleItem *> *)subtitleItems
                                                       serpSubtitleItems:(nonnull NSArray<YMKSearchSubtitleItem *> *)serpSubtitleItems;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchSubtitleItem *> *subtitleItems;
```

List of subtitles

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchSubtitleItem *> *serpSubtitleItems;
```

List of subtitles to be displayed in SERP

## Class methods

### subtitleMetadataWithSubtitleItems:serpSubtitleItems:

```objectivec
+ (nonnull YMKSearchSubtitleMetadata *)subtitleMetadataWithSubtitleItems:(nonnull NSArray<YMKSearchSubtitleItem *> *)subtitleItems
                                                       serpSubtitleItems:(nonnull NSArray<YMKSearchSubtitleItem *> *)serpSubtitleItems;
```

## Properties

### subtitleItems

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchSubtitleItem *> *subtitleItems;
```

List of subtitles.

### serpSubtitleItems

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSearchSubtitleItem *> *serpSubtitleItems;
```

List of subtitles to be displayed in SERP.
