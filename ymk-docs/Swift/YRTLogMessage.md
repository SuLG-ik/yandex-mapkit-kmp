---
title: "YRTLogMessage"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YRTLogMessage"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YRTLogMessage.html"
---
# YRTLogMessage

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YRTLogMessage.html)

```swift
class YRTLogMessage : NSObject
```

Represents a log message with its metadata.

## Summary

### Class methods

```swift
 init(time: Date,
     level: YRTLogMessageLogLevel,
     scope: String,
   message: String,
 verboseInfo: String)
```

### Properties

```swift
var time: Date { get }
```

Absolute timestamp of the log message

```swift
var level: YRTLogMessageLogLevel { get }
```

Severity level of the log message

```swift
var scope: String { get }
```

Scope or category of the log message

```swift
var message: String { get }
```

The log message content

```swift
var verboseInfo: String { get }
```

Additional verbose information about the log message

## Class methods

### init(time:level:scope:message:verboseInfo:)

```swift
 init(time: Date,
     level: YRTLogMessageLogLevel,
     scope: String,
   message: String,
 verboseInfo: String)
```

## Properties

### time

```swift
var time: Date { get }
```

Absolute timestamp of the log message.

### level

```swift
var level: YRTLogMessageLogLevel { get }
```

Severity level of the log message.

### scope

```swift
var scope: String { get }
```

Scope or category of the log message.

### message

```swift
var message: String { get }
```

The log message content.

### verboseInfo

```swift
var verboseInfo: String { get }
```

Additional verbose information about the log message. Used for logging exceptions with call stack.
