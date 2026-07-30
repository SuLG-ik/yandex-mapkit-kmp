---
title: "LogMessage"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.runtime.logging"
section: "Android / Справочник / com.yandex.runtime.logging / LogMessage"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/logging/LogMessage.html"
---
# LogMessage

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/logging/LogMessage.html)

**Package** com.yandex.runtime.logging

java.lang.Object
↳ com.yandex.runtime.logging.LogMessage

`class LogMessage implements Serializable`

Represents a log message with its metadata.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static final` | [LogLevel](LogMessage_LogLevel.md) | Log level severity. |

## Summary

### Constructors

**Signature and Description**

```java
LogMessage(long time,
           @NonNull LogLevel level,
           @NonNull java.lang.String scope,
           @NonNull java.lang.String message,
           @NonNull java.lang.String verboseInfo)
```

```java
LogMessage()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `long` | `getTime()`<br>Absolute timestamp of the log message. |
| `LogLevel` | `getLevel()`<br>Severity level of the log message. |
| `java.lang.String` | `getScope()`<br>Scope or category of the log message. |
| `java.lang.String` | `getMessage()`<br>The log message content. |
| `java.lang.String` | `getVerboseInfo()`<br>Additional verbose information about the log message. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### LogMessage

```java
LogMessage(long time,
           @NonNull LogLevel level,
           @NonNull java.lang.String scope,
           @NonNull java.lang.String message,
           @NonNull java.lang.String verboseInfo)
```

### LogMessage

```java
LogMessage()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getTime

```java
long getTime()
```

Absolute timestamp of the log message.

### getLevel

```java
@NonNull
LogLevel getLevel()
```

Severity level of the log message.

### getScope

```java
@NonNull
java.lang.String getScope()
```

Scope or category of the log message.

### getMessage

```java
@NonNull
java.lang.String getMessage()
```

The log message content.

### getVerboseInfo

```java
@NonNull
java.lang.String getVerboseInfo()
```

Additional verbose information about the log message.

Used for logging exceptions with call stack.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
