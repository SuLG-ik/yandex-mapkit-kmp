---
title: "Офлайн карты"
kind: "Guide"
platform: "android"
language: "Kotlin/Java"
section: "Android / Руководство / Офлайн карты"
source: "https://yandex.ru/maps-api/docs/mapkit/android/generated/tutorials/map_offline.html"
---
# Офлайн карты

`ANDROID` · `Kotlin/Java` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/android/generated/tutorials/map_offline.html)

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

В MapKit SDK регион описывается классом [Region](../../../com/yandex/mapkit/offline_cache/Region.md) и предоставляет следующие данные:

- `id` - уникальный идентификатор региона;
- `name` - название региона;
- `center` - координаты центра региона;
- `size` - размер в байтах для скачивания данных этого региона;
- `releaseTime` - временная метка, когда офлайн карты для данного региона были последний раз обновлены на сервере;
- `parentId` - идентификатор родительского региона, например: Москва в качестве родительского региона содержит Московскую область.

### Получение списка регионов

Точкой входа в API управления офлайн-кэшами является класс [OfflineCacheManager](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md). Экземпляр этого класса хранится в виде синглтона в MapKit SDK. Для его получения используется метод [MapKit.getOfflineCacheManager](../../../com/yandex/mapkit/MapKit.md#getofflinecachemanager).

```kotlin
val offlineCacheManager = MapKitFactory.getInstance().offlineCacheManager
```

Для получения списка всех доступных регионов используется подписка на событие обновления списка регионов с помощью интерфейса [RegionListUpdatesListener](../../../com/yandex/mapkit/offline_cache/RegionListUpdatesListener.md).

```kotlin
val listener = RegionListUpdatesListener {
    val regions = offlineCacheManager.regions()
    // Handle regions update
}

offlineCacheManager.addRegionListUpdatesListener(listener)
```

C помощью метода [OfflineCacheManager.regions](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#regions) можно получить список обновленных регионов.

### Состояние региона

Состояние региона описывается перечислением [RegionState](../../../com/yandex/mapkit/offline_cache/RegionState.md):

- `available` - офлайн-карты данного региона доступны для загрузки;
- `downloading` - офлайн-карты в процессе загрузки;
- `paused` - процесс загрузки был приостановлен и может быть возобновлен;
- `completed` - загрузка данных завершена успешно;
- `outdated` - на сервере есть более новая версия офлайн-карт для данного региона;
- `unsupported` - офлайн-карты данного региона загружены, но больше не поддерживаются, после их удаления с устройства регион пропадет из доступных для загрузки;
- `need_update` - данные сильно устарели, требуется загрузить новую версию.

Для получения текущего состояния для отдельного региона используется метод [OfflineCacheManager.getState](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#getstateint).

MapKit SDK предоставляет возможность подписаться на события изменения состояния регионов с помощью интерфейса [RegionListener](../../../com/yandex/mapkit/offline_cache/RegionListener.md). Он предоставляет два метода для переопределения:

1. [RegionListener.onRegionStateChanged](../../../com/yandex/mapkit/offline_cache/RegionListener.md#onregionstatechangedint) - оповещает об изменении состояния отдельного региона.
2. [RegionListener.onRegionProgress](../../../com/yandex/mapkit/offline_cache/RegionListener.md#onregionprogressint) - оповещает об изменении статуса загрузки офлайн-карты региона.

```kotlin
val regionListener = object : RegionListener {
    override fun onRegionStateChanged(regionId: Int) {
        val state = offlineCacheManager.getState(regionId)
        // Handle region state changes
    }

    override fun onRegionProgress(regionId: Int) {
        val progress = offlineCacheManager.getProgress(regionId)
        // Handle region progress changes
    }
}

offlineCacheManager.addRegionListener(regionListener)
```

### Дополнительная информация о регионах

При помощи следующих методов можно получить дополнительную информацию о регионах:

- [OfflineCacheManager.getCities](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#getcitiesint) - получение списка из названий городов, которые содержит регион.
- [OfflineCacheManager.getDownloadedReleaseTime](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#getdownloadedreleasetimeint) - дата релиза загруженного региона.

## Загрузка офлайн-карт

Для управления статусом загрузки офлайн-карт отдельного региона MapKit SDK предоставляет следующий набор методов:

- [OfflineCacheManager.startDownload](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#startdownloadint) - начинает загрузку офлайн-карт;
- [OfflineCacheManager.stopDownload](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#stopdownloadint) - если загрузка карт была начата, отменяет ее;
- [OfflineCacheManager.pauseDownload](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#pausedownloadint) - приостанавливает загрузку офлайн-карт;
- [OfflineCacheManager.drop](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#dropint) - удаляет все офлайн-кэши для отдельного региона.

> [!TIP] Совет
> Используйте метод [OfflineCacheManager.mayBeOutOfAvailableSpace](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#maybeoutofavailablespaceint) для проверки наличия свободного места на устройстве прежде чем начинать загрузку.

Все методы управления статусом загрузки офлайн-карт принимают единственный аргумент - id региона, для которого применяется указанное действие. В результате выполнения данных методов [состояние регионов](map_offline.md#region-state) может измениться. Так, например, если регион доступен для скачивания, то после вызова метода [OfflineCacheManager.startDownload](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#startdownloadint) начнется его загрузка, и состояние региона изменится на `downloading`.

### Свойства загрузки

При помощи данных методов можно настроить свойства загрузки офлайн-карт:

- [OfflineCacheManager.allowUseCellularNetwork](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#allowusecellularnetworkboolean) - позволяет включить возможность загрузки и обновления офлайн-карт по мобильной сети (3G, LTE и т.п.).
- [OfflineCacheManager.enableAutoUpdate](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#enableautoupdateboolean) - активирует автоматическое обновление офлайн-кэшей для регионов, которые находятся в состоянии `need_update`.

### Обработка ошибок

В ходе загрузки происходит скачивание данных офлайн-карт с сервера и сохранения офлайн-кэшей на диске устройства. Для обработки различных ошибок, которые могут произойти в ходе данного процесса, используется интерфейс [OfflineCacheManager.ErrorListener](../../../com/yandex/mapkit/offline_cache/ErrorListener.md).

```kotlin
val listener = object : ErrorListener {
    override fun onError(error: Error) {
        when (error) {
            is LocalError -> {
                // Handle local error
            }
            is RemoteError -> {
                // Handle remote error
            }
            else -> { // Undefined error }
        }
    }

    override fun onRegionError(error: Error, regionId: Int) {
        // Handle error for region with regionId id
    }
}
```

Данный интерфейс предоставляет методы для обработки ошибок, связанных с загрузкой определенных регионов и работой [OfflineCacheManager](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md).

Ошибки могут быть двух типов:

- [LocalError](../../../com/yandex/runtime/LocalError.md) - ошибки на устройстве пользователя, например, повреждение диска, недостаток свободного места для сохранения;
- [RemoteError](../../../com/yandex/runtime/network/RemoteError.md) - ошибки со стороны сервера.

## Хранение офлайн-кэшей

Данные офлайн-карт, которые были получены во время их загрузки, MapKit SDK сохраняет на диске устройства в специальном формате офлайн-кэшей.

Для получения пути, по которому хранятся офлайн-кэши в файловой системе, используется метод [OfflineCacheManager.requestPath](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#requestpathpathgetterlistener).

```kotlin
offlineCacheManager.requestPath { path ->
    // Handle requested path
}
```

Данный метод принимает в качестве аргумента интерфейс [OfflineCacheManager.PathGetterListener](../../../com/yandex/mapkit/offline_cache/PathGetterListener.md), с помощью которого можно подписаться на событие получения пути.

Существует возможность изменить место хранения офлайн-кэшей на устройстве. Для этого предусмотрено два метода:

1. [OfflineCacheManager.setCachePath](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#setcachepathjavalangstring-pathsetterlistener) - позволяет изменить место на устройстве пользователя, в котором хранятся данные офлайн-кэшей. Если по заданному пути уже есть офлайн-кэши, то они будут использоваться, иначе, будут инициализированы новые кэши.
2. [OfflineCacheManager.moveData](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#movedatajavalangstring-datamovelistener) - переносит текущие офлайн-кэши в новое место на устройстве.

С помощью метода [OfflineCacheManager.computeCacheSize](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#computecachesizesizelistener) можно посчитать сколько памяти занимают все офлайн-кэши на устройстве пользователя.

Метод [OfflineCacheManager.clear](../../../com/yandex/mapkit/offline_cache/OfflineCacheManager.md#clearclearlistener) используется для удаления офлайн-кэшей.

## Исходный код

Подробнее с примерами использования API офлайн карт из MapKit SDK можно ознакомиться в демо-приложении `map-offline` в нашем [репозитории на GitHub](https://github.com/yandex/mapkit-android-demo).
