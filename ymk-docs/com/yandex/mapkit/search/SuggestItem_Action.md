---
title: "Action"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SuggestItem_Action"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SuggestItem_Action.html"
---
# Action

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SuggestItem_Action.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.search.SuggestItem.Action

`static final enum Action`

Action to be performed when user selected suggest item.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [SEARCH](SuggestItem_Action.md#search) | Immediately search for `text`. |
| [SUBSTITUTE](SuggestItem_Action.md#substitute) | Substitute query by `text` for further editing. |
| [FOLLOW_LINK](SuggestItem_Action.md#follow_link) | Exit suggest session and open link |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static Action[]` | `values()` |
| `static Action` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### SEARCH

|   |   |   |
| --- | --- | --- |
| `static final` | [Action](SuggestItem_Action.md) | SEARCH |

Immediately search for `text`.

### SUBSTITUTE

|   |   |   |
| --- | --- | --- |
| `static final` | [Action](SuggestItem_Action.md) | SUBSTITUTE |

Substitute query by `text` for further editing.

### FOLLOW_LINK

|   |   |   |
| --- | --- | --- |
| `static final` | [Action](SuggestItem_Action.md) | FOLLOW_LINK |

Exit suggest session and open link

## Methods

### values

```java
Action[] values()
```

### valueOf

```java
Action valueOf(java.lang.String name)
```
