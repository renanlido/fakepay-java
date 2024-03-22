package org.renanlido.transactions.infra.repository;

import org.jetbrains.annotations.NotNull;
import org.renanlido.transactions.domain.Transaction;
import org.renanlido.transactions.domain.repository.ITransactionRepository;
import org.renanlido.transactions.infra.model.TransactionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("TransactionRepository")
public class TransactionRepository implements ITransactionRepository {
  private final ITransactionRepositorySpring repositorySpringData;

  @Autowired
  public TransactionRepository(ITransactionRepositorySpring repositorySpringData) {
    this.repositorySpringData = repositorySpringData;
  }

  public void create(@NotNull Transaction transaction) {
    try {


      TransactionModel model = new TransactionModel(transaction.getId(), transaction.getPayerId(), transaction.getPayeeId(), transaction.getValue(), transaction.getCreatedAt());


      repositorySpringData.save(model);
    } catch (Exception e) {
      throw new RuntimeException("Error creating transaction", e);
    }
  }

  @Override
  public Transaction findById(UUID id) {
    TransactionModel record = repositorySpringData.findById(id).orElse(null);

    if (record == null) {
      return null;
    }

    return new Transaction(record.id(), record.payerId(), record.payerId(), record.value(), record.createdAt());
  }

  @Override
  public List<Transaction> findAll() {
    List<TransactionModel> models = repositorySpringData.findAll();

    return models.stream().map(model -> new Transaction(model.id(), model.payerId(), model.payerId(), model.value(), model.createdAt())).toList();
  }
}
