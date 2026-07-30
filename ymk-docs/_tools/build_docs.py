import json
import os
import posixpath
import re
import sys
from collections import defaultdict

from h2md import html_to_md

BASE = 'https://yandex.ru/maps-api/docs/mapkit/'
CACHE = 'cache'
OUT = sys.argv[1] if len(sys.argv) > 1 else 'out'

KIND_BY_TOC = {
    'Classes': 'Class', 'Enums': 'Enum', 'Protocols': 'Protocol',
    'Typedefs': 'Typedef', 'Categories': 'Category', 'Extensions': 'Extension',
}
LANG_CODE = {'Objective-C': 'objectivec', 'Swift': 'swift'}


def meta_for(rec):
    toc = rec['toc_path'].split(' / ')
    href = rec['href']
    title = rec['title'] or toc[-1]
    m = {'title': title, 'name': toc[-1], 'section': rec['toc_path']}

    if href.startswith(('Objective-C/', 'Swift/')):
        m['platform'] = 'ios'
        m['language'] = toc[2] if len(toc) > 2 else href.split('/')[0]
        m['kind'] = KIND_BY_TOC.get(toc[3] if len(toc) > 3 else '', 'Type')
        m['code_lang'] = LANG_CODE.get(m['language'], '')
    elif href.startswith('com/'):
        m['platform'] = 'android'
        m['language'] = 'Java'
        m['code_lang'] = 'java'
        m['package'] = toc[2] if len(toc) > 2 else posixpath.dirname(href).replace('/', '.')
        first = title.split(' ')[0]
        m['kind'] = first if first in ('Class', 'Enum', 'Interface', 'Error', 'Struct') else 'Class'
        m['name'] = title[len(m['kind']):].strip() if title.startswith(m['kind'] + ' ') else toc[-1]
    else:
        m['kind'] = 'Guide'
        if rec['title']:
            m['name'] = rec['title']
        if href.startswith('android/'):
            m['platform'], m['code_lang'], m['language'] = 'android', 'kotlin', 'Kotlin/Java'
        elif href.startswith('ios/'):
            m['platform'], m['code_lang'], m['language'] = 'ios', 'swift', 'Swift/Objective-C'
        elif href.startswith('flutter/'):
            m['platform'], m['code_lang'], m['language'] = 'flutter', 'dart', 'Dart'
        else:
            m['platform'], m['code_lang'], m['language'] = 'common', '', ''
    return m


def yaml_str(s):
    s = str(s).replace('"', '\\"')
    return '"%s"' % s


def first_paragraph(md):
    body = md.split('\n## ', 1)[0]
    body = re.sub(r'```.*?```', '', body, flags=re.S)
    body = re.sub(r'> \[!.*?\n(?:>.*\n)*', '', body)
    for line in body.split('\n'):
        line = line.strip()
        if (not line or line.startswith(('#', '|', '>', '**Package', 'java.lang', '↳'))
                or line.startswith('`')):
            continue
        line = re.sub(r'\[([^\]]*)\]\([^)]*\)', r'\1', line)
        line = line.replace('*', '').replace('`', '').strip()
        if len(line) > 2:
            return line
    return ''


def main():
    records = []
    for fn in sorted(os.listdir(CACHE)):
        if not fn.endswith('.json'):
            continue
        rec = json.load(open(os.path.join(CACHE, fn), encoding='utf-8'))
        records.append(rec)
    print('records:', len(records))

    infos = []
    for rec in records:
        m = meta_for(rec)
        href = rec['href']
        rel_md = href[:-5] + '.md' if href.endswith('.html') else href + '.md'
        body = html_to_md(rec['html'], href, m['code_lang'])

        fm = ['---',
              'title: ' + yaml_str(m['name']),
              'kind: ' + yaml_str(m['kind']),
              'platform: ' + yaml_str(m['platform'])]
        if m.get('language'):
            fm.append('language: ' + yaml_str(m['language']))
        if m.get('package'):
            fm.append('package: ' + yaml_str(m['package']))
        fm += ['section: ' + yaml_str(m['section']),
               'source: ' + yaml_str(BASE + href),
               '---', '']

        badge = ' · '.join('`%s`' % x for x in
                           [m['platform'].upper() if m['platform'] != 'common' else 'MapKit',
                            m.get('language') or '', m['kind']] if x)
        head = ['# ' + m['name'], '',
                '%s — [оригинал](%s)' % (badge, BASE + href), '']

        text = '\n'.join(fm) + '\n'.join(head) + '\n' + body
        text = re.sub(r'\n{3,}', '\n\n', text)

        path = os.path.join(OUT, rel_md)
        os.makedirs(os.path.dirname(path), exist_ok=True)
        with open(path, 'w', encoding='utf-8') as f:
            f.write(text)

        m['rel_md'] = rel_md
        m['desc'] = first_paragraph(body)
        m['href'] = href
        infos.append(m)

    json.dump(infos, open('infos.json', 'w', encoding='utf-8'), ensure_ascii=False, indent=1)
    print('written:', len(infos))
    return infos


if __name__ == '__main__':
    main()
