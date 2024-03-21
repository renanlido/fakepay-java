package org.renanlido.transactions.infra.record;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.UUID;

@Table("wallet")
public record WalletRecord(
    @Id UUID id, @Column("full_name") String fullName, String email, String password, Long cpf, @NonNull Integer type,
    BigDecimal balance) {

}
