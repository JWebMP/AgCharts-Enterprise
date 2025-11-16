# C4 Level 2 — Containers

Purpose: detail the primary containers that collaborate when the plugin is present in a host JWebMP application.

```mermaid
graph TB
    Dev[JWebMP Developer] -->|Implements pages/components| Server[JWebMP Server Runtime<br/>Java 25]
    subgraph Host["Host JWebMP Application"]
        Server -->|Loads via ServiceLoader| Plugin[AgChartsEnterprise Module<br/>JPMS]
        Plugin -->|Annotates dependencies| AngularWorkspace[Generated Angular Workspace<br/>Angular 20]
    end
    Plugin -->|Extends base charts| Community[AgCharts Community Plugin]
    AngularWorkspace -->|npm install/build| EnterpriseNpm[ag-charts-enterprise NPM]
```

Notes
- The plugin is packaged as its own Java module but is loaded into the host server container via JPMS and ServiceLoader.
- The generated Angular workspace is not committed; it is a build output that consumes dependency metadata emitted by the plugin.
