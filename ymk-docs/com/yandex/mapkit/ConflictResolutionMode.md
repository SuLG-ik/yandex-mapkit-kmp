---
title: "ConflictResolutionMode"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / ConflictResolutionMode"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/ConflictResolutionMode.html"
---
# ConflictResolutionMode

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/ConflictResolutionMode.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.ConflictResolutionMode

`final enum ConflictResolutionMode`

Determines how feature participates in conflict resolution.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [MINOR](ConflictResolutionMode.md#minor) | Feature can be hidden (if supported) due to conflict with higher feature but will not conflict with lower features. |
| [EQUAL](ConflictResolutionMode.md#equal) | Feature can be hidden (if supported) due to conflict with higher feature and can displace lower features. |
| [MAJOR](ConflictResolutionMode.md#major) | Feature can NOT be hidden but can displace lower features. |
| [IGNORE](ConflictResolutionMode.md#ignore) | Feature doesn't participate in conflict resolution. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static ConflictResolutionMode[]` | `values()` |
| `static ConflictResolutionMode` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### MINOR

|   |   |   |
| --- | --- | --- |
| `static final` | [ConflictResolutionMode](ConflictResolutionMode.md) | MINOR |

Feature can be hidden (if supported) due to conflict with higher feature but will not conflict with lower features.

### EQUAL

|   |   |   |
| --- | --- | --- |
| `static final` | [ConflictResolutionMode](ConflictResolutionMode.md) | EQUAL |

Feature can be hidden (if supported) due to conflict with higher feature and can displace lower features.

### MAJOR

|   |   |   |
| --- | --- | --- |
| `static final` | [ConflictResolutionMode](ConflictResolutionMode.md) | MAJOR |

Feature can NOT be hidden but can displace lower features.

### IGNORE

|   |   |   |
| --- | --- | --- |
| `static final` | [ConflictResolutionMode](ConflictResolutionMode.md) | IGNORE |

Feature doesn't participate in conflict resolution.

## Methods

### values

```java
ConflictResolutionMode[] values()
```

### valueOf

```java
ConflictResolutionMode valueOf(java.lang.String name)
```
