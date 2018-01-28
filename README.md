# Spring Boot/MySql/JPA/REST/Docker
This is a base repository for all my JPA related work

### How to run the App
#### MySQL docker container
* Start MySQL docker container<br>
    `docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -d mysql:5.6`
    <br>where mysql-standalone is my container name, password is my password for root used of mysql <br>
    and mysql:5.6 is image name : tag.
* Once container starts, please verify using following commands <br>
`docker container ls` <br>
`docker logs mysql-standalone` <br>
* (Optional) You can connect to container using MySql client container image as follows: <br>
`docker run -it --link mysql-standalone:mysql --rm mysql sh -c 'exec mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P"$MYSQL_PORT_3306_TCP_PORT" -uroot -p"$MYSQL
 _ENV_MYSQL_ROOT_PASSWORD"'` <br>

#### Build project
* Build project using following commands<br>
`git clone https://github.com/beercafeguy/spring-boot-mysql.git` <br>
`cd <project base dir>` <br>
`mvn clen install`<br>
 If you want to test the project in local, provide the details of a working mysql instance in application.properties and run following command after build. <br>
`mvn spring-boot:run`

* Build docker image<br>
`docker build -t boot_mysql_app:V1 --build-arg JAR_FILE=target/spring-boot-mysql-0.0.1-SNAPSHOT.jar .`<br>
* Login to hub and register the image to docker hub<br>
`docker login` <br>
`docker tag <image id> beercafeguy/boot_mysql_app:V1` <br>
`docker push beercafeguy/boot_mysql_app:V1`<br>

#### Run the app
* Start the container using image we just created <br>
`docker run --name boot_mysql_app -p 8087:8087 --link mysql-standalone:mysql -d beercafeguy/boot_mysql_app:V1`

* Verify the app on following url <br>
[http://localhost:8087/api/users](http://localhost:8087/api/users)     

* Initially this app won't have any user so use any REST client like POSTMAN 
to push some data using POST API.

#### APIs implemented
GET     `/api/users`    To get list of users<br>
POST    `/api/users`    Create a new USER<br>
PUT     `/api/users/{id}`   Update User<br>
DELETE  `/api/users/{id}`   Delete User<br>


