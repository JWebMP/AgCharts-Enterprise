# Ag Charts Enterprise — Glossary (Topic-First)

This glossary aggregates terminology for the JWebMP Ag Charts Enterprise plugin using topic-first precedence. Host terms never override topic glossaries; link to source glossaries instead of duplicating definitions.

## Glossary Precedence Policy
- Topic glossaries take priority within their scope; host entries avoid redefining them.
- When a term belongs to multiple topics, prefer the most specific topic glossary.
- Prompt language alignment: use CRTP-style fluent setters (no builders) and JWebMP naming from the linked glossaries.
- Forward-only: remove or replace outdated terms rather than keeping legacy synonyms.

## Topic Glossaries (authoritative sources)
- Java 25 LTS — `rules/generative/language/java/GLOSSARY.md`
- TypeScript/Angular client runtime — `rules/generative/language/typescript/GLOSSARY.md`, `rules/generative/language/angular/GLOSSARY.md`
- JWebMP core and client — `rules/generative/frontend/jwebmp/core/README.md`, `rules/generative/frontend/jwebmp/client/GLOSSARY.md`
- JWebMP TypeScript bridge — `rules/generative/frontend/jwebmp/typescript/GLOSSARY.md`
- JWebMP AgCharts base — `rules/generative/frontend/jwebmp/agcharts/GLOSSARY.md`
- JWebMP AgCharts Enterprise add-ons — `rules/generative/frontend/jwebmp/agcharts-enterprise/GLOSSARY.md`
- GuicedEE client/runtime — `rules/generative/backend/guicedee/client/GLOSSARY.md`
- Fluent API (CRTP) — `rules/generative/backend/fluent-api/GLOSSARY.md`

## Local Terms (minimal, non-overlapping)
- AgCharts Enterprise module: JPMS module `com.jwebmp.plugins.agchartsenterprise` exporting enterprise chart components and options.
- Gauge options listener: WebSocket receiver (`AgGauge.InitialOptionsReceiver`) that responds with initial gauge options when the Angular component requests configuration.
- Page configurator: `AgChartsEnterprisePageConfigurator` providing plugin metadata, TypeScript dependency declarations, and Angular boot imports for ag-charts-enterprise.

## Traceability
- See `docs/architecture/README.md` for diagram sources and flow references.
- RULES/GUIDES/IMPLEMENTATION will reference this glossary for terminology alignment once produced in later stages.
