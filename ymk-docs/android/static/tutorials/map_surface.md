---
title: "Внешние surface"
kind: "Guide"
platform: "android"
language: "Kotlin/Java"
section: "Android / Руководство / Внешние Surface"
source: "https://yandex.ru/maps-api/docs/mapkit/android/static/tutorials/map_surface.html"
---
# Внешние surface

`ANDROID` · `Kotlin/Java` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/android/static/tutorials/map_surface.html)

MapKit SDK позволяет отрисовывать карту на несколько [Android Surface](https://developer.android.com/reference/android/view/Surface). Рендеринг одной карты в несколько Surface вместо отрисовки нескольких MapView позволяет снизить нагрузку на CPU, GPU, а также снизить расход памяти устройства.

> [!WARNING] Важно
> Рендеринг в Surface позволяет дублировать участок карты, а не рисовать отдельную карту на каждый Surface. Это значит, что отображаемая карта в Surface соответствует стилям, тайлам и прочим характеристикам MapWindow. При этом, управлять картой через Surface невозможно.

## Обертка над Surface

В MapKit SDK Android Surface передается в обернутом в [Surface](../../../com/yandex/runtime/view/Surface.md).

Такой Surface создается с помощью [SurfaceFactory.from(android.view.Surface)](../../../com/yandex/runtime/view/SurfaceFactory.md#fromandroidviewsurface).

```kotlin
val androidSurface = layout.surfaceView.holder.surface
val surface = SurfaceFactory.from(androidSurface)
```

## Работа с Surface

### Добавление Surface к MapView

> [!WARNING] Важно
> Установите `app:movable="true"` для MapView в XML Layout, чтобы включить возможность подключения android.view.Surface к соответствующему MapWindow.
> Например:
>
>
> ```xml
> <FrameLayout
>     xmlns:app="http://schemas.android.com/apk/res-auto"
>     xmlns:android="http://schemas.android.com/apk/res/android" >
>
>     <com.yandex.mapkit.map.MapView
>         android:id="@+id/map_view"
>         app:movable="true" />
>
> </FrameLayout>
> ```

Для добавления Surface к MapView используйте метод [MapWindow.addSurface(Surface)](../../../com/yandex/mapkit/map/MapWindow.md#addsurfacesurface), для удаления - [MapWindow.removeSurface(Surface)](../../../com/yandex/mapkit/map/MapWindow.md#removesurfacesurface).

### Добавление Surface к OffscreenMapWindow

Иногда для отображения карты на Surface нет необходимости отображать MapView, или же отображение на все Surface могут потребовать слишком большой MapView, который не влезет ни на один экран. Для таких случаев используйте [OffscreenMapWindow](../../../com/yandex/mapkit/map/OffscreenMapWindow.md).

Как и MapView, OffscreenMapWindow содержит в себе MapWindow, что позволяет работать с Surface. Но при этом OffscreenMapWindow не является View-элементом, из-за чего отрисовывается только на Surface.

Для создания OffscreenMapWindow используйте метод [MapKit.createOffscreenMapWindow](../../../com/yandex/mapkit/MapKit.md#createoffscreenmapwindowint-int).

### Расположение карты на Surface

Для изменения положения [фокуса карты](../../../com/yandex/mapkit/map/MapWindow.md#setfocuspointscreenpoint) внутри Surface используйте метод [Surface.setAnchorPoint(android.graphics.PointF)](../../../com/yandex/runtime/view/Surface.md#setanchorpointandroidgraphicspointf). Область которая будет отображена берется минимумом из размера карты и размера самого Surface. По умолчанию якорь совпадает с фокусом карты, поэтому он находится в центре Surface.

Якорь задается в пределах [0, 1] по каждой оси и означает точку на Surface, в которую попадет фокус карты. Фокус карты всегда будет виден на Surface, а диапазон якоря смещается так, чтобы пересечение Surface с картой никогда не выходило за нее. Так, например, якорь равный {0, 0} сместит точку фокуса карты в левый нижний угол Surface, а якорь равный {1, 1} сместит точку фокуса карты в правый верхний угол Surface.
Пример работы якорей на двух Surface:

Сама карта:

![Пример карты](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/map_surface/surface_anchor_map_example.png)

Два равноразмерных Surface с указанными якорями для них (якори приписаны рядом с соответстующим Surface):

![Пример якоря](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/map_surface/surface_anchor_surfaces_example.png)

> [!NOTE] Примечание
> Отрисовка на Surface, который больше или равен размером самой карте, всегда будет рисовать всю карту, и растягивать ее на весь Surface. Изменить положение карты на этом Surface не получится.
