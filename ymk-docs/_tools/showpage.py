import re
import sys
import urllib.request

from lxml import html as LH

BASE = 'https://yandex.ru/maps-api/docs/mapkit/'
UA = ('Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 '
      '(KHTML, like Gecko) Chrome/126.0 Safari/537.36')

sys.path.insert(0, __file__.rsplit('/', 1)[0])
from h2md import extract_page

href = sys.argv[1]
req = urllib.request.Request(BASE + href, headers={'User-Agent': UA, 'Accept-Language': 'ru'})
with urllib.request.urlopen(req, timeout=45) as r:
    body = r.read().decode('utf-8', 'replace')

data = extract_page(body)
root = LH.fragment_fromstring(data['html'], create_parent='div')
for el in root.xpath('//span[contains(@class,"visually-hidden")] | //button | //svg | //style'):
    el.getparent().remove(el)

for a in root.xpath('//a[@href]'):
    a.text = (a.text or '') + ' →(' + a.get('href') + ')'

print('URL:   ' + BASE + href)
print('TITLE: ' + (data.get('title') or ''))
print('=' * 70)
text = root.text_content()
text = re.sub(r'\n{3,}', '\n\n', text.replace('\xa0', ' '))
print(text.strip())
