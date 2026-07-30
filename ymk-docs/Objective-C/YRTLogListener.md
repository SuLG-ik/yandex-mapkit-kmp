---
title: "YRTLogListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YRTLogListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTLogListener.html"
---
# YRTLogListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YRTLogListener.html)

```objectivec
@protocol YRTLogListener <NSObject>
```

Listener interface for receiving log messages.

## Summary

### Instance methods

```objectivec
- (void)onMessageReceivedWithMessage:(nonnull YRTLogMessage *)message;
```

Called when a new log message is received

## Instance methods

### onMessageReceivedWithMessage:

```objectivec
- (void)onMessageReceivedWithMessage:(nonnull YRTLogMessage *)message;
```

Called when a new log message is received.

| Parameters |   |
| --- | --- |
| message | The log message that was received. |
