package org.renanlido.transactions.application.useCases.exceptions;

import org.renanlido.shared.exceptions.ExceptionTypes;
import org.renanlido.shared.exceptions.IExceptionResponse;

public class TransactionsException extends Exception implements IExceptionResponse {

  private final ExceptionTypes errorType;
  private final String message;

  public TransactionsException(ExceptionTypes errorType, String message) {
    super(message);

    this.errorType = errorType;
    this.message = message;
  }


  @Override
  public ExceptionTypes errorType() {
    return this.errorType;
  }

  @Override
  public String message() {
    return this.message;
  }
}
