CREATE TABLE products (

      id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(50) NOT NULL,
      description VARCHAR(255),
      image_url VARCHAR(255) NOT NULL,
      category VARCHAR(15) NOT NULL,
      price DECIMAL(10,2) NOT NULL,
      stock INT NOT NULL,
      created_at DATETIME,
      updated_at DATETIME

);