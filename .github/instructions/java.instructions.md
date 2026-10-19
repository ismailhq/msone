---
applyTo: "**/*.java"
---

# Java / Spring engineering rules

Purpose
- Provide concrete, enforceable Java and Spring development rules for this repository.
- Complement existing high-level rules in `.github/copilot-instructions.md` and service-specific rules (e.g., Kafka).

Core rules
- Java & Spring versions
  - Use the Java (JDK) and Spring Boot versions declared in each module's `pom.xml`. Do not upgrade versions without an approved ADR.
- Formatting & style
  - Use a deterministic formatter: google-java-format or Spotless with google-java-format.
  - Keep line length to 120 characters maximum.
  - Use `@Override` on overridden methods.
  - Follow standard package and class naming (lowercase package names, PascalCase class names).
- Imports & dependencies
  - Avoid wildcard imports.
  - Prefer explicit dependencies defined in parent `pom.xml` to maintain consistent versions.
  - Do not add new dependencies without justification (security, license, footprint).
- Logging
  - Use SLF4J (logger per-class: `private static final Logger LOG = LoggerFactory.getLogger(MyClass.class);`).
  - Do not log sensitive data (PII, secrets). Mask or redact when necessary.
  - Use appropriate log levels: DEBUG for developer info, INFO for high-level lifecycle events, WARN for recoverable issues, ERROR for unrecoverable errors.
- Exceptions & error handling
  - Validate inputs at API boundaries and fail fast for invalid input.
  - Prefer checked exceptions only when callers are expected to handle them; favour meaningful runtime exceptions for unexpected states.
  - Catch the most specific exception possible; do not swallow exceptions silently.
  - Create and use service-level exceptions with clear messages and error codes where appropriate.
- Null handling
  - Prefer Java 8+ `Optional<T>` for potentially absent return values instead of returning null where it improves clarity.
  - Explicitly document `@Nullable` / `@NotNull` contract if used in public APIs.
- Immutability & thread-safety
  - Favor immutable objects for DTOs and value types (final fields, no setters) when practical.
  - Avoid shared mutable state; if required, guard with clear concurrency primitives and document thread expectations.
- DTOs, mapping & validation
  - Keep domain models separate from transport DTOs (REST/Kafka).
  - Validate incoming requests with Bean Validation (`javax.validation` / `jakarta.validation`) and return clear validation errors.
- Tests & coverage
  - Unit tests: use JUnit (version from pom), Mockito for mocking. Tests should be fast and deterministic.
  - Integration tests: run with embedded containers or testcontainers when external infra is required (Kafka, DB).
  - Each PR must include unit tests for new logic and integration tests for changes that affect runtime behavior or contracts.
  - Aim for meaningful coverage (coverage % is a guide, not a substitute for good tests).
- Kafka conventions
  - Follow `.github/instructions/kafka.instructions.md` for any Kafka producer/consumer classes (file pattern **/*Kafka*.java).
  - Ensure consumer groups, offset strategy, error handling (DLT), idempotency and partitioning decisions are documented in code and ADR if required.
- Observability & correlation
  - Propagate a correlation-ID across threads, REST calls, Kafka messages, and logs (use configured MDC key).
  - Add metrics for critical business operations and failures.
  - Ensure spans/traces are propagated for distributed tracing.
- Security & secrets
  - Never commit secrets. Use secrets manager, environment variables, or secure config stores.
  - Sanitize user input used in logging, queries and downstream calls.
  - Follow repository security guidelines for dependencies (Dependabot, OWASP checks).
- Build & CI
  - Use the project Maven wrapper (`mvnw` / `mvnw.cmd`) for consistent builds.
  - Builds must be reproducible: `./mvnw -DskipTests=false clean verify`.
  - Add (and document) any required settings for local test infra (e.g., docker-compose for Kafka).
- Documentation & ADRs
  - All design changes that alter API contracts or events must be accompanied by an ADR and tests.
  - Update Javadoc for public APIs; add example usages where helpful.
- Performance & resource safety
  - Use timeouts for network / blocking operations; do not rely on default infinite waits.
  - Limit collection sizes and use streaming where large data sets are processed.

Code review checklist (for reviewers)
- Does the change follow the Java/Spring rules above?
- Are new dependencies justified and approved?
- Are inputs validated and errors handled?
- Is logging and observability present and not leaking secrets?
- Are tests included and passing locally?
- Any breaking changes documented with ADR or API docs?

Notes
- These rules are additive to repository-level rules in `.github/copilot-instructions.md`, `.github/instructions/kafka.instructions.md`, and documentation rules under `.github/instructions/documentation.instructions.md`.
- If you need a rule exception, document the reason in the PR description and get an approver sign-off.
