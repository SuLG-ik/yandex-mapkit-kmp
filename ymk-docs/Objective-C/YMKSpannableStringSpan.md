---
title: "YMKSpannableStringSpan"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSpannableStringSpan"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSpannableStringSpan.html"
---
# YMKSpannableStringSpan

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSpannableStringSpan.html)

```objectivec
@interface YMKSpannableStringSpan : NSObject
```

A span of text in the SpannableString.

## Summary

### Class methods

```objectivec
+ (nonnull YMKSpannableStringSpan *)spanWithBegin:( NSInteger)begin
                                              end:( NSInteger)end;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSInteger begin;
```

The index of the beginning symbol of the span

```objectivec
@property (nonatomic, readonly) NSInteger end;
```

The index of the ending symbol of the span

## Class methods

### spanWithBegin:end:

```objectivec
+ (nonnull YMKSpannableStringSpan *)spanWithBegin:( NSInteger)begin
                                              end:( NSInteger)end;
```

## Properties

### begin

```objectivec
@property (nonatomic, readonly) NSInteger begin;
```

The index of the beginning symbol of the span.

### end

```objectivec
@property (nonatomic, readonly) NSInteger end;
```

The index of the ending symbol of the span.
