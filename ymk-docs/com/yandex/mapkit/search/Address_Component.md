---
title: "Component"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Address_Component"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Address_Component.html"
---
# Component

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Address_Component.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Address.Component

`static class Component implements Serializable`

Single address component.

Component represents a single entry in the administrative hierarchy of the address.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static final` | [Kind](Component_Address_Kind.md) | An address component kind, for example, large administrative area. |

## Summary

### Constructors

**Signature and Description**

```java
Component()
```

Use constructor with parameters in your code.

```java
Component(@NonNull java.lang.String name,
          @NonNull java.util.List<Kind> kinds)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getName()`<br>Component name. |
| `synchronized java.util.List<Kind>` | `getKinds()`<br>Component kinds. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Component

```java
Component()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Component

```java
Component(@NonNull java.lang.String name,
          @NonNull java.util.List<Kind> kinds)
```

## Methods

### getName

```java
@NonNull
java.lang.String getName()
```

Component name.

### getKinds

```java
@NonNull
java.util.List<Kind> getKinds()
```

Component kinds.

May contain both general and specific kind, for example [mapkit.search.Address.Component.Kind#STATION](Component_Address_Kind.md#station) and [mapkit.search.Address.Component.Kind#METRO_STATION](Component_Address_Kind.md#metro_station).

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
