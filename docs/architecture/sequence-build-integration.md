# Sequence — Build Integration (Page Configurator → Angular)

Shows how the enterprise dependency is wired into the generated Angular workspace during a build.

```mermaid
sequenceDiagram
    participant Dev as Developer
    participant Maven as Maven Build (Java 25)
    participant Config as AgChartsEnterprisePageConfigurator
    participant Generator as Angular Generator
    participant NPM as npm Registry
    participant Workspace as Generated Angular Workspace

    Dev->>Maven: mvn clean package
    Maven->>Config: Instantiate via ServiceLoader / provides
    Config->>Generator: Emit @TsDependency("ag-charts-enterprise") + @NgBootImportReference metadata
    Generator->>NPM: npm install ag-charts-enterprise ag-charts-angular
    NPM-->>Generator: Packages resolved
    Generator->>Workspace: Write package.json + boot imports referencing AgChartsEnterpriseModule
    Workspace-->>Dev: Angular artifacts (build output)
```

Highlights
- No manual TypeScript edits are required; annotations drive the generator.
- The generator fetches both the enterprise runtime and the Angular bridge (`ag-charts-angular`) so imports stay in lockstep.
- Build outputs remain read-only; the authoritative sources are the Java configurator and option models.
