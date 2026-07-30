---
title: "Панорама"
kind: "Guide"
platform: "flutter"
language: "Dart"
section: "Flutter / Руководство / Панорама"
source: "https://yandex.ru/maps-api/docs/mapkit/flutter/generated/tutorials/map_panorama.html"
---
# Панорама

`FLUTTER` · `Dart` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/flutter/generated/tutorials/map_panorama.html)

MapKit SDK позволяет посмотреть, как выглядит какая-либо местность (например, достопримечательности, дороги или здания) в формате панорам.

> [!WARNING] Важно
> Функционал панорам доступен в [full](https://pub.dev/packages/yandex_maps_mapkit)-версии MapKit SDK.

## Виды панорам

MapKit SDK поддерживает несколько видов панорам:

1. Уличные панорамы.
   ![street_panorama](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_panorama/street_panorama.png)
2. Интерьерные панорамы.
   ![street_panorama](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_panorama/interior_panorama.png)
3. Воздушные панорамы.
   ![aerial_panorama](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_panorama/aerial_panorama.png)

## Просмотр панорамы

Выполните следующие шаги, чтобы посмотреть панораму:

1. Создайте и настройте [слой панорам](map_panorama.md#panorama_layer).

   ```dart
   PlacesFactory.instance.createPanoramaLayer(mapWindow)
     ..setStreetPanoramaVisible(true)
     ..setAirshipPanoramaVisible(true);
   ```

   - [PanoramaLayer.setStreetPanoramaVisible](https://pub.dev/documentation/yandex_maps_navikit/latest/places/PanoramaLayer/setStreetPanoramaVisible.html) включает отображение уличных и интерьерных панорам на карте.
   - [PanoramaLayer.setAirshipPanoramaVisible](https://pub.dev/documentation/yandex_maps_navikit/latest/places/PanoramaLayer/setAirshipPanoramaVisible.html) включает отображение воздушных панорам на карте.
2. Получите [идентификатор панорамы](map_panorama.md#get_panorama_id_example) в зависимости от выбранного типа панорамы:

   - Для получения идентификатора уличной или интерьерной панорамы используется метод [PanoramaService.findNearest](https://pub.dev/documentation/yandex_maps_navikit/latest/places/PanoramaService/findNearest.html). В него нужно передать точку на карте для поиска ближайшей к ней панорамы.
   - Для получения идентификатора воздушной панорамы нужно при помощи [GeoObject.metadataContainer](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/GeoObject/metadataContainer.html) получить объект [AirshipTapInfo](https://pub.dev/documentation/yandex_maps_navikit/latest/places/AirshipTapInfo-class.html), в котором содержится [panoramaId](https://pub.dev/documentation/yandex_maps_navikit/latest/places/AirshipTapInfo/panoramaId.html).
3. Наконец, для открытия панорамы ее идентификатор нужно передать в [PanoramaWidget](https://pub.dev/documentation/yandex_maps_navikit/latest/widgets/PanoramaWidget-class.html).

   ```dart
   void navigateToPanorama(String panoramaId) {
     Navigator.of(context).push(
       PageRouteBuilder(
         pageBuilder: (context, animation, secondaryAnimation) {
           return PanoramaWidget(
             onPanoramaCreated: (PanoramaPlayer panoramaPlayer) {
               panoramaPlayer.openPanorama(panoramaId);
             },
           );
         },
       )
     );
   }
   ```

   Также в документации класса [PanoramaPlayer](https://pub.dev/documentation/yandex_maps_navikit/latest/places/PanoramaPlayer-class.html) вы можете найти несколько методов, которые могут быть полезны для настройки панорамы.

## Слой панорам

Слой панорам позволяет увидеть на карте места, в которых можно открыть панораму. После создания этого слоя вы должны увидеть на карте новые объекты, которые обозначают места с доступной для просмотра панорамой:

- Синие точки и полилинии обозначают уличные или интерьерные панорамы.
- Иконки аэростата обозначают воздушные панорамы.

![panorama_layer](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_panorama/panorama_layer.png)

## Примеры получения идентификатора панорамы

Для получения идентификатора уличной или интерьерной панорамы вы можете использовать следующий код:

```dart
final class MapInputListenerImpl implements MapInputListener {

  final PanoramaService panoramaService;
  final PanoramaServiceSearchListener panoramaSearchListener;

  PanoramaServiceSearchSession? searchSession;

  const MapInputListenerImpl(
    this.panoramaService,
    this.panoramaSearchListener,
  );

  @override
  void onMapTap(Map map, Point point) {
    // You need to store reference to search session until panoramaSearchListener is notified
    searchSession = panoramaService.findNearest(
      point,
      panoramaSearchListener,
    );
  }

  @override
  void onMapLongTap(Map map, Point point) {}
}

final panoramaService = PlacesFactory.instance.createPanoramaService();

final panoramaSearchListener = PanoramaServiceSearchListener(
  onPanoramaSearchResult: (String panoramaId) => navigateToPanorama(panoramaId),
  onPanoramaSearchError: (error) {
    // Handle search error
  }
);

final mapInputListener = MapInputListenerImpl(
  panoramaService,
  panoramaSearchListener,
);

mapWindow.map.addInputListener(mapInputListener);
```

- В коллбэке [onMapTap(Map, Point)](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapInputListener/onMapTap.html) возвращается точка на карте, в которой произошло касание.
- Далее эта точка передается в [PanoramaService.findNearest](https://pub.dev/documentation/yandex_maps_navikit/latest/places/PanoramaService/findNearest.html) для поиска идентификатора ближайшей к ней панорамы.
- Когда идентификатор панорамы будет найден, он будет передан в [PanoramaServiceSearchListener](https://pub.dev/documentation/yandex_maps_navikit/latest/places/PanoramaServiceSearchListener-class.html).
- Подробнее про обработку тапов по карте можно почитать [здесь](map_interaction.md#taps).

Для получения идентификатора воздушной панорамы вы можете использовать следующий код:

```dart
final class LayersGeoObjectTapListenerImpl implements LayersGeoObjectTapListener {

  final bool Function(GeoObjectTapEvent) onObjectTapped;

  const LayersGeoObjectTapListenerImpl({
    required this.onObjectTapped,
  });

  @override
  bool onObjectTap(GeoObjectTapEvent event) => onObjectTapped(event);
}

final geoObjectTapListener = LayersGeoObjectTapListenerImpl(
  onObjectTapped: (event) {
    final geoObject = event.geoObject;
    final airshipTapInto = geoObject.airshipTapInfo;
    final point = geoObject.point;

    if (airshipTapInto != null && point != null) {
      navigateToPanorama(airshipTapInto.panoramaId);
      return true;
    }
    return false;
  }
);

mapWindow.map.addTapListener(geoObjectTapListener);
```

- Важно заметить, что иконка аэростата, которой обозначается воздушная панорама на карте, является объектом класса [GeoObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/GeoObject-class.html).
- Поэтому для получения объекта **GeoObject** при нажатии на иконку воздушной панорамы нужно использовать класс [LayersGeoObjectTapListener](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/LayersGeoObjectTapListener-class.html).
- Далее при помощи [GeoObject.metadataContainer](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/GeoObject/metadataContainer.html) вы сможете получить объект [AirshipTapInfo](https://pub.dev/documentation/yandex_maps_navikit/latest/places/AirshipTapInfo-class.html), в котором содержится [panoramaId](https://pub.dev/documentation/yandex_maps_navikit/latest/places/AirshipTapInfo/panoramaId.html).
- Подробнее о том, как взаимодействовать с объектами **GeoObject** можно прочитать [здесь](map_interaction.md#poi).

```dart
extension GeoObjectAirshipTapInfo on GeoObject {
  AirshipTapInfo? get airshipTapInfo {
    return metadataContainer.get(AirshipTapInfo.factory);
  }
}

extension ToponymGeoObjectMetadata on GeoObject {
  SearchToponymObjectMetadata? get toponymMetadata {
    return metadataContainer.get(SearchToponymObjectMetadata.factory);
  }
}

extension PointFromGeometry on GeoObject {
  Point? get pointFromGeometry {
    return geometry.map((item) => item.asPoint())
        .whereType<Point>()
        .firstOrNull;
  }
}

extension GeoObjectPoint on GeoObject {
  Point? get point {
    return toponymMetadata?.balloonPoint ?? pointFromGeometry;
  }
}
```

## Исходный код

Пример реализации просмотра панорам вы можете найти в приложении `map_panorama` в нашем [репозитории на GitHub](https://github.com/yandex/mapkit-flutter-demo).
