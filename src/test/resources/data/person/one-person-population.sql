CREATE TABLE person (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(150) NOT NULL,
                        customer_id BIGINT NOT NULL,
                        birth_date DATE,
                        register_date TIMESTAMP,
                        removed BOOLEAN
);

INSERT INTO person (name, customer_id, birth_date, register_date, removed)
VALUES (
'Maria Silva',
2,
    DATE '1985-10-20',
    TIMESTAMP '2026-02-11 09:15:00',
    TRUE
);

