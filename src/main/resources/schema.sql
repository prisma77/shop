CREATE TABLE IF NOT EXISTS product (
                                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                       name VARCHAR(100) NOT NULL,
    price INT NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    description VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS cart (
                                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                    session_id VARCHAR(100) NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    unit_price INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_cart_product FOREIGN KEY (product_id) REFERENCES product(id)
    );
CREATE INDEX idx_cart_session ON cart(session_id);

