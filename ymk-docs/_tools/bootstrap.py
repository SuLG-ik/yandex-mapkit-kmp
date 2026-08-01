import argparse
import os
import shutil
import subprocess
import sys

TOOLS = os.path.dirname(os.path.abspath(__file__))
OUT = os.path.dirname(TOOLS)
MARKER = os.path.join(OUT, 'SUMMARY.md')


def run(script, *args):
    print('\n$ python3 %s %s' % (script, ' '.join(args)), flush=True)
    result = subprocess.run([sys.executable, script, *args], cwd=TOOLS)
    if result.returncode != 0:
        sys.exit('failed: %s (exit %d)' % (script, result.returncode))


def require_lxml():
    try:
        import lxml.html
        lxml.html.fromstring('<p/>')
    except ImportError:
        sys.exit('lxml is required: pip3 install lxml')


def main():
    parser = argparse.ArgumentParser(
        description='Build the local copy of the Yandex MapKit reference into ymk-docs/.')
    parser.add_argument('--force', action='store_true',
                        help='rebuild even if the copy is already present')
    parser.add_argument('--refresh', action='store_true',
                        help='drop the download cache so pages are fetched from the site again')
    parser.add_argument('--validate', action='store_true',
                        help='run validate2.py and link_check.py after the build')
    args = parser.parse_args()

    if os.path.exists(MARKER) and not args.force:
        print('ymk-docs is already built (%s exists), nothing to do.' % MARKER)
        print('Use --force to rebuild, --refresh to also re-download the pages.')
        return

    require_lxml()

    cache = os.path.join(TOOLS, 'cache')
    if args.refresh and os.path.isdir(cache):
        print('removing download cache %s' % cache)
        shutil.rmtree(cache)

    run('fetch_toc.py')
    run('fetch_all.py')
    run('build_docs.py', OUT)
    run('build_indexes.py', OUT)

    if args.validate:
        run('validate2.py', OUT)
        run('link_check.py', OUT)

    print('\nymk-docs is ready at %s' % OUT)


if __name__ == '__main__':
    main()
