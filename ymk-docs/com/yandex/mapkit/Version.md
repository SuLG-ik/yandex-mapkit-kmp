---
title: "Version"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / Version"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Version.html"
---
# Version

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Version.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.Version

`class Version implements Serializable`

Dot-separated version string.

Alphabetical symbols are ignored without errors.

Examples of correct versions: "1.2.3", "2.0.0-2", "2014.04.25", "42".

## Summary

### Constructors

**Signature and Description**

```java
Version(@NonNull java.lang.String str)
```

```java
Version()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getStr()`<br>Version string. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Version

```java
Version(@NonNull java.lang.String str)
```

### Version

```java
Version()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getStr

```java
@NonNull
java.lang.String getStr()
```

Version string.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
