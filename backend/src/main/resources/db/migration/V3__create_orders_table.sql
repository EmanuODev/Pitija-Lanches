CREATE TABLE orders (

    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNSIGNED NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    payment_method VARCHAR(10) NOT NULL,
    created_at DATETIME,
    updated_at DATETIME,

    FOREIGN KEY (user_id) REFERENCES users (id)

);