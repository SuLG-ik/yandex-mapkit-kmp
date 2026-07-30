---
title: "YMKPanoramaPlayer"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPanoramaPlayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaPlayer.html"
---
# YMKPanoramaPlayer

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaPlayer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKPanoramaPlayer : NSObject
```

Panorama player that is used to open panoramas.

## Summary

### Instance methods

```objectivec
- (void)openPanoramaWithPanoramaId:(nonnull NSString *)panoramaId;
```

Opens the panorama with the given ID

```objectivec
- (void)
    openUserPanoramaWithLocalDataSourceWithPanoramaDescription:
        (nonnull YMKPanoramaDescription *)panoramaDescription
                                             tileImageProvider:
                                                 (nonnull id<
                                                     YMKPanoramaTileImageFactory>)
                                                     tileImageProvider
                                             iconImageProvider:
                                                 (nonnull id<
                                                     YMKPanoramaIconImageFactory>)
                                                     iconImageProvider
                                     userPanoramaEventListener:
                                         (nonnull id<
                                             YMKPanoramaUserPanoramaDelegate>)
                                             userPanoramaEventListener;
```

Opens the panorama from the local datasource

```objectivec
- (void)
    openUserPanoramaWithNetworkDataSourceWithPanoramaDescription:
        (nonnull YMKPanoramaDescription *)panoramaDescription
                                                 tileUrlProvider:
                                                     (nonnull id<
                                                         YMKPanoramaTileUrlProvider>)
                                                         tileUrlProvider
                                                 iconUrlProvider:
                                                     (nonnull id<
                                                         YMKPanoramaIconUrlProvider>)
                                                         iconUrlProvider
                                       userPanoramaEventListener:
                                           (nonnull id<
                                               YMKPanoramaUserPanoramaDelegate>)
                                               userPanoramaEventListener;
```

Opens the panorama from the network datasource

```objectivec
- (nonnull NSString *)panoramaId;
```

Opened the panorama with the given ID

```objectivec
- (nonnull YMKPoint *)position;
```

Geo position of current panorama

```objectivec
- (void)lookAtWithPosition:(nonnull YMKPoint *)position;
```

Sets the view direction to the center of the given geo position

```objectivec
- (nonnull YMKDirection *)direction;
```

View direction of the opened panorama

```objectivec
- (void)setDirectionWithDirection:(nonnull YMKDirection *)direction;
```

Sets the view direction bearing and tilt

```objectivec
- (nonnull YMKSpan *)span;
```

View span of the opened panorama

```objectivec
- (void)setSpanWithSpan:(nonnull YMKSpan *)span;
```

Sets the view area span

```objectivec
- (void)reset;
```

Closes the opened panorama and stops all player actions

```objectivec
- (nonnull NSArray<YMKHistoricalPanorama *> *)historicalPanoramas;
```

```objectivec
- (void)enableZoom;
```

Enables player zoom controls

```objectivec
- (void)disableZoom;
```

Disables player zoom controls

```objectivec
- (BOOL)zoomEnabled;
```

Checks if zoom controls are enabled

```objectivec
- (void)enableMove;
```

Shows transition arrows and allows switching panoramas

```objectivec
- (void)disableMove;
```

Hides transition arrows and disallows switching panoramas

```objectivec
- (BOOL)moveEnabled;
```

Checks if switching panoramas is enabled

```objectivec
- (void)enableRotation;
```

Allows the user to rotate panoramas

```objectivec
- (void)disableRotation;
```

Disallows the user to rotate panoramas

```objectivec
- (BOOL)rotationEnabled;
```

Checks if player rotation is enabled

```objectivec
- (void)enableMarkers;
```

Allows markers (house numbers, railway stations, airports) to be shown

```objectivec
- (void)disableMarkers;
```

Disallows markers (house numbers, railway stations, airports) to be shown

```objectivec
- (BOOL)markersEnabled;
```

Checks if markers are enabled

```objectivec
- (void)enableCompanies;
```

Allows companies (company names and icons) to be shown

```objectivec
- (void)disableCompanies;
```

Disallows companies (company names and icons) to be shown

```objectivec
- (BOOL)companiesEnabled;
```

Checks if companies are enabled

```objectivec
- (void)addPanoramaChangeListenerWithPanoramaChangeListener:
    (nonnull id<YMKPanoramaChangeDelegate>)panoramaChangeListener;
```

Adds a panorama change listener

```objectivec
- (void)removePanoramaChangeListenerWithPanoramaChangeListener:
    (nonnull id<YMKPanoramaChangeDelegate>)panoramaChangeListener;
```

Removes the panorama change listener

```objectivec
- (void)addDirectionChangeListenerWithDirectionChangeListener:
    (nonnull id<YMKPanoramaDirectionChangeDelegate>)directionChangeListener;
```

Adds direction listener

```objectivec
- (void)removeDirectionChangeListenerWithDirectionChangeListener:
    (nonnull id<YMKPanoramaDirectionChangeDelegate>)directionChangeListener;
```

Removes the direction listener

```objectivec
- (void)addSpanChangeListenerWithSpanChangeListener:
    (nonnull id<YMKPanoramaSpanChangeDelegate>)spanChangeListener;
```

Adds span listener

```objectivec
- (void)removeSpanChangeListenerWithSpanChangeListener:
    (nonnull id<YMKPanoramaSpanChangeDelegate>)spanChangeListener;
```

Removes span listener

```objectivec
- (void)addCompanyTapListenerWithCompanyTapListener:
    (nonnull id<YMKPanoramaCompanyTapDelegate>)companyTapListener;
```

Adds company tap listener

```objectivec
- (void)removeCompanyTapListenerWithCompanyTapListener:
    (nonnull id<YMKPanoramaCompanyTapDelegate>)companyTapListener;
```

Removes company tap listener

```objectivec
- (void)addErrorListenerWithErrorListener:
    (nonnull id<YMKPanoramaErrorDelegate>)errorListener;
```

Adds error listener

```objectivec
- (void)removeErrorListenerWithErrorListener:
    (nonnull id<YMKPanoramaErrorDelegate>)errorListener;
```

Removes error listener

```objectivec
- (void)enableLoadingWheel;
```

Allows showing loading wheels

```objectivec
- (void)disableLoadingWheel;
```

Disallows showing loading wheels

```objectivec
- (BOOL)loadingWheelEnabled;
```

Checks if loading wheels can be shown while the panorama is opening

```objectivec
- (void)onMemoryWarning;
```

Called when a memory warning happens

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKLogo *logo;
```

Yandex logo object

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### openPanoramaWithPanoramaId:

```objectivec
- (void)openPanoramaWithPanoramaId:(nonnull NSString *)panoramaId;
```

Opens the panorama with the given ID.

| Parameters |   |
| --- | --- |
| panoramaId | The panoramaId that specifies the panorama to open. You can get the panoramaId by using the PanoramaService methods. |

### openUserPanoramaWithLocalDataSourceWithPanoramaDescription:tileImageProvider:iconImageProvider:userPanoramaEventListener:

```objectivec
- (void)
    openUserPanoramaWithLocalDataSourceWithPanoramaDescription:
        (nonnull YMKPanoramaDescription *)panoramaDescription
                                             tileImageProvider:
                                                 (nonnull id<
                                                     YMKPanoramaTileImageFactory>)
                                                     tileImageProvider
                                             iconImageProvider:
                                                 (nonnull id<
                                                     YMKPanoramaIconImageFactory>)
                                                     iconImageProvider
                                     userPanoramaEventListener:
                                         (nonnull id<
                                             YMKPanoramaUserPanoramaDelegate>)
                                             userPanoramaEventListener;
```

Opens the panorama from the local datasource.

The class maintains a strong reference to the object in the 'tileImageProvider' parameter until it (the class) is invalidated.

The class maintains a strong reference to the object in the 'iconImageProvider' parameter until it (the class) is invalidated.

The class does not retain the object in the 'userPanoramaEventListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| panoramaDescription | Initialize this struct to open panorama |
| tileImageProvider | The tile datasource |
| iconImageProvider | The icon datasource |
| userPanoramaEventListener | The user panorama notification listener |

### openUserPanoramaWithNetworkDataSourceWithPanoramaDescription:tileUrlProvider:iconUrlProvider:userPanoramaEventListener:

```objectivec
- (void)
    openUserPanoramaWithNetworkDataSourceWithPanoramaDescription:
        (nonnull YMKPanoramaDescription *)panoramaDescription
                                                 tileUrlProvider:
                                                     (nonnull id<
                                                         YMKPanoramaTileUrlProvider>)
                                                         tileUrlProvider
                                                 iconUrlProvider:
                                                     (nonnull id<
                                                         YMKPanoramaIconUrlProvider>)
                                                         iconUrlProvider
                                       userPanoramaEventListener:
                                           (nonnull id<
                                               YMKPanoramaUserPanoramaDelegate>)
                                               userPanoramaEventListener;
```

Opens the panorama from the network datasource.

The class maintains a strong reference to the object in the 'tileUrlProvider' parameter until it (the class) is invalidated.

The class maintains a strong reference to the object in the 'iconUrlProvider' parameter until it (the class) is invalidated.

The class does not retain the object in the 'userPanoramaEventListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| panoramaDescription | Initialize this struct to open panorama |
| tileUrlProvider | The network tile datasource |
| iconUrlProvider | The netwokr icon datasource |
| userPanoramaEventListener | The user panorama notification listener |

### panoramaId

```objectivec
- (nonnull NSString *)panoramaId;
```

Opened the panorama with the given ID.

**Returns**

PanoramaId of the currently opened panorama. Empty if no

panorama is open.

### position

```objectivec
- (nonnull YMKPoint *)position;
```

Geo position of current panorama.

**Returns**

Geo position of the currently opened panorama. Empty if no

panorama is open.

### lookAtWithPosition:

```objectivec
- (void)lookAtWithPosition:(nonnull YMKPoint *)position;
```

Sets the view direction to the center of the given geo position.

| Parameters |   |
| --- | --- |
| position | The position to look at. |

### direction

```objectivec
- (nonnull YMKDirection *)direction;
```

View direction of the opened panorama.

**Returns**

View direction of the opened panorama. Empty if no panorama

is open.

### setDirectionWithDirection:

```objectivec
- (void)setDirectionWithDirection:(nonnull YMKDirection *)direction;
```

Sets the view direction bearing and tilt.

| Parameters |   |
| --- | --- |
| direction | View direction. |

### span

```objectivec
- (nonnull YMKSpan *)span;
```

View span of the opened panorama.

**Returns**

Current view span of the opened panorama. May be different

from the span provided by the setSpan(span) method.

### setSpanWithSpan:

```objectivec
- (void)setSpanWithSpan:(nonnull YMKSpan *)span;
```

Sets the view area span. Invalid values are adjusted by the player to the closest valid values.

| Parameters |   |
| --- | --- |
| span | View area span. May be adjusted by the player. |

### reset

```objectivec
- (void)reset;
```

Closes the opened panorama and stops all player actions.

### historicalPanoramas

```objectivec
- (nonnull NSArray<YMKHistoricalPanorama *> *)historicalPanoramas;
```

**Returns**

panoramas published earlier at the current panorama position.

Result is updated on the YMKPanoramaChangeDelegate callback

### enableZoom

```objectivec
- (void)enableZoom;
```

Enables player zoom controls.

### disableZoom

```objectivec
- (void)disableZoom;
```

Disables player zoom controls.

### zoomEnabled

```objectivec
- (BOOL)zoomEnabled;
```

Checks if zoom controls are enabled.

### enableMove

```objectivec
- (void)enableMove;
```

Shows transition arrows and allows switching panoramas.

### disableMove

```objectivec
- (void)disableMove;
```

Hides transition arrows and disallows switching panoramas.

### moveEnabled

```objectivec
- (BOOL)moveEnabled;
```

Checks if switching panoramas is enabled.

### enableRotation

```objectivec
- (void)enableRotation;
```

Allows the user to rotate panoramas.

### disableRotation

```objectivec
- (void)disableRotation;
```

Disallows the user to rotate panoramas.

### rotationEnabled

```objectivec
- (BOOL)rotationEnabled;
```

Checks if player rotation is enabled.

### enableMarkers

```objectivec
- (void)enableMarkers;
```

Allows markers (house numbers, railway stations, airports) to be shown.

### disableMarkers

```objectivec
- (void)disableMarkers;
```

Disallows markers (house numbers, railway stations, airports) to be shown.

### markersEnabled

```objectivec
- (BOOL)markersEnabled;
```

Checks if markers are enabled.

### enableCompanies

```objectivec
- (void)enableCompanies;
```

Allows companies (company names and icons) to be shown.

### disableCompanies

```objectivec
- (void)disableCompanies;
```

Disallows companies (company names and icons) to be shown.

### companiesEnabled

```objectivec
- (BOOL)companiesEnabled;
```

Checks if companies are enabled.

### addPanoramaChangeListenerWithPanoramaChangeListener:

```objectivec
- (void)addPanoramaChangeListenerWithPanoramaChangeListener:
    (nonnull id<YMKPanoramaChangeDelegate>)panoramaChangeListener;
```

Adds a panorama change listener.

The class does not retain the object in the 'panoramaChangeListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| panoramaChangeListener | Panorama change listener. |

### removePanoramaChangeListenerWithPanoramaChangeListener:

```objectivec
- (void)removePanoramaChangeListenerWithPanoramaChangeListener:
    (nonnull id<YMKPanoramaChangeDelegate>)panoramaChangeListener;
```

Removes the panorama change listener.

| Parameters |   |
| --- | --- |
| panoramaChangeListener | The panorama change listener to remove. |

### addDirectionChangeListenerWithDirectionChangeListener:

```objectivec
- (void)addDirectionChangeListenerWithDirectionChangeListener:
    (nonnull id<YMKPanoramaDirectionChangeDelegate>)directionChangeListener;
```

Adds direction listener.

The class does not retain the object in the 'directionChangeListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| directionChangeListener | Panorama direction listener. |

### removeDirectionChangeListenerWithDirectionChangeListener:

```objectivec
- (void)removeDirectionChangeListenerWithDirectionChangeListener:
    (nonnull id<YMKPanoramaDirectionChangeDelegate>)directionChangeListener;
```

Removes the direction listener.

| Parameters |   |
| --- | --- |
| directionChangeListener | The panorama direction listener to remove. |

### addSpanChangeListenerWithSpanChangeListener:

```objectivec
- (void)addSpanChangeListenerWithSpanChangeListener:
    (nonnull id<YMKPanoramaSpanChangeDelegate>)spanChangeListener;
```

Adds span listener.

The class does not retain the object in the 'spanChangeListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| spanChangeListener | Panorama span listener. |

### removeSpanChangeListenerWithSpanChangeListener:

```objectivec
- (void)removeSpanChangeListenerWithSpanChangeListener:
    (nonnull id<YMKPanoramaSpanChangeDelegate>)spanChangeListener;
```

Removes span listener.

| Parameters |   |
| --- | --- |
| spanChangeListener | The span listener to remove. |

### addCompanyTapListenerWithCompanyTapListener:

```objectivec
- (void)addCompanyTapListenerWithCompanyTapListener:
    (nonnull id<YMKPanoramaCompanyTapDelegate>)companyTapListener;
```

Adds company tap listener.

The class does not retain the object in the 'companyTapListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| companyTapListener | Company tap listener. |

### removeCompanyTapListenerWithCompanyTapListener:

```objectivec
- (void)removeCompanyTapListenerWithCompanyTapListener:
    (nonnull id<YMKPanoramaCompanyTapDelegate>)companyTapListener;
```

Removes company tap listener.

| Parameters |   |
| --- | --- |
| companyTapListener | The company tap listener to remove. |

### addErrorListenerWithErrorListener:

```objectivec
- (void)addErrorListenerWithErrorListener:
    (nonnull id<YMKPanoramaErrorDelegate>)errorListener;
```

Adds error listener.

The class does not retain the object in the 'errorListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| errorListener | Listeners that notify when a panorama failed to open. |

### removeErrorListenerWithErrorListener:

```objectivec
- (void)removeErrorListenerWithErrorListener:
    (nonnull id<YMKPanoramaErrorDelegate>)errorListener;
```

Removes error listener.

| Parameters |   |
| --- | --- |
| errorListener | The listener to remove. |

### enableLoadingWheel

```objectivec
- (void)enableLoadingWheel;
```

Allows showing loading wheels.

### disableLoadingWheel

```objectivec
- (void)disableLoadingWheel;
```

Disallows showing loading wheels.

### loadingWheelEnabled

```objectivec
- (BOOL)loadingWheelEnabled;
```

Checks if loading wheels can be shown while the panorama is opening.

### onMemoryWarning

```objectivec
- (void)onMemoryWarning;
```

Called when a memory warning happens.

## Properties

### logo

```objectivec
@property (nonatomic, readonly, nonnull) YMKLogo *logo;
```

Yandex logo object.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
