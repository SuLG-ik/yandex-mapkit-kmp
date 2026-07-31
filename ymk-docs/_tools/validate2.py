import json
import os
import re
import sys
from collections import Counter

from lxml import html as LH

OUT = sys.argv[1] if len(sys.argv) > 1 else 'out'
CACHE = 'cache'
WORD = re.compile(r'[0-9A-Za-zА-Яа-яЁё_]{4,}')
NONWORD = re.compile(r'[^0-9A-Za-zА-Яа-яЁё_]+')


def html_text(fragment):
    root = LH.fragment_fromstring(fragment, create_parent='div')
    for el in root.xpath('//span[contains(@class,"visually-hidden")] | //button '
                         '| //svg | //style | //script'):
        el.getparent().remove(el)
    for el in root.xpath('//a[contains(@class,"yfm-anchor")]'):
        tail = el.tail
        p = el.getparent()
        p.remove(el)
        if tail:
            p.text = (p.text or '') + tail
    return ' '.join(root.itertext())


stats = Counter()
problems = []

for fn in sorted(os.listdir(CACHE)):
    if not fn.endswith('.json'):
        continue
    rec = json.load(open(os.path.join(CACHE, fn), encoding='utf-8'))
    md_path = os.path.join(OUT, rec['href'][:-5] + '.md')
    stats['pages'] += 1
    if not os.path.exists(md_path):
        problems.append((rec['href'], 'MISSING FILE', []))
        continue
    md = open(md_path, encoding='utf-8').read()
    md = re.sub(r'^---\n.*?\n---\n', '', md, flags=re.S)
    md_flat = NONWORD.sub('', md).lower()

    src = html_text(rec['html'])
    toks = WORD.findall(src)
    stats['tokens'] += len(toks)
    missing = [t for t in toks if t.lower() not in md_flat]
    if missing:
        stats['pages_with_loss'] += 1
        stats['tokens_lost'] += len(missing)
        problems.append((rec['href'], 'MISSING TOKENS', missing[:10]))

print(json.dumps(stats, ensure_ascii=False, indent=1))
print('coverage: %.6f%%' % (100.0 * (stats['tokens'] - stats['tokens_lost']) / max(stats['tokens'], 1)))
for href, kind, ex in problems[:30]:
    print(kind, href, ex)
print('problem pages:', len(problems))
