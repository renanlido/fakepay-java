package org.renanlido.transactions.infra.record;

import org.renanlido.transactions.domain.WalletType;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Table("wallets")
public record WalletRecord(
    UUID id, String fullName, String email, String password, Long cpf, WalletType type, BigDecimal balance) {

}
