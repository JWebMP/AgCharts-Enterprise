# AI Assistant Rules — JWebMP Ag Charts Enterprise

Pinned constraints for AI Assistant:
- Load `PACT.md`, `RULES.md`, `GUIDES.md`, `IMPLEMENTATION.md`, `GLOSSARY.md`, and `docs/PROMPT_REFERENCE.md` before generating content.
- Honor Document Modularity and Forward-Only policies from `RULES.md` §4/5/6; do not preserve legacy anchors.
- Documentation-first: complete and respect staged artifacts before proposing code changes.
- Scope: Java 25 LTS, Maven, JWebMP Core/Client/TypeScript/Angular (Angular 17 override), AgCharts + AgCharts Enterprise, GuicedEE Client, CRTP fluent APIs (no builders).
- Logging default: Log4j2 if logging is introduced.
- Submodule safety: do not place project docs inside `rules/`; only link to Rules Repository topics.
- Diagrams: Mermaid with node labels free of parentheses; render via the Mermaid MCP server (`.mcp.json`).
