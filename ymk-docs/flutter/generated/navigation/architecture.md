---
title: "Общая архитектура NaviKit SDK"
kind: "Guide"
platform: "flutter"
language: "Dart"
section: "Flutter / NaviKit SDK / Общая архитектура"
source: "https://yandex.ru/maps-api/docs/mapkit/flutter/generated/navigation/architecture.html"
---
# Общая архитектура NaviKit SDK

`FLUTTER` · `Dart` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/flutter/generated/navigation/architecture.html)

NaviKit SDK предоставляет широкий функционал и содержит большое количество классов и компонентов. Для того, чтобы упростить процесс интеграции навигационных сценариев в ваше приложение, важно понимать общую архитектуру NaviKit SDK.

Ниже рассмотрены основные сущности, входящие в состав NaviKit SDK, и их зависимости друг от друга.

## Диаграмма

На диаграмме изображены основные компоненты из NaviKit SDK.

![NaviKit SDK entities diagram](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/navigation/architecture/navigation_entities_diagram.png)

Данные сущности можно разделить на две группы: full MapKit SDK и более общая группа NaviKit SDK.

## Сущности MapKit SDK

NaviKit SDK включает в себя весь функционал [full](https://pub.dev/packages/yandex_maps_mapkit)-версии MapKit SDK. Поэтому на диаграмме сущности **Map** и **Directions** находятся в отдельной группе MapKit SDK full.

- **Map** - отвечает за API работы непосредственно с картой, ее отображение, настройку и стилизацию.
- **Directions** - включает в себя функционал маршрутизации, построения [маршрутов](../tutorials/map_routes.md), который представляется в full-версии MapKit SDK.

## Сущности NaviKit SDK

NaviKit SDK является надстройкой над full-версией MapKit SDK, предоставляя доступ к дополнительным компонентам:

- **Navigation** - компонент инкапсулирует логику [построения маршрутов](routes_building.md), а также информацию о текущем состоянии [ведения](guidance.md). Навигация не зависит от компонента карты и не содержит логику отображении объектов.
- **Navigation Layer** - [навигационный слой](navigation_layer.md) позволяет связать сущности карты и навигации. С помощью него на карте рисуются маршруты, маневры, контрольные точки и дорожные события.
