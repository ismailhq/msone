
---
mode: agent
description: Implement a production-ready feature following organization-specific Java and Spring Boot standards.
---

# Feature Implementation

Act as a Senior Java Engineer working in this repository.

## Input
Feature requirement: ${input:requirement:Describe the feature to implement}

## Workflow

1. Read `.github/copilot-instructions.md` and applicable
   path-specific instructions.
2. Inspect pom.xml, existing source code, tests and configuration.
3. Identify affected controllers, services, repositories,
   database entities, APIs and Kafka components.
4. Explain the implementation plan and assumptions.
5. Implement the smallest complete change consistent with
   the existing architecture.
6. Add unit and integration tests.
7. Handle validation, exceptions, timeouts, retries and
   idempotency where applicable.
8. Update relevant API specifications and documentation.
9. Run the appropriate Maven tests and verification commands.
10. Review the final diff for security issues, unrelated changes
    and backward-compatibility risks.

## Organization standards

- Use the Java and Spring Boot versions declared in pom.xml.
- Follow existing dependency-injection and exception-handling patterns.
- Respect the existing Spring MVC or WebFlux architecture.
- Preserve API contracts unless a breaking change is approved.
- Follow existing Kafka retry, DLT and event-schema conventions.
- Never hardcode credentials or weaken security controls.

## Output

Report:
- Files changed and implementation summary.
- Design decisions and assumptions.
- Tests executed and their actual results.
- Security and deployment considerations.
- Remaining risks and unresolved questions.

Do not deploy, execute destructive operations or modify
unrelated modules without explicit authorization.
