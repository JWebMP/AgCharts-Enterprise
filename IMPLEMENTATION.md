# IMPLEMENTATION — JWebMP Ag Charts Enterprise

Current code layout and how it maps to guides and rules.

## Modules and services
- JPMS module `com.jwebmp.plugins.agchartsenterprise` (`src/main/java/module-info.java`) exports core, gauge, axes, and series packages; opens them for Guice/Jackson.
- Service registrations under `src/main/resources/META-INF/services/` expose:
  - `AgChartsEnterprisePageConfigurator` as `IPageConfigurator`
  - `AgChartsEnterpriseModuleScanInclusion` as `IGuiceScanModuleInclusions`
- Page configurator declares the `ag-charts-enterprise` dependency and Angular boot imports; see `rules/generative/frontend/jwebmp/agcharts-enterprise/page-configurator.rules.md`.

## Components
- `AgGauge` provides Angular bridge glue (EventBus wiring, WebSocket receiver) and expects subclasses to return initial options via CRTP setters. See `docs/architecture/sequence-gauge-options.md`.
- `AgRadialGauge` supplies default radial gauge options with scale min/max.
- `AgRadialColumnChart` builds polar axes and a radial column series asynchronously (`Uni<AgChartOptions<?>>`).
- Option models live under `src/main/java/com/jwebmp/plugins/agchartsenterprise/options/...` and mirror AG Charts Enterprise configuration.

## Tests
- Serialization-focused tests under `src/test/java/com/jwebmp/plugins/agchartsenterprise/` validate heatmap series, navigator options, and radial column charts. Use them as exemplars when adding option types.

## Build and runtime
- Maven build (inherits `com.jwebmp:parent`); `flatten-maven-plugin` present. Align any new configuration with `rules/generative/language/java/build-tooling.md`.
- Runtime dependencies: JWebMP core/client/angular, AgCharts base plugin, ag-charts-enterprise JS runtime via `@TsDependency`, GuicedEE injection, Mutiny for async flows.

## Traceability
- Follow `GLOSSARY.md` for terminology; apply CRTP fluent API rules.
- Connect implementation changes to guides in `GUIDES.md` and architecture diagrams in `docs/architecture/`.
