package org.renanlido.transactions.infra.repository;

import org.renanlido.transactions.infra.record.TransactionRecord;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface ITransactionRepositorySpring extends ListCrudRepository<TransactionRecord, UUID> {
}
