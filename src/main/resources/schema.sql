DROP TABLE IF EXISTS products;

CREATE TABLE products (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          category VARCHAR(255) NOT NULL,
                          photo_url VARCHAR(255),
                          description TEXT,
                          price DECIMAL(10, 2) NOT NULL
);
