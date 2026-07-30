---
title: "SearchManagerType"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SearchManagerType"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SearchManagerType.html"
---
# SearchManagerType

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SearchManagerType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.search.SearchManagerType

`final enum SearchManagerType`

Search manager type.

Describes difference in online/offline search handling.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [ONLINE](SearchManagerType.md#online) | Online search manager. |
| [OFFLINE](SearchManagerType.md#offline) | Offline search manager. |
| [COMBINED](SearchManagerType.md#combined) | Combined search manager. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static SearchManagerType[]` | `values()` |
| `static SearchManagerType` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### ONLINE

|   |   |   |
| --- | --- | --- |
| `static final` | [SearchManagerType](SearchManagerType.md) | ONLINE |

Online search manager.

Always tries to use online search even if network is not available.

### OFFLINE

|   |   |   |
| --- | --- | --- |
| `static final` | [SearchManagerType](SearchManagerType.md) | OFFLINE |

Offline search manager.

Always tries to use offline search even if network is available.

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

### COMBINED

|   |   |   |
| --- | --- | --- |
| `static final` | [SearchManagerType](SearchManagerType.md) | COMBINED |

Combined search manager.

Decision to use online or offline search is based on internal timeout. If server manages to respond within given time, then online search result is returned. Otherwise uses offline search.  Will combine online and offline search result in single session (hence the name). Timeout logic is applied on each resubmit until first response from offline search is returned to the listener. After that timeout is reduced to zero for all following resubmits.

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

## Methods

### values

```java
SearchManagerType[] values()
```

### valueOf

```java
SearchManagerType valueOf(java.lang.String name)
```
