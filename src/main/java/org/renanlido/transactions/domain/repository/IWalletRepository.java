package org.renanlido.transactions.domain.repository;

import jakarta.annotation.Nullable;
import org.renanlido.transactions.domain.Wallet;

import java.util.UUID;

public interface IWalletRepository {
  void save(Wallet transaction);

  @Nullable
  Wallet findById(UUID id);

  Wallet[] findAll();

}
