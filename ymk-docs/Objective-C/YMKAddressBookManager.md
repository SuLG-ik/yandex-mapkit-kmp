---
title: "YMKAddressBookManager"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKAddressBookManager"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAddressBookManager.html"
---
# YMKAddressBookManager

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKAddressBookManager.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKAddressBookManager : NSObject
```

## Summary

### Instance methods

```objectivec
- (void)addListenerWithAddressBookListener:
    (nonnull id<YMKAddressBookListener>)addressBookListener;
```

The class does not retain the object in the 'addressBookListener' parameter

```objectivec
- (void)removeListenerWithAddressBookListener:
    (nonnull id<YMKAddressBookListener>)addressBookListener;
```

The class does not retain the object in the 'addressBookListener' parameter

```objectivec
- (void)requestRefresh;
```

Request to attempt to get address book from server

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKAddressBook *addressBook;
```

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### addListenerWithAddressBookListener:

```objectivec
- (void)addListenerWithAddressBookListener:
    (nonnull id<YMKAddressBookListener>)addressBookListener;
```

The class does not retain the object in the 'addressBookListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListenerWithAddressBookListener:

```objectivec
- (void)removeListenerWithAddressBookListener:
    (nonnull id<YMKAddressBookListener>)addressBookListener;
```

The class does not retain the object in the 'addressBookListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### requestRefresh

```objectivec
- (void)requestRefresh;
```

Request to attempt to get address book from server. Refresh attempts may be throttled and ignored. Immediately after downloading from disk, the first attempt to update will be made automatically.

## Properties

### addressBook

```objectivec
@property (nonatomic, readonly, nonnull) YMKAddressBook *addressBook;
```

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
