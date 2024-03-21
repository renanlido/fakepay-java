package org.renanlido.transactions.domain;

public enum WalletType {
  CONSUMER(1), MERCHANT(2);

  private final int value;

  WalletType(int value) {
    this.value = value;
  }

  public static WalletType getById(int id) {
    for (WalletType e : values()) {
      if (e.value == id) {
        return e;
      }
    }
    throw new IllegalArgumentException("Invalid WalletType id: " + id);
  }
  public int getValue() {
    return value;
  }
}
