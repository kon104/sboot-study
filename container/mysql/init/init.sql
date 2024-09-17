CREATE DATABASE IF NOT EXISTS springbootdb;
USE springbootdb;

CREATE TABLE account (
  uid INT(11) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(64),
  age INT(11),
  address VARCHAR(64)
);

INSERT INTO account (name, age, address) VALUES ('Mike', 18, 'tokyo');
INSERT INTO account (name, age, address) VALUES ('Nancy', 25, 'kanagawa');

CREATE USER hoge IDENTIFIED BY 'password';
GRANT select,insert,update,delete ON springbootdb.* TO 'hoge'@'%';
