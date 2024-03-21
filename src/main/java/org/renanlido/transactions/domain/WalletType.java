package org.renanlido.transactions.domain;

public enum WalletType {
  CONSUMER(1), MERCHANT(2);

  private final int value;

  WalletType(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
