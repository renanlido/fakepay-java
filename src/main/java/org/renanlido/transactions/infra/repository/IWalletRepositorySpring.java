package org.renanlido.transactions.infra.repository;

import org.renanlido.transactions.infra.record.WalletRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IWalletRepositorySpring extends CrudRepository<WalletRecord, UUID> {
}
