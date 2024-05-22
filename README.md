# sboot-study
Repository for studying Spring Boot.

## How to set up the environment coding the app on Spring Boot.
```
$ sudo apt update
$ sudo apt upgrade
$ sudo apt install openjdk-11-jdk-headless
$ sudo apt install maven

$ git clone https://github.com/kon104/sboot-study.git

$ cd sboot-study/
$ mvn spring-boot:run
```

## How to set up My SQL Server.
```
$ sudo apt install mysql-server-8.0
$ sudo vim /etc/mysql/mysql.conf.d/mysqld.cnf
  -	bind-address        = 127.0.0.1
  +	# bind-address        = 127.0.0.1

$ sudo service mysql start
$ sudo mysql -u root

CREATE DATABASE springbootdb;
CREATE TABLE accounts (
  uid INT(11) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(64),
  password VARCHAR(64)
);
INSERT INTO accounts (name,password) VALUES ('Mike','pw1');
INSERT INTO accounts (name,password) VALUES ('Nancy','pw2');
CREATE USER hoge IDENTIFIED BY 'password';
GRANT select ON springbootdb.* TO 'hoge'@'%';
```



