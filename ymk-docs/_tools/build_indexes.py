import json
import os
import posixpath
import re
import sys
from collections import defaultdict, OrderedDict

OUT = sys.argv[1] if len(sys.argv) > 1 else 'out'
BASE = 'https://yandex.ru/maps-api/docs/mapkit/'

infos = json.load(open('infos.json', encoding='utf-8'))
by_href = {i['href']: i for i in infos}
toc = json.loads(open('toc.js', encoding='utf-8').read().split('=', 1)[1].strip().rstrip(';'))


def w(path, text):
    full = os.path.join(OUT, path)
    os.makedirs(os.path.dirname(full), exist_ok=True)
    with open(full, 'w', encoding='utf-8') as f:
        f.write(text.rstrip() + '\n')


def urlq(p):
    return p.replace('(', '%28').replace(')', '%29').replace(' ', '%20')


def rel(target, from_path):
    d = posixpath.dirname(from_path)
    return urlq(posixpath.relpath(target, d or '.'))


def desc_of(i):
    d = (i.get('desc') or '').strip()
    d = re.sub(r'\s+', ' ', d)
    if len(d) > 160:
        d = d[:157].rsplit(' ', 1)[0] + '…'
    return d.replace('|', '\\|')


def table(items, from_path, name_key='name'):
    lines = ['| Тип | Описание |', '| --- | --- |']
    for i in sorted(items, key=lambda x: x[name_key].lower()):
        lines.append('| [%s](%s) | %s |' % (i[name_key], rel(i['rel_md'], from_path), desc_of(i) or ' '))
    return '\n'.join(lines)


def build_summary():
    lines = ['# Полное оглавление MapKit Mobile SDK', '',
             'Зеркало дерева навигации оригинальной документации '
             '(%s).' % BASE, '']

    def walk(items, depth):
        for it in items:
            name = it.get('name', '')
            href = it.get('href')
            pad = '  ' * depth
            if href:
                md = href[:-5] + '.md' if href.endswith('.html') else href + '.md'
                lines.append('%s- [%s](%s)' % (pad, name, urlq(md)))
            else:
                lines.append('%s- **%s**' % (pad, name))
            if it.get('items'):
                walk(it['items'], depth + 1)

    walk(toc['items'], 0)
    w('SUMMARY.md', '\n'.join(lines))
    return len([l for l in lines if '](' in l])


def build_lang_index(lang_dir, title):
    items = [i for i in infos if i['href'].startswith(lang_dir + '/')]
    by_kind = defaultdict(list)
    for i in items:
        by_kind[i['kind']].append(i)
    p = '%s/README.md' % lang_dir
    lines = ['# %s' % title, '',
             'Справочник MapKit Mobile SDK для iOS, язык **%s**. Всего типов: **%d**.' % (lang_dir, len(items)),
             '', '[← Ко всей документации](../README.md) · [Полное оглавление](../SUMMARY.md)', '']
    for kind in sorted(by_kind, key=lambda k: (-len(by_kind[k]), k)):
        lines += ['## %s (%d)' % (kind, len(by_kind[kind])), '', table(by_kind[kind], p), '']
    w(p, '\n'.join(lines))
    return len(items)


def build_android_indexes():
    pkgs = defaultdict(list)
    for i in infos:
        if i['href'].startswith('com/'):
            pkgs[i['package']].append(i)

    for pkg, items in pkgs.items():
        d = pkg.replace('.', '/')
        p = '%s/README.md' % d
        up = rel('README.md', p)
        lines = ['# `%s`' % pkg, '',
                 'Пакет справочника MapKit SDK для Android. Типов: **%d**.' % len(items), '',
                 '[← Ко всей документации](%s) · [Все пакеты Android](%s)'
                 % (up, rel('INDEX-android.md', p)), '']
        by_kind = defaultdict(list)
        for i in items:
            by_kind[i['kind']].append(i)
        for kind in sorted(by_kind, key=lambda k: (-len(by_kind[k]), k)):
            lines += ['## %s (%d)' % (kind, len(by_kind[kind])), '', table(by_kind[kind], p), '']
        w(p, '\n'.join(lines))

    p = 'INDEX-android.md'
    total = sum(len(v) for v in pkgs.values())
    lines = ['# Справочник Android — все пакеты', '',
             'MapKit SDK для Android — пакетов: **%d**, типов: **%d**.' % (len(pkgs), total), '',
             '[← Ко всей документации](README.md) · [Полное оглавление](SUMMARY.md)', '',
             '## Пакеты', '', '| Пакет | Типов |', '| --- | --- |']
    for pkg in sorted(pkgs):
        lines.append('| [`%s`](%s/README.md) | %d |' % (pkg, pkg.replace('.', '/'), len(pkgs[pkg])))
    lines += ['', '## Все типы по алфавиту', '', '| Тип | Пакет | Описание |', '| --- | --- | --- |']
    for i in sorted(infos, key=lambda x: (x['name'].lower(), x.get('package', ''))):
        if not i['href'].startswith('com/'):
            continue
        lines.append('| [%s](%s) | `%s` | %s |'
                     % (i['name'], i['rel_md'], i['package'], desc_of(i) or ' '))
    w(p, '\n'.join(lines))
    return len(pkgs), total


def build_guides_index():
    guides = [i for i in infos if i['kind'] == 'Guide']
    p = 'INDEX-guides.md'
    lines = ['# Руководства и статьи', '',
             'Не-справочные разделы документации MapKit: начало работы, руководства, NaviKit SDK, '
             'стили карты, версии, FAQ. Всего: **%d**.' % len(guides), '',
             '[← Ко всей документации](README.md) · [Полное оглавление](SUMMARY.md)', '']
    by_sec = OrderedDict()
    for i in guides:
        parts = i['section'].split(' / ')
        key = ' / '.join(parts[:2]) if len(parts) > 1 else parts[0]
        by_sec.setdefault(key, []).append(i)
    for sec, items in by_sec.items():
        lines += ['## %s' % sec, '', '| Страница | Описание |', '| --- | --- |']
        for i in items:
            lines.append('| [%s](%s) | %s |' % (i['title'] or i['name'], urlq(i['rel_md']), desc_of(i) or ' '))
        lines.append('')
    w(p, '\n'.join(lines))
    return len(guides)


def build_root(stats):
    lines = [
        '# Справочник MapKit Mobile SDK — локальная копия',
        '',
        'Полная офлайн-копия документации Яндекс MapKit Mobile SDK в формате Markdown, '
        'снятая с %s.' % BASE,
        '',
        '- Страниц всего: **%d**' % stats['total'],
        '- Справочник Android (`com.yandex.*`) — типов: **%d**, пакетов: **%d**'
        % (stats['android'], stats['android_pkgs']),
        '- Справочник iOS Objective-C — типов: **%d**' % stats['objc'],
        '- Справочник iOS Swift — типов: **%d**' % stats['swift'],
        '- Руководства, NaviKit SDK, Flutter и прочее — страниц: **%d**' % stats['guides'],
        '',
        '## Навигация',
        '',
        '| Раздел | Что внутри |',
        '| --- | --- |',
        '| [Полное оглавление](SUMMARY.md) | Дерево навигации 1:1 с сайтом, все страницы (%d) |' % stats['total'],
        '| [Справочник Android](INDEX-android.md) | Все пакеты `com.yandex.mapkit.*` и `com.yandex.runtime.*` |',
        '| [Справочник iOS · Objective-C](Objective-C/README.md) | Classes, Enums, Protocols, Typedefs, Categories |',
        '| [Справочник iOS · Swift](Swift/README.md) | Те же типы в Swift-синтаксисе |',
        '| [Руководства](INDEX-guides.md) | Начало работы, туториалы, NaviKit SDK, Flutter, FAQ |',
        '| [Скрипты пересборки](_tools/README.md) | Чем снята копия и как обновить её под новый релиз |',
        '',
        '## Как устроены файлы',
        '',
        'Пути повторяют структуру сайта: страница `%sObjective-C/YMKAddressBook.html` '
        'лежит в `Objective-C/YMKAddressBook.md`, `%scom/yandex/mapkit/Animation.html` — '
        'в `com/yandex/mapkit/Animation.md`.' % (BASE, BASE),
        '',
        'Каждый файл начинается с YAML front-matter:',
        '',
        '```yaml',
        '---',
        'title: "YMKAddressBook"      # имя типа',
        'kind: "Class"                # Class | Enum | Interface | Protocol | Typedef | Category | Extension | Guide',
        'platform: "ios"              # ios | android | flutter | common',
        'language: "Objective-C"      # Objective-C | Swift | Java | Kotlin/Java | Dart',
        'package: "com.yandex.mapkit" # только для Android',
        'section: "iOS / Справочник / Objective-C / Classes"',
        'source: "…"                  # адрес оригинальной страницы',
        '---',
        '```',
        '',
        'Дальше идёт тело страницы: сигнатуры в блоках кода с подсветкой, сводные таблицы '
        'в GFM, примечания в формате `> [!NOTE]`.',
        '',
        '## Ссылки',
        '',
        'Все перекрёстные ссылки между страницами — относительные и ведут на локальные `.md`, '
        'поэтому документацию можно читать офлайн в любом markdown-редакторе. Ссылки на '
        'изображения оставлены абсолютными и ведут на сервер Яндекса.',
        '',
        '## Обновление',
        '',
        'Копия снята автоматически. Оригинал живёт по адресу %s и обновляется вместе с '
        'релизами SDK — сверяйтесь с полем `source` в шапке нужной страницы.' % BASE,
        '',
        'Пересборка запускается вручную и очень редко — под релиз MapKit. Готовый порядок '
        'действий с проверками оформлен скиллом `/yml-update-original-docs`; сами скрипты '
        'лежат в [`_tools/`](_tools/README.md):',
        '',
        '```bash',
        'cd _tools && python3 fetch_toc.py && python3 fetch_all.py \\',
        '  && python3 build_docs.py .. && python3 build_indexes.py ..',
        '```',
        '',
        'Там же лежат проверки полноты (`validate2.py`) и целостности ссылок (`link_check.py`).',
    ]
    w('README.md', '\n'.join(lines))


stats = {
    'total': len(infos),
    'android': len([i for i in infos if i['href'].startswith('com/')]),
    'objc': len([i for i in infos if i['href'].startswith('Objective-C/')]),
    'swift': len([i for i in infos if i['href'].startswith('Swift/')]),
}
n_summary = build_summary()
build_lang_index('Objective-C', 'Справочник iOS — Objective-C')
build_lang_index('Swift', 'Справочник iOS — Swift')
pkgs, atotal = build_android_indexes()
stats['android_pkgs'] = pkgs
stats['guides'] = build_guides_index()
build_root(stats)
print('indexes built:', stats, 'summary links:', n_summary)
