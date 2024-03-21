package org.renanlido.transactions.infra.repository;

import org.renanlido.transactions.domain.Wallet;
import org.renanlido.transactions.domain.repository.IWalletRepository;
import org.renanlido.transactions.infra.record.WalletRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Repository
public class WalletRepository implements IWalletRepository {
  private final IWalletRepositorySpring repositorySpring;

  @Autowired
  public WalletRepository(IWalletRepositorySpring repositorySpring) {
    this.repositorySpring = repositorySpring;
  }


  @Override
  public void save(Wallet transaction) {
    WalletRecord record = new WalletRecord(
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
    WalletRecord record = repositorySpring.findById(id).orElse(null);

    if (record == null) {
      return null;
    }

    return new Wallet(
        record.id(),
        record.fullName(),
        record.email(),
        record.password(),
        record.cpf(),
        record.type(),
        record.balance()
    );
  }

  @Override
  public Wallet[] findAll() {
    Iterator<WalletRecord> iterator = repositorySpring.findAll().iterator();
    Stream<WalletRecord> stream = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false);


    return stream.map(record -> new Wallet(
        record.id(),
        record.fullName(),
        record.email(),
        record.password(),
        record.cpf(),
        record.type(),
        record.balance()
    )).toArray(Wallet[]::new);
  }
}
