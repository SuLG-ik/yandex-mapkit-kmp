---
title: "YRTLogMessage"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YRTLogMessage"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTLogMessage.html"
---
# YRTLogMessage

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTLogMessage.html)

```objectivec
@interface YRTLogMessage : NSObject
```

Represents a log message with its metadata.

## Summary

### Class methods

```objectivec
+ (nonnull YRTLogMessage *)logMessageWithTime:(nonnull NSDate *)time
                                        level:( YRTLogMessageLogLevel)level
                                        scope:(nonnull NSString *)scope
                                      message:(nonnull NSString *)message
                                  verboseInfo:(nonnull NSString *)verboseInfo;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSDate *time;
```

Absolute timestamp of the log message

```objectivec
@property (nonatomic, readonly) YRTLogMessageLogLevel level;
```

Severity level of the log message

```objectivec
@property (nonatomic, readonly, nonnull) NSString *scope;
```

Scope or category of the log message

```objectivec
@property (nonatomic, readonly, nonnull) NSString *message;
```

The log message content

```objectivec
@property (nonatomic, readonly, nonnull) NSString *verboseInfo;
```

Additional verbose information about the log message

## Class methods

### logMessageWithTime:level:scope:message:verboseInfo:

```objectivec
+ (nonnull YRTLogMessage *)logMessageWithTime:(nonnull NSDate *)time
                                        level:( YRTLogMessageLogLevel)level
                                        scope:(nonnull NSString *)scope
                                      message:(nonnull NSString *)message
                                  verboseInfo:(nonnull NSString *)verboseInfo;
```

## Properties

### time

```objectivec
@property (nonatomic, readonly, nonnull) NSDate *time;
```

Absolute timestamp of the log message.

### level

```objectivec
@property (nonatomic, readonly) YRTLogMessageLogLevel level;
```

Severity level of the log message.

### scope

```objectivec
@property (nonatomic, readonly, nonnull) NSString *scope;
```

Scope or category of the log message.

### message

```objectivec
@property (nonatomic, readonly, nonnull) NSString *message;
```

The log message content.

### verboseInfo

```objectivec
@property (nonatomic, readonly, nonnull) NSString *verboseInfo;
```

Additional verbose information about the log message. Used for logging exceptions with call stack.
