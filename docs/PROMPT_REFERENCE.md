# Prompt Reference — JWebMP Ag Charts Enterprise

Use this file as the first stop for future prompts. It pins stack selections, glossary precedence, and architecture sources.

## Stack and Policy Pins
- Language/Build: Java 25 LTS, Maven.
- Frontend: JWebMP Core/Client/TypeScript/Angular; AG Charts plugin plus enterprise add-ons.
- Backend/runtime: GuicedEE Client; CRTP fluent API strategy (no builders).
- Policies: Document Modularity, Forward-Only (RULES.md §4/5/6), documentation-first stage gating with blanket approval recorded.
- Logging: Default to Log4j2 when logging is required.

## Rules Repository Links
- Root rules: `rules/RULES.md`
- Java: `rules/generative/language/java/java-25.rules.md`, `rules/generative/language/java/build-tooling.md`
- TypeScript/Angular: `rules/generative/language/typescript/README.md`, `rules/generative/language/angular/README.md` with Angular version override to be selected in RULES.md
- JWebMP stack: `rules/generative/frontend/jwebmp/README.md`, `rules/generative/frontend/jwebmp/client/README.md`, `rules/generative/frontend/jwebmp/typescript/README.md`, `rules/generative/frontend/jwebmp/agcharts/README.md`, `rules/generative/frontend/jwebmp/agcharts-enterprise/README.md`
- GuicedEE client: `rules/generative/backend/guicedee/client/README.md`
- Fluent API: `rules/generative/backend/fluent-api/crtp.rules.md`

## Glossary Precedence
- Host glossary: `GLOSSARY.md` with topic-first links.
- Topic glossaries: Java, TypeScript/Angular, JWebMP client/typescript/agcharts/agcharts-enterprise, GuicedEE client, CRTP fluent API.

## Architecture Sources
- Index: `docs/architecture/README.md`
- Context: `docs/architecture/c4-context.md`
- Containers: `docs/architecture/c4-container.md`
- Components: `docs/architecture/c4-component-agcharts-enterprise.md`
- Sequences: `docs/architecture/sequence-gauge-options.md`, `docs/architecture/sequence-radial-column.md`
- ERD: `docs/architecture/erd-agcharts-enterprise.md`

## MCP Servers
- Mermaid MCP configured in `.mcp.json` (`https://mcp.mermaidchart.com/mcp`). Load before rendering diagrams.

## Traceability Expectations
- Close loops: PACT ↔ GLOSSARY ↔ RULES ↔ GUIDES ↔ IMPLEMENTATION with diagram references.
- Keep host docs outside `rules/`; update indexes when adding or removing artifacts.
