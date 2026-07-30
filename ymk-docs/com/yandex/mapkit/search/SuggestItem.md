---
title: "SuggestItem"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SuggestItem"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SuggestItem.html"
---
# SuggestItem

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SuggestItem.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.SuggestItem

`class SuggestItem implements Serializable`

A single suggested item.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static final` | [Type](SuggestItem_Type.md) | Suggest item type. |
| `static final` | [Action](SuggestItem_Action.md) | Action to be performed when user selected suggest item. |
| `static final` | [BusinessContext](SuggestItem_BusinessContext.md) | More detailed info about type=Business response |

## Summary

### Constructors

**Signature and Description**

```java
SuggestItem()
```

Use constructor with parameters in your code.

```java
SuggestItem(@NonNull Type type,
            @NonNull SpannableString title,
            @Nullable SpannableString subtitle,
            @NonNull java.util.List<java.lang.String> tags,
            @NonNull java.lang.String searchText,
            @Nullable java.lang.String displayText,
            @Nullable java.lang.String uri,
            @Nullable java.lang.String link,
            @Nullable LocalizedValue distance,
            boolean isPersonal,
            @NonNull Action action,
            @Nullable java.lang.String logId,
            boolean isOffline,
            boolean isWordItem,
            @NonNull java.util.List<KeyValuePair> properties,
            @Nullable Point center,
            @Nullable BusinessContext businessContext)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Type` | `getType()`<br>Suggested object type. |
| `synchronized SpannableString` | `getTitle()`<br>Short object name. |
| `synchronized SpannableString` | `getSubtitle()`<br>If type is TOPONYM returns reversed toponym hierarchy, if type is BUSINESS returns business address. |
| `synchronized java.util.List<java.lang.String>` | `getTags()`<br>Additional free-form data for suggest item. |
| `synchronized java.lang.String` | `getSearchText()`<br>Text to search for. |
| `synchronized java.lang.String` | `getDisplayText()`<br>Text to display if searchText is too technical to display. |
| `synchronized java.lang.String` | `getUri()`<br>Element uri, if applicable. |
| `synchronized java.lang.String` | `getLink()`<br>Element link, if applicable. |
| `synchronized LocalizedValue` | `getDistance()`<br>Optional distance localized value. |
| `synchronized boolean` | `getIsPersonal()`<br>If the suggested item respects personalization. |
| `synchronized Action` | `getAction()`<br>Action to perform on click/tap/enter. |
| `synchronized java.lang.String` | `getLogId()`<br>Id for request logging. |
| `synchronized boolean` | `getIsOffline()`<br>Item is from offline search. |
| `synchronized boolean` | `getIsWordItem()`<br>Item is a word suggest item. |
| `synchronized java.util.List<KeyValuePair>` | `getProperties()`<br>Additional item properties. |
| `synchronized Point` | `getCenter()`<br>Position of object. |
| `synchronized BusinessContext` | `getBusinessContext()`<br>Detailed subtype of the Business type<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### SuggestItem

```java
SuggestItem()
```

Use constructor with parameters in your code.

This one is for serialization only!

### SuggestItem

```java
SuggestItem(@NonNull Type type,
            @NonNull SpannableString title,
            @Nullable SpannableString subtitle,
            @NonNull java.util.List<java.lang.String> tags,
            @NonNull java.lang.String searchText,
            @Nullable java.lang.String displayText,
            @Nullable java.lang.String uri,
            @Nullable java.lang.String link,
            @Nullable LocalizedValue distance,
            boolean isPersonal,
            @NonNull Action action,
            @Nullable java.lang.String logId,
            boolean isOffline,
            boolean isWordItem,
            @NonNull java.util.List<KeyValuePair> properties,
            @Nullable Point center,
            @Nullable BusinessContext businessContext)
```

## Methods

### getType

```java
@NonNull
Type getType()
```

Suggested object type.

### getTitle

```java
@NonNull
SpannableString getTitle()
```

Short object name.

### getSubtitle

```java
@Nullable
SpannableString getSubtitle()
```

If type is TOPONYM returns reversed toponym hierarchy, if type is BUSINESS returns business address.

Optional field, can be null.

### getTags

```java
@NonNull
java.util.List<java.lang.String> getTags()
```

Additional free-form data for suggest item.

If type is TOPONYM, returns toponym kind (house/street/locality/...). If type is BUSINESS, returns category class (drugstores/restaurants/...).

### getSearchText

```java
@NonNull
java.lang.String getSearchText()
```

Text to search for.

### getDisplayText

```java
@Nullable
java.lang.String getDisplayText()
```

Text to display if searchText is too technical to display.

Optional field, can be null.

### getUri

```java
@Nullable
java.lang.String getUri()
```

Element uri, if applicable.

Optional field, can be null.

### getLink

```java
@Nullable
java.lang.String getLink()
```

Element link, if applicable.

Optional field, can be null.

### getDistance

```java
@Nullable
LocalizedValue getDistance()
```

Optional distance localized value.

Optional field, can be null.

### getIsPersonal

```java
boolean getIsPersonal()
```

If the suggested item respects personalization.

### getAction

```java
@NonNull
Action getAction()
```

Action to perform on click/tap/enter.

### getLogId

```java
@Nullable
java.lang.String getLogId()
```

Id for request logging.

Optional field, can be null.

### getIsOffline

```java
boolean getIsOffline()
```

Item is from offline search.

### getIsWordItem

```java
boolean getIsWordItem()
```

Item is a word suggest item.

### getProperties

```java
@NonNull
java.util.List<KeyValuePair> getProperties()
```

Additional item properties.

### getCenter

```java
@Nullable
Point getCenter()
```

Position of object.

Optional field, can be null.

### getBusinessContext

```java
@Nullable
BusinessContext getBusinessContext()
```

Detailed subtype of the Business type

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
