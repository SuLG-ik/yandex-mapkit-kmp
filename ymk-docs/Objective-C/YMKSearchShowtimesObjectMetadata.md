---
title: "YMKSearchShowtimesObjectMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchShowtimesObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchShowtimesObjectMetadata.html"
---
# YMKSearchShowtimesObjectMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchShowtimesObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchShowtimesObjectMetadata : NSObject <YMKBaseMetadata>
```

Event schedule snippet.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchShowtimesObjectMetadata *)showtimesObjectMetadataWithTitle:(nonnull NSString *)title
                                                                     showtimes:(nonnull NSArray<YMKSearchShowtime *> *)showtimes;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *title;
```

Event title

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSearchShowtime *> *showtimes;
```

List of showtimes

## Class methods

### showtimesObjectMetadataWithTitle:showtimes:

```objectivec
+ (nonnull YMKSearchShowtimesObjectMetadata *)showtimesObjectMetadataWithTitle:(nonnull NSString *)title
                                                                     showtimes:(nonnull NSArray<YMKSearchShowtime *> *)showtimes;
```

## Properties

### title

```objectivec
@property (nonatomic, readonly, nonnull) NSString *title;
```

Event title.

### showtimes

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSearchShowtime *> *showtimes;
```

List of showtimes.
