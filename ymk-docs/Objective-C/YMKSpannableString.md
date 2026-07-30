---
title: "YMKSpannableString"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSpannableString"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSpannableString.html"
---
# YMKSpannableString

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSpannableString.html)

```objectivec
@interface YMKSpannableString : NSObject
```

A string that supports spans in it.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSpannableString *)spannableStringWithText:(nonnull NSString *)text
                                                  spans:(nonnull NSArray<YMKSpannableStringSpan *> *)spans;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

The text of the spannable string

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSpannableStringSpan *> *spans;
```

The spans in stored text

## Class methods

### spannableStringWithText:spans:

```objectivec
+ (nonnull YMKSpannableString *)spannableStringWithText:(nonnull NSString *)text
                                                  spans:(nonnull NSArray<YMKSpannableStringSpan *> *)spans;
```

## Properties

### text

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

The text of the spannable string.

### spans

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKSpannableStringSpan *> *spans;
```

The spans in stored text.
