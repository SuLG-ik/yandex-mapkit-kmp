---
title: "Офлайн карты"
kind: "Guide"
platform: "flutter"
language: "Dart"
section: "Flutter / Руководство / Офлайн карты"
source: "https://yandex.ru/maps-api/docs/mapkit/flutter/generated/tutorials/map_offline.html"
---
# Офлайн карты

`FLUTTER` · `Dart` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/flutter/generated/tutorials/map_offline.html)

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

В MapKit SDK регион описывается классом [OfflineCacheRegion](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheRegion-class.html) и предоставляет следующие данные:

- `id` - уникальный идентификатор региона;
- `name` - название региона;
- `center` - координаты центра региона;
- `size` - размер в байтах для скачивания данных этого региона;
- `releaseTime` - временная метка, когда офлайн карты для данного региона были последний раз обновлены на сервере;
- `parentId` - идентификатор родительского региона, например: Москва в качестве родительского региона содержит Московскую область.

### Получение списка регионов

Точкой входа в API управления офлайн-кэшами является класс [OfflineCacheManager](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager-class.html). Экземпляр этого класса хранится в виде синглтона в MapKit SDK. Для его получения используется метод [mapkit.offlineCacheManager](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapKit/offlineCacheManager.html).

```dart
final offlineCacheManager = mapkit.offlineCacheManager;
```

Для получения списка всех доступных регионов используется подписка на событие обновления списка регионов с помощью интерфейса [OfflineMapRegionListUpdatesListener](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineMapRegionListUpdatesListener-class.html).

```dart
final class OfflineCacheRegionListenerImpl implements OfflineMapRegionListUpdatesListener {

  @override
  void onListUpdated() {
    final regions = offlineCacheManager.regions();
    // Handle regions update
  }
}

final listener = OfflineCacheRegionListenerImpl();
offlineCacheManager.addRegionListUpdatesListener(listener)
```

C помощью метода [OfflineCacheManager.regions](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/regions.html) можно получить список обновленных регионов.

### Состояние региона

Состояние региона описывается перечислением [OfflineCacheRegionState](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheRegionState.html):

- `available` - офлайн-карты данного региона доступны для загрузки;
- `downloading` - офлайн-карты в процессе загрузки;
- `paused` - процесс загрузки был приостановлен и может быть возобновлен;
- `completed` - загрузка данных завершена успешно;
- `outdated` - на сервере есть более новая версия офлайн-карт для данного региона;
- `unsupported` - офлайн-карты данного региона загружены, но больше не поддерживаются, после их удаления с устройства регион пропадет из доступных для загрузки;
- `need_update` - данные сильно устарели, требуется загрузить новую версию.

Для получения текущего состояния для отдельного региона используется метод [OfflineCacheManager.getState](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/getState.html).

MapKit SDK предоставляет возможность подписаться на события изменения состояния регионов с помощью интерфейса [OfflineCacheRegionListener](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheRegionListener-class.html). Он предоставляет два метода для переопределения:

1. [OfflineCacheRegionListener.onRegionStateChanged](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheRegionListener/onRegionStateChanged.html) - оповещает об изменении состояния отдельного региона.
2. [OfflineCacheRegionListener.onRegionProgress](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheRegionListener/onRegionProgress.html) - оповещает об изменении статуса загрузки офлайн-карты региона.

```dart
final class OfflineCacheRegionListenerImpl implements OfflineCacheRegionListener {

  @override
  void onRegionStateChanged(int regionId) {
    final state = offlineCacheManager.getState(regionId);
    // Handle region state changes
  }

  @override
  void onRegionProgress(int regionId) {
    final progress = offlineCacheManager.getProgress(regionId);
    // Handle region progress changes
  }
}

final regionListener = OfflineCacheRegionListenerImpl();
offlineCacheManager.addRegionListener(regionListener);
```

### Дополнительная информация о регионах

При помощи следующих методов можно получить дополнительную информацию о регионах:

- [OfflineCacheManager.getCities](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/getCities.html) - получение списка из названий городов, которые содержит регион.
- [OfflineCacheManager.getDownloadedReleaseTime](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/getDownloadedReleaseTime.html) - дата релиза загруженного региона.

## Загрузка офлайн-карт

Для управления статусом загрузки офлайн-карт отдельного региона MapKit SDK предоставляет следующий набор методов:

- [OfflineCacheManager.startDownload](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/startDownload.html) - начинает загрузку офлайн-карт;
- [OfflineCacheManager.stopDownload](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/stopDownload.html) - если загрузка карт была начата, отменяет ее;
- [OfflineCacheManager.pauseDownload](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/pauseDownload.html) - приостанавливает загрузку офлайн-карт;
- [OfflineCacheManager.drop](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/drop.html) - удаляет все офлайн-кэши для отдельного региона.

> [!TIP] Совет
> Используйте метод [OfflineCacheManager.mayBeOutOfAvailableSpace](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/mayBeOutOfAvailableSpace.html) для проверки наличия свободного места на устройстве прежде чем начинать загрузку.

Все методы управления статусом загрузки офлайн-карт принимают единственный аргумент - id региона, для которого применяется указанное действие. В результате выполнения данных методов [состояние регионов](map_offline.md#region-state) может измениться. Так, например, если регион доступен для скачивания, то после вызова метода [OfflineCacheManager.startDownload](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/startDownload.html) начнется его загрузка, и состояние региона изменится на `downloading`.

### Свойства загрузки

При помощи данных методов можно настроить свойства загрузки офлайн-карт:

- [OfflineCacheManager.allowUseCellularNetwork](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/allowUseCellularNetwork.html) - позволяет включить возможность загрузки и обновления офлайн-карт по мобильной сети (3G, LTE и т.п.).
- [OfflineCacheManager.enableAutoUpdate](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/enableAutoUpdate.html) - активирует автоматическое обновление офлайн-кэшей для регионов, которые находятся в состоянии `need_update`.

### Обработка ошибок

В ходе загрузки происходит скачивание данных офлайн-карт с сервера и сохранения офлайн-кэшей на диске устройства. Для обработки различных ошибок, которые могут произойти в ходе данного процесса, используется интерфейс [OfflineCacheManagerErrorListener](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManagerErrorListener-class.html).

```dart
final class OfflineCacheManagerErrorListenerImpl implements OfflineCacheManagerErrorListener {

  @override
  void onError(Error error) {
    switch (error.runtimeType) {
      case LocalError:
        // Handle local error
      case RemoteError:
        // Handle remote error
      default:
        // Handle undefined error
    }
  }

  @override
  void onRegionError(Error error, int regionId) {
    // Handle error for region with regionId id
  }
}
```

Данный интерфейс предоставляет методы для обработки ошибок, связанных с загрузкой определенных регионов и работой [OfflineCacheManager](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager-class.html).

Ошибки могут быть двух типов:

- [LocalError](https://pub.dev/documentation/yandex_maps_navikit/latest/runtime/LocalError-class.html) - ошибки на устройстве пользователя, например, повреждение диска, недостаток свободного места для сохранения;
- [RemoteError](https://pub.dev/documentation/yandex_maps_navikit/latest/runtime/RemoteError-class.html) - ошибки со стороны сервера.

## Хранение офлайн-кэшей

Данные офлайн-карт, которые были получены во время их загрузки, MapKit SDK сохраняет на диске устройства в специальном формате офлайн-кэшей.

Для получения пути, по которому хранятся офлайн-кэши в файловой системе, используется метод [OfflineCacheManager.requestPath](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/requestPath.html).

```dart
offlineCacheManager.requestPath(
  OfflineCacheManagerPathGetterListener(onPathReceived: (path) => /* Handle requested path */)
);
```

Данный метод принимает в качестве аргумента интерфейс [OfflineCacheManagerPathGetterListener](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManagerPathGetterListener-class.html), с помощью которого можно подписаться на событие получения пути.

Существует возможность изменить место хранения офлайн-кэшей на устройстве. Для этого предусмотрено два метода:

1. [OfflineCacheManager.setCachePath](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/setCachePath.html) - позволяет изменить место на устройстве пользователя, в котором хранятся данные офлайн-кэшей. Если по заданному пути уже есть офлайн-кэши, то они будут использоваться, иначе, будут инициализированы новые кэши.
2. [OfflineCacheManager.moveData](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/moveData.html) - переносит текущие офлайн-кэши в новое место на устройстве.

С помощью метода [OfflineCacheManager.computeCacheSize](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/computeCacheSize.html) можно посчитать сколько памяти занимают все офлайн-кэши на устройстве пользователя.

Метод [OfflineCacheManager.clear](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/OfflineCacheManager/clear.html) используется для удаления офлайн-кэшей.

## Исходный код

Подробнее с примерами использования API офлайн карт из MapKit SDK можно ознакомиться в демо-приложении `map_offline` в нашем [репозитории на GitHub](https://github.com/yandex/mapkit-flutter-demo).
