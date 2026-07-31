---
title: "YMKSearchOptions"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchOptions.html"
---
# YMKSearchOptions

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchOptions : NSObject
```

Struct to fine-tune search request.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSearchOptions *)searchOptionsWithSearchTypes:( YMKSearchType)searchTypes
                                            resultPageSize:(nullable NSNumber *)resultPageSize
                                                  snippets:( YMKSearchSnippet)snippets
                                              userPosition:(nullable YMKPoint *)userPosition
                                                    origin:(nullable NSString *)origin
                                                  geometry:( BOOL)geometry
                                 disableSpellingCorrection:( BOOL)disableSpellingCorrection
                                                   filters:(nullable YMKSearchFilterCollection *)filters;
```

### Instance methods

```objectivec
- (nonnull YMKSearchOptions *)init;
```

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKSearchType searchTypes;
```

The search type can be one of the YMKSearchType values or their bitwise 'OR' combination

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *resultPageSize;
```

Maximum number of search results per page

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKSearchSnippet snippets;
```

Snippets that will be requested

```objectivec
@property (nonatomic, strong, readwrite, nullable) YMKPoint *userPosition;
```

The server uses the user position to calculate the distance from the user to search results

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSString *origin;
```

String that sets an identifier for the request source

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL geometry;
```

Adds the geometry to the server response

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    BOOL disableSpellingCorrection;
```

Force disable correction of spelling mistakes

```objectivec
@property (nonatomic, strong, readwrite, nullable)
    YMKSearchFilterCollection *filters;
```

Filter set that will be requested

## Class methods

### searchOptionsWithSearchTypes:resultPageSize:snippets:userPosition:origin:geometry:disableSpellingCorrection:filters:

```objectivec
+ (nonnull YMKSearchOptions *)searchOptionsWithSearchTypes:( YMKSearchType)searchTypes
                                            resultPageSize:(nullable NSNumber *)resultPageSize
                                                  snippets:( YMKSearchSnippet)snippets
                                              userPosition:(nullable YMKPoint *)userPosition
                                                    origin:(nullable NSString *)origin
                                                  geometry:( BOOL)geometry
                                 disableSpellingCorrection:( BOOL)disableSpellingCorrection
                                                   filters:(nullable YMKSearchFilterCollection *)filters;
```

## Instance methods

### init

```objectivec
- (nonnull YMKSearchOptions *)init;
```

## Properties

### searchTypes

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKSearchType searchTypes;
```

The search type can be one of the YMKSearchType values or their bitwise 'OR' combination. If searchType is not initialized, it means to search in all the sources.

### resultPageSize

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSNumber *resultPageSize;
```

Maximum number of search results per page.

Optional field, can be nil.

### snippets

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKSearchSnippet snippets;
```

Snippets that will be requested. The value should be one of YMKSearchSnippet, or their bitwise 'OR' combination.

### userPosition

```objectivec
@property (nonatomic, strong, readwrite, nullable) YMKPoint *userPosition;
```

The server uses the user position to calculate the distance from the user to search results.

Optional field, can be nil.

### origin

```objectivec
@property (nonatomic, copy, readwrite, nullable) NSString *origin;
```

String that sets an identifier for the request source.

Optional field, can be nil.

### geometry

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL geometry;
```

Adds the geometry to the server response.

### disableSpellingCorrection

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    BOOL disableSpellingCorrection;
```

Force disable correction of spelling mistakes.

### filters

```objectivec
@property (nonatomic, strong, readwrite, nullable)
    YMKSearchFilterCollection *filters;
```

Filter set that will be requested. Please note that the full set of filters that can be applied can only be obtained after the primary request. If you pass an invalid filter to the primary request (for example, "pharmacy with swimming pool"), the behavior is undefined. That is the search can either ignore an invalid filter or return an empty response.

Optional field, can be nil.
