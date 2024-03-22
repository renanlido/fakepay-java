package org.renanlido.transactions.domain;

import jakarta.annotation.Nullable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class Transaction {
  private final UUID id;
  private final UUID payerId;
  private final UUID payeeId;
  private final BigDecimal value;
  private final LocalDateTime createdAt;

  public Transaction(@Nullable UUID id, UUID payerId, UUID payeeId, BigDecimal value, @Nullable LocalDateTime createdAt) {
    this.id = Optional.ofNullable(id).orElse(UUID.randomUUID());
    this.payerId = payerId;
    this.payeeId = payeeId;
    this.value = value;
    this.createdAt = Optional.ofNullable(createdAt).orElse(LocalDateTime.now());
  }

  public UUID getId() {
    return this.id;
  }

  public UUID getPayerId() {
    return this.payerId;
  }

  public UUID getPayeeId() {
    return this.payeeId;
  }

  public BigDecimal getValue() {
    return this.value;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public void validate() {
    if (this.payerId.equals(this.payeeId)) {
      throw new IllegalArgumentException("Payer and payee cannot be the same");
    }

    if (this.value.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Value must be greater than zero");
    }
  }
}
