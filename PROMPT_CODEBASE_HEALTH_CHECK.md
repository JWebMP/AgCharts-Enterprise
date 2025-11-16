# 🩺 AG Charts Enterprise — Codebase Health Check and Standards Compliance

Use this prompt to perform a full repository health check for the AG Charts Enterprise JWebMP plugin, assess compliance against the enterprise Rules Repository, detect gaps and deviations, and generate a prioritized remediation plan with proposed diffs.

**Project Configuration**: AG Charts Enterprise JWebMP Plugin  
**Status**: Registered plugin with complete documentation  
**Repository**: AGCharts-Enterprise (Owner: GedMarc)  
**Branch**: master  

---

## 0) Project Inputs (Pre-configured)

**Repository Information**:
- Repository URL / local path: C:\Java\JWebMP\JWebMP\Plugins\AgChartsEnterprise
- Org and project name: GedMarc / AGCharts-Enterprise  
- Short description: JWebMP extension enabling AG Charts Enterprise features on top of the community AgCharts plugin
- License: LICENSE (present in repository)

**Scope Focus** (Pre-selected for this project):
- Backend Reactive:
  - [x] Vert.x 5 (JWebMP integration)
  - [ ] Hibernate Reactive 7
- Backend (Spring MVC): Not applicable
- Backend Reactive (GuicedEE):
  - [x] Core (JWebMP dependency)
  - [x] Web (JWebMP dependency)
  - [x] Rest (potential usage)
  - [ ] Persistence
  - [ ] RabbitMQ
  - [ ] Cerial
  - [ ] OpenAPI
  - [ ] Sockets
- Structural:
  - [x] MapStruct (policy applied)
  - [x] Lombok (policy applied)  
  - [x] Logging (inherited policies)
  - [ ] JSpecify (policies available)
- Fluent API Strategy:
  - [x] CRTP (enforced for JWebMP plugins)
  - [ ] Builder pattern
- Frontend (Standard):
  - [x] Web Components (underlying principles)
- Frontend (Reactive):
  - Angular:
    - [ ] Angular 17
    - [ ] Angular 19  
    - [x] Angular 20 (TypeScript generation target)
  - Other frameworks: Not applicable
- Frontend (Angular Plugins): Not applicable
- Frameworks (JWebMP):
  - [x] Core (primary framework)
  - [ ] WebAwesome (alignment for component naming)
- Platform:
  - [ ] Observability/Health
  - [ ] Security & Auth
  - [ ] Secrets & Env
  - OpenAPI Provider:
    - [x] Swagger (default)
- Data: Not applicable (chart data only)
- Architecture:
  - [x] Monolith (default sample approach)
  - [ ] Microservices
  - [ ] Micro Frontends
  - [ ] DDD
  - [x] TDD (docs-first, test-first enforced)
  - [ ] BDD

**AI Engine**: 
- [x] JetBrains Junie (primary)
- [x] GitHub Copilot (supported)
- [x] Cursor (supported)
- [x] ChatGPT (supported)
- [x] Claude (supported)
- [x] Roo (supported)

**Level of Change**:
- [x] Forward-only (default, enforced)
- [ ] Conservative

**Language Selection**:
- Java LTS:
  - [ ] Java 17 LTS
  - [ ] Java 21 LTS
  - [x] Java 25 LTS (configured)
- Web:
  - [x] TypeScript (Angular integration for @TsDependency)
  - [x] Angular (TypeScript) (configured for Angular 20)
- Kotlin: Not applicable
- Other: Not applicable

**Policies** (Pre-configured for JWebMP plugin):
- Use Markdown for docs. Follow RULES.md sections: 4 (Behavioral), 5 (Technical), Document Modularity Policy, 6 (Forward-Only Change Policy).
- Generated artifacts are read-only; do not propose edits to compiled outputs (TS/HTML/site bundles).
- JWebMP: no inline string HTML; render UI with JWebMP components; do not generate separate TS/HTML for missing views.
- PostgreSQL JPMS: do not shade the driver; prefer com.guicedee.services:postgresql and requires org.postgresql.
- Fluent API Strategy: CRTP enforced (JWebMP plugin); no @Builder; implement manual CRTP fluent setters returning (J)this.
- Glossary policy: Plugin GLOSSARY.md composed from topic-scoped glossaries with LLM guidance.

---

## Documentation-First, Stage-Gated Workflow (Mandatory)

- This repository enforces a documentation-first, stage-gated process for all AI systems.
- The AI MUST NOT write or modify source code until documentation phases are completed and explicitly approved by the user.

**Stage 1** — Health Check Plan (Docs only)
- Deliver: Scope confirmation and inventory approach, Rule/topic mapping plan, Risks and assumptions
- Output format: Markdown plan with links to plugin rule indexes
- STOP: Request explicit user approval to proceed to Stage 2

**Stage 2** — Findings & Documentation (Docs only)  
- Deliver: Compliance matrix with evidence links, Documentation fixes proposals, Risk notes
- STOP: Request explicit user approval to proceed to Stage 3

**Stage 3** — Proposed Diffs (No code applied yet)
- Deliver: Single change set proposal with unified diffs, Migration notes and validation plan
- STOP: Request explicit user approval to proceed to Stage 4

**Stage 4** — Apply Diffs (Code allowed)
- Scope: Only after explicit approval
- Approach: Apply the single change set; present results, run validations, report outcomes

**Universal STOP rule**: If approval is not granted, revise docs/findings; do not produce or apply code.

---

## 1) Self‑Configure the AI Engine (Plugin-Specific)

**Pin Plugin Rules**:
- Primary plugin rules: `./rules/generative/frontend/jwebmp/agcharts-enterprise/README.md`
- Parent JWebMP rules: `./rules/generative/frontend/jwebmp/README.md`
- Enterprise rules root: `./rules/RULES.md`

**Owner Mode** (this plugin repo is active workspace):
- Do not refer to Rules Repository as a submodule
- Operate in forward-only mode; close loops across artifacts
- Plugin-specific focus on AG Charts Enterprise integration

**Language Rules Application**:
- Java 25 LTS: Apply `rules/generative/language/java/java-25.rules.md` and `build-tooling.md`
- TypeScript: Include `rules/generative/language/typescript/README.md`
- Angular integration: Include `rules/generative/language/angular/README.md`

---

## 2) Plugin-Specific Health Check Plan

**Inventory Scope** (Plugin-focused):
- Plugin structure: `src/main/java/`, `src/test/java/`, `src/main/resources/`
- Build configuration: `pom.xml`, Maven alignment with JWebMP BOM
- Documentation: Complete rules system under `rules/generative/frontend/jwebmp/agcharts-enterprise/`, including `java-usage-guide.rules.md`
- Plugin registration: ServiceLoader discovery mechanisms
- Angular integration: Page Configurator with @TsDependency

**Applied Stacks Detection**:
- JWebMP Core integration
- AG Charts Enterprise TypeScript dependency
- Angular TypeScript generation support
- Page Configurator pattern
- CRTP fluent API implementation

**Plugin-Specific Gaps to Check**:
- Missing Page Configurator implementation
- Incomplete @TsDependency declarations
- Missing or outdated `java-usage-guide.rules.md`
- Non-CRTP API patterns
- Missing integration with community plugin
- Documentation link integrity

---

## 3) Plugin Health Check Tasks

**A. Plugin Structure and Integration**
- Verify ServiceLoader configuration in `META-INF/services/`
- Check Page Configurator implementation and auto-discovery
- Validate @TsDependency for `ag-charts-enterprise`
- Ensure `@NgBootImportReference` imports `AgChartsEnterprise` (from `ag-charts-enterprise`) and `AgChartsModule` (from `ag-charts-angular`)
- Confirm integration with community `agcharts` plugin
- Verify Maven dependency structure and BOM alignment

**B. JWebMP Rule Mapping**
- Map to JWebMP plugin patterns: `rules/generative/frontend/jwebmp/`
- Page Configurator rules compliance
- CRTP fluent API implementation
- Component-based UI rendering (no inline HTML)
- Angular TypeScript generation alignment

**C. Language and Framework Checks (Plugin-Specific)**
- Java 25 LTS compliance in module-info.java and build configuration
- JPMS module structure and requires statements
- CRTP pattern implementation (no @Builder usage)
- TypeScript dependency management via annotations
- Angular 20 compatibility for generated code

**D. AG Charts Enterprise Integration**
- Licensing documentation and activation patterns
- Enterprise feature enablement
- Client-side dependency inclusion
- Compatibility with community plugin
- Chart API extension patterns

**E. Documentation and Link Integrity (Plugin Rules)**
- Verify all plugin rule files are present and linked
- Check cross-references to parent JWebMP rules
- Validate glossary completeness and LLM guidance
- Ensure examples follow CRTP patterns
- Verify troubleshooting coverage
- Confirm `java-usage-guide.rules.md` reflects the Java-only workflow and current implementation patterns

**F. Plugin Testing and Examples**
- Unit test presence and patterns
- Integration test coverage
- Example implementations using CRTP
- Documentation example accuracy

---

## 4) Plugin-Specific Output Requirements

**Compliance Matrix** (Plugin Rules Focus):
- Plugin Structure Rules → Implementation Evidence → Status → Action
- JWebMP Integration Rules → Code/Config Evidence → Status → Action  
- AG Charts Enterprise Rules → Documentation/Implementation → Status → Action
- CRTP Pattern Rules → Code Examples → Status → Action
- Documentation Rules → File Structure/Links → Status → Action
- Java Usage Guide Coverage → Java-only docs/examples → Status → Action

**Plugin Remediation Priorities**:
1. **Critical**: Page Configurator and ServiceLoader configuration
2. **High**: @TsDependency and Angular integration  
3. **Medium**: CRTP pattern compliance and examples
4. **Low**: Documentation enhancements and link optimization (including `java-usage-guide.rules.md` updates)

---

## 5) Plugin Output Checklist

- [ ] Stage 1 (Health Check Plan) produced and user-approved
- [ ] Stage 2 (Findings & Documentation) produced and user-approved  
- [ ] Stage 3 (Proposed Diffs) produced and user-approved
- [ ] Stage 4 (Apply Diffs) executed after approval; results validated
- [ ] Plugin structure and ServiceLoader discovery validated
- [ ] Page Configurator implementation verified
- [ ] @TsDependency and Angular integration checked
- [ ] CRTP fluent API pattern compliance verified
- [ ] AG Charts Enterprise integration validated
- [ ] Plugin documentation completeness verified
- [ ] `java-usage-guide.rules.md` aligned with implementation and linked
- [ ] Link integrity across plugin rules confirmed
- [ ] Maven/build configuration alignment checked
- [ ] Examples and testing coverage assessed

---

## 6) Plugin-Specific Guardrails

- **Plugin Focus**: Maintain focus on AG Charts Enterprise integration, not general web development
- **JWebMP Compliance**: All UI must use JWebMP components; no inline HTML strings
- **CRTP Enforcement**: No Lombok @Builder; manual CRTP setters only
- **Documentation Integrity**: Plugin rules must remain modular and cross-linked
- **Enterprise Integration**: Licensing and activation must be documented but not implemented in code
- **Forward-Only**: No backward compatibility; update all references in same change

---

## 7) AI Response Format (Plugin Health Check)

**Required Structure**:
1. **Stage N deliverables** with file paths and working links to plugin rules
2. **Plugin-specific findings** with evidence from implementation and documentation
3. **AG Charts Enterprise integration status** with specific rule compliance
4. **CRTP and JWebMP compliance** with code examples and violations
5. **Documentation loop closure** across plugin rule files
6. **STOP** — Request explicit approval: "APPROVED Stage N → Stage N+1"

---

## Starting Point References (Plugin-Specific)

**Plugin Documentation**:
- Plugin README: `./README.md`
- Plugin Rules Index: `./rules/generative/frontend/jwebmp/agcharts-enterprise/README.md`
- Java Usage Guide: `./rules/generative/frontend/jwebmp/agcharts-enterprise/java-usage-guide.rules.md`
- Registration Status: `./PROMPT_REGISTER_JWEBMP_PLUGIN.md`

**Key Plugin Files**:
- Maven configuration: `./pom.xml`
- Module descriptor: `./src/main/java/module-info.java`
- Plugin rules: `./rules/generative/frontend/jwebmp/agcharts-enterprise/*.md`

**Parent Rules**:
- JWebMP rules: `./rules/generative/frontend/jwebmp/README.md`
- Enterprise rules: `./rules/RULES.md`

---

**Health check configured for AG Charts Enterprise JWebMP Plugin**  
**Registration Status**: Complete (November 12, 2025)  
**Focus**: Plugin-specific compliance and integration validation

End of prompt.
