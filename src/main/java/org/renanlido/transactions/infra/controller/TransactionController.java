package org.renanlido.transactions.infra.controller;

import org.renanlido.transactions.application.dtos.PerformTransactionInputDTO;
import org.renanlido.transactions.application.useCases.PerformTransactionUseCase;
import org.renanlido.transactions.application.useCases.exceptions.TransactionsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("transactions")
public class TransactionController {

  private final PerformTransactionUseCase performTransactionUseCase;


  public TransactionController(PerformTransactionUseCase performTransactionUseCase) {
    this.performTransactionUseCase = performTransactionUseCase;
  }

  @GetMapping
  public String hello() {
    return "Hello World!";
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
