---
title: "ThreadCategory"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / ThreadCategory"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/ThreadCategory.html"
---
# ThreadCategory

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/ThreadCategory.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.transport.masstransit.ThreadCategory

`final enum ThreadCategory`

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [PRIMARY](ThreadCategory.md#primary) | Primary thread |
| [SECONDARY](ThreadCategory.md#secondary) | Secondary thread |
| [TEMPORARY](ThreadCategory.md#temporary) | Temporary thread |
| [TO_DEPOT](ThreadCategory.md#to_depot) | Thread going to depot |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static ThreadCategory[]` | `values()` |
| `static ThreadCategory` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### PRIMARY

|   |   |   |
| --- | --- | --- |
| `static final` | [ThreadCategory](ThreadCategory.md) | PRIMARY |

Primary thread

### SECONDARY

|   |   |   |
| --- | --- | --- |
| `static final` | [ThreadCategory](ThreadCategory.md) | SECONDARY |

Secondary thread

### TEMPORARY

|   |   |   |
| --- | --- | --- |
| `static final` | [ThreadCategory](ThreadCategory.md) | TEMPORARY |

Temporary thread

### TO_DEPOT

|   |   |   |
| --- | --- | --- |
| `static final` | [ThreadCategory](ThreadCategory.md) | TO_DEPOT |

Thread going to depot

## Methods

### values

```java
ThreadCategory[] values()
```

### valueOf

```java
ThreadCategory valueOf(java.lang.String name)
```
