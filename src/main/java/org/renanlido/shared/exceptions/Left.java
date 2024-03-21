package org.renanlido.shared.exceptions;

public class Left<L, R> extends Either<L, R> {
  private final L value;

  public Left(L value) {
    this.value = value;
  }

  public Boolean isLeft() {
    return true;
  }

  public Boolean isRight() {
    return false;
  }

  @Override
  public L getValue() {
    return this.value;
  }

}

