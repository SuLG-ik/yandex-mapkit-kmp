---
title: "ExperimentData"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.runtime.config"
section: "Android / Справочник / com.yandex.runtime.config / ExperimentData"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/config/ExperimentData.html"
---
# ExperimentData

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/config/ExperimentData.html)

**Package** com.yandex.runtime.config

java.lang.Object
↳ com.yandex.runtime.config.ExperimentData

`class ExperimentData implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
ExperimentData(int testId,
               int userGroup,
               int userBucket)
```

```java
ExperimentData()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getTestId()` |
| `int` | `getUserGroup()` |
| `int` | `getUserBucket()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ExperimentData

```java
ExperimentData(int testId,
               int userGroup,
               int userBucket)
```

### ExperimentData

```java
ExperimentData()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getTestId

```java
int getTestId()
```

### getUserGroup

```java
int getUserGroup()
```

### getUserBucket

```java
int getUserBucket()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
