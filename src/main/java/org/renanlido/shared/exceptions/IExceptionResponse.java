package org.renanlido.shared.exceptions;

public interface IExceptionResponse {
  ExceptionTypes errorType();

  String message();
}

