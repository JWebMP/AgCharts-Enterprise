---
version: 2.0
date: 2024-12-02
title: The Human–AI Collaboration Pact
project: JWebMP / Ag Charts Enterprise
authors: [JWebMP maintainers, GuicedEE maintainers, AI assistants]
---

# 🤝 Pact.md (v2) — JWebMP Ag Charts Enterprise  
### The Human–AI Collaboration Pact  
*(Human × AI Assistant — “The Pact” Developer Edition)*  

## 1. Purpose
This pact aligns the JWebMP Ag Charts Enterprise library with the Rules Repository. It sets the shared language, tone, and guardrails for forward-only, documentation-first work across PACT → RULES → GUIDES → IMPLEMENTATION. Blanket approval is active for this run; stage gates are recorded as auto-approved.

## 2. Principles
- Continuity: Carry context across threads and artifacts; pin RULES.md sections 4/5, Document Modularity, and Forward-Only.
- Finesse: Favor clear, concise engineering narratives over filler.
- Non-Transactional Flow: Collaborate from discovery → documentation → design → implementation.
- Closing Loops: Every change links back to PACT, GLOSSARY, RULES, GUIDES, IMPLEMENTATION, and diagrams under docs/architecture/.
- Transparency: Surface assumptions and unknowns instead of inventing architecture.

## 3. Structure of Work

| Layer | Description | Artifact |
|-------|-------------|----------|
| Pact | Shared culture, tone, approvals, and constraints. | `PACT.md` |
| Rules | Conventions and stack selections mapped to Rules Repository topics. | `RULES.md` |
| Guides | How-to recipes and validations for selected stacks. | `GUIDES.md` |
| Implementation | Code layout, module notes, and traceability back to guides. | `IMPLEMENTATION.md` |

## 4. Behavioral Agreements
- Language: Clear, precise technical English aligned to RULES.md §4.
- Tone: Friendly teammate, not mechanical. Attribute contributions jointly.
- Context: Respect Document Modularity and Forward-Only policies; no legacy anchors.
- Boundaries: Do not place project docs inside the `rules/` submodule.

## 5. Technical Commitments
- Stacks: Java 25 LTS, Maven build, CRTP fluent API strategy, JWebMP Core/Client/TypeScript/Angular/AgCharts, GuicedEE Client.
- Logging: Default to Log4j2 if logging surfaces in scope.
- Docs-as-Code: Use Markdown with Mermaid; diagrams live under docs/architecture/ with sources committed.
- MCP: Mermaid MCP configured via `.mcp.json` for diagram rendering.
- Traceability: Link RULES → GUIDES → IMPLEMENTATION and reference topic glossaries in `GLOSSARY.md`.

## 6. Shared Goals
1. Capture the current library architecture from the checked-in code (no speculation).
2. Publish modular docs and diagrams that future prompts must load.
3. Keep fluent APIs consistent with CRTP; avoid Lombok builders.
4. Maintain forward-only changes; update references alongside edits.

## 7. Stage Gates and Approvals
- Blanket approval noted; Stage 1–4 gates auto-approved but still recorded in outputs.
- Documentation-first: No source code edits until Stage 4 after Stage 1–3 docs/plans exist.
- MCP usage is documented whenever diagrams are rendered.

## 8. Closing Note
We engineer intentionally: clarify, document, validate, then implement. Every artifact should be discoverable, linked, and grounded in this repository’s code.
