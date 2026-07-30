---
title: "YMKSpeaker"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKSpeaker"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSpeaker.html"
---
# YMKSpeaker

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSpeaker.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKSpeaker : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func reset()
```

Stops all speech and forgets all previously scheduled phrases

```swift
func say(with phrase: YMKLocalizedPhrase)
```

Pronounces the phrase, interrupting the one being spoken now, if neccessary

```swift
func duration(with phrase: YMKLocalizedPhrase) -> Double
```

Returns the phrase duration (how many seconds it takes to pronounce it)

## Instance methods

### reset()

```swift
func reset()
```

Stops all speech and forgets all previously scheduled phrases.

### say(with:)

```swift
func say(with phrase: YMKLocalizedPhrase)
```

Pronounces the phrase, interrupting the one being spoken now, if neccessary.

### duration(with:)

```swift
func duration(with phrase: YMKLocalizedPhrase) -> Double
```

Returns the phrase duration (how many seconds it takes to pronounce it).
