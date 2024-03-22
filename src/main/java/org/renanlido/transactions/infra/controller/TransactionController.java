package org.renanlido.transactions.infra.controller;

import org.renanlido.transactions.application.dtos.PerformTransactionInputDTO;
import org.renanlido.transactions.application.useCases.GetAllTransactionsUseCase;
import org.renanlido.transactions.application.useCases.PerformTransactionUseCase;
import org.renanlido.transactions.application.useCases.exceptions.TransactionsException;
import org.renanlido.transactions.domain.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("transactions")
public class TransactionController {

  private final PerformTransactionUseCase performTransactionUseCase;
  private final GetAllTransactionsUseCase getAll;

  public TransactionController(PerformTransactionUseCase performTransactionUseCase, GetAllTransactionsUseCase getAll) {
    this.performTransactionUseCase = performTransactionUseCase;
    this.getAll = getAll;
  }

  @GetMapping()
  public ResponseEntity<List<Transaction>> hello() {
    var transactions = getAll.execute();


    return ResponseEntity.ok(transactions.getValue());
  }

  @PostMapping
  public ResponseEntity<String> performTransaction(@RequestBody PerformTransactionInputDTO input) {
    var transaction = performTransactionUseCase.execute(input);

    if (transaction.isLeft()) {

      TransactionsException exception = transaction.getValue();

      return ResponseEntity.status(exception.errorType().code()).body(exception.message());
    }

    return ResponseEntity.noContent().build();
  }
}
