---
title: "NavigationSerialization"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / NavigationSerialization"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/NavigationSerialization.html"
---
# NavigationSerialization

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/NavigationSerialization.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

java.lang.Object
↳ com.yandex.mapkit.navigation.automotive.NavigationSerialization

`class NavigationSerialization`

## Summary

### Constructors

**Signature and Description**

```java
NavigationSerialization()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static native byte[]` | `serialize(@NonNull Navigation navigation)`<br>Serializes a given instance of Navigation. |
| `static native Navigation` | `deserialize(@NonNull byte[] serializedNavigation)`<br>Deserializes a given instance of Navigation. |

## Constuctors

### NavigationSerialization

```java
NavigationSerialization()
```

## Methods

### serialize

```java
@NonNull
byte[] serialize(@NonNull Navigation navigation)
```

Serializes a given instance of Navigation.

### deserialize

```java
@Nullable
Navigation deserialize(@NonNull byte[] serializedNavigation)
```

Deserializes a given instance of Navigation.

Navigation will be in the suspended mode. Returns null if deserialization failed.
