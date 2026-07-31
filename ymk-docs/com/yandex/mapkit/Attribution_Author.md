---
title: "Author"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / Attribution_Author"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Attribution_Author.html"
---
# Author

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/Attribution_Author.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.Attribution.Author

`static class Author implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
Author(@NonNull java.lang.String name,
       @Nullable java.lang.String uri,
       @Nullable java.lang.String email)
```

```java
Author()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getName()` |
| `java.lang.String` | `getUri()`<br>A reference to the author's site. |
| `java.lang.String` | `getEmail()`<br>Author's email. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Author

```java
Author(@NonNull java.lang.String name,
       @Nullable java.lang.String uri,
       @Nullable java.lang.String email)
```

### Author

```java
Author()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getName

```java
@NonNull
java.lang.String getName()
```

### getUri

```java
@Nullable
java.lang.String getUri()
```

A reference to the author's site.

Optional field, can be null.

### getEmail

```java
@Nullable
java.lang.String getEmail()
```

Author's email.

Must contain at least one @ symbol.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
