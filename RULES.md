# RULES — JWebMP Ag Charts Enterprise (Host Project)

Scope and selections
- Language/Build: Java 25 LTS with Maven (see `rules/generative/language/java/java-25.rules.md`, `rules/generative/language/java/build-tooling.md`).
- Frontend runtime: JWebMP Core/Client/TypeScript/Angular with AgCharts and AgCharts Enterprise add-ons.
- Angular version: default to Angular 17 rules unless the host app overrides (base `rules/generative/language/angular/README.md` + `rules/generative/language/angular/angular-17.rules.md`).
- Fluent API strategy: CRTP (no builders); follow `rules/generative/backend/fluent-api/crtp.rules.md`.
- Logging: Default to Log4j2; align with `rules/generative/backend/logging/README.md` when logging is added.
- Documentation-first and Forward-Only policies apply; see `PACT.md` and `GLOSSARY.md` for alignment and terminology.

Topic rule indexes
- Java: `rules/generative/language/java/README.md`
- Angular/TypeScript: `rules/generative/language/angular/README.md`, `rules/generative/language/typescript/README.md`
- JWebMP: `rules/generative/frontend/jwebmp/README.md`, `rules/generative/frontend/jwebmp/core/README.md`, `rules/generative/frontend/jwebmp/client/README.md`, `rules/generative/frontend/jwebmp/typescript/README.md`
- AgCharts: `rules/generative/frontend/jwebmp/agcharts/README.md`, `rules/generative/frontend/jwebmp/agcharts-enterprise/README.md`
- GuicedEE client: `rules/generative/backend/guicedee/client/README.md`
- Architecture and testing: `rules/generative/architecture/README.md`, `rules/generative/architecture/tdd/README.md`
- Platform/ops references for future CI/observability/security work: `rules/generative/platform/ci-cd/README.md`, `rules/generative/platform/observability/README.md`, `rules/generative/platform/security-auth/README.md`

Glossary and naming
- Use `GLOSSARY.md` for topic precedence. Topic glossaries override host entries (Java, TypeScript/Angular, JWebMP, AgCharts, GuicedEE, CRTP).
- Align terminology with the ag-charts-enterprise rules (e.g., gauge options, radial columns) and CRTP method chaining.

Doc and diagram policy
- Place host docs outside `rules/`; keep sources under `docs/` (see `docs/architecture/README.md`).
- Mermaid diagrams must avoid parentheses in node labels; render via the Mermaid MCP server in `.mcp.json`.

Change management
- Forward-Only: replace outdated guidance rather than keeping legacy anchors.
- Documentation-first stage gating: complete PACT/RULES/GUIDES/IMPLEMENTATION before code changes (Stage 4). Blanket approval is logged but does not bypass documentation requirements.
