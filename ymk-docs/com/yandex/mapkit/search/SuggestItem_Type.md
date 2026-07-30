---
title: "Type"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SuggestItem_Type"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SuggestItem_Type.html"
---
# Type

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SuggestItem_Type.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.search.SuggestItem.Type

`static final enum Type`

Suggest item type.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [UNKNOWN](SuggestItem_Type.md#unknown) | For backward compatibility in future. |
| [TOPONYM](SuggestItem_Type.md#toponym) | City, street, house etc. |
| [BUSINESS](SuggestItem_Type.md#business) | Company with specific location. |
| [TRANSIT](SuggestItem_Type.md#transit) | Public transport route number or transit-related keyword. |
| [LINK](SuggestItem_Type.md#link) | Web link or deep link |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static Type[]` | `values()` |
| `static Type` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### UNKNOWN

|   |   |   |
| --- | --- | --- |
| `static final` | [Type](SuggestItem_Type.md) | UNKNOWN |

For backward compatibility in future.

### TOPONYM

|   |   |   |
| --- | --- | --- |
| `static final` | [Type](SuggestItem_Type.md) | TOPONYM |

City, street, house etc.

### BUSINESS

|   |   |   |
| --- | --- | --- |
| `static final` | [Type](SuggestItem_Type.md) | BUSINESS |

Company with specific location.

### TRANSIT

|   |   |   |
| --- | --- | --- |
| `static final` | [Type](SuggestItem_Type.md) | TRANSIT |

Public transport route number or transit-related keyword.

### LINK

|   |   |   |
| --- | --- | --- |
| `static final` | [Type](SuggestItem_Type.md) | LINK |

Web link or deep link

## Methods

### values

```java
Type[] values()
```

### valueOf

```java
Type valueOf(java.lang.String name)
```
