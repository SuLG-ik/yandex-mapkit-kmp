import re
from pathlib import Path

GRADLE_PROPERTIES = "gradle.properties"
VERSION_CATALOG = "gradle/libs.versions.toml"

PLACEHOLDER = re.compile(r"(\\?)\{\{\s*([a-z_]+)\s*\}\}")

resolved = {}


def read_gradle_properties(root):
    values = {}
    for line in (root / GRADLE_PROPERTIES).read_text(encoding="utf-8").splitlines():
        stripped = line.strip()
        if not stripped or stripped.startswith("#") or "=" not in stripped:
            continue
        key, _, value = stripped.partition("=")
        values[key.strip()] = value.strip().replace("\\=", "=")
    return values


def read_version_catalog(root):
    values = {}
    inside_versions = False
    for line in (root / VERSION_CATALOG).read_text(encoding="utf-8").splitlines():
        stripped = line.strip()
        if stripped.startswith("["):
            inside_versions = stripped == "[versions]"
            continue
        if not inside_versions or stripped.startswith("#") or "=" not in stripped:
            continue
        key, _, value = stripped.partition("=")
        values[key.strip()] = value.strip().strip('"')
    return values


def collect(config):
    root = Path(config.config_file_path).parent
    properties = read_gradle_properties(root)
    catalog = read_version_catalog(root)
    mapkit = catalog["yandex-mapkit"]
    return {
        "version": properties["library_version"],
        "mapkit_version": mapkit,
        "kotlin_version": catalog["kotlin"],
        "compose_version": catalog["compose-plugin"],
        "min_sdk": catalog["android-minSdk"],
    }


def on_config(config, **kwargs):
    resolved.update(collect(config))
    config.extra.update(resolved)
    return config


def substitute(match):
    escaped, name = match.group(1), match.group(2)
    if escaped:
        return match.group(0)[1:]
    return resolved.get(name, match.group(0))


def on_page_markdown(markdown, page, config, files, **kwargs):
    if not resolved:
        resolved.update(collect(config))
    return PLACEHOLDER.sub(substitute, markdown)
