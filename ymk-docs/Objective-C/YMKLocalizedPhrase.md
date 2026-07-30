---
title: "YMKLocalizedPhrase"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKLocalizedPhrase"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocalizedPhrase.html"
---
# YMKLocalizedPhrase

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLocalizedPhrase.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKLocalizedPhrase : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKLocalizedPhrase *)localizedPhraseWithTokens:(nonnull NSArray<NSNumber *> *)tokens
                                                     text:(nonnull NSString *)text
                                                 language:( YMKAnnotationLanguage)language;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *tokens;
```

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

```objectivec
@property (nonatomic, readonly) YMKAnnotationLanguage language;
```

## Class methods

### localizedPhraseWithTokens:text:language:

```objectivec
+ (nonnull YMKLocalizedPhrase *)localizedPhraseWithTokens:(nonnull NSArray<NSNumber *> *)tokens
                                                     text:(nonnull NSString *)text
                                                 language:( YMKAnnotationLanguage)language;
```

## Properties

### tokens

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *tokens;
```

### text

```objectivec
@property (nonatomic, readonly, nonnull) NSString *text;
```

### language

```objectivec
@property (nonatomic, readonly) YMKAnnotationLanguage language;
```
