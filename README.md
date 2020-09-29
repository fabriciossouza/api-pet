# Documentacao

##### Tecnologias/ferramentas utilizadas
- Java 8
- Maven 
- Spring boot
- Spring Data Rest
- Swagger
- Docker

##### Como executar os testes:
```console
$ cd api-pet/
$ mvn clean test
```

OBS: Os Testes usam o banco h2 mockado.

##### Subindo a aplicação local apontando para o banco Local (H2).
```console
$ mvn clean install
$ cd target/
$ java -jar *.jar
```


##### Subindo a aplicação local com profile Production apontando para o banco Mysql
```console
$ cd api-pet/
$ docker rm -f api-database; docker run --name api-database -p 3306:3306 -v ${PWD}/scripts/schema.sql:/docker-entrypoint-initdb.d/schema.sql -e MYSQL_ROOT_PASSWORD=root123 -e MYSQL_DATABASE=api-pet mysql:5.7
$ mvn clean install
$ cd target/
$ java -jar -Dspring.profiles.active=production *.jar
```

##### Subindo a aplicação em um container docker.
```console
$ mvn clean package
$ bash build.sh
$ bash run.sh
$ docker logs -f api-pet
```

##### Caso queira utilizar o POSTMAN para realizar testes manuais:
 O arquivo encontra-se em:
  > "postman/api-pet.postam_collection.json"


##### Acesso a documentacao dos endpoints via swagger 
  > http://localhost:8080/swagger-ui.html

