package org.renanlido.transactions.application.useCases;

import org.renanlido.shared.exceptions.Either;
import org.renanlido.shared.exceptions.ExceptionTypes;
import org.renanlido.transactions.application.dtos.PerformTransactionInputDTO;
import org.renanlido.transactions.application.useCases.exceptions.TransactionsException;
import org.renanlido.transactions.domain.Transaction;
import org.renanlido.transactions.domain.repository.ITransactionRepository;
import org.renanlido.transactions.domain.repository.IWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PerformTransactionUseCase {
  private final @Qualifier("TransactionRepository") ITransactionRepository transactionRepository;
  private final @Qualifier("WalletRepository") IWalletRepository walletRepository;

  @Autowired
  public PerformTransactionUseCase(ITransactionRepository transactionRepository, IWalletRepository walletRepository) {
    this.transactionRepository = transactionRepository;
    this.walletRepository = walletRepository;
  }

  public Either<TransactionsException, Void> execute(PerformTransactionInputDTO input) {
    var payerWallet = walletRepository.findById(input.payerWalletId());
    var payeeWallet = walletRepository.findById(input.payeeWalletId());

    if (input.payerWalletId() == input.payeeWalletId()) {
      return Either.left(new TransactionsException(ExceptionTypes.INVALID_ARGUMENT, "Payer and payee cannot be the same"));
    }

    if (payeeWallet == null) {
      return Either.left(new TransactionsException(ExceptionTypes.NOT_FOUND, "Payee wallet not found"));
    }

    if (payerWallet == null) {
      return Either.left(new TransactionsException(ExceptionTypes.NOT_FOUND, "Payer wallet not found"));
    }


    if (payerWallet.withdraw(input.value()).isLeft()) {
      return Either.left(new TransactionsException(ExceptionTypes.INVALID_ARGUMENT, "Insufficient funds"));
    }

    payeeWallet.deposit(input.value());

    transactionRepository.create(new Transaction(null, input.payerWalletId(), input.payeeWalletId(), input.value(), null));

    walletRepository.save(payerWallet);
    walletRepository.save(payeeWallet);

    return Either.right(null);
  }

}
