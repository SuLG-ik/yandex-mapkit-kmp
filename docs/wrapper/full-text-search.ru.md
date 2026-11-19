# Текстовый поиск Full

`SearchManager` ищет по тексту в заданной области из общего кода Kotlin. MapKit возвращает
организации и топонимы как [геообъекты](geoobjects.ru.md). Пустая коллекция означает успешное
завершение запроса без результатов.

## Установка

Подключите обёртку Full. Для каждого дополнительного модуля обёртки в приложении используйте
соответствующий артефакт с суффиксом `-full`.

```kotlin
commonMain.dependencies {
    implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-full:{{ version }}")
}
```

Android получает `com.yandex.android:maps.mobile:{{ mapkit_version_full }}` через обёртку.
На iOS укажите ту же версию Full для `YandexMapsMobile` в общем модуле и приложении Xcode.

```kotlin
cocoapods {
    ios.deploymentTarget = "15.0"
    pod("YandexMapsMobile") {
        version = "{{ mapkit_version_full }}"
        packageName = "YandexMapKit"
    }
}
```

Выполните [инициализацию на платформе](../getting-started/quick-start.ru.md) и укажите действующий
ключ MapKit. [Тестовое приложение] проверяет установку Full и создание менеджера без сетевого
запроса.

## Выполнение запроса

Храните менеджер и текущую сессию в модели экрана. Вызовите поиск из UI-потока и передайте точку,
ограничивающий прямоугольник, полилинию или прямоугольный полигон. У полигона должно быть четыре
угловые точки и необязательная замыкающая точка. Используйте внешний контур без внутренних колец.

```kotlin
val manager = Search.getInstance().createSearchManager(SearchManagerType.ONLINE)
val area = BoundingBox(southWest, northEast).toGeometry()
val session = manager.submit(
    text = "coffee",
    geometry = area,
    searchOptions = SearchOptions(searchTypes = SearchType.BIZ.value, geometry = true),
    searchListener = SearchListener(
        onSearchResponse = { response ->
            val places = response.collection.children.mapNotNull { it.obj }
            showPlaces(places.mapNotNull { obj ->
                val name = obj.name
                val point = obj.geometry.firstNotNullOfOrNull { it.point }
                if (name != null && point != null) name to point else null
            })
        },
        onSearchError = { error -> showFailure(error.description ?: "Поиск не удался") },
    ),
)
```

Сохраните `session` в поле и вызывайте `cancel()` при замене запроса и при уходе с экрана. Обёртка
держит слушатель, пока запрос выполняется, и освобождает при ответе или отмене. Ответ, пришедший
после отмены, игнорируется. Это касается и `cancel()` на общем объекте, полученном обратным
преобразованием той же нативной сессии. Обработчики вызываются на UI-потоке.

`SearchError.error` содержит типизированную ошибку MapKit на Android и на iOS, если SDK её передал.
`SearchError.description` содержит сообщение iOS. [Проверяемый пример] сохраняет текущую сессию,
отсекает результаты заменённого запроса и читает объекты во вложенных коллекциях.

Общий API покрывает начальный текстовый запрос и отмену. Платформенные методы доступны через
`toNative()`. Поведение сервиса описано в руководствах [для Android] и [для iOS].

## Проверки регрессий

[Тест адаптера Android] и [тест адаптера iOS] получают ответы локально. Они проверяют параметры,
названия и координаты, пустой ответ, нативную ошибку и запоздалые события после отмены. [CI Full]
также собирает и запускает отдельное приложение на Android и iOS.

[Тестовое приложение]: https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/main/verification/lite-consumer
[Проверяемый пример]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/verification/lite-consumer/shared/src/fullMain/kotlin/ru/sulgik/liteconsumer/FullTextSearchExample.kt
[для Android]: https://yandex.com/maps-api/docs/mapkit/android/generated/tutorials/map_search.html
[для iOS]: https://yandex.com/maps-api/docs/mapkit/ios/generated/tutorials/map_search.html
[Тест адаптера Android]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/fullAndroidHostTest/kotlin/ru/sulgik/mapkit/search/SearchAdapterTest.kt
[тест адаптера iOS]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/fullIosTest/kotlin/ru/sulgik/mapkit/search/SearchAdapterTest.kt
[CI Full]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/workflows/full-consumer.yml
