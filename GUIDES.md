# GUIDES — JWebMP Ag Charts Enterprise

How to apply the selected rules and stacks for this plugin.

## Getting started
- Ensure Angular runtime selection follows `rules/generative/language/angular/README.md` with the Angular 17 override (`rules/generative/language/angular/angular-17.rules.md`). For other versions, update RULES.md and reroute guides accordingly.
- Load JWebMP stack guides: `rules/generative/frontend/jwebmp/core/README.md`, `rules/generative/frontend/jwebmp/client/README.md`, `rules/generative/frontend/jwebmp/typescript/README.md`.
- AgCharts base and enterprise specifics: `rules/generative/frontend/jwebmp/agcharts/README.md`, `rules/generative/frontend/jwebmp/agcharts-enterprise/README.md`, and the focused entries `java-usage-guide.rules.md`, `page-configurator.rules.md`, `agcharts-enterprise-integration.rules.md`, `usage-examples.rules.md`, `troubleshooting.rules.md`.

## Gauge components (AgGauge/AgRadialGauge)
- Follow CRTP chaining; avoid builders. Reference `rules/generative/backend/fluent-api/crtp.rules.md`.
- When wiring options, mirror the WebSocket flow described in `docs/architecture/sequence-gauge-options.md` and the Angular integration notes in `rules/generative/frontend/jwebmp/agcharts-enterprise/page-configurator.rules.md`.
- Keep EventBus listener names stable; they drive the `InitialOptionsReceiver` dispatch.

## Radial column charts
- Build axes and series following `rules/generative/frontend/jwebmp/agcharts/chart-components.rules.md` and enterprise additions in `rules/generative/frontend/jwebmp/agcharts-enterprise/agcharts-enterprise-integration.rules.md`.
- Reuse label/axis helpers from the base AgCharts rules to align with serialization expectations (see `AgRadialColumnChart#getInitialOptions()`).
- Validate options serialization against existing tests (see `src/test/java/...` and `rules/generative/architecture/tdd/README.md` for TDD flow).

## Page configurator and dependency loading
- Keep `AgChartsEnterprisePageConfigurator` aligned with `rules/generative/frontend/jwebmp/agcharts-enterprise/page-configurator.rules.md` and `rules/generative/frontend/jwebmp/agcharts-enterprise/licensing-and-activation.rules.md` when handling license keys.
- Use `rules/generative/frontend/jwebmp/agcharts-enterprise/usage-examples.rules.md` for client-facing examples.

## Testing and validation
- Prefer TDD (`rules/generative/architecture/tdd/README.md`) and Java testing rules (`rules/generative/platform/testing/jacoco.rules.md`, `rules/generative/platform/testing/README.md`) when expanding coverage.
- Mirror serialization expectations seen in current tests (heatmap, navigator, radial column) when introducing new option models.

## Acceptance checkpoints
- Gauge components: WebSocket receiver responds with non-null options for the listener name; Angular side renders when options arrive; license key (if used) is set via configurator.
- Radial column charts: Axis keys map to dataset fields; optional labels/legend settings serialize into JSON; async `Uni` completes before client render.
- Page configurator: TypeScript dependency and Angular boot imports remain registered; module inclusion advertised via `IGuiceScanModuleInclusions`.

## Traceability
- Cross-link updates with `PACT.md`, `RULES.md`, `GLOSSARY.md`, `IMPLEMENTATION.md`, and diagrams in `docs/architecture/`.
