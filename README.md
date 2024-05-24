# sboot-study
Repository for studying Spring Boot.

## How to set up the environment coding the app on Spring Boot.
```
$ sudo apt update
$ sudo apt upgrade
$ sudo apt install openjdk-21-jdk-headless
$ sudo apt install maven
$ sudo apt install git curl net-tools

$ git clone https://github.com/kon104/sboot-study.git

$ cd sboot-study/
$ mvn spring-boot:run
```

## How to set up My SQL Server.

Log in to the Docker container and create the environment by following steps.

```
quest $ sudo apt install mysql-server-8.0
guest $ sudo vim /etc/mysql/mysql.conf.d/mysqld.cnf
  -	bind-address        = 127.0.0.1
  +	# bind-address        = 127.0.0.1

guest $ sudo service mysql start
guest $ sudo mysql -u root

CREATE DATABASE springbootdb;
USE springbootdb;
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
If you create the environment by steps above, you can access from the host os to mysql server on the Docker container by a command below.
```
host $ mysql -u hoge -p -h 127.0.0.1
```

