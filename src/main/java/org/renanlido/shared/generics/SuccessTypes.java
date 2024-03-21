package org.renanlido.shared.generics;

public enum SuccessTypes {

  OK(200),
  CREATED(201),
  ACCEPTED(202),
  NO_CONTENT(204);
  private final int _code;

  SuccessTypes(int code) {
    this._code = code;
  }

  public int code() {
    return _code;
  }
}
