---
title: "SubtitleItem"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SubtitleItem"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SubtitleItem.html"
---
# SubtitleItem

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SubtitleItem.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.SubtitleItem

`class SubtitleItem implements Serializable`

Separate subtitle of a certain type.

## Summary

### Constructors

**Signature and Description**

```java
SubtitleItem()
```

Use constructor with parameters in your code.

```java
SubtitleItem(@NonNull java.lang.String type,
             @Nullable java.lang.String text,
             @NonNull java.util.List<KeyValuePair> properties)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getType()`<br>Subtitle type. |
| `synchronized java.lang.String` | `getText()`<br>Short summary text. |
| `synchronized java.util.List<KeyValuePair>` | `getProperties()`<br>Detailed subtitle info. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### SubtitleItem

```java
SubtitleItem()
```

Use constructor with parameters in your code.

This one is for serialization only!

### SubtitleItem

```java
SubtitleItem(@NonNull java.lang.String type,
             @Nullable java.lang.String text,
             @NonNull java.util.List<KeyValuePair> properties)
```

## Methods

### getType

```java
@NonNull
java.lang.String getType()
```

Subtitle type.

For example, "exchange".

### getText

```java
@Nullable
java.lang.String getText()
```

Short summary text.

For example, "USD 57.69/57.3".

Optional field, can be null.

### getProperties

```java
@NonNull
java.util.List<KeyValuePair> getProperties()
```

Detailed subtitle info.

For example, [ {"key": "currency", "value": "USD"}, {"key": "buy", "value": "57.3"}, {"key": "sell", "value": "57.69"} ].

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
