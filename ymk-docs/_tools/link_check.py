import os
import posixpath
import re
import sys
from collections import Counter

OUT = sys.argv[1] if len(sys.argv) > 1 else 'out'
LINK = re.compile(r'\[[^\]]*\]\(([^)\s]+)\)')

broken = Counter()
total = 0
files = 0
for root, dirs, names in os.walk(OUT):
    for n in names:
        if not n.endswith('.md'):
            continue
        files += 1
        p = os.path.join(root, n)
        rel_dir = os.path.relpath(root, OUT)
        text = open(p, encoding='utf-8').read()
        for m in LINK.finditer(text):
            href = m.group(1)
            if href.startswith(('http://', 'https://', 'mailto:', '#')):
                continue
            total += 1
            target = href.split('#')[0]
            if not target:
                continue
            target = target.replace('%28', '(').replace('%29', ')').replace('%20', ' ')
            full = os.path.normpath(os.path.join(OUT, rel_dir, target))
            if not os.path.exists(full):
                broken[target] += 1

print('md files: %d, internal links: %d, broken: %d (unique %d)'
      % (files, total, sum(broken.values()), len(broken)))
for t, c in broken.most_common(40):
    print('BROKEN x%d -> %s' % (c, t))
