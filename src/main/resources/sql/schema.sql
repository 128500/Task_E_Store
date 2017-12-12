--create tables
CREATE TABLE PRODUCTS (
  product_id SERIAL4,
  manufacturer VARCHAR(50),
  category VARCHAR(50),
  name VARCHAR(50),
  code BIGINT,
  price VARCHAR(30),
  description TEXT,
  flag BOOLEAN,
  PRIMARY KEY (product_id)
);

CREATE TABLE CATEGORIES (
  category_id SERIAL4,
  name VARCHAR(50),
  PRIMARY KEY (category_id)
);

CREATE TABLE MANUFACTURERS (
  m_id SERIAL4,
  name VARCHAR(50),
  PRIMARY KEY (m_id)
);