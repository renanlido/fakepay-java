package org.renanlido.transactions.infra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(schema = "public", name = "wallet")
public class WalletModel {

  @Id()
  @Column(name = "id")
  private UUID _id;
  @Column(name = "full_name")

  private String _fullName;
  @Column(name = "email")

  private String _email;
  @Column(name = "password")
  private String _password;
  @Column(name = "cpf")
  private Long _cpf;
  @Column(name = "type")
  private Integer _type;

  @Column(name = "balance")
  private BigDecimal _balance;

  public WalletModel() {
  }

  public WalletModel(UUID id, String fullName, String email, String password, Long cpf, Integer type, BigDecimal balance) {
    this._id = id;
    this._fullName = fullName;
    this._email = email;
    this._password = password;
    this._cpf = cpf;
    this._type = type;
    this._balance = balance;
  }

  public UUID id() {
    return _id;
  }

  public void setId(UUID id) {
    this._id = id;
  }

  public String fullName() {
    return _fullName;
  }

  public void setFullName(String fullName) {
    this._fullName = fullName;
  }

  public String email() {
    return _email;
  }

  public void setEmail(String email) {
    this._email = email;
  }

  public String password() {
    return _password;
  }

  public void setPassword(String password) {
    this._password = password;
  }

  public Long cpf() {
    return _cpf;
  }

  public void setCpf(Long cpf) {
    this._cpf = cpf;
  }

  public Integer type() {
    return _type;
  }

  public void setType(Integer type) {
    this._type = type;
  }

  public BigDecimal balance() {
    return _balance;
  }

  public void setBalance(BigDecimal balance) {
    this._balance = balance;
  }
}
