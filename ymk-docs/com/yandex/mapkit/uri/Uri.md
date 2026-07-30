---
title: "Uri"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.uri"
section: "Android / Справочник / com.yandex.mapkit.uri / Uri"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/uri/Uri.html"
---
# Uri

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/uri/Uri.html)

**Package** com.yandex.mapkit.uri

java.lang.Object
↳ com.yandex.mapkit.uri.Uri

`class Uri implements Serializable`

URI that can be used for requests.

## Summary

### Constructors

**Signature and Description**

```java
Uri(@NonNull java.lang.String value)
```

```java
Uri()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getValue()`<br>Gets URI. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Uri

```java
Uri(@NonNull java.lang.String value)
```

### Uri

```java
Uri()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getValue

```java
@NonNull
java.lang.String getValue()
```

Gets URI.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
