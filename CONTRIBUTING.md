CONTRIBUTING GUIDELINES

Quick start
- Clone the repository and use the Maven wrapper to build and test.
  PowerShell:
  .\mvnw.cmd clean verify

Where to find the rules
- High-level engineering rules: `.github/copilot-instructions.md`
- Java rules: `.github/instructions/java.instructions.md` (project-specific Java + Spring rules)
- Kafka rules: `.github/instructions/kafka.instructions.md`
- Documentation rules: `.github/instructions/documentation.instructions.md`
- ADRs and architecture docs: `docs/adr/`, `docs/architecture/`

Branching & naming
- Work on feature branches created from `main`:
  - Feature: `feature/<short-descriptive-name>`
  - Bugfix: `bugfix/<jira-or-id>-short-desc`
  - Hotfix: `hotfix/<short-desc>`
- Rebase or pull `main` regularly to keep changes small and reviewable.

Commit messages
- Use conventional commits where possible:
  - feat: short description
  - fix: short description
  - docs: short description
  - chore: short description
- Keep subject line <= 72 chars and add a detailed body for non-trivial changes.

Pull Request process
- Open a PR against `main` when your feature is ready.
- PR title: concise summary; include issue/JIRA number if available.
- PR description must include:
  - What changed and why
  - Tests added/modified
  - Any required deployment or configuration changes
  - Links to ADRs or design docs, if applicable
- Use reviewers assigned by the component owner.
- Address review comments and squash/fixup commits as requested by reviewers.

Testing & CI
- Run unit tests locally:
  .\mvnw.cmd test
- Run full verification (includes integration if configured):
  .\mvnw.cmd clean verify
- CI runs checks for format, tests and static analysis. Fix any CI failures before merging.

Style & static analysis
- Code must pass the project's formatter and linter. The project uses a configured formatter (see `pom.xml` or `spotless` config).
- Address SpotBugs/PMD/Checkstyle warnings unless there is an approved rationale.

Adding dependencies
- Add new dependencies only after confirming there is no existing in-repo alternative and the license is compatible.
- Document new major dependencies in the PR.

Secrets & configuration
- Use environment variables or external secret stores. Do not store secrets or credentials in the repo.
- Configuration overrides for local development should be documented in `README.md` or `docs/operations/`.

Documentation
- Update docs in `docs/` for any user-visible changes (APIs, configs).
- New features with architectural implications should reference an ADR under `docs/adr/`.

Security
- Run dependency vulnerability checks and fix any high/critical issues promptly.
- Follow secure coding practices in Java and Spring (input validation, escaping, principle of least privilege).

Release & deployment
- Releases are handled by the release maintainers (document any release-impacting changes in PRs).
- Do not attempt production deployments without approval and runbooks.

Contact & ownership
- If unsure, contact the team lead or service owner (see `docs/operations/` or repository OWNERS file if present).

Appendix: Useful commands (PowerShell)
- Build & test:
  .\mvnw.cmd clean verify
- Run unit tests:
  .\mvnw.cmd test
- Run a single module:
  cd path\to\module; ..\..\mvnw.cmd clean package
- Format check (if repository uses Spotless):
  .\mvnw.cmd spotless:check
