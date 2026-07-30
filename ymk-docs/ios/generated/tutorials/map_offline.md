---
title: "Офлайн карты"
kind: "Guide"
platform: "ios"
language: "Swift/Objective-C"
section: "iOS / Руководство / Офлайн карты"
source: "https://yandex.ru/maps-api/docs/mapkit/ios/generated/tutorials/map_offline.html"
---
# Офлайн карты

`IOS` · `Swift/Objective-C` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/ios/generated/tutorials/map_offline.html)

MapKit SDK осуществляет загрузку данных о карте по сети интернет для отображения на устройстве пользователя. С помощью механизма офлайн-кэшей, MapKit SDK позволяет осуществить предварительную загрузку офлайн-карт, чтобы затем использовать их при отсутствии подключения к интернету.

В офлайн-режиме MapKit SDK предоставляет следующий функционал для загруженных регионов:

- отображение тайлов карты;
- построение автомобильных маршрутов без учета пробок;
- геосаджест и поиск.

> [!WARNING] Важно
> Функционал офлайн-карт доступен только при наличии [платной лицензии](https://yandex.ru/maps-api/products/mapkit#price).

## Регионы

Карта в MapKit SDK делится на отдельные регионы, каждому из них соответствует набор данных, которые можно загрузить и использовать в качестве офлайн-кэшей.

Регионами могут быть:

- города: Москва, Минск, Казань и т.д.;
- областные регионы, которые включают в себя несколько городов: Московская область, Минская область и т.д.;
- отдельные страны: Сербия, Финляндия, Армения и т.д.

В MapKit SDK регион описывается классом [YMKOfflineCacheRegion](../../../Swift/YMKOfflineCacheRegion.md) и предоставляет следующие данные:

- `id` - уникальный идентификатор региона;
- `name` - название региона;
- `center` - координаты центра региона;
- `size` - размер в байтах для скачивания данных этого региона;
- `releaseTime` - временная метка, когда офлайн карты для данного региона были последний раз обновлены на сервере;
- `parentId` - идентификатор родительского региона, например: Москва в качестве родительского региона содержит Московскую область.

### Получение списка регионов

Точкой входа в API управления офлайн-кэшами является класс [YMKOfflineCacheManager](../../../Swift/YMKOfflineCacheManager.md). Экземпляр этого класса хранится в виде синглтона в MapKit SDK. Для его получения используется метод [YMKMapKit.offlineCacheManager](../../../Swift/YMKMapKit.md#offlinecachemanager).

```swift
let offlineCacheManager = YMKMapKit.sharedInstance().offlineCacheManager
```

Для получения списка всех доступных регионов используется подписка на событие обновления списка регионов с помощью интерфейса [YMKOfflineMapRegionListUpdatesListener](../../../Swift/YMKOfflineMapRegionListUpdatesListener.md).

```swift
class RegionListUpdatesListener: NSObject, YMKOfflineMapRegionListUpdatesListener {
    func onListUpdated() {
        let regions = offlineCacheManager.regions()
        // Handle regions update
    }
}

let regionListUpdatesListener = RegionListUpdatesListener()
offlineCacheManager.addRegionListUpdatesListener(with: regionListUpdatesListener)
```

C помощью метода [YMKOfflineCacheManager.regions()](../../../Swift/YMKOfflineCacheManager.md#regions) можно получить список обновленных регионов.

### Состояние региона

Состояние региона описывается перечислением [YMKOfflineCacheRegionState](../../../Swift/YMKOfflineCacheRegionState.md):

- `available` - офлайн-карты данного региона доступны для загрузки;
- `downloading` - офлайн-карты в процессе загрузки;
- `paused` - процесс загрузки был приостановлен и может быть возобновлен;
- `completed` - загрузка данных завершена успешно;
- `outdated` - на сервере есть более новая версия офлайн-карт для данного региона;
- `unsupported` - офлайн-карты данного региона загружены, но больше не поддерживаются, после их удаления с устройства регион пропадет из доступных для загрузки;
- `need_update` - данные сильно устарели, требуется загрузить новую версию.

Для получения текущего состояния для отдельного региона используется метод [YMKOfflineCacheManager.getStateWithRegionId(_:)](../../../Swift/YMKOfflineCacheManager.md#getstatewithregionid_).

MapKit SDK предоставляет возможность подписаться на события изменения состояния регионов с помощью интерфейса [YMKOfflineCacheRegionListener](../../../Swift/YMKOfflineCacheRegionListener.md). Он предоставляет два метода для переопределения:

1. [YMKOfflineCacheRegionListener.onRegionStateChanged(withRegionId:)](../../../Swift/YMKOfflineCacheRegionListener.md#onregionstatechangedwithregionid) - оповещает об изменении состояния отдельного региона.
2. [YMKOfflineCacheRegionListener.onRegionProgress(withRegionId:)](../../../Swift/YMKOfflineCacheRegionListener.md#onregionprogresswithregionid) - оповещает об изменении статуса загрузки офлайн-карты региона.

```swift
class RegionListener: NSObject, YMKOfflineCacheRegionListener {
    func onRegionStateChanged(withRegionId regionId: UInt) {
        let state = offlineCacheManager.getStateWithRegionId(regionId)
        // Handle region state changes
    }

    func onRegionProgress(withRegionId regionId: UInt) {
        let progress = offlineCacheManager.getProgressWithRegionId(regionId)
        // Handle region progress changes
    }
}

let regionListener = RegionListener()
offlineCacheManager.addRegionListener(regionListener)
```

### Дополнительная информация о регионах

При помощи следующих методов можно получить дополнительную информацию о регионах:

- [YMKOfflineCacheManager.getCitiesWithRegionId(_:)](../../../Swift/YMKOfflineCacheManager.md#getcitieswithregionid_) - получение списка из названий городов, которые содержит регион.
- [YMKOfflineCacheManager.getDownloadedReleaseTime(withRegionId:)](../../../Swift/YMKOfflineCacheManager.md#getdownloadedreleasetimewithregionid) - дата релиза загруженного региона.

## Загрузка офлайн-карт

Для управления статусом загрузки офлайн-карт отдельного региона MapKit SDK предоставляет следующий набор методов:

- [YMKOfflineCacheManager.startDownload(withRegionId:)](../../../Swift/YMKOfflineCacheManager.md#startdownloadwithregionid) - начинает загрузку офлайн-карт;
- [YMKOfflineCacheManager.stopDownload(withRegionId:)](../../../Swift/YMKOfflineCacheManager.md#stopdownloadwithregionid) - если загрузка карт была начата, отменяет ее;
- [YMKOfflineCacheManager.pauseDownload(withRegionId:)](../../../Swift/YMKOfflineCacheManager.md#pausedownloadwithregionid) - приостанавливает загрузку офлайн-карт;
- [YMKOfflineCacheManager.drop(withRegionId:)](../../../Swift/YMKOfflineCacheManager.md#dropwithregionid) - удаляет все офлайн-кэши для отдельного региона.

> [!TIP] Совет
> Используйте метод [YMKOfflineCacheManager.mayBeOutOfAvailableSpace(withRegionId:)](../../../Swift/YMKOfflineCacheManager.md#maybeoutofavailablespacewithregionid) для проверки наличия свободного места на устройстве прежде чем начинать загрузку.

Все методы управления статусом загрузки офлайн-карт принимают единственный аргумент - id региона, для которого применяется указанное действие. В результате выполнения данных методов [состояние регионов](map_offline.md#region-state) может измениться. Так, например, если регион доступен для скачивания, то после вызова метода [YMKOfflineCacheManager.startDownload(withRegionId:)](../../../Swift/YMKOfflineCacheManager.md#startdownloadwithregionid) начнется его загрузка, и состояние региона изменится на `downloading`.

### Свойства загрузки

При помощи данных методов можно настроить свойства загрузки офлайн-карт:

- [YMKOfflineCacheManager.allowUseCellularNetwork(withUseCellular:)](../../../Swift/YMKOfflineCacheManager.md#allowusecellularnetworkwithusecellular) - позволяет включить возможность загрузки и обновления офлайн-карт по мобильной сети (3G, LTE и т.п.).
- [YMKOfflineCacheManager.enableAutoUpdate(withEnable:)](../../../Swift/YMKOfflineCacheManager.md#enableautoupdatewithenable) - активирует автоматическое обновление офлайн-кэшей для регионов, которые находятся в состоянии `need_update`.

### Обработка ошибок

В ходе загрузки происходит скачивание данных офлайн-карт с сервера и сохранения офлайн-кэшей на диске устройства. Для обработки различных ошибок, которые могут произойти в ходе данного процесса, используется интерфейс [YMKOfflineCacheManagerErrorListener](../../../Swift/YMKOfflineCacheManagerErrorListener.md).

```swift
class ErrorListener: NSObject, YMKOfflineCacheManagerErrorListener {
    func onErrorWithError(_ error: Error) {
        switch error {
        case let localError as YRTLocalError:
            // Handle local error
        case let remoteError as YRTRemoteError:
            // Handle remote error
        default:
            // Undefined error
        }
    }

    func onRegionErrorWithError(_ error: Error, regionId: UInt) {
        // Handle error for region with regionId id
    }
}
```

Данный интерфейс предоставляет методы для обработки ошибок, связанных с загрузкой определенных регионов и работой [YMKOfflineCacheManager](../../../Swift/YMKOfflineCacheManager.md).

Ошибки могут быть двух типов:

- [YRTLocalError](../../../Swift/YRTLocalError.md) - ошибки на устройстве пользователя, например, повреждение диска, недостаток свободного места для сохранения;
- [YRTRemoteError](../../../Swift/YRTRemoteError.md) - ошибки со стороны сервера.

## Хранение офлайн-кэшей

Данные офлайн-карт, которые были получены во время их загрузки, MapKit SDK сохраняет на диске устройства в специальном формате офлайн-кэшей.

Для получения пути, по которому хранятся офлайн-кэши в файловой системе, используется метод [YMKOfflineCacheManager.requestPath(pathGetterListener:)](../../../Swift/YMKOfflineCacheManager.md#requestpathpathgetterlistener).

```swift
offlineCacheManager.requestPath { path in
    // Handle requested path
}
```

Данный метод принимает в качестве аргумента интерфейс [YMKOfflineCacheManagerPathGetterListener](../../../Swift/YMKOfflineCacheManagerPathGetterListener.md), с помощью которого можно подписаться на событие получения пути.

Существует возможность изменить место хранения офлайн-кэшей на устройстве. Для этого предусмотрено два метода:

1. [YMKOfflineCacheManager.setCachePathWithPath(_:pathSetterListener:)](../../../Swift/YMKOfflineCacheManager.md#setcachepathwithpath_pathsetterlistener) - позволяет изменить место на устройстве пользователя, в котором хранятся данные офлайн-кэшей. Если по заданному пути уже есть офлайн-кэши, то они будут использоваться, иначе, будут инициализированы новые кэши.
2. [YMKOfflineCacheManager.moveData(withNewPath:dataMoveListener:)](../../../Swift/YMKOfflineCacheManager.md#movedatawithnewpathdatamovelistener) - переносит текущие офлайн-кэши в новое место на устройстве.

С помощью метода [YMKOfflineCacheManager.computeCacheSize(sizeCallback:)](../../../Swift/YMKOfflineCacheManager.md#computecachesizesizecallback) можно посчитать сколько памяти занимают все офлайн-кэши на устройстве пользователя.

Метод [YMKOfflineCacheManager.clear(clearCallback:)](../../../Swift/YMKOfflineCacheManager.md#clearclearcallback) используется для удаления офлайн-кэшей.

## Исходный код

Подробнее с примерами использования API офлайн карт из MapKit SDK можно ознакомиться в демо-приложении `MapOffline` в нашем [репозитории на GitHub](https://github.com/yandex/mapkit-ios-demo).
