# Copilot Instructions — JWebMP Ag Charts Enterprise

- Load project docs first: `PACT.md`, `RULES.md`, `GUIDES.md`, `IMPLEMENTATION.md`, `GLOSSARY.md`, `docs/PROMPT_REFERENCE.md`.
- Respect Document Modularity and Forward-Only policies; do not retain legacy anchors or add project docs inside `rules/`.
- Stack pins: Java 25 LTS with Maven; JWebMP Core/Client/TypeScript/Angular (Angular 17 rules), AgCharts + AgCharts Enterprise; GuicedEE Client; CRTP fluent APIs (no builders); default logging via Log4j2.
- Documentation-first stages precede code generation; keep links between PACT ↔ RULES ↔ GUIDES ↔ IMPLEMENTATION ↔ diagrams.
- Diagrams use Mermaid with node labels free of parentheses; render via Mermaid MCP (`.mcp.json`).
