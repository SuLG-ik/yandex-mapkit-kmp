---
title: "YRTLogListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YRTLogListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YRTLogListener.html"
---
# YRTLogListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YRTLogListener.html)

```swift
protocol YRTLogListener : NSObjectProtocol
```

Listener interface for receiving log messages.

## Summary

### Instance methods

```swift
func onMessageReceived(with message: YRTLogMessage)
```

Called when a new log message is received

## Instance methods

### onMessageReceived(with:)

```swift
func onMessageReceived(with message: YRTLogMessage)
```

Called when a new log message is received.

| Parameters |   |
| --- | --- |
| message | The log message that was received. |
