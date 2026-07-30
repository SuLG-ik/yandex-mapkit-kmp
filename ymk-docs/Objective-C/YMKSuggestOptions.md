---
title: "YMKSuggestOptions"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSuggestOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSuggestOptions.html"
---
# YMKSuggestOptions

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSuggestOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSuggestOptions : NSObject
```

Struct to fine-tune suggest request.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSuggestOptions *)suggestOptionsWithSuggestTypes:( YMKSuggestType)suggestTypes
                                                 userPosition:(nullable YMKPoint *)userPosition
                                                 suggestWords:( BOOL)suggestWords
                                                 strictBounds:( BOOL)strictBounds;
```

### Instance methods

```objectivec
- (nonnull YMKSuggestOptions *)init;
```

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKSuggestType suggestTypes;
```

The suggest type can be one of YMKSuggestType values or their bitwise 'OR' combination

```objectivec
@property (nonatomic, strong, readwrite, nullable) YMKPoint *userPosition;
```

The server uses the user position to calculate the distance from the user to suggest results

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL suggestWords;
```

Enable word-by-word suggestion items

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL strictBounds;
```

Strictly limit the output and keep only objects that fall within the window

## Class methods

### suggestOptionsWithSuggestTypes:userPosition:suggestWords:strictBounds:

```objectivec
+ (nonnull YMKSuggestOptions *)suggestOptionsWithSuggestTypes:( YMKSuggestType)suggestTypes
                                                 userPosition:(nullable YMKPoint *)userPosition
                                                 suggestWords:( BOOL)suggestWords
                                                 strictBounds:( BOOL)strictBounds;
```

## Instance methods

### init

```objectivec
- (nonnull YMKSuggestOptions *)init;
```

## Properties

### suggestTypes

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKSuggestType suggestTypes;
```

The suggest type can be one of YMKSuggestType values or their bitwise 'OR' combination. If suggestType is not initialized, it means to use server-defined types.

### userPosition

```objectivec
@property (nonatomic, strong, readwrite, nullable) YMKPoint *userPosition;
```

The server uses the user position to calculate the distance from the user to suggest results.

Optional field, can be nil.

### suggestWords

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL suggestWords;
```

Enable word-by-word suggestion items.

### strictBounds

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) BOOL strictBounds;
```

Strictly limit the output and keep only objects that fall within the window. The window is advisory in nature and doesn't impose strict restrictions on search results, helping to select the most relevant hints.
