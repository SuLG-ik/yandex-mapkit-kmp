# Обзор

[![Kotlin](https://img.shields.io/badge/kotlin-{{ kotlin_version }}-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v{{ compose_version }}-blue)](https://github.com/JetBrains/compose-multiplatform)
[![Maven Central](https://img.shields.io/maven-central/v/ru.sulgik.mapkit/yandex-mapkit-kmp?color=blue)](https://search.maven.org/artifact/ru.sulgik.mapkit/yandex-mapkit-kmp)
[![License](https://img.shields.io/badge/License-Apache/2.0-blue.svg)](https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/LICENSE)
![badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat&color=blue)
![badge-ios](http://img.shields.io/badge/platform-ios-CDCDCD.svg?style=flat&color=blue)

Kotlin-first SDK для Yandex MapKit. API читается так же, как оригинальный, но живёт в общем коде —
одна реализация логики карты работает и на Android, и на iOS, а рисовать её можно через Compose
Multiplatform.

!!! info "Это не проект Яндекса"
    Автор не связан с оригинальным SDK; это обёртка над официальным
    [Yandex MapKit SDK](https://yandex.ru/dev/mapkit/doc/). Документация Яндекса остаётся полезной и
    здесь: обёртка сохраняет имена пакетов, типов и членов MapKit.

```kotlin
@Composable
fun MapScreen() {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition(Point(55.751225, 37.629540), zoom = 15f, azimuth = 0f, tilt = 0f)
    }
    YandexMap(cameraPositionState = cameraPositionState, modifier = Modifier.fillMaxSize()) {
        Placemark(
            state = rememberPlacemarkState(Point(55.751225, 37.629540)),
            icon = imageProvider(Res.drawable.pin_red),
        )
    }
}
```

## Что покрыто

Обёртка нацелена на сборку **lite** MapKit `{{ mapkit_version }}`, и всё, что lite отдаёт на обеих
платформах, доступно из общего кода:

- сама карта — `MapKit`, `MapView`, `MapWindow`, `Map`, `CameraPosition`, `VisibleRegion`,
  `CameraBounds`, `Logo`, стили карты, планы помещений;
- объекты карты — метки, ломаные, полигоны, окружности, коллекции, кластеризация и объекты
  представления (`Icon`, `CompositeIcon`, `Model`, `PlacemarkAnimation`, `PlacemarkText`);
- объекты базовой карты — `GeoObject` и его метаданные за нажатием на POI, здание или топоним;
- геолокация — `LocationManager`, `UserLocationLayer`, симулятор и фиктивный менеджер;
- слои — свои тайловые слои, слои объектов карты, пробки;
- хранилище и офлайн-карты — `StorageManager`, `OfflineCacheManager`;
- runtime — иерархия `Error`, логирование и `I18nManager`;
- `ImageProvider` и `AnimatedImageProvider` с адаптерами для ресурсов Compose Multiplatform и
  [moko-resources](https://github.com/icerockdev/moko-resources).

[Что обёрнуто](wrapper/coverage.md) расписывает каждый пакет, включая те несколько членов, которые
оставлены за бортом осознанно.

Сборка **full** — поиск, маршрутизация, панорамы, дорожные события, персонализация — не обёрнута:
этих типов нет в lite SDK.

## Два способа нарисовать карту

=== "Compose Multiplatform"

    `yandex-mapkit-kmp-compose` рисует карту и её объекты из общего кода. Объекты карты — отдельная
    композиция, поэтому `Placemark`, `Polyline`, `Polygon`, `Circle`, `Clustering`, `TileLayer` и
    `TrafficLayer` — это composable-функции, которые сами добавляют себя на карту и убирают, когда
    покидают композицию.

    [Обзор Compose](compose/overview.md)

=== "Платформенные View"

    `yandex-mapkit-kmp` сам ничего не рисует. Создайте `MapView` так же, как это делает официальный
    SDK, преобразуйте его через `toCommon()` и передайте в общий код, который дальше управляет
    картой через API обёртки.

    [Обзор обёртки](wrapper/overview.md)

## Задача обёртки

- Писать логику карты один раз, в общем коде.
- Сохранить оригинальный API. `com.yandex.mapkit.map.Map` превращается в `ru.sulgik.mapkit.map.Map`,
  и [официальная документация](https://yandex.ru/dev/mapkit/doc/) продолжает работать.
- Сделать это по-котлиновски: `Duration` и `Instant` вместо голых чисел, nullable-типы вместо
  значений-заглушек, `data class` для value-типов, лямбды для слушателей.
- Поддержать мультиплатформенные ресурсы — ресурсы Compose Multiplatform и
  [moko-resources](https://github.com/icerockdev/moko-resources).

!!! warning "До 1.0.0"
    Это библиотека одного автора, опубликованная для сообщества, а не продукт команды. API ещё
    формируется и может меняться между минорными версиями; что именно гарантируется, описано в
    разделе [Совместимость](getting-started/contributing.md#совместимость).

## Автор

- [@SuLG-ik](https://github.com/SuLG-ik) — основной разработчик. Telegram:
  [@vollllodya](https://t.me/vollllodya)
