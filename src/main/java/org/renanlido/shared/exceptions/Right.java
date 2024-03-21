package org.renanlido.shared.exceptions;

public class Right<L, R> extends Either<L, R> {
  private final R value;

  public Right(R value) {
    this.value = value;
  }

  public Boolean isLeft() {
    return false;
  }

  public Boolean isRight() {
    return true;
  }

  @Override
  public R getValue() {
    return this.value;
  }
}
