---
title: "Поиск"
kind: "Guide"
platform: "flutter"
language: "Dart"
section: "Flutter / Руководство / Поиск"
source: "https://yandex.ru/maps-api/docs/mapkit/flutter/generated/tutorials/map_search.html"
---
# Поиск

`FLUTTER` · `Dart` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/flutter/generated/tutorials/map_search.html)

MapKit SDK позволяет искать различные места и объекты на карте по их названию. Например, при помощи поискового API можно получить список ресторанов поблизости, узнать о наличии заправочных станций вдоль маршрута или найти место по точному адресу. Кроме поиска по названию MapKit SDK предоставляет запросы к геокодеру. С его помощью можно определить координату объекта по его адресу или наоборот - узнать адрес по координате.

> [!WARNING] Важно
> Функционал поиска доступен в [full](https://pub.dev/packages/yandex_maps_mapkit)-версии MapKit SDK.

## Выполнение поискового запроса

Рассмотрим общий алгоритм выполнения поискового запроса с помощью MapKit SDK:

1. Создайте экземпляр класса [SearchManager](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchManager-class.html), он является входной точкой поискового API MapKit SDK.

   ```dart
   final searchManager = SearchFactory.instance.createSearchManager(SearchManagerType.Combined);
   ```

   При создании [SearchManager](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchManager-class.html) укажите его тип [SearchManagerType](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchManagerType.html), который определяет режим работы: офлайн, онлайн или смешанный.
2. Определите какой [тип поискового запроса](map_search.md#search-request-types) следует использовать в вашем случае.
   Например, поиск по тексту в некоторой геометрии - метод [SearchManager.submit](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchManager/submit.html).
3. Создайте экземпляр класса [SearchOptions](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchOptions-class.html), чтобы задать [параметры поиска](map_search.md#search-options) запроса.
   Пример параметров для поиска только по организациям:

   ```dart
   val searchOptions = SearchOptions(
     searchTypes: SearchType.Biz,
     resultPageSize: 32,
   );
   ```
4. Создайте новую [сессию поиска](map_search.md#search-session) с помощью одного из методов класса [SearchManager](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchManager-class.html), который соответствует нужному типу поискового запроса.
   Пример поиска мест, в которых можно поесть, например, кафе, рестораны и т.д.

   ```dart
   final session = searchManager.submit(
     VisibleRegionUtils.toPolygon(map.visibleRegion),
     searchOptions,
     searchSessionListener,
     text: "where to eat",
   );
   ```
5. Во время создания поисковой сессии, используйте следующий механизм для получения [результатов поискового запроса](map_search.md#search-result).
   Создайте объект типа интерфейса [SearchSessionSearchListener](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSessionSearchListener-class.html):

   ```dart
   final class SearchSessionSearchListenerImpl implements SearchSessionSearchListener {

     @override
     void onSearchResponse(SearchResponse response) {
       // Handle search response.
     }

     @override
     void onSearchError(Error error) {
       // Handle search error.
     }
   }
   ```

   Реализация данного интерфейса передается в качестве аргумента во все методы создания поисковой сессии.
   Передавайте такой объект в качестве аргумента во все методы создания поисковой сессии.

## Типы поисковых запросов

MapKit SDK предоставляет несколько типов поисковых запросов, каждый из которых реализует различные пользовательские сценарии поиска. Запросы делятся на следующие группы:

- [текстовый](map_search.md#text-search);
- [обратное геокодирование](map_search.md#reverse-geocoding);
- [запрос по URI](map_search.md#uri-search).

Рассмотрим основные особенности и различия каждого типа поисковых запросов.

### Текстовый поиск

Данный поиск осуществляется по тексту, который вводится пользователем.

Поиск по тексту обладает большой вариативностью. В зависимости от введенного текста можно искать, например, по:

- названию организации;
- адресу;
- названию рубрики ("Рестораны", "Фитнес");
- месту досуга ("Где погулять вечером");
- координате, например, (59.935493, 30.327392).

Для создания поисковой сессии текстового поиска используется два вида методов:

1. [SearchManager.submit](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchManager/submit.html) - осуществляет поиск объектов по тексту запроса, которые ограничены некоторой геометрией на карте: вдоль полилинии, рядом с точкой, внутри boundingBox или полигона.
2. [SearchManager.submitAlongPolyline](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchManager/submitAlongPolyline.html) - используется для поиска вдоль полилинии, но внутри заданного boundingBox или полигона. Данный метод полезен при осуществлении поиска вдоль некоторого маршрута внутри видимой области карты. Например, поиск заправочных станций, которые находятся на текущем маршруте.

При выполнении поиска вдоль маршрута MapKit SDK сортирует поисковые результаты в зависимости от расстояния найденных объектов до переданной полилинии и возвращает ближайшие.

### Обратное геокодирование

Обратное геокодирование решает следующую задачу - как по координате, которую указал пользователь, получить адрес или название расположенного там объекта.

Для создания поисковой сессии обратного поиска используется метод [SearchManager.submitPoint](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchManager/submitPoint.html), со следующими аргументами:

- `point` - точка, по координате которой будет происходить поиск.
- `zoom` - значение текущего уровня масштаба карты, оно используется для отбрасывания слишком малых объектов на малых зумах.

### URI поиск

Некоторые гео-объекты карты MapKit предоставляют строковый URI-идентификатор. Поиск по URI позволяет осуществить поиск по таким объектам. Получить URI можно при помощи [URI-метаданных](map_search.md#uri-object-metadata) гео-объекта.

Для создания сессии поиска по URI существует два вида методов:

1. [SearchManager.resolveURI](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchManager/resolveURI.html) - используется для поиска гео-объектов по их URI, который был получен с помощью [URI-метаданных](map_search.md#uri-object-metadata).
2. [SearchManager.searchByURI](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchManager/searchByURI.html) - позволяет найти несколько объектов по URI. Используется для осуществления поиска по геосаджесту с использованием URI.

## Параметры поиска

Каждый из типов поисковых запросов поддерживает передачу аргумента [SearchOptions](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchOptions-class.html) для определения параметров поиска.

Существует следующие виды параметров поиска:

- `searchTypes` - тип объектов для поиска: топонимы, компании или и то, и другое.
- `resultPageSize` - количество результатов на одну страницу поиска.
- `userPosition` - используется для вычисления дистанции от пользователя до объектов результата поиска.
- `geometry` - возвращение геометрии для найденного объекта (используется при поиске топонимов).
- `disableSpellingCorrection` - включает исправление ошибок в тексте поискового запроса.
- `filters` - задает параметры фильтрации для поискового запроса.

> [!WARNING] Важно
> В зависимости от [типа поискового запроса](map_search.md#search-types) некоторые параметры поиска могут быть **проигнорированы**.
>
>
> Чтобы узнать какие параметры поиска поддерживаются для конкретных типов поисковых запросов, смотрите документацию поисковых методов класса [SearchManager](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchManager-class.html).

## Сессия поиска

Поисковый запрос в MapKit SDK реализован в виде асинхронной операции, он может потребовать выполнения сетевого запроса, например, во время онлайн поиска. Каждый из методов создания поискового запроса класса [SearchManager](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchManager-class.html) возвращает объект сессии поиска [SearchSession](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSession-class.html), он управляет состоянием поискового запроса.

Пример создания поисковой сессии для поиска ресторанов на карте:

```dart
final session = searchManager.submit(
  VisibleRegionUtils.toPolygon(map.visibleRegion),
  SearchOptions(searchTypes: SearchType.Biz.value),
  searchListener,
  text: "Restaurant",
);
```

> [!WARNING] Важно
> Объект сессии [SearchSession](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSession-class.html) должен хранится на стороне клиентского приложения. Иначе поисковый запрос может быть автоматически отменен.

Класс [SearchSession](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSession-class.html) поддерживает большое количество операций по управлению поисковым запросом, например: отмена текущего запроса, получение следующей страницы с результатами, включение сортировки результатов по дистанции до конкретной геометрии и т.д. С помощью функционала повторного выполнения запроса можно изменить некоторые параметры первоначального запроса, а затем выполнить повторный запрос.

Пример использования созданного объекта [SearchSession](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSession-class.html) для создания повторного запроса с другой геометрией для поиска:

```dart
Session? _searchSession;

void resubmitAfterMove() {
  final geometry = VisibleRegionUtils.toPolygon(map.visibleRegion);
  searchSession?.setSearchArea(geometry);
  searchSession?.resubmit(searchSessionListener);
}
```

Данный метод можно использовать, например, при изменении положения камеры после свайпа карты.

## Результаты поиска

Для получения результатов поискового запроса используется подписка на интерфейс [SearchSessionSearchListener](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSessionSearchListener-class.html). Он передается аргументом во время вызова методов создания поискового запроса при помощи класса [SearchManager](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchManager-class.html).

[SearchSessionSearchListener](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSessionSearchListener-class.html) поддерживает два типа методов-обработчиков:

1. [SearchSessionSearchListener.onSearchResponse](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSessionSearchListener/onSearchResponse.html) - оповещает об успешном завершении поискового запроса. Предоставляет объект [SearchResponse](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchResponse-class.html), который содержит информацию о результатах запроса.
2. [SearchSessionSearchListener.onSearchError](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchSessionSearchListener/onSearchError.html) - событие завершения поискового запроса с ошибкой.

При успешном выполнении запроса можно получить объект [SearchResponse](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchResponse-class.html), он предоставляет информацию о:

- [коллекции гео-объектов](map_search.md#geo-object-collection);
- [метаданных поискового запроса](map_search.md#request-metadata);
- наличии или отсутствии офлайн запроса.

Рассмотрим более детально, из чего состоят данные об успешном выполнении запроса.

### Коллекция гео-объектов

Метод [SearchResponse.collection](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchResponse/collection.html) позволяет получить коллекцию найденных объектов. При помощи метода [GeoObjectCollection.children](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/GeoObjectCollection/children.html) можно получить список найденных [гео-объектов](map_search.md#search-geo-object).

```dart
@override
void onSearchResponse(response: Response) {
  final geoObjects = response.collection
      .children
      .map((it) => it.asGeoObject())
      .whereType<GeoObject>();
  // Process geoObjects collection.
}
```

### Гео-объекты

Класс [GeoObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/GeoObject-class.html) - это сущность MapKit SDK, которая предоставляет информацию об объектах на карте. Гео-объектом может являться организация, здание или какой-нибудь географический объект, например, страна, город или море.

Гео-объекты делятся на два типа:

1. Организации - например, рестораны, салоны красоты, государственные учреждения, школы, больницы, магазины, отели и другие компании.
2. Топонимы - строения, города, страны, различные географические объекты.

В контексте поискового API гео-объекты используются в качестве результата поиска. Наиболее используемыми параметрами гео-объектов во время поиска являются:

- `name` - название объекта.
- `geometry` - геометрия, содержит координату организации или геометрию топонима.
- `metadataContainer` - используется для расширения базового гео-объекта дополнительными метаданными.

У разных типов гео-объектов имеются разные виды метаданных.

#### UriObjectMetadata

При помощи типа [UriObjectMetadata](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/UriObjectMetadata-class.html) можно получить уникальный идентификатор для гео-объекта.

```dart
final uri = geoObject.metadataContainer.get(UriObjectMetadata.factory)?.uris.firstOrNull;
```

С помощью URI можно организовать функционал закладок в приложении. Пользователь выбирает понравившееся место (гео-объект), затем приложение сохраняет строковый идентификатор данного гео-объекта. Когда пользователь захочет вернуться к сохраненному месту, с помощью [поиска по URI](map_search.md#uri-search) можно получить гео-объект и отобразить его на карте.

#### SearchBusinessObjectMetadata

Класс [SearchBusinessObjectMetadata](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchBusinessObjectMetadata-class.html) содержит большое количество методов с разнообразной информацией о организации. [SearchBusinessObjectMetadata](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchBusinessObjectMetadata-class.html) можно получить только если данный гео-объект является организацией.

```dart
final metadata = geoObject.metadataContainer.get(SearchBusinessObjectMetadata.factory);
if (metadata != null) {
    // Geo object is a business organization.
} else {
    // Not an organization.
}
```

Ключевыми данными класса [SearchBusinessObjectMetadata](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchBusinessObjectMetadata-class.html) являются:

- `name` - название организации;
- `address` - адрес организации;
- `phones` - список номеров организации;
- `workingHours` - часы работы организации;
- `features` - список особенностей организации, например, наличие Wi-Fi или возможность оплатить картой.

#### SearchToponymObjectMetadata

С помощью класса [SearchToponymObjectMetadata](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchToponymObjectMetadata-class.html) можно получить дополнительную информацию о топониме: адрес, название и т.д. [SearchToponymObjectMetadata](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchToponymObjectMetadata-class.html) можно получить только если данный гео-объект является топонимом.

### Метаданные запроса

Метаданные запроса представлены классом [SearchMetadata](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchMetadata-class.html), они содержат дополнительную информацию о поисковом запросе.

Общая информация:

- `found` - примерное количество найденных объектов.
- `displayType` - тип отображения: `single` - результат не является частью какой-либо группы, скорее всего не нужно выполнять перезапрос при перемещении карты, `multiple` - результат может быть частью группы, имеет смысл делать перезапрос при перемещении карты.
- `boundingBox` - bounding box объектов-результатов на карте. Можно переместить карту в данную геометрию, чтобы показать результаты поиска на карте.
- `sort` - тип сортировки объектов в выдаче, например, по дистанции от пользователя.
- `toponym` - результат обратного геокодинга, если он был применен.
- `requestText` - текст запроса, который был введен пользователем при поиске.
- `correctedRequestText` - это `requestText`, после примененной автокоррекции текста.
- `requestBoundingBox` - bounding-box карты, который был передан во время создания запроса.

Кроме общей информации метаданные запроса содержат дополнительную информацию, которая зависит от типа поискового запроса, был ли это поиск организаций или топонимов:

- `toponym` - содержит гео-объект с результатом поиска топонимов.
- `toponymResultMetadata` - дополнительная информация о поисковом запросе топонимов.
- `businessResultMetadata` - дополнительная информация о поисковом запросе организаций.

Рассмотрим более подробно, в чем состоит отличия между `toponymResultMetadata` и `businessResultMetadata` метаданными.

#### SearchToponymResultMetadata

Представлен классом [SearchToponymResultMetadata](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchToponymResultMetadata-class.html), предоставляет данные о:

- количестве найденных топонимов;
- режиме и точности поиска;
- координате, по которой был осуществлен [обратный геокодинг](map_search.md#reverse-geocoding).

#### SearchBusinessResultMetadata

Класс [SearchBusinessResultMetadata](https://pub.dev/documentation/yandex_maps_navikit/latest/search/SearchBusinessResultMetadata-class.html) предоставляет данные о наличии:

- поисковых категорий в результате поиска;
- поисковых цепочек - список не пустой, если по запросу была найдена сетевая организация;
- поисковых фильтров.

## Исходный код

С примером использования функционала поискового API можно ознакомиться в приложении `map_search` в нашем [репозитории на GitHub](https://github.com/yandex/mapkit-flutter-demo).
