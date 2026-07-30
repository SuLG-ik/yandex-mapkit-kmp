---
title: "KeyValuePair"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.runtime"
section: "Android / Справочник / com.yandex.runtime / KeyValuePair"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/KeyValuePair.html"
---
# KeyValuePair

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/KeyValuePair.html)

**Package** com.yandex.runtime

java.lang.Object
↳ com.yandex.runtime.KeyValuePair

`class KeyValuePair implements Serializable`

Universal key-value data.

## Summary

### Constructors

**Signature and Description**

```java
KeyValuePair(@NonNull java.lang.String key,
             @NonNull java.lang.String value)
```

```java
KeyValuePair()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getKey()`<br>Data key. |
| `java.lang.String` | `getValue()`<br>Data value. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### KeyValuePair

```java
KeyValuePair(@NonNull java.lang.String key,
             @NonNull java.lang.String value)
```

### KeyValuePair

```java
KeyValuePair()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getKey

```java
@NonNull
java.lang.String getKey()
```

Data key.

For example, "currency".

### getValue

```java
@NonNull
java.lang.String getValue()
```

Data value.

For example, "USD".

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
