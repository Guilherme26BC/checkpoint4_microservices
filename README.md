
# Checkpoint2
API Java com a finalidade de simular os primeiros passos de um sistema de agendamento de consultas, sendo nesse estado atual, os métodos CRUDs de  Paciente e Profissionais.

- Guilherme Bezerra Carvalho RM 550282
- Rodolfo Sanches Cima RM 99748
## Instalação

- Configuração do swagger
  - https://springdoc.org/properties

- application.properties
```  
springdoc.swagger-ui.path=/ springdoc.swagger-ui.disable-swagger-default-url=true  
```    
## Navegação
### Executando a API

```  
mvn spring-boot:run  
```  
### Execução docker
```
docker build -t checkpoint4 .
docker compose up db
docker compose up 
```
- execução com dockerhub:

substituir o:

```
build: .

```
por:
```
image: guibezerra/checkpoint4
```

ou 

```bash
  docker network create app-network
   docker run -d --name mysql-db --network app-network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=minha-api -p 3306:3306 mysql:8.0
    docker run -d --name spring-boot-api --network app-network -p 8080:8080 -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql-db:3306/minha-api -e SPRING_DATASOURCE_USERNAME=root -e SPRING_DATASOURCE_PASSWORD=root guibezerra/checkpoint1:latest
```
Fazendo todo o trabalho do docker compose de maneira separada
### Documentação da API
- http://localhost:8080/

### Referências
- https://springdoc.org/