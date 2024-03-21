package org.renanlido.transactions.domain.repository;

import org.renanlido.transactions.domain.Transaction;

import java.util.UUID;

public interface ITransactionRepository {
  void save(Transaction transaction);

  Transaction findById(UUID id);

  Transaction[] findAll();

}
