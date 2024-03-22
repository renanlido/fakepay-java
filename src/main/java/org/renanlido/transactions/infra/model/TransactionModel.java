package org.renanlido.transactions.infra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(schema = "public", name = "transaction")
public class TransactionModel {

  @Id()
  @Column(name = "id")
  private UUID _id;
  @Column(name = "payer_id")
  private UUID _payerId;
  @Column(name = "payee_id")
  private UUID _payeeId;
  @Column(name = "value")
  private BigDecimal _value;
  @Column(name = "created_at")
  private LocalDateTime _createdAt;


  public TransactionModel() {
  }

  public TransactionModel(UUID id, UUID payerId, UUID payeeId, BigDecimal value, LocalDateTime createdAt) {
    this._id = id;
    this._payerId = payerId;
    this._payeeId = payeeId;
    this._value = value;
    this._createdAt = createdAt;
  }

  public UUID id() {
    return _id;
  }

  public void setId(UUID id) {
    this._id = id;
  }

  public UUID payerId() {
    return _payerId;
  }

  public void setPayerId(UUID payerId) {
    this._payerId = payerId;
  }

  public UUID payeeId() {
    return _payeeId;
  }

  public void setPayeeId(UUID payeeId) {
    this._payeeId = payeeId;
  }

  public BigDecimal value() {
    return _value;
  }

  public void setValue(BigDecimal value) {
    this._value = value;
  }

  public LocalDateTime createdAt() {
    return _createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this._createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "TransactionModel{" +
        "id=" + _id +
        ", payerId=" + _payerId +
        ", payeeId=" + _payeeId +
        ", value=" + _value +
        ", createdAt=" + _createdAt +
        '}';
  }
}
