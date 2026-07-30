---
title: "YMKSearchBusinessRating1xObjectMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchBusinessRating1xObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessRating1xObjectMetadata.html"
---
# YMKSearchBusinessRating1xObjectMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchBusinessRating1xObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchBusinessRating1xObjectMetadata : NSObject <YMKBaseMetadata>
```

Snippet for company ratings. Score from 0 to 5.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchBusinessRating1xObjectMetadata *)businessRating1xObjectMetadataWithRatings:( NSUInteger)ratings
                                                                                       reviews:( NSUInteger)reviews
                                                                                         score:(nullable NSNumber *)score;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSUInteger ratings;
```

Total number of ratings

```objectivec
@property (nonatomic, readonly) NSUInteger reviews;
```

Total number of reviews

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *score;
```

Average rating score for the company (0 to 5)

## Class methods

### businessRating1xObjectMetadataWithRatings:reviews:score:

```objectivec
+ (nonnull YMKSearchBusinessRating1xObjectMetadata *)businessRating1xObjectMetadataWithRatings:( NSUInteger)ratings
                                                                                       reviews:( NSUInteger)reviews
                                                                                         score:(nullable NSNumber *)score;
```

## Properties

### ratings

```objectivec
@property (nonatomic, readonly) NSUInteger ratings;
```

Total number of ratings.

### reviews

```objectivec
@property (nonatomic, readonly) NSUInteger reviews;
```

Total number of reviews.

### score

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *score;
```

Average rating score for the company (0 to 5).

Optional field, can be nil.
