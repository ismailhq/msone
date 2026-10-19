
---
mode: agent
description: Review code changes for correctness, security, reliability and organization-specific engineering standards.
---

# Pull Request Review

Act as a Senior Java Tech Lead reviewing the current changes.

## Review scope

Inspect the current branch changes against the appropriate
base branch. Review the diff and relevant surrounding code.

## Review checklist

1. Business logic, boundary conditions and null handling.
2. Exception propagation and error-response consistency.
3. SQL/JPA performance, N+1 queries and transaction boundaries.
4. Concurrency, thread safety and resource management.
5. REST timeouts, retries and circuit-breaker behavior.
6. Kafka duplicate delivery, idempotency, ordering, retries and DLT.
7. Authentication, authorization and sensitive-data exposure.
8. Logging, correlation IDs, tracing and metrics.
9. Unit-test quality, integration tests and regression coverage.
10. API/event compatibility and deployment risks.
11. Compliance with repository and path-specific instructions.

## Findings

For each finding, provide:

- Severity: Critical, High, Medium or Low.
- File and relevant method or line.
- Evidence from the code.
- Concrete failure scenario and impact.
- Recommended fix.
- Regression test.

Separate confirmed defects from potential risks.
Avoid style-only findings unless they violate an explicit
organization standard.

## Final report

Summarize:
- Critical and high-priority findings.
- Missing tests and security concerns.
- Backward-compatibility risks.
- Recommended actions before merge.

Do not approve or merge the PR on behalf of a human reviewer.
Do not claim tests passed unless they were actually executed.
