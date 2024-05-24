# brief message

```
host $ docker build -t my-ubuntu/mysql .
host $ docker run -d --name my-ubuntu-mysql -p 3306:3306 -t my-ubuntu/mysql
host $ docker exec -it my-ubuntu-mysql /bin/bash
```
