package org.renanlido.transactions.application.dtos;

import java.math.BigDecimal;
import java.util.UUID;


public record PerformTransactionInputDTO(UUID payerWalletId, UUID payeeWalletId, BigDecimal value) {
  
}

