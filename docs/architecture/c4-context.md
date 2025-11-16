# C4 Level 1 — Context

Purpose: show how the AgChartsEnterprise JWebMP plugin fits into the surrounding ecosystem (developers, host apps, build pipeline, and AG Charts Enterprise distribution).

```mermaid
graph LR
    Dev[JWebMP Developer<br/>builds host apps] -->|Adds dependency| Host
    subgraph Host["Host JWebMP Application"]
        Plugin["AgChartsEnterprise Plugin"]
    end
    Plugin -->|Extends components/services| JWebMP[JWebMP Core Framework]
    Plugin -->|Declares @TsDependency / @NgBootImportReference| AngularBuild[Angular Build Pipeline]
    AngularBuild -->|Installs| NPM[AG Charts Enterprise NPM Package]
    Dev -->|Deploys| Host
```

Key points
- Plugin operates inside a host JWebMP app but drives both server behavior (wrappers) and client generation (Angular workspace).
- Angular build relies solely on metadata emitted by the plugin; no manual TypeScript edits are required.
