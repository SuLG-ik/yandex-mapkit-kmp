---
title: "SuggestOptions"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SuggestOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SuggestOptions.html"
---
# SuggestOptions

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SuggestOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.SuggestOptions

`final class SuggestOptions implements Serializable`

Struct to fine-tune suggest request.

## Summary

### Constructors

**Signature and Description**

```java
SuggestOptions(int suggestTypes,
               @Nullable Point userPosition,
               boolean suggestWords,
               boolean strictBounds)
```

```java
SuggestOptions()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getSuggestTypes()`<br>The suggest type can be one of [mapkit.search.SuggestType](SuggestType.md) values or their bitwise 'OR' combination. |
| `SuggestOptions` | `setSuggestTypes(int suggestTypes)`<br>See **#getSuggestTypes()**. |
| `Point` | `getUserPosition()`<br>The server uses the user position to calculate the distance from the user to suggest results. |
| `SuggestOptions` | `setUserPosition(@Nullable Point userPosition)`<br>See **#getUserPosition()**. |
| `boolean` | `getSuggestWords()`<br>Enable word-by-word suggestion items. |
| `SuggestOptions` | `setSuggestWords(boolean suggestWords)`<br>See **#getSuggestWords()**. |
| `boolean` | `getStrictBounds()`<br>Strictly limit the output and keep only objects that fall within the window. |
| `SuggestOptions` | `setStrictBounds(boolean strictBounds)`<br>See **#getStrictBounds()**. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### SuggestOptions

```java
SuggestOptions(int suggestTypes,
               @Nullable Point userPosition,
               boolean suggestWords,
               boolean strictBounds)
```

### SuggestOptions

```java
SuggestOptions()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getSuggestTypes

```java
int getSuggestTypes()
```

The suggest type can be one of [mapkit.search.SuggestType](SuggestType.md) values or their bitwise 'OR' combination.

If suggestType is not initialized, it means to use server-defined types.

### setSuggestTypes

```java
SuggestOptions setSuggestTypes(int suggestTypes)
```

See **#getSuggestTypes()**.

### getUserPosition

```java
@Nullable
Point getUserPosition()
```

The server uses the user position to calculate the distance from the user to suggest results.

Optional field, can be null.

### setUserPosition

```java
SuggestOptions setUserPosition(@Nullable Point userPosition)
```

See **#getUserPosition()**.

### getSuggestWords

```java
boolean getSuggestWords()
```

Enable word-by-word suggestion items.

### setSuggestWords

```java
SuggestOptions setSuggestWords(boolean suggestWords)
```

See **#getSuggestWords()**.

### getStrictBounds

```java
boolean getStrictBounds()
```

Strictly limit the output and keep only objects that fall within the window.

The window is advisory in nature and doesn't impose strict restrictions on search results, helping to select the most relevant hints.

### setStrictBounds

```java
SuggestOptions setStrictBounds(boolean strictBounds)
```

See **#getStrictBounds()**.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
