---
title: "YMKDataSourceLayer"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDataSourceLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDataSourceLayer.html"
---
# YMKDataSourceLayer

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDataSourceLayer.html)

```objectivec
@interface YMKDataSourceLayer : NSObject
```

## Summary

### Instance methods

```objectivec
- (void)clear;
```

Clears all cached tiles and starts new requests for tiles that are displayed

```objectivec
- (BOOL)setStyleWithId:(NSInteger)id style:(nonnull NSString *)style;
```

Applies JSON style transformation to the layer

```objectivec
- (void)resetStyles;
```

Resets all JSON style transformations applied to the layer

```objectivec
- (void)setLayerLoadedListenerWithLayerLoadedListener:
    (nullable id<YMKLayerLoadedListener>)layerLoadedListener;
```

Sets layer loaded listener

```objectivec
- (void)remove;
```

Removes the data source layer from the parent layer

```objectivec
- (void)setDataSourceListenerWithDataSourceListener:
    (nullable id<YMKDataSourceListener>)dataSourceListener;
```

Sets data source listener

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isActive)
    BOOL active;
```

Manages visibility of the layer

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### clear

```objectivec
- (void)clear;
```

Clears all cached tiles and starts new requests for tiles that are displayed.

### setStyleWithId:style:

```objectivec
- (BOOL)setStyleWithId:(NSInteger)id style:(nonnull NSString *)style;
```

Applies JSON style transformation to the layer. Replaces previous styling with the specified ID (if such exists). Stylings are applied in an ascending order. Set to empty string to clear previous styling with the specified ID. Returns true if the style was successfully parsed and false otherwise. If the returned value is false, the current style remains unchanged.

### resetStyles

```objectivec
- (void)resetStyles;
```

Resets all JSON style transformations applied to the layer.

### setLayerLoadedListenerWithLayerLoadedListener:

```objectivec
- (void)setLayerLoadedListenerWithLayerLoadedListener:
    (nullable id<YMKLayerLoadedListener>)layerLoadedListener;
```

Sets layer loaded listener.

The class does not retain the object in the 'layerLoadedListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### remove

```objectivec
- (void)remove;
```

Removes the data source layer from the parent layer. The object becomes invalid after that.

### setDataSourceListenerWithDataSourceListener:

```objectivec
- (void)setDataSourceListenerWithDataSourceListener:
    (nullable id<YMKDataSourceListener>)dataSourceListener;
```

Sets data source listener. Use it to invalidate data source. Temporary solution until https://st.yandex-team.ru/MAPSMOBCORE-20531 is done

The class does not retain the object in the 'dataSourceListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

## Properties

### active

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isActive)
    BOOL active;
```

Manages visibility of the layer.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
