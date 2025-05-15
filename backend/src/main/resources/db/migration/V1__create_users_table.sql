CREATE TABLE users (

       id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(50) NOT NULL,
       email VARCHAR(255) NOT NULL,
       password VARCHAR(255) NOT NULL,
       phone VARCHAR(20) NOT NULL,
       role VARCHAR(6) NOT NULL,
       created_at DATETIME,
       updated_at DATETIME

);