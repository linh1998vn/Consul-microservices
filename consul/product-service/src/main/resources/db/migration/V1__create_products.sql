CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(160) NOT NULL,
    price NUMERIC(12, 2) NOT NULL CHECK (price > 0)
);

INSERT INTO products (name, price) VALUES
    ('Mechanical Keyboard', 89.99),
    ('USB-C Dock', 129.50),
    ('Noise Cancelling Headphones', 219.00);
