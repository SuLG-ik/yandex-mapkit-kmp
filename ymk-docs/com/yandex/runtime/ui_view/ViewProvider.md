---
title: "ViewProvider"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.runtime.ui_view"
section: "Android / Справочник / com.yandex.runtime.ui_view / ViewProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/ui_view/ViewProvider.html"
---
# ViewProvider

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/ui_view/ViewProvider.html)

**Package** com.yandex.runtime.ui_view

java.lang.Object
↳ com.yandex.runtime.ui_view.ViewProvider

`class ViewProvider`

This class can be used to associate any custom view with PlacemarkMapObject Snapshot of provided view is taken in constructor and updated any time snapshot method is called by user

## Summary

### Constructors

**Signature and Description**

```java
ViewProvider(android.view.View view,
             boolean cacheable)
```

Constructor of ViewProvider.

```java
ViewProvider(android.view.View view)
```

Constructor of ViewProvider.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getId()`<br>Unique ID of the view provider. |
| `boolean` | `isCacheable()`<br>True if view provider is cacheable. |
| `void` | `snapshot()`<br>Takes a snapshot of the given view. |

## Constuctors

### ViewProvider

```java
ViewProvider(android.view.View view,
             boolean cacheable)
```

Constructor of ViewProvider.

Attention: Blocks the UI by executing the snapshot function.

| Parameters |   |
| --- | --- |
| `view` | Any custom user defined View. |
| `cacheable` | Weather provided view snapshot should be cached in internal cache. |

### ViewProvider

```java
ViewProvider(android.view.View view)
```

Constructor of ViewProvider.

Cacheable flag will be set True value by default. Attention: Blocks the UI by executing the snapshot function.

| Parameters |   |
| --- | --- |
| `view` | Any custom user defined View. |

## Methods

### getId

```java
java.lang.String getId()
```

Unique ID of the view provider.

### isCacheable

```java
boolean isCacheable()
```

True if view provider is cacheable.

False otherwise.

### snapshot

```java
void snapshot()
```

Takes a snapshot of the given view.

Attention: This blocks the UI.
