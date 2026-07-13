CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    product_id BIGINT NOT NULL,
    product_name VARCHAR(160) NOT NULL,
    quantity INTEGER NOT NULL CHECK (quantity > 0),
    unit_price NUMERIC(12, 2) NOT NULL CHECK (unit_price > 0),
    total NUMERIC(12, 2) NOT NULL CHECK (total > 0),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL
);
