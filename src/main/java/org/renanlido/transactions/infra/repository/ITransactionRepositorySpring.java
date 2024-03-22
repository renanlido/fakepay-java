package org.renanlido.transactions.infra.repository;

import org.renanlido.transactions.infra.model.TransactionModel;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface ITransactionRepositorySpring extends ListCrudRepository<TransactionModel, UUID> {
}
