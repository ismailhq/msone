
---
applyTo: "**/*Kafka*.java"
---

# Kafka-specific engineering rules

- Inspect existing producer and consumer configuration.
- Check consumer group, offset management and delivery semantics.
- Consider duplicate delivery and idempotent processing.
- Follow existing retry, backoff and DLT conventions.
- Preserve event schema compatibility.
- Consider ordering requirements and partition keys.
- Test malformed messages and downstream service failures.
- Do not claim exactly-once business processing merely because
  Kafka producer idempotence is enabled.
- Follow existing observability and correlation-ID conventions.
