import json
import os
import posixpath
import re
from lxml import html as LH

BASE = 'https://yandex.ru/maps-api/docs/mapkit/'

LANG_MAP = {
    'kotlin': 'kotlin', 'java': 'java', 'swift': 'swift', 'objectivec': 'objectivec',
    'objective-c': 'objectivec', 'dart': 'dart', 'xml': 'xml', 'bash': 'bash',
    'shell': 'bash', 'gradle': 'groovy', 'groovy': 'groovy', 'json': 'json',
    'yaml': 'yaml', 'plaintext': '', 'ruby': 'ruby', 'cpp': 'cpp', 'c': 'c',
}

NOTE_TITLES = {'note': 'NOTE', 'tip': 'TIP', 'info': 'NOTE', 'warning': 'WARNING',
               'alert': 'CAUTION', 'important': 'IMPORTANT'}


def extract_page(html_text):
    i = html_text.find('window.__DATA__')
    if i < 0:
        raise ValueError('no __DATA__')
    start = html_text.index('=', i) + 1
    end = html_text.index('</script>', start)
    return json.loads(html_text[start:end].strip().rstrip(';'))['data']


def norm_text(s):
    if not s:
        return ''
    return s.replace('\xa0', ' ').replace('​', '')


def esc_md(s):
    return re.sub(r'([\\`*_\[\]<>])', r'\\\1', s)


class Converter:
    def __init__(self, page_href, code_lang=''):
        self.page_href = page_href
        self.page_dir = posixpath.dirname(page_href)
        self.code_lang = code_lang

    def rel_link(self, href):
        if not href:
            return ''
        if href.startswith(('http://', 'https://', 'mailto:', '//')):
            return href
        if href.startswith('#'):
            return href
        anchor = ''
        if '#' in href:
            href, anchor = href.split('#', 1)
            anchor = '#' + anchor
        if href.startswith('/'):
            return BASE.rstrip('/') + href + anchor
        target = posixpath.normpath(href)
        if target.endswith('.html'):
            target = target[:-5] + '.md'
        elif not posixpath.splitext(target)[1]:
            target += '.md'
        rel = posixpath.relpath(target, self.page_dir or '.')
        return rel + anchor

    def inline(self, node, in_code=False, skip_tail=False):
        out = []
        tag = node.tag if isinstance(node.tag, str) else ''
        cls = node.get('class') or ''

        if tag in ('button', 'svg', 'script', 'style'):
            return ''
        if 'visually-hidden' in cls or node.get('data-no-index') == 'true':
            return norm_text(node.tail) if node.tail else ''
        if tag == 'a' and 'yfm-anchor' in cls:
            return norm_text(node.tail) if node.tail else ''

        children = ''.join(self.inline(c, in_code) for c in node)
        text = norm_text(node.text)
        body = text + children

        if tag == 'br':
            out.append('\n' if in_code else '<br>')
        elif tag in ('em', 'i'):
            out.append(body if in_code else ('*%s*' % body if body.strip() else body))
        elif tag in ('strong', 'b'):
            out.append(body if in_code else ('**%s**' % body if body.strip() else body))
        elif tag == 'code':
            out.append(body if in_code else '`%s`' % body.replace('`', '\\`'))
        elif tag == 'samp':
            out.append(body)
        elif tag == 'a':
            href = self.rel_link(node.get('href'))
            if in_code or not body.strip():
                out.append(body)
            elif href:
                out.append('[%s](%s)' % (body, href.replace(' ', '%20').replace('(', '%28').replace(')', '%29')))
            else:
                out.append(body)
        elif tag == 'img':
            src = node.get('src') or ''
            if src and not src.startswith(('http', '//')):
                src = BASE + src.lstrip('/')
            out.append('![%s](%s)' % (node.get('alt') or '', src))
        elif tag == 'sup':
            out.append('<sup>%s</sup>' % body)
        else:
            out.append(body)

        if node.tail and not skip_tail:
            out.append(norm_text(node.tail))
        return ''.join(out)

    def split_p(self, p):
        parts = []
        buf = []

        def flush():
            s = ''.join(buf).strip()
            buf.clear()
            if s:
                parts.append(('text', s))

        if p.text and p.text.strip():
            buf.append(norm_text(p.text))
        for c in p:
            t = c.tag if isinstance(c.tag, str) else ''
            if t == 'samp':
                pending = ''.join(buf)
                code = norm_text(c.text) + ''.join(self.inline(x, True) for x in c)
                if parts and parts[-1][0] == 'code' and not pending.strip():
                    buf.clear()
                    parts[-1] = ('code', parts[-1][1] + '\n' + code)
                else:
                    flush()
                    parts.append(('code', code))
                if c.tail:
                    buf.append(norm_text(c.tail))
            elif t == 'br':
                buf.append('\n')
                if c.tail:
                    buf.append(norm_text(c.tail))
            else:
                buf.append(self.inline(c))
        flush()
        return parts

    def cell_text(self, td):
        parts = []
        if td.text and td.text.strip():
            parts.append(('text', norm_text(td.text).strip()))
        for child in td:
            t = child.tag if isinstance(child.tag, str) else ''
            if t == 'p':
                parts.extend(self.split_p(child))
            elif t in ('ul', 'ol'):
                parts.append(('text', self.block(child).strip()))
            elif t == 'pre':
                parts.append(('pre', self.block(child).strip()))
            elif t == 'table':
                parts.append(('pre', self.table(child).strip()))
            else:
                parts.append(('text', self.inline(child, skip_tail=True).strip()))
            if child.tail and child.tail.strip():
                parts.append(('text', norm_text(child.tail).strip()))
        return [(k, v) for k, v in parts if v.strip()]

    def inline_children(self, node, in_code=False):
        s = norm_text(node.text) + ''.join(self.inline(c, in_code) for c in node)
        return s

    def table(self, tbl):
        rows = tbl.xpath('./tr | ./tbody/tr | ./thead/tr')
        if not rows:
            return ''
        grid = [[self.cell_text(td) for td in r.xpath('./td | ./th')] for r in rows]
        ncols = max((len(r) for r in grid), default=0)
        if ncols == 0:
            return ''

        if ncols == 1:
            out = []
            for cells in grid:
                if not cells:
                    continue
                parts = cells[0]
                if len(parts) == 1 and parts[0][0] == 'text':
                    t = parts[0][1].strip()
                    if not t:
                        continue
                    if re.fullmatch(r'\*\*[^*]+\*\*', t):
                        out.append(t)
                        out.append('')
                        continue
                for kind, val in parts:
                    val = val.strip('\n')
                    if not val.strip():
                        continue
                    if kind == 'code':
                        val = '\n'.join(l.rstrip() for l in val.split('\n') if l.strip())
                        out.append('```%s\n%s\n```' % (self.code_lang, val))
                    elif kind == 'pre':
                        out.append(val)
                    else:
                        out.append(val.replace('<br>', '  \n'))
                    out.append('')
            return '\n'.join(out).strip() + '\n'

        def flat(parts):
            chunks = []
            for kind, val in parts:
                val = val.strip()
                if not val:
                    continue
                if kind == 'code':
                    val = re.sub(r'\s*\n\s*', ' ', val)
                    val = re.sub(r' {2,}', ' ', val).strip()
                    chunks.append('`%s`' % val.replace('|', '\\|').replace('`', ''))
                else:
                    val = re.sub(r'\n+', '<br>', val.replace('|', '\\|'))
                    chunks.append(val)
            return '<br>'.join(chunks) or ' '

        header = [flat(c) for c in grid[0]] + [' '] * (ncols - len(grid[0]))
        body_rows = grid[1:]
        looks_header = all(re.fullmatch(r'\*\*.*\*\*', h.strip()) or h.strip() == ' '
                           for h in header if h.strip())
        if not looks_header:
            body_rows = grid
            header = [' '] * ncols
        header = [h.strip().strip('*') or ' ' for h in header]
        out = ['| ' + ' | '.join(header) + ' |',
               '|' + '|'.join([' --- '] * ncols) + '|']
        for cells in body_rows:
            vals = [flat(c) for c in cells] + [' '] * (ncols - len(cells))
            out.append('| ' + ' | '.join(vals) + ' |')
        return '\n'.join(out) + '\n'

    def block(self, node, depth=0):
        tag = node.tag if isinstance(node.tag, str) else ''
        cls = node.get('class') or ''
        out = []

        if tag in ('button', 'svg', 'script', 'style'):
            return ''

        if tag in ('h1', 'h2', 'h3', 'h4', 'h5', 'h6'):
            lvl = int(tag[1])
            title = self.inline_children(node).strip()
            title = re.sub(r'\s+', ' ', title)
            title = re.sub(r'^\*\*(.+?)\*\*$', r'\1', title).strip()
            return '\n%s %s\n' % ('#' * min(lvl, 6), title)

        if tag == 'p':
            txt = self.inline_children(node).strip()
            txt = re.sub(r'<br>\s*', '  \n', txt)
            return ('\n%s\n' % txt) if txt else ''

        if tag == 'table':
            t = self.table(node)
            return ('\n%s\n' % t) if t.strip() else ''

        if tag == 'pre':
            code_el = node.find('code')
            src = code_el if code_el is not None else node
            lang = ''
            for c in (src.get('class') or '').split():
                if c not in ('hljs',) and c in LANG_MAP:
                    lang = LANG_MAP[c]
            raw = norm_text(src.text_content())
            return '\n```%s\n%s\n```\n' % (lang, raw.rstrip('\n'))

        if tag in ('ul', 'ol'):
            items = []
            for i, li in enumerate(node.findall('li'), 1):
                marker = '- ' if tag == 'ul' else '%d. ' % i
                inner_blocks = []
                lead = norm_text(li.text)
                acc = [lead] if lead.strip() else []
                for c in li:
                    ct = c.tag if isinstance(c.tag, str) else ''
                    if ct in ('ul', 'ol', 'pre', 'table', 'div', 'details', 'blockquote'):
                        if acc:
                            inner_blocks.append(''.join(acc).strip())
                            acc = []
                        inner_blocks.append(self.block(c, depth + 1).strip())
                        if c.tail and c.tail.strip():
                            acc.append(norm_text(c.tail))
                    else:
                        acc.append(self.inline(c))
                if acc:
                    inner_blocks.append(''.join(acc).strip())
                body = '\n\n'.join(b for b in inner_blocks if b)
                lines = body.split('\n')
                pad = ' ' * len(marker)
                items.append(marker + ('\n' + pad).join(lines))
            return '\n' + '\n'.join(items) + '\n'

        if tag == 'div' and re.search(r'\byfm-note\b', cls):
            ntype = node.get('note-type') or 'note'
            title_el = node.find('.//p[@class="yfm-note-title"]')
            title = self.inline_children(title_el).strip() if title_el is not None else ''
            content = node.find('.//div[@class="yfm-note-content"]')
            inner = self.children_blocks(content, depth) if content is not None else ''
            lines = [l for l in inner.strip().split('\n')]
            quoted = '\n'.join(('> ' + l).rstrip() for l in lines)
            head = '> [!%s]' % NOTE_TITLES.get(ntype, 'NOTE')
            if title:
                head += ' ' + title
            return '\n%s\n%s\n' % (head, quoted)

        if tag == 'div' and re.search(r'\byfm-tabs\b', cls):
            parts = []
            titles = [self.inline_children(t).strip()
                      for t in node.xpath('.//div[contains(@class,"yfm-tab-list")]//div[contains(@class,"yfm-tab")]')]
            panels = node.xpath('./div[contains(@class,"yfm-tab-panel")]')
            for i, panel in enumerate(panels):
                name = titles[i] if i < len(titles) else 'Tab %d' % (i + 1)
                parts.append('\n**%s**\n%s' % (name, self.children_blocks(panel, depth)))
            return '\n'.join(parts)

        if tag in ('div', 'details') and re.search(r'\byfm-cut\b', cls):
            title_el = node.find('.//summary')
            title = self.inline_children(title_el).strip() if title_el is not None else 'Подробнее'
            content = node.find('.//div[@class="yfm-cut-content"]')
            inner = self.children_blocks(content, depth) if content is not None else ''
            return '\n**%s**\n%s\n' % (title, inner)

        if tag == 'br':
            return '\n'
        if tag == 'hr':
            return '\n---\n'
        if tag == 'blockquote':
            inner = self.children_blocks(node, depth).strip()
            return '\n' + '\n'.join('> ' + l for l in inner.split('\n')) + '\n'

        if tag in ('div', 'section', 'details', 'span', 'figure'):
            return self.children_blocks(node, depth)

        txt = self.inline(node).strip()
        return ('\n%s\n' % txt) if txt else ''

    def children_blocks(self, node, depth=0):
        out = []
        if node.text and node.text.strip():
            out.append(norm_text(node.text).strip())
        for c in node:
            out.append(self.block(c, depth))
            if c.tail and c.tail.strip():
                out.append(norm_text(c.tail).strip())
        return '\n'.join(x for x in out if x is not None)


def html_to_md(html_fragment, page_href, code_lang=''):
    root = LH.fragment_fromstring(html_fragment, create_parent='div')
    conv = Converter(page_href, code_lang)
    md = conv.children_blocks(root)
    md = re.sub(r'[ \t]+\n', '\n', md)
    md = re.sub(r'\n{3,}', '\n\n', md)
    return md.strip() + '\n'
