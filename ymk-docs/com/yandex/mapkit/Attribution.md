---
title: "Attribution"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / Attribution"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Attribution.html"
---
# Attribution

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Attribution.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.Attribution

`class Attribution implements Serializable`

Details about the source of information.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [Author](Attribution_Author.md) |   |
| `static` | [Link](Attribution_Link.md) |   |

## Summary

### Constructors

**Signature and Description**

```java
Attribution()
```

Use constructor with parameters in your code.

```java
Attribution(@Nullable Author author,
            @Nullable Link link,
            @Nullable Image avatarImage)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Author` | `getAuthor()`<br>Additional information about the author. |
| `synchronized Link` | `getLink()`<br>Link to a specific page on the author's site. |
| `synchronized Image` | `getAvatarImage()`<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Attribution

```java
Attribution()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Attribution

```java
Attribution(@Nullable Author author,
            @Nullable Link link,
            @Nullable Image avatarImage)
```

## Methods

### getAuthor

```java
@Nullable
Author getAuthor()
```

Additional information about the author.

Optional field, can be null.

### getLink

```java
@Nullable
Link getLink()
```

Link to a specific page on the author's site.

To link to the website as a whole, use author.uri.

Optional field, can be null.

### getAvatarImage

```java
@Nullable
Image getAvatarImage()
```

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
