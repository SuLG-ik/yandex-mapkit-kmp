---
title: "YMKAttribution"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKAttribution"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAttribution.html"
---
# YMKAttribution

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAttribution.html)

```objectivec
@interface YMKAttribution : NSObject
```

Details about the source of information.

## Summary

### Class methods

```objectivec
+ (nonnull YMKAttribution *)attributionWithAuthor:(nullable YMKAttributionAuthor *)author
                                             link:(nullable YMKAttributionLink *)link
                                      avatarImage:(nullable YMKImage *)avatarImage;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) YMKAttributionAuthor *author;
```

Additional information about the author

```objectivec
@property (nonatomic, readonly, nullable) YMKAttributionLink *link;
```

Link to a specific page on the author's site

```objectivec
@property (nonatomic, readonly, nullable) YMKImage *avatarImage;
```

Optional field, can be nil

## Class methods

### attributionWithAuthor:link:avatarImage:

```objectivec
+ (nonnull YMKAttribution *)attributionWithAuthor:(nullable YMKAttributionAuthor *)author
                                             link:(nullable YMKAttributionLink *)link
                                      avatarImage:(nullable YMKImage *)avatarImage;
```

## Properties

### author

```objectivec
@property (nonatomic, readonly, nullable) YMKAttributionAuthor *author;
```

Additional information about the author.

Optional field, can be nil.

### link

```objectivec
@property (nonatomic, readonly, nullable) YMKAttributionLink *link;
```

Link to a specific page on the author's site. To link to the website as a whole, use author.uri.

Optional field, can be nil.

### avatarImage

```objectivec
@property (nonatomic, readonly, nullable) YMKImage *avatarImage;
```

Optional field, can be nil.
