# JWebMP Ag Charts Enterprise

Plugin library extending JWebMP AgCharts with enterprise chart types (gauges, radial columns, heatmaps) and Angular bindings.

## Rules Repository Adoption
- Rules submodule lives at `rules` (see `.gitmodules`). Keep project-specific docs outside the submodule.
- Documentation-first, forward-only workflow with PACT → RULES → GUIDES → IMPLEMENTATION → code. Blanket approval for this run is recorded, but documentation gates still apply.
- Quick links: `PACT.md`, `RULES.md`, `GUIDES.md`, `IMPLEMENTATION.md`, `IMPLEMENTATION_PLAN.md`, `GLOSSARY.md`, `docs/architecture/README.md`, `docs/PROMPT_REFERENCE.md`.
- Update submodule when needed: `git submodule update --init --recursive`.

## Stack
- Java 25 LTS, Maven build (inherits `com.jwebmp:parent`).
- JWebMP Core/Client/TypeScript/Angular with AgCharts and AgCharts Enterprise NPM runtime.
- Angular ruleset: Angular 17 override applied (see `RULES.md` and `rules/generative/language/angular/angular-17.rules.md`).
- CRTP fluent APIs (no builders); default logging policy is Log4j2.

## Development Workflow
- Follow `GUIDES.md` and topic rules under `rules/generative/...`.
- Keep terminology aligned with `GLOSSARY.md`; refer to architecture diagrams in `docs/architecture/`.
- Environment variables: copy `.env.example` and fill required values (license keys, CI credentials). Do not commit secrets.
- Tests: `mvn -q -DskipITs=true test` validates current serialization coverage.

## CI and Automation
- GitHub Actions workflow `./.github/workflows/maven-package.yml` uses the shared GuicedEE workflow for Maven builds (requires repository secrets: `USERNAME`, `USER_TOKEN`, `SONA_USERNAME`, `SONA_PASSWORD`).
- Mermaid diagrams render via the Mermaid MCP server configured in `.mcp.json`.
