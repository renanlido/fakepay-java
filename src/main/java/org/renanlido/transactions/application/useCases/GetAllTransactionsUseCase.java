package org.renanlido.transactions.application.useCases;

import org.renanlido.shared.exceptions.Either;
import org.renanlido.transactions.application.useCases.exceptions.TransactionsException;
import org.renanlido.transactions.domain.Transaction;
import org.renanlido.transactions.domain.repository.ITransactionRepository;
import org.renanlido.transactions.domain.repository.IWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllTransactionsUseCase {
  private final @Qualifier("TransactionRepository") ITransactionRepository transactionRepository;

  @Autowired
  public GetAllTransactionsUseCase(ITransactionRepository transactionRepository, IWalletRepository walletRepository) {
    this.transactionRepository = transactionRepository;
  }

  public Either<TransactionsException, List<Transaction>> execute() {
    var transactions = transactionRepository.findAll();

    return Either.right(transactions);
  }

}
