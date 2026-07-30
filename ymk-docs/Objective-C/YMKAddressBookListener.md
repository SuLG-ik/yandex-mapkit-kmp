---
title: "YMKAddressBookListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKAddressBookListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAddressBookListener.html"
---
# YMKAddressBookListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAddressBookListener.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@protocol YMKAddressBookListener <NSObject>
```

## Summary

### Instance methods

```objectivec
- (void)onLoadedWithHasAddressBook:(BOOL)hasAddressBook;
```

Called when local address book copy id loaded from disk

```objectivec
- (void)onDropped;
```

Called when address book was dropped, usually after account changed

```objectivec
- (void)onRefreshSuccessWithChanged:(BOOL)changed;
```

Called after refresh successfull attempt

```objectivec
- (void)onRefreshErrorWithError:(nonnull NSError *)error;
```

Called if error occured on refresh attempt

## Instance methods

### onLoadedWithHasAddressBook:

```objectivec
- (void)onLoadedWithHasAddressBook:(BOOL)hasAddressBook;
```

Called when local address book copy id loaded from disk. Called immediatly for listeners added after loading.

### onDropped

```objectivec
- (void)onDropped;
```

Called when address book was dropped, usually after account changed

### onRefreshSuccessWithChanged:

```objectivec
- (void)onRefreshSuccessWithChanged:(BOOL)changed;
```

Called after refresh successfull attempt

### onRefreshErrorWithError:

```objectivec
- (void)onRefreshErrorWithError:(nonnull NSError *)error;
```

Called if error occured on refresh attempt. This may throw subclasses of NetworkError during network loading, as well as other exceptions.
