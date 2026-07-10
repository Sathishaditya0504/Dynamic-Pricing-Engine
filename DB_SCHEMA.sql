CRATE TABLE product (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(100) NOT NULL,
      base_price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE pricing_rule(
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     type VARCHAR (50) NOT NULL,
     rule_value DECIMAL(10, 2) NOT NULL,
     condition_text VARCHAR(200) NOT NULL

);

CREATE TABLE dynamic_price (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     product_id BIGINT NOT NULL,
     final_price DECIMAL(10, 2) NOT NULL,
     timestamp TIMESTAMP NOT NULL,
     CONSTRAINT fk_dynamic_price_product
               FOREIGN KEY (product_id)
               REFERENCES product(id)
);