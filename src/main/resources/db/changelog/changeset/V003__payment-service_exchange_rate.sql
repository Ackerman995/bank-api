CREATE TABLE exchange_rate (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    from_currency VARCHAR(8) NOT NULL,
    to_currency VARCHAR(8) NOT NULL,
    exchange_date TIMESTAMP NOT NULL,
    close_rate DECIMAL(20, 10) NOT NULL,
    previous_close_rate DECIMAL(20, 10) NOT NULL
);