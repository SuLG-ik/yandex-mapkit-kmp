---
title: "Precision"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Precision"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Precision.html"
---
# Precision

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Precision.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.search.Precision

`final enum Precision`

Precision for matching house numbers (response vs.

request).

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [EXACT](Precision.md#exact) | The house number in the response is exactly the same as requested (3/2 vs. |
| [NUMBER](Precision.md#number) | The house number in the response has the same number part as the requested one (5 vs. |
| [RANGE](Precision.md#range) | The house number and coordinates are restored from the house range. |
| [NEARBY](Precision.md#nearby) | The house number in the response is close to the requested one (13 vs. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static Precision[]` | `values()` |
| `static Precision` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### EXACT

|   |   |   |
| --- | --- | --- |
| `static final` | [Precision](Precision.md) | EXACT |

The house number in the response is exactly the same as requested (3/2 vs.

3/2)

### NUMBER

|   |   |   |
| --- | --- | --- |
| `static final` | [Precision](Precision.md) | NUMBER |

The house number in the response has the same number part as the requested one (5 vs.

5a).

### RANGE

|   |   |   |
| --- | --- | --- |
| `static final` | [Precision](Precision.md) | RANGE |

The house number and coordinates are restored from the house range.

This means that there is no information about this specific house, but there is information about a range of houses to infer house position from.

### NEARBY

|   |   |   |
| --- | --- | --- |
| `static final` | [Precision](Precision.md) | NEARBY |

The house number in the response is close to the requested one (13 vs.

11).

## Methods

### values

```java
Precision[] values()
```

### valueOf

```java
Precision valueOf(java.lang.String name)
```
