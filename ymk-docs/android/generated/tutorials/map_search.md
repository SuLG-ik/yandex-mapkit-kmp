---
title: "Поиск"
kind: "Guide"
platform: "android"
language: "Kotlin/Java"
section: "Android / Руководство / Поиск"
source: "https://yandex.ru/maps-api/docs/mapkit/android/generated/tutorials/map_search.html"
---
# Поиск

`ANDROID` · `Kotlin/Java` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/android/generated/tutorials/map_search.html)

MapKit SDK позволяет искать различные места и объекты на карте по их названию. Например, при помощи поискового API можно получить список ресторанов поблизости, узнать о наличии заправочных станций вдоль маршрута или найти место по точному адресу. Кроме поиска по названию MapKit SDK предоставляет запросы к геокодеру. С его помощью можно определить координату объекта по его адресу или наоборот - узнать адрес по координате.

> [!WARNING] Важно
> Функционал поиска доступен в [full](../getting_started.md#add-library)-версии MapKit SDK.

## Выполнение поискового запроса

Рассмотрим общий алгоритм выполнения поискового запроса с помощью MapKit SDK:

1. Создайте экземпляр класса [SearchManager](../../../com/yandex/mapkit/search/SearchManager.md), он является входной точкой поискового API MapKit SDK.

   ```kotlin
   val searchManager = SearchFactory.getInstance().createSearchManager(SearchManagerType.COMBINED)
   ```

   При создании [SearchManager](../../../com/yandex/mapkit/search/SearchManager.md) укажите его тип [SearchManagerType](../../../com/yandex/mapkit/search/SearchManagerType.md), который определяет режим работы: офлайн, онлайн или смешанный.
2. Определите какой [тип поискового запроса](map_search.md#search-request-types) следует использовать в вашем случае.
   Например, поиск по тексту в некоторой геометрии - метод [SearchManager.submit(String, Geometry, SearchOptions, SearchListener)](../../../com/yandex/mapkit/search/SearchManager.md#submitjavalangstring-geometry-searchoptions-searchlistener).
3. Создайте экземпляр класса [SearchOptions](../../../com/yandex/mapkit/search/SearchOptions.md), чтобы задать [параметры поиска](map_search.md#search-options) запроса.
   Пример параметров для поиска только по организациям:

   ```kotlin
   val searchOptions = SearchOptions().apply {
       searchTypes = SearchType.Biz
       resultPageSize = 32
   }
   ```
4. Создайте новую [сессию поиска](map_search.md#search-session) с помощью одного из методов класса [SearchManager](../../../com/yandex/mapkit/search/SearchManager.md), который соответствует нужному типу поискового запроса.
   Пример поиска мест, в которых можно поесть, например, кафе, рестораны и т.д.

   ```kotlin
   val session = searchManager.submit(
       "where to eat",
       VisibleRegionUtils.toPolygon(map.visibleRegion),
       searchOptions,
       searchSessionListener,
   )
   ```
5. Во время создания поисковой сессии, используйте следующий механизм для получения [результатов поискового запроса](map_search.md#search-result).
   Создайте объект типа интерфейса [SearchListener](../../../com/yandex/mapkit/search/SearchListener.md):

   ```kotlin
   val searchSessionListener = object : SearchSessionListener {
       override fun onSearchResponse(response: Response) {
           // Handle search response.
       }

       override fun onSearchError(error: Error) {
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

1. [SearchManager.submit(String, Geometry, SearchOptions, SearchListener)](../../../com/yandex/mapkit/search/SearchManager.md#submitjavalangstring-geometry-searchoptions-searchlistener) - осуществляет поиск объектов по тексту запроса, которые ограничены некоторой геометрией на карте: вдоль полилинии, рядом с точкой, внутри boundingBox или полигона.
2. [SearchManager.submit(String, Polyline, Geometry, SearchOptions, SearchListener)](../../../com/yandex/mapkit/search/SearchManager.md#submitjavalangstring-polyline-geometry-searchoptions-searchlistener) - используется для поиска вдоль полилинии, но внутри заданного boundingBox или полигона. Данный метод полезен при осуществлении поиска вдоль некоторого маршрута внутри видимой области карты. Например, поиск заправочных станций, которые находятся на текущем маршруте.

При выполнении поиска вдоль маршрута MapKit SDK сортирует поисковые результаты в зависимости от расстояния найденных объектов до переданной полилинии и возвращает ближайшие.

### Обратное геокодирование

Обратное геокодирование решает следующую задачу - как по координате, которую указал пользователь, получить адрес или название расположенного там объекта.

Для создания поисковой сессии обратного поиска используется метод [SearchManager.submit(Point, Float, SearchOptions, SearchListener)](../../../com/yandex/mapkit/search/SearchManager.md#submitpoint-javalanginteger-searchoptions-searchlistener), со следующими аргументами:

- `point` - точка, по координате которой будет происходить поиск.
- `zoom` - значение текущего уровня масштаба карты, оно используется для отбрасывания слишком малых объектов на малых зумах.

### URI поиск

Некоторые гео-объекты карты MapKit предоставляют строковый URI-идентификатор. Поиск по URI позволяет осуществить поиск по таким объектам. Получить URI можно при помощи [URI-метаданных](map_search.md#uri-object-metadata) гео-объекта.

Для создания сессии поиска по URI существует два вида методов:

1. [SearchManager.resolveURI](../../../com/yandex/mapkit/search/SearchManager.md#resolveurijavalangstring-searchoptions-searchlistener) - используется для поиска гео-объектов по их URI, который был получен с помощью [URI-метаданных](map_search.md#uri-object-metadata).
2. [SearchManager.searchByURI](../../../com/yandex/mapkit/search/SearchManager.md#searchbyurijavalangstring-searchoptions-searchlistener) - позволяет найти несколько объектов по URI. Используется для осуществления поиска по геосаджесту с использованием URI.

## Параметры поиска

Каждый из типов поисковых запросов поддерживает передачу аргумента [SearchOptions](../../../com/yandex/mapkit/search/SearchOptions.md) для определения параметров поиска.

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
> Чтобы узнать какие параметры поиска поддерживаются для конкретных типов поисковых запросов, смотрите документацию поисковых методов класса [SearchManager](../../../com/yandex/mapkit/search/SearchManager.md).

## Сессия поиска

Поисковый запрос в MapKit SDK реализован в виде асинхронной операции, он может потребовать выполнения сетевого запроса, например, во время онлайн поиска. Каждый из методов создания поискового запроса класса [SearchManager](../../../com/yandex/mapkit/search/SearchManager.md) возвращает объект сессии поиска [Session](../../../com/yandex/mapkit/search/Session.md), он управляет состоянием поискового запроса.

Пример создания поисковой сессии для поиска ресторанов на карте:

```kotlin
val session = searchManager.submit(
    "Restaurant",
    VisibleRegionUtils.toPolygon(map.mapRegion),
    SearchOptions().apply {
        searchTypes = SearchType.BIZ.value
    },
    searchListener
)
```

> [!WARNING] Важно
> Объект сессии [Session](../../../com/yandex/mapkit/search/Session.md) должен хранится на стороне клиентского приложения. Иначе поисковый запрос может быть автоматически отменен.

Класс [Session](../../../com/yandex/mapkit/search/Session.md) поддерживает большое количество операций по управлению поисковым запросом, например: отмена текущего запроса, получение следующей страницы с результатами, включение сортировки результатов по дистанции до конкретной геометрии и т.д. С помощью функционала повторного выполнения запроса можно изменить некоторые параметры первоначального запроса, а затем выполнить повторный запрос.

Пример использования созданного объекта [Session](../../../com/yandex/mapkit/search/Session.md) для создания повторного запроса с другой геометрией для поиска:

```kotlin
private var searchSession: Session?

fun resubmitAfterMove() {
    val geometry = VisibleRegionUtils.toPolygon(map.visibleRegion)
    searchSession?.setSearchArea(geometry)
    searchSession?.resubmit(searchSessionListener)
}
```

Данный метод можно использовать, например, при изменении положения камеры после свайпа карты.

## Результаты поиска

Для получения результатов поискового запроса используется подписка на интерфейс [SearchListener](../../../com/yandex/mapkit/search/SearchListener.md). Он передается аргументом во время вызова методов создания поискового запроса при помощи класса [SearchManager](../../../com/yandex/mapkit/search/SearchManager.md).

[SearchListener](../../../com/yandex/mapkit/search/SearchListener.md) поддерживает два типа методов-обработчиков:

1. [SearchListener.onSearchResponse](../../../com/yandex/mapkit/search/SearchListener.md#onsearchresponseresponse) - оповещает об успешном завершении поискового запроса. Предоставляет объект [Response](../../../com/yandex/mapkit/search/Response.md), который содержит информацию о результатах запроса.
2. [SearchListener.onSearchError](../../../com/yandex/mapkit/search/SearchListener.md#onsearcherrorerror) - событие завершения поискового запроса с ошибкой.

При успешном выполнении запроса можно получить объект [Response](../../../com/yandex/mapkit/search/Response.md), он предоставляет информацию о:

- [коллекции гео-объектов](map_search.md#geo-object-collection);
- [метаданных поискового запроса](map_search.md#request-metadata);
- наличии или отсутствии офлайн запроса.

Рассмотрим более детально, из чего состоят данные об успешном выполнении запроса.

### Коллекция гео-объектов

Метод [Response.getCollection](../../../com/yandex/mapkit/search/Response.md#getcollection) позволяет получить коллекцию найденных объектов. При помощи метода [GeoObjectCollection.getChildren](../../../com/yandex/mapkit/GeoObjectCollection.md#getchildren) можно получить список найденных [гео-объектов](map_search.md#search-geo-object).

```kotlin
override fun onSearchResponse(response: Response) {
    val geoObjects = response.collection.children.mapNotNull { it.obj }
    // Process geoObjects collection.
}
```

### Гео-объекты

Класс [GeoObject](../../../com/yandex/mapkit/GeoObject.md) - это сущность MapKit SDK, которая предоставляет информацию об объектах на карте. Гео-объектом может являться организация, здание или какой-нибудь географический объект, например, страна, город или море.

Гео-объекты делятся на два типа:

1. Организации - например, рестораны, салоны красоты, государственные учреждения, школы, больницы, магазины, отели и другие компании.
2. Топонимы - строения, города, страны, различные географические объекты.

В контексте поискового API гео-объекты используются в качестве результата поиска. Наиболее используемыми параметрами гео-объектов во время поиска являются:

- `name` - название объекта.
- `geometry` - геометрия, содержит координату организации или геометрию топонима.
- `metadataContainer` - используется для расширения базового гео-объекта дополнительными метаданными.

У разных типов гео-объектов имеются разные виды метаданных.

#### UriObjectMetadata

При помощи типа [UriObjectMetadata](../../../com/yandex/mapkit/uri/UriObjectMetadata.md) можно получить уникальный идентификатор для гео-объекта.

```kotlin
val uri = geoObject.metadataContainer.getItem<UriObjectMetadata>()?.uris?.firstOrNull()
```

С помощью URI можно организовать функционал закладок в приложении. Пользователь выбирает понравившееся место (гео-объект), затем приложение сохраняет строковый идентификатор данного гео-объекта. Когда пользователь захочет вернуться к сохраненному месту, с помощью [поиска по URI](map_search.md#uri-search) можно получить гео-объект и отобразить его на карте.

#### BusinessObjectMetadata

Класс [BusinessObjectMetadata](../../../com/yandex/mapkit/search/BusinessObjectMetadata.md) содержит большое количество методов с разнообразной информацией о организации. [BusinessObjectMetadata](../../../com/yandex/mapkit/search/BusinessObjectMetadata.md) можно получить только если данный гео-объект является организацией.

```kotlin
val metadata = geoObject.metadataContainer.getItem<BusinessObjectMetadata>()
if (metadata != null) {
    // Geo object is a business organization.
} else {
    // Not an organization.
}
```

Ключевыми данными класса [BusinessObjectMetadata](../../../com/yandex/mapkit/search/BusinessObjectMetadata.md) являются:

- `name` - название организации;
- `address` - адрес организации;
- `phones` - список номеров организации;
- `workingHours` - часы работы организации;
- `features` - список особенностей организации, например, наличие Wi-Fi или возможность оплатить картой.

#### ToponymObjectMetadata

С помощью класса [ToponymObjectMetadata](../../../com/yandex/mapkit/search/ToponymObjectMetadata.md) можно получить дополнительную информацию о топониме: адрес, название и т.д. [ToponymObjectMetadata](../../../com/yandex/mapkit/search/ToponymObjectMetadata.md) можно получить только если данный гео-объект является топонимом.

### Метаданные запроса

Метаданные запроса представлены классом [SearchMetadata](../../../com/yandex/mapkit/search/SearchMetadata.md), они содержат дополнительную информацию о поисковом запросе.

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

#### ToponymResultMetadata

Представлен классом [ToponymResultMetadata](../../../com/yandex/mapkit/search/ToponymResultMetadata.md), предоставляет данные о:

- количестве найденных топонимов;
- режиме и точности поиска;
- координате, по которой был осуществлен [обратный геокодинг](map_search.md#reverse-geocoding).

#### BusinessResultMetadata

Класс [BusinessResultMetadata](../../../com/yandex/mapkit/search/BusinessResultMetadata.md) предоставляет данные о наличии:

- поисковых категорий в результате поиска;
- поисковых цепочек - список не пустой, если по запросу была найдена сетевая организация;
- поисковых фильтров.

## Исходный код

С примером использования функционала поискового API можно ознакомиться в приложении `map-search` в нашем [GitHub репозитории](https://github.com/yandex/mapkit-android-demo).
