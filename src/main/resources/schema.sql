DROP TABLE IF EXISTS TRANSACTION;
DROP TABLE IF EXISTS WALLET;

CREATE TABLE IF NOT EXISTS WALLET
(
    id          uuid PRIMARY KEY NOT NULL UNIQUE,
    "full_name" VARCHAR(100)     NOT NULL,
    email       VARCHAR(20)      NOT NULL UNIQUE,
    password    VARCHAR(20)      NOT NULL,
    cpf         VARCHAR(11)      NOT NULL UNIQUE,
    type        INT              NOT NULL,
    balance     DECIMAL(10, 2)   NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    version     BIGINT
);

CREATE UNIQUE INDEX IF NOT EXISTS cpf_index ON WALLET (cpf);

CREATE UNIQUE INDEX IF NOT EXISTS email_index ON WALLET (email);

CREATE TABLE IF NOT EXISTS TRANSACTION
(
    id         uuid PRIMARY KEY NOT NULL UNIQUE,
    payer_id   uuid             NOT NULL,
    payee_id   uuid             NOT NULL,
    value      DECIMAL(10, 2)   NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (payer_id) REFERENCES WALLET (id),
    FOREIGN KEY (payee_id) REFERENCES WALLET (id)
);

