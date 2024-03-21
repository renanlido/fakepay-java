package org.renanlido.transactions.infra.repository;

import org.renanlido.transactions.domain.Transaction;
import org.renanlido.transactions.domain.repository.ITransactionRepository;
import org.renanlido.transactions.infra.record.TransactionRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.UUID;

@Repository
public class TransactionRepository implements ITransactionRepository {
  private final ITransactionRepositorySpring repositorySpringData;

  @Autowired
  public TransactionRepository(ITransactionRepositorySpring repositorySpringData) {
    this.repositorySpringData = repositorySpringData;
  }


  @Override
  public void save(Transaction transaction) {
    TransactionRecord record = new TransactionRecord(transaction.getId(), transaction.getPayerId(), transaction.getPayerId(), transaction.getValue(), transaction.getCreatedAt());

    repositorySpringData.save(record);
  }

  @Override
  public Transaction findById(UUID id) {
    TransactionRecord record = repositorySpringData.findById(id).orElse(null);

    if (record == null) {
      return null;
    }

    return new Transaction(record.id(), record.payerId(), record.payerId(), record.value(), record.createdAt());
  }

  @Override
  public Transaction[] findAll() {
    TransactionRecord[] records = repositorySpringData.findAll().toArray(new TransactionRecord[0]);


    return Arrays.stream(records).map(record -> new Transaction(record.id(), record.payerId(), record.payerId(), record.value(), record.createdAt())).toArray(Transaction[]::new);
  }
}
