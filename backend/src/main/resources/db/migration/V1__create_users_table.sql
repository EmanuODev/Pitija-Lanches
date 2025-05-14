CREATE TABLE users (

       id BIGINT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(50) NOT NULL,
       email VARCHAR(255) NOT NULL,
       password VARCHAR(255) NOT NULL,
       phone VARCHAR(20) NOT NULL,
       role VARCHAR(6) NOT NULL,
       createdAt DATETIME,
       updatedAt DATETIME

);