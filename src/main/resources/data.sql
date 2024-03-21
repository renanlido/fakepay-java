DELETE
FROM transaction
WHERE 1 = 1;

DELETE
FROM wallet
WHERE 1 = 1;

INSERT INTO wallet (id, "full_name", email, password, cpf, type, balance, version)
VALUES ('01289712-b265-4854-bf2c-81ba2dfa2d20', 'John Doe', 'jhondoe@emai.com', '123456', '12345678901', 1, 1000, 1),
       ('932719f2-6e93-42bf-a8d5-fd826be6a321', 'Jane Kine', 'janekine@gmail.com', '123456', '12345678902', 2, 1000, 1)
