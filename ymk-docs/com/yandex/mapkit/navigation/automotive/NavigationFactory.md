---
title: "NavigationFactory"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / NavigationFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/NavigationFactory.html"
---
# NavigationFactory

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/NavigationFactory.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

java.lang.Object
↳ com.yandex.mapkit.navigation.automotive.NavigationFactory

`class NavigationFactory`

## Summary

### Constructors

**Signature and Description**

```java
NavigationFactory()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static native Navigation` | `createNavigation(@NonNull DrivingRouterType type)`<br>Creates navigation engine with given options. |

## Constuctors

### NavigationFactory

```java
NavigationFactory()
```

## Methods

### createNavigation

```java
@NonNull
Navigation createNavigation(@NonNull DrivingRouterType type)
```

Creates navigation engine with given options.

Each call returns new independent instance of Navigation. Navigation will be in the suspended mode.
