# Cursor Rules — JWebMP Ag Charts Enterprise

- Load `PACT.md`, `RULES.md`, `GUIDES.md`, `IMPLEMENTATION.md`, `GLOSSARY.md`, and `docs/PROMPT_REFERENCE.md` before proposing changes.
- Apply Document Modularity and Forward-Only policies; avoid legacy anchors and keep host docs outside `rules/`.
- Stacks: Java 25 LTS + Maven; JWebMP Core/Client/TypeScript/Angular (Angular 17 override); AgCharts + AgCharts Enterprise; GuicedEE Client; CRTP fluent APIs; Log4j2 default.
- Follow documentation-first stage gates even under blanket approval; trace updates across PACT ↔ RULES ↔ GUIDES ↔ IMPLEMENTATION ↔ diagrams.
- Mermaid diagrams only (no parentheses in node labels); use Mermaid MCP server defined in `.mcp.json`.
