# Implementation Plan — Stage 3

Scope: Forward-only implementation for JWebMP Ag Charts Enterprise with blanket approval recorded. No code changes executed in this stage.

## Objectives
1. Wire host documentation loops: README links to PACT/RULES/GUIDES/IMPLEMENTATION/GLOSSARY and docs/architecture/.
2. Align AI workspace configs for selected engines: `.aiassistant/rules/`, `.github/copilot-instructions.md`, `.cursor/rules.md` (no Roo needed).
3. Environment alignment: add `.env.example` based on `rules/generative/platform/secrets-config/env-variables.md` with entries for AG Charts license keys and CI tokens if required.
4. CI alignment: add GitHub Actions workflow for Maven build using GuicedEE shared workflow (per required changes).
5. Verify Rules submodule reference in README and ensure no project docs live inside `rules/`.

## Scaffolding & File Targets
- Documentation updates: `README.md` (create if absent) to document Rules submodule usage and link core artifacts.
- AI configs: `.aiassistant/rules/README.md` (or equivalent summary), `.github/copilot-instructions.md`, `.cursor/rules.md`.
- Environment: `.env.example`.
- CI: `.github/workflows/maven-package.yml` using `GuicedEE/Workflows/.github/workflows/projects.yml@master`.

## Build and Tooling
- Maven build already present; no plugin changes anticipated. Respect JPMS module boundaries and existing `flatten-maven-plugin`.
- Java 25 toolchain assumption; verify parent BOM compatibility before changing any compiler settings (defer unless required).

## Rollout & Validation
- After changes, run `mvn -q -DskipITs=true test` to confirm serialization tests still pass.
- Validate diagrams render with Mermaid MCP (no parentheses in node labels).
- Ensure `.env.example` contains only non-secret placeholders; document required secrets in README/CI notes.

## Risks and Mitigations
- GuicedEE shared workflow requires GitHub secrets (`USERNAME`, `USER_TOKEN`, `SONA_USERNAME`, `SONA_PASSWORD`); document need without embedding values.
- License key handling for ag-charts-enterprise must remain opt-in; avoid hard-coding defaults beyond empty placeholders.
- Submodule integrity: avoid modifying files under `rules/`; only link to them.
