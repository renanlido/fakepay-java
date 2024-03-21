package org.renanlido.shared.exceptions;

public enum ExceptionTypes {

  NOT_FOUND(404),
  INVALID_ARGUMENT(400),
  UNAUTHORIZED(401),
  INTERNAL(500);
  private final int _code;

  ExceptionTypes(int code) {
    this._code = code;
  }

  public int code() {
    return _code;
  }
}


