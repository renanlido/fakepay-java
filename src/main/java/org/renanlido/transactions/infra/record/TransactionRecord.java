package org.renanlido.transactions.infra.record;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.UUID;

@Table("transactions")
public record TransactionRecord(@Id UUID id, UUID payerId, UUID payeeId, BigDecimal value, LocalDateTime createdAt) {
  public TransactionRecord {
    value = value.setScale(2, RoundingMode.HALF_UP);
  }
}
