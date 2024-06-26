# sboot-study
Repository for studying Spring Boot.

## How to set up the environment coding the app on Spring Boot.
```
$ sudo apt update
$ sudo apt upgrade -y
$ sudo apt install -y openjdk-21-jdk-headless
$ sudo apt install -y maven
$ sudo apt install -y vim git curl net-tools iputils-ping lsb-release

$ git clone https://github.com/kon104/sboot-study.git

$ cd sboot-study/
$ mvn spring-boot:run
```

## How to set up My SQL Server.

At first, create the Docker container to run MySQL Server.
```
host $ docker pull ubuntu
host $ docker run -d --name my-ubuntu-mysql -p 3306:3306 -t ubuntu
```

Log in to the Docker container where you want to run MySQL Server, and create the environment using following steps.

```
host $ docker exec -it my-ubuntu-mysql /bin/bash

guest $ sudo apt update
guest $ sudo apt upgrade -y
guest $ sudo apt install -y vim git curl net-tools iputils-ping lsb-release
quest $ sudo apt install -y mysql-server-8.0
guest $ sudo vim /etc/mysql/mysql.conf.d/mysqld.cnf
  -	bind-address        = 127.0.0.1
  +	# bind-address        = 127.0.0.1

guest $ sudo service mysql start
guest $ sudo mysql -u root
```
```
CREATE DATABASE springbootdb;
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
```

If you create the environment by steps above, you can access from the Host OS to MySQL Server on the Docker container using a command below.
```
host $ mysql -u hoge -p -h 127.0.0.1
```

If you restart the Docker container, you have to start the process of MySQL Server because it was stopped when the Docker container stopped.
```
host $ docker stop my-ubuntu-mysql
host $ docker start my-ubuntu-mysql
host $ docker exec -it my-ubuntu-mysql /bin/bash
guest $ sudo service mysql start
```
