CREATE TABLE IF NOT EXISTS WALLETS
(
    id        uuid PRIMARY KEY NOT NULL UNIQUE,
    fullName  VARCHAR(100)     NOT NULL,
    email     VARCHAR(20)      NOT NULL UNIQUE,
    password  VARCHAR(20)      NOT NULL,
    cpf       VARCHAR(11)      NOT NULL UNIQUE,
    type      INT              NOT NULL,
    balance   DECIMAL(10, 2)   NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    version   BIGINT
);

CREATE UNIQUE INDEX IF NOT EXISTS cpf_index ON WALLETS (cpf);

CREATE UNIQUE INDEX IF NOT EXISTS email_index ON WALLETS (email);

CREATE TABLE IF NOT EXISTS TRANSACTIONS
(
    id        uuid PRIMARY KEY NOT NULL UNIQUE,
    payerId   uuid             NOT NULL,
    payeeId   uuid             NOT NULL,
    value     DECIMAL(10, 2)   NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (payerId) REFERENCES WALLETS (id),
    FOREIGN KEY (payeeId) REFERENCES WALLETS (id)
);

