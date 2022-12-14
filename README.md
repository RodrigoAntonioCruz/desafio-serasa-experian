<h3 align="center">
  <img align="center" alt="LOGO SERASA EXPERIAN"  height="100" src="https://www.serasaexperian.com.br/images-cms/wp-content/uploads/2022/08/logo-serasa-experian-color-1.png.webp" /><br>
  DESAFIO BACKEND SERASA EXPERIAN
</h3> <br>


### Contexto do Desafio

Desenvolver uma `API REST` 	para cadastro de `pessoas` com `score` e suas `regiões` de `afinidades`, que contemple as seguintes operações nos respectivos `Endpoints`:

<p align="center">
  <img align="center" src="https://raw.githubusercontent.com/RodrigoAntonioCruz/assets/main/swagger-serasa.png" />
</p>


<h4>Tecnologias</h4>
<ul>
  <li> Java 11
  <li> Maven	
  <li> Spring Boot 
  <li> Spring Data JPA 
  <li> Spring Security 
  <li> Spring Cloud Open Feign 
  <li> Lombok
  <li> Swagger
  <li> H2-database
  <li> ModelMapper	
  <li> Validation
  <li> JWT	
  <li> JUnit
</ul>

### Requisitos

Para rodar esta aplicação, você deve ter instalado em seu computador:

<ul> 
   <li><a href="https://www.azul.com/downloads/?package=jdk" target="_blank">Java 11 (LTS)</a>
   <li><a href="https://maven.apache.org/install.html" target="_blank">Apache Maven</a>
</ul> 

### Executando o projeto

1. Clone ou baixe o projeto do repositório para o seu `Computador`.

2. Navegue até a raíz do seu diretório onde salvou ou clonou o projeto, abra o `terminal e execute os seguintes comandos:`
<ul> 
   <li> sudo mvn clean install
   <li> sudo mvn spring-boot:run
</ul>

3. Após a execução dos passos anteriores, estarão disponíveis para acesso em seu browser a documentação `swagger` e o console do `banco de dados H2` nos links abaixo:

<ul> 
  <li><a href="http://localhost:8887/api/v1/swagger-ui/#/" target="_blank">ENDPOINT-API-REST</a>
  <li><a href="http://localhost:8887/api/v1/h2-console" target="_blank">ENDPOINT-H2-DB</a>  
</ul>
