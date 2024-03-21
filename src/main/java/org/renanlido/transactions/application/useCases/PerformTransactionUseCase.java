package org.renanlido.transactions.application.useCases;

import org.renanlido.shared.exceptions.Either;
import org.renanlido.shared.exceptions.ExceptionTypes;
import org.renanlido.transactions.application.dtos.CreateTransactionInputDTO;
import org.renanlido.transactions.application.useCases.exceptions.TransactionsException;
import org.renanlido.transactions.domain.Transaction;
import org.renanlido.transactions.domain.repository.ITransactionRepository;
import org.renanlido.transactions.domain.repository.IWalletRepository;
import org.springframework.stereotype.Service;

@Service
public class PerformTransactionUseCase {
  private final ITransactionRepository transactionRepository;
  private final IWalletRepository walletRepository;

  public PerformTransactionUseCase(ITransactionRepository transactionRepository, IWalletRepository walletRepository) {
    this.transactionRepository = transactionRepository;
    this.walletRepository = walletRepository;
  }

  public Either<TransactionsException, Void> execute(CreateTransactionInputDTO input) {
    var payerWallet = walletRepository.findById(input.payerId());
    var payeeWallet = walletRepository.findById(input.payeeId());

    if (input.payerId() == input.payeeId()) {
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

    var transaction = new Transaction(null, input.payerId(), input.payeeId(), input.value(), null);

    transactionRepository.save(transaction);

    walletRepository.save(payerWallet);
    walletRepository.save(payeeWallet);

    return Either.right(null);
  }

}
