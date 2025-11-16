# ✅ JWebMP Plugin Registration Status — AgChartsEnterprise

**Status: REGISTRATION COMPLETE** (as of November 12, 2025)

This module is fully registered as a JWebMP Plugin with complete rules, indexes, and guides under rules/generative/frontend/jwebmp/agcharts-enterprise/ in alignment with the enterprise Rules Repository.

## Registration Summary

✅ **Documentation Structure**: Complete modular rule system with 6 specialized files
✅ **Cross-Integration**: Proper links to JWebMP, Frontend, and Angular indexes  
✅ **Policy Compliance**: CRTP patterns, Forward-Only policy, Document Modularity
✅ **Enterprise Standards**: Full compliance with Rules Repository requirements
✅ **Version Alignment**: 2.0.0-SNAPSHOT with Java 25 LTS and TypeScript integration

**Quick Access**: [Plugin Rules Index](./rules/generative/frontend/jwebmp/agcharts-enterprise/README.md)

Use this prompt for maintenance or updates to the existing documentation structure.

---

## 0) Provide Inputs
Fill before running.

- Library name: AgChartsEnterprise (JWebMP Plugin)
- Current/new version: 2.0.0-SNAPSHOT
- Repository URL / path: C:/Java/JWebMP/JWebMP/Plugins/AgChartsEnterprise
- Short description: JWebMP extension enabling AG Charts Enterprise features on top of the community AgCharts plugin.
- Type:
  - [x] Service/Framework (JWebMP Plugin / Frontend Wrapper)
  - [ ] UI component library
  - [ ] Data/ORM
  - [ ] Other: 

- Component/topic areas (list):
  - JWebMP Wrappers and Page Configurators
  - AG Charts Enterprise Integration
  - Angular TypeScript dependency wiring (ag-charts-enterprise)
  - Licensing notes and activation
  - Examples and usage patterns

- Structural:
  - [x] MapStruct
  - [x] Lombok
  - [x] Logging (inherited policies)
  - [ ] JSpecify (policies available in repo rules)

- Fluent API Strategy (choose exactly one for examples):
  - [x] CRTP (preferred for JWebMP/GuicedEE)
  - [ ] Builder pattern (Lombok @Builder/manual)

- Frontend (Standard):
  - [x] Web Components (underlying principles)

- Frontend (Reactive):
  - Angular (choose exactly one)
    - [ ] Angular 17
    - [ ] Angular 19
    - [ ] Angular 20
  - Other frameworks
    - [ ] React
    - [ ] Next.js

- Frontend (Angular Plugins):
  - [ ] Angular Awesome (if applicable in host projects; link only)

- Frameworks (JWebMP):
  - [x] Core
  - [ ] WebAwesome (links for component naming alignment)

- Security (Reactive):
  - [ ] Vert.x Web Auth/JWT/OAuth2

- Security/Auth Providers:
  - [ ] OpenID Connect (generic)
  - [ ] GCP (IAP/OIDC)
  - [ ] Firebase Auth
  - [ ] Microsoft Entra ID (Azure AD)

- CI/CD Providers:
  - [ ] GitHub Actions (link templates)
  - [ ] GitLab CI
  - [ ] Jenkins
  - [ ] TeamCity
  - [ ] Google Cloud Build
  - [ ] Azure Pipelines
  - [ ] AWS CodeBuild/CodePipeline

- Architecture:
  - [x] Monolith (default sample)
  - [ ] Microservices
  - [ ] Micro Frontends
  - [ ] DDD
  - [x] TDD (docs-first, test-first) — documentation-first enforced
  - [ ] BDD (optional for guides)

- Observability/Diagnostics:
  - [ ] Wireshark

- AI engine used:
  - [x] JetBrains Junie
  - [ ] GitHub Copilot
  - [ ] Cursor
  - [ ] ChatGPT
  - [ ] Claude
  - [ ] Roo

- Release impact:
  - [x] Forward-only (breaking changes allowed)
  - [ ] Backcompat required (only if explicitly demanded)

Policies (must honor):
- Follow RULES.md sections: 4 (Behavioral), 5 (Technical), Document Modularity Policy, 6 (Forward-Only Change Policy).
- Generated artifacts are read-only; do not propose edits to compiled outputs (e.g., TS/HTML/site bundles).
- For JWebMP specifically, do not generate or reference separate TS/HTML components for missing views—render dialogs/tables directly from Java components/cell renderers.
- Avoid inline string HTML; use JWebMP components (Div, Paragraph, Span, Table, H1–H6, etc.).
- PostgreSQL JPMS policy (if applicable): do not shade the driver; use com.guicedee.services:postgresql.
- Fluent API Strategy: CRTP selected; return (J)this from fluent setters, align Lombok usage accordingly (no @Builder in CRTP examples).

Language Selection
- Java LTS (choose one):
  - [ ] Java 17 LTS
  - [ ] Java 21 LTS (default for examples unless overridden)
  - [x] Java 25 LTS
- Web
  - [x] TypeScript (Angular integration)
- Kotlin
  - [ ] Kotlin / Ktor (not applicable here)

Language selection → generation rules
- If Java 25 is selected:
  - Apply rules/generative/language/java/java-25.rules.md and build-tooling.md.
- If Web → TypeScript is selected:
  - Include rules/generative/language/typescript/README.md.
  - If Angular is also selected: include rules/generative/language/angular/README.md and scaffold app structure when requested (docs-first).

---

## 1) Self‑Configure the AI Engine
- Pin repo rules: rules/ (especially rules/generative/frontend/jwebmp/README.md).
- Operate in forward-only mode. Close loops across artifacts.
- Owner mode (this plugin repo is active workspace). Do not treat the Rules Repository as a submodule here; link to it from docs.

---

## 2) Library Documentation Tasks (Docs-only until Stage 4)
Target paths: keep library-specific docs within this repo (outside any Rules Repository submodule). Use docs/ and rules/ under this project.

1) Topic index (parent README)
   - Update or create a topic index README under rules/generative/frontend/jwebmp/ for plugin-specific rules. Link to existing index:
     - rules/generative/frontend/jwebmp/README.md

2) Modularize content
   - Add/adjust modular .rules.md files for topics:
     - agcharts-enterprise-integration.rules.md
     - page-configurator.rules.md
     - licensing-and-activation.rules.md
     - java-usage-guide.rules.md
     - usage-examples.rules.md
     - troubleshooting.rules.md

3) Rules templates (components/topics)
   - Provide: overview, usage patterns, minimal examples, configuration, performance/constraints, see-also links.

4) Cross-links to enterprise topics
   - Link to Rules Repository indexes:
     - JWebMP: rules/generative/frontend/jwebmp/README.md
     - Angular: rules/generative/language/angular/README.md

5) Versioning and release notes
   - If organization is breaking per Forward-Only, add RELEASE_NOTES.md and update CHANGELOG.md.

6) Root README updates (this module)
   - Add “How to use these rules” section pointing to the topic index and to using the Rules Repository in host projects.
   - Add “Prompt Language Alignment & Glossary” note:
     - Link to topic GLOSSARY.md.
     - State it is the minimal authoritative glossary; host projects copy only enforced aligned names and link to the rest.

---

## 3) Special Guidance by Library Type
- JWebMP wrappers
  - Provide wrapper-specific rules; link to WebAwesome component naming alignment where relevant.
- AgCharts Enterprise specifics
  - Ensure Page Configurator wiring documents @TsDependency for ag-charts-enterprise.
  - Document interplay with community plugin (agcharts) and Angular peer deps.

---

## 4) Registration Completion Status
- [x] Parent topic README index created/updated with full topic coverage
- [x] Modular .md files created and linked; monoliths removed per Forward-Only policy
- [x] .rules.md files created/updated with usage, patterns, see-also links
- [x] Cross-links to Rules Repository topic indexes included
- [x] Fluent API Strategy declared (CRTP) and reflected in examples
- [x] Topic GLOSSARY.md created/updated with LLM guidance; README links to it
- [x] Release notes and version bump prepared (version 2.0.0-SNAPSHOT)
- [x] Root README updated with navigation and usage instructions
- [x] All links resolve

**Completed Files:**
- ✅ `rules/generative/frontend/jwebmp/agcharts-enterprise/README.md` - Topic index
- ✅ `rules/generative/frontend/jwebmp/agcharts-enterprise/agcharts-enterprise-integration.rules.md`
- ✅ `rules/generative/frontend/jwebmp/agcharts-enterprise/page-configurator.rules.md`
- ✅ `rules/generative/frontend/jwebmp/agcharts-enterprise/licensing-and-activation.rules.md`
- ✅ `rules/generative/frontend/jwebmp/agcharts-enterprise/java-usage-guide.rules.md`
- ✅ `rules/generative/frontend/jwebmp/agcharts-enterprise/usage-examples.rules.md`
- ✅ `rules/generative/frontend/jwebmp/agcharts-enterprise/troubleshooting.rules.md`
- ✅ `rules/generative/frontend/jwebmp/agcharts-enterprise/GLOSSARY.md`
- ✅ `README.md` - Root module README with navigation

---

## 5) Maintenance Mode Instructions
Since registration is complete, use this prompt for:

**Documentation Updates:**
1) Review existing rules for accuracy and completeness
2) Update examples to reflect current best practices
3) Add new usage patterns as they emerge
4) Maintain cross-links when parent repository structure changes
5) Keep `java-usage-guide.rules.md` aligned with implementation examples and API contracts

**Version Updates:**
1) Update version information in relevant files when releasing
2) Add new features documentation to appropriate rule files
3) Update GLOSSARY.md with new terminology

**Quality Assurance:**
1) Verify all links remain functional
2) Ensure CRTP patterns remain consistent
3) Validate compliance with Forward-Only policy
4) Test examples for accuracy

---

## 6) Quick Reference Links (in this repo)
- Module POM: ./pom.xml
- Module README: ./README.md
- **Plugin Rules Index**: ./rules/generative/frontend/jwebmp/agcharts-enterprise/README.md
- Parent JWebMP Index: ./rules/generative/frontend/jwebmp/README.md
- Rules root: ./rules/

## 7) External Links
- Parent Rules Repository: [Rules Repository structure and policies]
- JWebMP Documentation: [JWebMP framework guides]
- AG Charts Enterprise: https://www.ag-grid.com/charts/

---

**Registration completed on November 12, 2025**
**Module version: 2.0.0-SNAPSHOT**
**Compliance: Rules Repository enterprise standards**

End of prompt.
