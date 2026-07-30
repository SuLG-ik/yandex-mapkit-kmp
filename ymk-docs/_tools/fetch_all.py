import json
import os
import sys
import time
import urllib.request
import urllib.error
from concurrent.futures import ThreadPoolExecutor

from h2md import extract_page

BASE = 'https://yandex.ru/maps-api/docs/mapkit/'
UA = ('Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 '
      '(KHTML, like Gecko) Chrome/126.0 Safari/537.36')
CACHE = 'cache'

hrefs = json.load(open('hrefs.json', encoding='utf-8'))
seen = set()
tasks = []
for href, path in hrefs:
    if href in seen:
        continue
    seen.add(href)
    tasks.append((href, path))

os.makedirs(CACHE, exist_ok=True)
failed = []
done = [0]


def cache_path(href):
    return os.path.join(CACHE, href.replace('/', '__').replace('.html', '.json'))


def fetch(item):
    href, path = item
    out = cache_path(href)
    if os.path.exists(out) and os.path.getsize(out) > 40:
        done[0] += 1
        return
    url = BASE + href
    for attempt in range(4):
        try:
            req = urllib.request.Request(url, headers={'User-Agent': UA,
                                                       'Accept-Language': 'ru'})
            with urllib.request.urlopen(req, timeout=45) as r:
                body = r.read().decode('utf-8', 'replace')
            data = extract_page(body)
            rec = {
                'href': href,
                'toc_path': path,
                'title': data.get('title') or '',
                'sourcePath': (data.get('meta') or {}).get('sourcePath', ''),
                'html': data.get('html') or '',
            }
            with open(out, 'w', encoding='utf-8') as f:
                json.dump(rec, f, ensure_ascii=False)
            done[0] += 1
            if done[0] % 100 == 0:
                print('fetched %d/%d' % (done[0], len(tasks)), flush=True)
            return
        except Exception as e:
            if attempt == 3:
                failed.append((href, repr(e)))
                return
            time.sleep(1.5 * (attempt + 1))


start = time.time()
with ThreadPoolExecutor(max_workers=10) as ex:
    list(ex.map(fetch, tasks))

print('DONE %d/%d in %.1fs, failed=%d' % (done[0], len(tasks), time.time() - start, len(failed)))
json.dump(failed, open('failed.json', 'w'), ensure_ascii=False, indent=1)
for f in failed[:20]:
    print('FAIL', f)
