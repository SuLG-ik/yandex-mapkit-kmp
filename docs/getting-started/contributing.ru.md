# Разработка

## Что нужно

- macOS
- CocoaPods
- Android Studio

## Пример

Примеру нужен ваш API-ключ в `local.properties`:

=== "local.properties"
    ```
    MAPKIT_API_KEY=<API-KEY>
    ```

## Ветки

`main` — единственная долгоживущая ветка. Ответвляйтесь от неё, открывайте pull request обратно в
неё и дайте проверкам отработать. Ветки `release/X.Y.x` появляются только тогда, когда исправление
нужно выпустить без всего остального, что уже попало в `main`.

## Проверки

На каждый pull request параллельно запускаются четыре задачи — `lint`, `test-android`, `test-ios` и
`api-check`, — и все их можно воспроизвести локально:

=== "Форматирование"
    ```
    ./gradlew spotlessApply
    ```

=== "Android"
    ```
    ./gradlew libraryAssemble libraryTests -PskipIosTarget=true
    ```

=== "iOS"
    ```
    ./gradlew libraryCompileIosArm64 libraryIosTests
    ```

=== "Публичный API"
    ```
    ./gradlew libraryApiCheck
    ```

Задачи `library*` разворачиваются на четыре публикуемых модуля. iOS-задачам нужен CocoaPods, и
`libraryApiCheck` тоже — дампы покрывают iOS-таргеты, поэтому он запускается только на macOS.

Тесты отрисовки Compose ждут настоящий кадр (`GraphicsLayer` → `ImageBitmap`), который JVM не
выдаёт, поэтому они исключены из Android-прогона на хосте и покрываются симулятором iOS плюс
отдельной задачей на эмуляторе. Эта задача запускается при пушах в `main` и ещё раз перед каждым
релизом:

```
./gradlew :yandex-mapkit-kmp-compose:connectedAndroidDeviceTest
```

## Публичный API

Четыре публикуемых модуля хранят по два дампа своего публичного API в `<module>/api`. Любое
изменение публичного объявления валит `libraryApiCheck`, пока оба дампа не обновлены:

```
./gradlew libraryApiDump
```

Запускайте на macOS — дамп, сгенерированный без iOS-таргетов, неполон — и коммитьте результат вместе
с изменением. Просмотр этого диффа — самый простой способ понять, меняет ли pull request API
намеренно.

`<module>.klib.api` — klib-дамп от Kotlin ABI validator, он покрывает `commonMain` и `iosMain`.
Валидатор не подхватывает Android-таргет у `com.android.kotlin.multiplatform.library`, поэтому
`<module>.android.api` создаётся отдельно задачей `dumpAndroidAbi`: она прогоняет `javap -public` по
классам основной Android-компиляции и стережёт объявления, существующие только в `androidMain`, —
такие как `MapKit.initialize(Context)` и фабрики `ImageProvider`. Поскольку это дамп `javap`, он
чувствителен к JDK, которой был сгенерирован — используйте ту же версию JDK, что и CI.

## Документация

Сайт — это MkDocs Material. Он собирается из `docs/` и деплоится CI вместе с KDoc, который Dokka
рендерит в `docs/kdoc`.

```bash
pip install -r docs/requirements.txt
```

```bash
mkdocs serve
```

```bash
./gradlew :dokkaGenerate
```

### Два языка

Каждая страница существует дважды, в
[раскладке с суффиксом](https://ultrabug.github.io/mkdocs-static-i18n/) от `mkdocs-static-i18n`:
`wrapper/overview.md` — английская, `wrapper/overview.ru.md` — русская. Английский — язык по
умолчанию, за ним остаются «голые» URL; русский обслуживается по пути `/ru/`.

Страница без своего двойника `.ru.md` откатывается к английскому тексту, а не отдаёт 404, так что
новая страница может приехать на одном языке и быть переведённой позже — но pull request, который её
добавляет, должен добавлять обе. Заголовки разделов в `nav` переводятся в `mkdocs.yml` в блоке
`nav_translations`; новому пункту навигации нужна строка и там.

### Версии подставляются, а не пишутся руками

Никогда не пишите номер версии в страницу. `docs_hooks/versions.py` читает `gradle.properties` и
`gradle/libs.versions.toml` во время сборки и заменяет такие подстановки:

| Подстановка | Источник |
|---|---|
| `\{{ version }}` | `library_version` в `gradle.properties` |
| `\{{ mapkit_version }}` | `yandex-mapkit` из каталога версий |
| `\{{ kotlin_version }}` | `kotlin` из каталога версий |
| `\{{ compose_version }}` | `compose-plugin` из каталога версий |
| `\{{ min_sdk }}` | `android-minSdk` из каталога версий |

Неизвестная подстановка остаётся как есть, поэтому `\{{ something }}` в примере кода уцелеет; а
известную можно экранировать ведущим обратным слешем — именно так написана эта таблица.

README не собирается MkDocs, поэтому его версии синхронизирует Gradle:

```bash
./gradlew updateDocumentedVersions
```

```bash
./gradlew checkDocumentedVersions
```

Проверка выполняется в задаче `lint`, поэтому поднятый `library_version` с устаревшим README валит
CI.

## Совместимость

В пределах `1.x` модули гарантируют совместимость **исходников**, а не бинарную совместимость.

Обёртка следует за MapKit, а MapKit добавляет поля в свои структуры и константы в свои перечисления
в минорных релизах. Обёртка отражает эти структуры как `data class`, поэтому новое поле меняет
`componentN` и `copy$default`, а новая константа перечисления ломает компиляцию исчерпывающего
`when` по нему. И то, и другое ломает бинарную совместимость, а отказ от них означал бы заморозку
обёртки на той версии MapKit, с которой вышла 1.0.0.

На практике это значит: пересобирайте под ту версию, от которой зависите, не смешивайте версии
обёртки в одном графе зависимостей и ждите, что после обновления `when` по перечислению обёртки
потребует новой ветки. Переименования, удаления и изменения сигнатур по-прежнему остаются за
мажорным релизом.

## Релизы

Релизы описаны в [RELEASING.md](https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/RELEASING.md).
Заметные изменения попадают в раздел `Unreleased` файла
[CHANGELOG.md](https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/CHANGELOG.md) в том же pull
request, который их вносит.
