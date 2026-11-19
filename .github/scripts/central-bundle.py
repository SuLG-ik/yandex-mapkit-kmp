import argparse
import base64
import hashlib
import json
import os
from pathlib import Path
import posixpath
import re
import subprocess
import time
import tomllib
from urllib.error import HTTPError, URLError
from urllib.parse import urlencode
from urllib.request import Request, urlopen
from uuid import UUID
import xml.etree.ElementTree as ET
from zipfile import ZIP_DEFLATED, ZipFile


GROUP = "ru.sulgik.mapkit"
GROUP_PATH = GROUP.replace(".", "/")
MODULES = (
    "yandex-mapkit-kmp",
    "yandex-mapkit-kmp-compose",
    "yandex-mapkit-kmp-compose-resources",
    "yandex-mapkit-kmp-moko",
    "yandex-mapkit-kmp-moko-compose",
)
PLATFORMS = {
    "": ".jar",
    "-android": ".aar",
    "-iosarm64": ".klib",
    "-iossimulatorarm64": ".klib",
}
CHECKSUMS = ("md5", "sha1", "sha256", "sha512")
PUBLISHER = "https://central.sonatype.com/api/v1/publisher"
CENTRAL_REPO = "https://repo.maven.apache.org/maven2"


def artifact_path(artifact, version, extension):
    return f"{GROUP_PATH}/{artifact}/{version}/{artifact}-{version}{extension}"


def digest(path, algorithm):
    with path.open("rb") as stream:
        return hashlib.file_digest(stream, algorithm).hexdigest()


def require(condition, message):
    if not condition:
        raise ValueError(message)


def verify_module(path, root, platform, version, artifacts, sdk_version, files):
    metadata = json.loads(files[path].read_text())
    component = metadata["component"]
    require(
        (component["group"], component["module"], component["version"]) == (GROUP, root, version),
        f"{path}: incorrect Gradle component",
    )
    directory = posixpath.dirname(path)
    if platform:
        root_path = posixpath.normpath(posixpath.join(directory, component["url"]))
        require(root_path == artifact_path(root, version, ".module"), f"{path}: incorrect root metadata URL")
    redirects = set()
    sdk_dependencies = set()
    for variant in metadata["variants"]:
        redirect = variant.get("available-at")
        if redirect:
            target = redirect["module"]
            target_path = posixpath.normpath(posixpath.join(directory, redirect["url"]))
            require(
                redirect["group"] == GROUP
                and redirect["version"] == version
                and target in artifacts
                and target_path == artifact_path(target, version, ".module"),
                f"{path}: incorrect platform metadata URL",
            )
            redirects.add(target)
        for variant_file in variant.get("files", []):
            file_path = posixpath.normpath(posixpath.join(directory, variant_file["url"]))
            require(file_path in files, f"{path}: missing artifact {file_path}")
        for dependency in variant.get("dependencies", []):
            if dependency["group"] == GROUP:
                require(
                    dependency["module"] in artifacts and dependency["version"]["requires"] == version,
                    f"{path}: unexpected MapKit dependency {dependency}",
                )
            if (dependency["group"], dependency["module"]) == ("com.yandex.android", "maps.mobile"):
                sdk_dependencies.add(dependency["version"]["requires"])
    if not platform:
        require(
            redirects == {root + target for target in PLATFORMS if target},
            f"{path}: expected Android and both iOS platforms",
        )
    if root in (MODULES[0], MODULES[0] + "-full") and platform == "-android":
        require(sdk_dependencies == {sdk_version}, f"{path}: expected maps.mobile {sdk_version}")


def edition_files(repository, edition, version, sdk_version, verify_signatures):
    suffix = "-full" if edition == "full" else ""
    artifacts = {module + suffix + target for module in MODULES for target in PLATFORMS}
    expected_poms = {artifact_path(artifact, version, ".pom") for artifact in artifacts}
    actual_poms = {path.relative_to(repository).as_posix() for path in repository.rglob("*.pom")}
    require(
        expected_poms == actual_poms,
        f"{edition}: missing POMs {sorted(expected_poms - actual_poms)}, extra POMs {sorted(actual_poms - expected_poms)}",
    )
    files = {}
    for pom in sorted(expected_poms):
        for path in (repository / pom).parent.iterdir():
            if path.is_file() and not any(path.name.endswith(f".asc.{algorithm}") for algorithm in CHECKSUMS):
                files[path.relative_to(repository).as_posix()] = path

    for module in MODULES:
        root = module + suffix
        for platform, extension in PLATFORMS.items():
            artifact = root + platform
            for required in (".pom", ".module", "-sources.jar", "-javadoc.jar", extension):
                path = artifact_path(artifact, version, required)
                require(path in files, f"Missing {path}")
            pom_path = artifact_path(artifact, version, ".pom")
            pom = ET.parse(files[pom_path]).getroot()
            coordinates = tuple(pom.findtext(f"{{*}}{field}") for field in ("groupId", "artifactId", "version"))
            require(coordinates == (GROUP, artifact, version), f"{pom_path}: incorrect POM coordinates")
            for dependency in pom.findall("{*}dependencies/{*}dependency"):
                if dependency.findtext("{*}groupId") == GROUP:
                    require(
                        dependency.findtext("{*}artifactId") in artifacts
                        and dependency.findtext("{*}version") == version,
                        f"{pom_path}: unexpected MapKit dependency",
                    )
            verify_module(
                artifact_path(artifact, version, ".module"),
                root,
                platform,
                version,
                artifacts,
                sdk_version,
                files,
            )

    for name, path in files.items():
        if path.suffix.removeprefix(".") in (*CHECKSUMS, "asc"):
            require(name.rsplit(".", 1)[0] in files, f"Orphan signature or checksum {name}")
            continue
        signature = files.get(name + ".asc")
        require(signature is not None and signature.stat().st_size > 0, f"Missing signature for {name}")
        if verify_signatures:
            result = subprocess.run(
                ["gpg", "--batch", "--quiet", "--verify", signature, path], capture_output=True, text=True
            )
            require(result.returncode == 0, f"Invalid signature for {name}: {result.stderr}")
        for algorithm in CHECKSUMS:
            checksum = files.get(f"{name}.{algorithm}")
            if algorithm in ("md5", "sha1"):
                require(checksum is not None, f"Missing {algorithm} for {name}")
            if checksum is not None:
                require(checksum.read_text().strip() == digest(path, algorithm), f"Invalid {algorithm} for {name}")
    return files


def assemble(args):
    catalog = Path(__file__).resolve().parents[2] / "gradle/libs.versions.toml"
    sdk_base = tomllib.loads(catalog.read_text())["versions"]["yandex-mapkit"].removesuffix("-lite")
    files = {}
    for edition in ("lite", "full"):
        staged = edition_files(
            args.staging / edition, edition, args.version, f"{sdk_base}-{edition}", args.mode == "rehearsal"
        )
        require(not files.keys() & staged.keys(), f"{edition}: duplicates another edition's release files")
        files.update(staged)

    args.bundle.parent.mkdir(parents=True, exist_ok=True)
    with ZipFile(args.bundle, "w", compression=ZIP_DEFLATED) as bundle:
        for name, path in sorted(files.items()):
            bundle.write(path, name)
    require(args.bundle.stat().st_size < 1_000_000_000, "Central bundle exceeds the 1 GB upload limit")
    print(f"Verified two editions, {2 * len(MODULES) * len(PLATFORMS)} coordinates, {len(files)} files")
    print(f"Bundle SHA-256 {digest(args.bundle, 'sha256')}")


def deployed_artifacts():
    for suffix in ("", "-full"):
        for module in MODULES:
            for platform, extension in PLATFORMS.items():
                yield module + suffix + platform, extension


def central_request(path, authorization):
    request = Request(f"{PUBLISHER}/{path}", method="POST", headers={"Authorization": authorization})
    with urlopen(request, timeout=20) as response:
        return response.read()


def public_artifact_exists(path):
    try:
        with urlopen(Request(f"{CENTRAL_REPO}/{path}", method="HEAD"), timeout=10):
            return True
    except HTTPError as error:
        if error.code == 404:
            return False
        raise


def upload_bundle(bundle, name, authorization):
    query = urlencode({"name": name, "publishingType": "USER_MANAGED"})
    try:
        result = subprocess.run(
            [
                "curl", "--silent", "--show-error", "--fail", "--max-time", "600",
                "--header", "@-", "--form", f"bundle=@{bundle};type=application/octet-stream",
                f"{PUBLISHER}/upload?{query}",
            ],
            input=f"Authorization: {authorization}\n",
            text=True,
            stdout=subprocess.PIPE,
            check=True,
        )
        return str(UUID(result.stdout.strip()))
    except (subprocess.CalledProcessError, ValueError) as error:
        raise RuntimeError(f"Check Central Portal for deployment {name} before retrying the upload.") from error


def publish_deployment(deployment_id, name, version, authorization):
    deadline = time.monotonic() + 45 * 60
    requested_publish = False
    expected_purls = {f"pkg:maven/{GROUP}/{artifact}@{version}" for artifact, _ in deployed_artifacts()}
    while time.monotonic() < deadline:
        try:
            status = json.loads(central_request(f"status?{urlencode({'id': deployment_id})}", authorization))
        except HTTPError as error:
            if error.code != 429 and error.code < 500:
                raise
            time.sleep(10)
            continue
        except (URLError, TimeoutError):
            time.sleep(10)
            continue
        require(
            status["deploymentId"] == deployment_id and status["deploymentName"] == name,
            f"Deployment {deployment_id} does not match {name}",
        )
        state = status["deploymentState"]
        print(f"Central deployment {deployment_id}: {state}", flush=True)
        if state in ("VALIDATED", "PUBLISHED"):
            require(set(status["purls"]) == expected_purls, f"Deployment {deployment_id} lacks the expected coordinates")
        if state == "PUBLISHED":
            return
        if state == "VALIDATED" and not requested_publish:
            central_request(f"deployment/{deployment_id}", authorization)
            requested_publish = True
        if state not in ("PENDING", "VALIDATING", "VALIDATED", "PUBLISHING"):
            raise RuntimeError(f"Deployment {deployment_id} entered {state}. Check validation errors in Central Portal.")
        time.sleep(10)
    raise TimeoutError(f"Resume release with deployment ID {deployment_id} after checking Central Portal.")


def verify_publication(version):
    pending = [
        artifact_path(artifact, version, suffix)
        for artifact, extension in deployed_artifacts()
        for suffix in (".pom", ".module", extension)
    ]
    deadline = time.monotonic() + 30 * 60
    while pending and time.monotonic() < deadline:
        for path in pending.copy():
            if time.monotonic() >= deadline:
                break
            try:
                if public_artifact_exists(path):
                    pending.remove(path)
            except HTTPError as error:
                if error.code != 429 and error.code < 500:
                    raise
            except (URLError, TimeoutError):
                continue
        if pending:
            time.sleep(15)
    require(not pending, f"Maven Central still has missing artifacts: {pending}")
    print("Verified POM, module metadata and primary archive availability for both editions.")


def publish(args):
    require(re.fullmatch(r"[0-9a-f]{40}", args.commit), "Invalid release commit")
    username = os.environ["CENTRAL_USERNAME"]
    password = os.environ["CENTRAL_PASSWORD"]
    require(username and password, "Missing Central Portal token credentials")
    authorization = "Bearer " + base64.b64encode(f"{username}:{password}".encode()).decode()
    name = f"yandex-mapkit-kmp-{args.version}-{args.commit}"
    if args.resume:
        deployment_id = str(UUID(args.resume))
    else:
        for artifact, _ in deployed_artifacts():
            path = artifact_path(artifact, args.version, ".pom")
            require(not public_artifact_exists(path), f"{path} is already public. Resume the original deployment.")
        bundle_sha = digest(args.bundle, "sha256")
        deployment_id = upload_bundle(args.bundle, name, authorization)
        print(f"Uploaded deployment {deployment_id}, bundle SHA-256 {bundle_sha}", flush=True)
    print(f"Central release deployment ID: {deployment_id}", flush=True)
    with Path(os.environ["GITHUB_STEP_SUMMARY"]).open("a") as summary:
        summary.write(f"Central deployment `{deployment_id}` for `{name}`\n")
    publish_deployment(deployment_id, name, args.version, authorization)
    verify_publication(args.version)


def main():
    parser = argparse.ArgumentParser(description="Prepare or publish a combined Maven Central release.")
    commands = parser.add_subparsers(dest="command", required=True)
    assembly = commands.add_parser("assemble")
    assembly.add_argument("version")
    assembly.add_argument("staging", type=Path)
    assembly.add_argument("bundle", type=Path)
    assembly.add_argument("mode", choices=("rehearsal", "release"))
    publication = commands.add_parser("publish")
    publication.add_argument("version")
    publication.add_argument("commit")
    publication.add_argument("bundle", type=Path)
    publication.add_argument("--resume")
    args = parser.parse_args()
    if args.command == "assemble":
        assemble(args)
    else:
        publish(args)


if __name__ == "__main__":
    main()
