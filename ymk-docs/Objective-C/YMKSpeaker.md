---
title: "YMKSpeaker"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKSpeaker"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSpeaker.html"
---
# YMKSpeaker

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSpeaker.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKSpeaker <NSObject>
```

## Summary

### Instance methods

```objectivec
- (void)reset;
```

Stops all speech and forgets all previously scheduled phrases

```objectivec
- (void)sayWithPhrase:(nonnull YMKLocalizedPhrase *)phrase;
```

Pronounces the phrase, interrupting the one being spoken now, if neccessary

```objectivec
- (double)durationWithPhrase:(nonnull YMKLocalizedPhrase *)phrase;
```

Returns the phrase duration (how many seconds it takes to pronounce it)

## Instance methods

### reset

```objectivec
- (void)reset;
```

Stops all speech and forgets all previously scheduled phrases.

### sayWithPhrase:

```objectivec
- (void)sayWithPhrase:(nonnull YMKLocalizedPhrase *)phrase;
```

Pronounces the phrase, interrupting the one being spoken now, if neccessary.

### durationWithPhrase:

```objectivec
- (double)durationWithPhrase:(nonnull YMKLocalizedPhrase *)phrase;
```

Returns the phrase duration (how many seconds it takes to pronounce it).
