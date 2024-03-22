package org.renanlido.transactions.infra.repository;

import org.renanlido.transactions.infra.model.WalletModel;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface IWalletRepositorySpring extends ListCrudRepository<WalletModel, UUID> {
}
