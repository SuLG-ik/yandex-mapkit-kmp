#!/usr/bin/env bash
set -euo pipefail

payload=""
if [ ! -t 0 ]; then
  payload=$(cat || true)
fi

if [ -n "$payload" ]; then
  hook_cwd=$(printf '%s' "$payload" | jq -r '.new_cwd // .cwd // empty' 2>/dev/null || true)
  if [ -n "$hook_cwd" ] && [ -d "$hook_cwd" ]; then
    cd "$hook_cwd"
  fi
fi

git_dir=$(git rev-parse --git-dir 2>/dev/null) || exit 0
[ -f "$git_dir/gitdir" ] || exit 0

common_dir=$(cd "$(git rev-parse --git-common-dir)" && pwd)
main_root=$(dirname "$common_dir")
repo_root=$(git rev-parse --show-toplevel)
cd "$repo_root"

include_file="$repo_root/.worktreeinclude"
[ -f "$include_file" ] || include_file="$main_root/.worktreeinclude"
[ -f "$include_file" ] || exit 0

linked=""
relinked=""
while IFS= read -r raw || [ -n "$raw" ]; do
  entry="${raw%%#*}"
  entry="$(printf '%s' "$entry" | tr -d '\r' | sed -e 's/^[[:space:]]*//' -e 's/[[:space:]]*$//' -e 's:/*$::')"
  [ -z "$entry" ] && continue
  case "$entry" in /*|*..*) continue ;; esac

  target="$main_root/$entry"
  [ -e "$target" ] || continue

  if [ -L "$entry" ]; then
    [ "$(readlink "$entry")" = "$target" ] && continue
    rm -f -- "$entry"
    ln -s "$target" "$entry"
    relinked="$relinked $entry"
    continue
  fi

  if [ -e "$entry" ]; then
    rm -rf -- "$entry"
    ln -s "$target" "$entry"
    relinked="$relinked $entry"
    continue
  fi

  mkdir -p "$(dirname "$entry")"
  ln -s "$target" "$entry"
  linked="$linked $entry"
done < "$include_file"

[ -n "$linked" ] && echo "worktree-include: linked$linked from $main_root"
[ -n "$relinked" ] && echo "worktree-include: relinked$relinked from $main_root"
exit 0
