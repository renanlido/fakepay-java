package org.renanlido.transactions.application.dtos;

import java.math.BigDecimal;
import java.util.UUID;


public record CreateTransactionInputDTO(UUID payerId, UUID payeeId, BigDecimal value) {
  
}

