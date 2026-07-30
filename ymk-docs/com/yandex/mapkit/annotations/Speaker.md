---
title: "Speaker"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.annotations"
section: "Android / Справочник / com.yandex.mapkit.annotations / Speaker"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/annotations/Speaker.html"
---
# Speaker

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/annotations/Speaker.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.annotations

`interface Speaker`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `reset()`<br>Stops all speech and forgets all previously scheduled phrases. |
| `void` | `say(@NonNull LocalizedPhrase phrase)`<br>Pronounces the phrase, interrupting the one being spoken now, if neccessary. |
| `double` | `duration(@NonNull LocalizedPhrase phrase)`<br>Returns the phrase duration (how many seconds it takes to pronounce it). |

## Methods

### reset

```java
@UiThread
void reset()
```

Stops all speech and forgets all previously scheduled phrases.

### say

```java
@UiThread
void say(@NonNull LocalizedPhrase phrase)
```

Pronounces the phrase, interrupting the one being spoken now, if neccessary.

### duration

```java
@UiThread
double duration(@NonNull LocalizedPhrase phrase)
```

Returns the phrase duration (how many seconds it takes to pronounce it).
