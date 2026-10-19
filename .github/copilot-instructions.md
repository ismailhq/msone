
# Organization Engineering Standards

## General rules
- Inspect the existing code before modifying it.
- Follow the project's established architecture and conventions.
- Use the Java and Spring Boot versions declared in pom.xml.
- Avoid unrelated changes and unnecessary dependencies.
- Never hardcode secrets or expose sensitive information.

## Implementation
- Follow existing REST, database, security and Kafka patterns.
- Handle validation, exceptions, timeouts and failure scenarios.
- Preserve API and event compatibility unless a breaking change is approved.

## Testing
- Add appropriate unit and integration tests.
- Run relevant Maven verification commands.
- Report actual test results; never claim unexecuted tests passed.

## Documentation
- Keep documentation consistent with verified implementation.
- Follow approved HLD, LLD and ADR templates.
- Separate implemented behavior from assumptions and proposed changes.

## Safety
- Do not deploy to production or perform destructive operations without approval.
- Explain significant design decisions and unresolved risks.
