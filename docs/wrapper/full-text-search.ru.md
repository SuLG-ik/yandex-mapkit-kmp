# Текстовый поиск Full

`SearchManager` ищет по тексту в заданной области из общего кода Kotlin. MapKit возвращает
организации и топонимы как [геообъекты](geoobjects.ru.md). Пустая коллекция означает успешное
завершение запроса без результатов.

## Установка

Обёртка Full пока готовится к выпуску. [Тестовое приложение] собирает её артефакты во временный
Maven-репозиторий и подключает их оттуда. Запустите эмулятор Android или симулятор iOS, затем
выполните соответствующую команду из корня репозитория. Подставьте идентификатор из
`adb devices` или `xcrun simctl list devices booted`.

```sh
bash verification/lite-consumer/run.sh android emulator-5554 with-integrations full
bash verification/lite-consumer/run.sh ios SIMULATOR_UUID with-integrations full
```

Приложение подключает ядро и дополнительные модули по координатам с суффиксом `-full`. На Android
оно использует `com.yandex.android:maps.mobile:{{ mapkit_version_full }}`, а на iOS —
`YandexMapsMobile ({{ mapkit_version_full }})` через CocoaPods. Оно проверяет установку и создание
менеджера без сетевого запроса. Для запроса к сервису в своём приложении выполните
[инициализацию на платформе](../getting-started/quick-start.ru.md) и укажите действующий ключ MapKit.

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
