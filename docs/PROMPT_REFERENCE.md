# PROMPT_REFERENCE — AgChartsEnterprise (JWebMP Plugin)

Purpose: canonical index for AI prompts and human contributors. Load this file before modifying the project so all selected stacks, diagrams, and glossaries stay aligned.

## Selected stacks & versions
- **Language**: Java 25 LTS (module path), TypeScript/Angular 20 (generated workspace), Docs-first (TDD).
- **Frameworks**: JWebMP Core, AgCharts Community + Enterprise, Guice injection, npm-based Angular builder.
- **Policies**: Forward-only, Document Modularity, CRTP fluent APIs (no Lombok `@Builder`), generated assets are read-only.
- **Glossary precedence**: `rules/generative/frontend/jwebmp/agcharts-enterprise/GLOSSARY.md` (topic-level) → parent `rules/generative/frontend/jwebmp/README.md` → enterprise rules root.

## Architecture diagrams
| Diagram | Description |
| - | - |
| [`docs/architecture/c4-context.md`](./architecture/c4-context.md) | External context (developer, host app, JWebMP core, Angular build, npm). |
| [`docs/architecture/c4-container.md`](./architecture/c4-container.md) | Containers inside the host application plus generated Angular workspace. |
| [`docs/architecture/c4-component-agcharts-enterprise.md`](./architecture/c4-component-agcharts-enterprise.md) | Internal components (Page Configurator, module scan inclusion, wrappers, options, tests). |
| [`docs/architecture/sequence-build-integration.md`](./architecture/sequence-build-integration.md) | Build-time sequence showing how annotations pull `ag-charts-enterprise` into the Angular workspace. |

When adding new diagrams (ERD, additional sequences), extend this table and update `docs/architecture/README.md`.

## Prompt seeding checklist
When crafting prompts for this repository:
1. Load this file plus all diagrams listed above.
2. Load plugin rules index: `rules/generative/frontend/jwebmp/agcharts-enterprise/README.md`.
3. Load glossary: `rules/generative/frontend/jwebmp/agcharts-enterprise/GLOSSARY.md`.
4. Load language rules for Java 25, TypeScript, and Angular from `rules/generative/language/**`.
5. Respect `PROMPT_REGISTER_JWEBMP_PLUGIN.md` for registration/maintenance tasks or `PROMPT_CODEBASE_HEALTH_CHECK.md` for audits.

## Cross-links (closing the loop)
- Architecture README: [`docs/architecture/README.md`](./architecture/README.md)
- Root module README: [`README.md`](../README.md) → “How to use these rules” section.
- Rules index: [`rules/generative/frontend/jwebmp/agcharts-enterprise/README.md`](../rules/generative/frontend/jwebmp/agcharts-enterprise/README.md)
- Glossary: [`rules/generative/frontend/jwebmp/agcharts-enterprise/GLOSSARY.md`](../rules/generative/frontend/jwebmp/agcharts-enterprise/GLOSSARY.md)

Keep this file updated whenever stacks, diagrams, or governance policies change.
