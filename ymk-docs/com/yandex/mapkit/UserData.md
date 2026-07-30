---
title: "UserData"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / UserData"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/UserData.html"
---
# UserData

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/UserData.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.UserData

## All Superinterfaces:

*[BaseMetadata](BaseMetadata.md)*

`class UserData implements BaseMetadata, Serializable`

Describes data attached to features in user layer.

## Summary

### Constructors

**Signature and Description**

```java
UserData()
```

Use constructor with parameters in your code.

```java
UserData(@NonNull java.util.Map<java.lang.String, java.lang.String> data)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.Map<java.lang.String, java.lang.String>` | `getData()`<br>A dictionary of data. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### UserData

```java
UserData()
```

Use constructor with parameters in your code.

This one is for serialization only!

### UserData

```java
UserData(@NonNull java.util.Map<java.lang.String, java.lang.String> data)
```

## Methods

### getData

```java
@NonNull
java.util.Map<java.lang.String, java.lang.String> getData()
```

A dictionary of data.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
