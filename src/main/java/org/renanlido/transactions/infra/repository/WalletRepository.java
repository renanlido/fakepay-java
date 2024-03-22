package org.renanlido.transactions.infra.repository;

import org.jetbrains.annotations.NotNull;
import org.renanlido.transactions.domain.Wallet;
import org.renanlido.transactions.domain.WalletType;
import org.renanlido.transactions.domain.repository.IWalletRepository;
import org.renanlido.transactions.infra.model.WalletModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("WalletRepository")
public class WalletRepository implements IWalletRepository {
  private final IWalletRepositorySpring repositorySpring;

  @Autowired
  public WalletRepository(IWalletRepositorySpring repositorySpring) {
    this.repositorySpring = repositorySpring;
  }


  @Override
  public void save(@NotNull Wallet transaction) {
    WalletModel record = new WalletModel(
        transaction.getId(),
        transaction.getFullName(),
        transaction.getEmail(),
        transaction.getPassword(),
        transaction.getCpf(),
        transaction.getType(),
        transaction.getBalance()
    );

    repositorySpring.save(record);
  }

  @Override
  public Wallet findById(UUID id) {
    WalletModel record = repositorySpring.findById(id).orElse(null);

    if (record == null) {
      return null;
    }

    return new Wallet(
        record.id(),
        record.fullName(),
        record.email(),
        record.password(),
        record.cpf(),
        WalletType.getById(record.type()),
        record.balance()
    );
  }

  @Override
  public Wallet[] findAll() {
    List<WalletModel> models = repositorySpring.findAll();


    List<Wallet> list = new ArrayList<>();

    for (WalletModel model : models) {
      Wallet wallet = new Wallet(
          model.id(),
          model.fullName(),
          model.email(),
          model.password(),
          model.cpf(),
          WalletType.getById(model.type()),
          model.balance()
      );
      list.add(wallet);
    }
    
    return list.toArray(new Wallet[0]);
  }
}
