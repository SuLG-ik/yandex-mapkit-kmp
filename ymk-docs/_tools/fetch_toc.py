import json
import urllib.request

BASE = 'https://yandex.ru/maps-api/docs/mapkit/'
UA = ('Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 '
      '(KHTML, like Gecko) Chrome/126.0 Safari/537.36')

req = urllib.request.Request(BASE + 'toc.js', headers={'User-Agent': UA, 'Accept-Language': 'ru'})
with urllib.request.urlopen(req, timeout=45) as r:
    raw = r.read().decode('utf-8')
open('toc.js', 'w', encoding='utf-8').write(raw)

toc = json.loads(raw.split('=', 1)[1].strip().rstrip(';'))
hrefs = []


def walk(items, path):
    for it in items:
        p = path + [it.get('name', '?')]
        if it.get('href'):
            hrefs.append((it['href'], ' / '.join(p)))
        if it.get('items'):
            walk(it['items'], p)


walk(toc['items'], [])
json.dump(hrefs, open('hrefs.json', 'w', encoding='utf-8'), ensure_ascii=False, indent=1)
print('pages in toc:', len(hrefs))
