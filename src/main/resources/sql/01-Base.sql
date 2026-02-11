CREATE TABLE person (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(150) NOT NULL,
                        customer_id BIGINT NOT NULL,
                        birth_date DATE,
                        register_date TIMESTAMP,
                        removed BOOLEAN
);

INSERT INTO person
(id, customer_id, "name", birth_date, register_date, removed)
VALUES
    (1, 1, 'Lucas Favaro', '1990-05-12', '2026-02-11 08:30:00.000', true),
    (2, 1, 'Maria Silva', '1985-10-20', '2026-02-11 09:15:00.000', true),
    (3, 2, 'João Pereira', '2000-01-01', '2026-02-11 10:00:00.000', false);
