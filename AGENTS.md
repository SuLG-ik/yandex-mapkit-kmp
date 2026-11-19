# Repository guidance

Read [CLAUDE.md](CLAUDE.md) for module boundaries, build and test commands, and project conventions.

- Wrapper API changes follow the [wrapper guide](.claude/skills/ymk-wrapper-api/SKILL.md) and the
  pinned Android AAR and iOS headers. Mirror the native SDK hierarchy under `ru.sulgik.mapkit`.
- Compose map changes follow the [Compose guide](.claude/skills/ymk-compose-api/SKILL.md).
- Before merging any PR, send its final head commit and linked issue to a fresh, independent
  `gpt-6.2-astra` subagent with reasoning effort `high`. Use the
  [review checklist](.claude/skills/ymk-conventions-review/SKILL.md) and record the reviewed SHA,
  findings and verification in the PR. Send any new head to a fresh reviewer.
- Release changes follow [RELEASING.md](RELEASING.md).
