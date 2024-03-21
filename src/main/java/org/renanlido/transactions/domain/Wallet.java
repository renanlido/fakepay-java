package org.renanlido.transactions.domain;

import jakarta.annotation.Nullable;
import org.renanlido.shared.exceptions.Either;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public class Wallet {
  private final UUID id;
  private final String fullName;
  private final String email;
  private final String password;
  private final Long cpf;

  private final WalletType type;
  private BigDecimal balance;

  public Wallet(@Nullable UUID id, String fullName, String email, String password, Long cpf, WalletType type, BigDecimal balance) {
    this.id = Optional.ofNullable(id).orElse(UUID.randomUUID());
    this.fullName = fullName;
    this.email = email;
    this.password = password;
    this.cpf = cpf;
    this.type = type;
    this.balance = balance;
  }

  public UUID getId() {
    return this.id;
  }

  public String getFullName() {
    return this.fullName;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPassword() {
    return this.password;
  }

  public Long getCpf() {
    return this.cpf;
  }

  public WalletType getType() {
    return this.type;
  }

  public BigDecimal getBalance() {
    return this.balance;
  }

  private boolean hasBalance(BigDecimal value) {
    return this.balance.compareTo(value) >= 0;
  }

  public void deposit(BigDecimal value) {
    balance = this.balance.add(value);
  }

  public Either<Void, Void> withdraw(BigDecimal value) {
    if (!hasBalance(value)) {
      return Either.left(null);
    }

    balance = this.balance.subtract(value);

    return Either.right(null);
  }
}
