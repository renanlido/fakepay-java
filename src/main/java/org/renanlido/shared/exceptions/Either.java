package org.renanlido.shared.exceptions;

public abstract class Either<L, R> {

  public static <L, R> Either<L, R> left(L value) {
    return new Left<>(value);
  }

  public static <L, R> Either<L, R> right(R value) {
    return new Right<>(value);
  }


  public Boolean isLeft() {
    return this instanceof Left;
  }

  public Boolean isRight() {
    return this instanceof Right;
  }


  public abstract <T> T getValue();

}

