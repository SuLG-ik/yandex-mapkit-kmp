---
title: "YMKPlacemarkText"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPlacemarkText"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPlacemarkText.html"
---
# YMKPlacemarkText

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPlacemarkText.html)

```objectivec
@interface YMKPlacemarkText : NSObject
```

Provides an interface to set text and its style for a placemark.

## Summary

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    NSString *text;
```

UTF-8 encoded text to be displayed with the PlacemarkMapObject Empty string means no text

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKTextStyle *style;
```

The style properties (size, color, etc

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Properties

### text

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    NSString *text;
```

UTF-8 encoded text to be displayed with the PlacemarkMapObject Empty string means no text

### style

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKTextStyle *style;
```

The style properties (size, color, etc.) of the placemark text. Note: The current style cannot be modified directly - you must reset it to apply changes.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
