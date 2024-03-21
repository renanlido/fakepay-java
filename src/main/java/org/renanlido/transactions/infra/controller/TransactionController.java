package org.renanlido.transactions.infra.controller;

import org.renanlido.transactions.application.dtos.CreateTransactionInputDTO;
import org.renanlido.transactions.application.useCases.PerformTransactionUseCase;
import org.renanlido.transactions.application.useCases.exceptions.TransactionsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {

  private final PerformTransactionUseCase performTransactionUseCase;


  public TransactionController(PerformTransactionUseCase performTransactionUseCase) {
    this.performTransactionUseCase = performTransactionUseCase;
  }

  @PostMapping
  public ResponseEntity<String> performTransaction(@RequestBody CreateTransactionInputDTO input) {
    var transaction = performTransactionUseCase.execute(input);

    if (transaction.isLeft()) {

      TransactionsException exception = transaction.getValue();

      return ResponseEntity.status(exception.errorType().code()).body(exception.message());
    }

    return ResponseEntity.noContent().build();
  }
}
