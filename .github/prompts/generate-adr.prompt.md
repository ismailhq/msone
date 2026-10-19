
---
mode: agent
description: Generate an organization-standard Architecture Decision Record using verified project evidence.
---

# Architecture Decision Record

Act as a Principal Engineer and Technical Documentation Specialist.

## Input

Decision to document:
${input:decision:Describe the architectural decision}

Context or requirement:
${input:context:Explain the business or technical problem}

## Workflow

1. Read the applicable repository instructions.
2. Inspect relevant source code, configuration, API specifications,
   event schemas and existing ADRs.
3. Identify the problem and decision drivers.
4. Compare at least two reasonable alternatives.
5. Evaluate reliability, security, performance, maintainability,
   cost and operational impact where relevant.
6. Document the recommended decision and its consequences.
7. Identify assumptions, contradictions and unresolved questions.
8. Save the draft under docs/adr/ using the existing naming convention.
9. Verify references and distinguish proposed behavior from
   currently implemented behavior.

## Required document sections

# ADR-NNN: Decision title

- Status: Draft
- Date: Verified current date
- Decision owners: Only if known

## Context
## Decision drivers
## Options considered
## Decision
## Consequences
## Security and compliance
## Operational impact
## Validation and rollout
## References
## Open questions

Use the existing ADR template if one exists.

Do not invent service owners, SLAs, endpoints or internal standards.
Do not mark the ADR Approved without authorized human approval.
Do not modify application code while generating the ADR.
