package org.renanlido.transactions.domain.repository;

import org.renanlido.transactions.domain.Transaction;

import java.util.List;
import java.util.UUID;

public interface ITransactionRepository {
  void create(Transaction transaction);

  Transaction findById(UUID id);

  List<Transaction> findAll();

}
