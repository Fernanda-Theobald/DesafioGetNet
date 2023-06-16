# DesafioGetNet
Desafio Técnico para a vaga de Analista de Testes QA da GetNet 

## GetNet Desafio Técnico Analista de Testes QA	

Este é um repositório que contém a automação de testes de API Rest referentes ao Desafio Técnico para a vaga de Analista de Testes QA	da GetNet 
- ReqRes API - Fake Data CRUD API
- Documentação - [https://reqres.in/](https://reqres.in/)
- URI = [https://reqres.in/api/](https://reqres.in/api/)


### Tecnologias Utilizadas

- git version 2.32.0.windows.2
- java version "1.8.0_301"
- IntelliJ IDEA Community Edition 2023.1
- JUnit 5.8.0-M1
- RestAssured 4.4.0
- Apache Maven 3.8.6 
- Postman 

### Como baixar o projeto
- Navegue até a raiz do diretório onde o projeto será armazenado
- Clique com o botão direito do mouse e selecione Git Bash Here
- Cole este comando e pressione Enter 
		> git clone https://github.com/Fernanda-Theobald/DesafioGetNet.git

​#### Como executar os testes via IDE
- Na própria IDE, navegar até o caminho abaixo e clicar duas vezes para abrir a classe de testes: src>test>java>modulos>usuario>UsuarioTest
- Acionar o botão verdinho ao lado esquerdo da linha de início da class (linha 14)

​#### Como executar os testes via terminal do IntelliJ
 - Na própria IDE, abrir o terminal e digitar o comando abaixo e pressionar Enter:
	> mvn clean test

### Notas Gerais
- A classe Pojo foi utilizada para armazenar os dados que são enviados para a API 
- Classe Data Factory utilizada para criação de dados iniciais, a fim de facilitar a criação e controle, além de deixar o código mais limpo
- O JUnit 5, utilizado neste projeto, possibilita a utilização da anotação DisplayName para inserir descrições em português para os testes, a fim de facilitar a leitura e entendimento de quem acessa o código 

### Plano de teste e estratégia de testes
Para realização destes testes, utilizei a técnica de testes exploratórios para avaliar o comportamento da API Rest. 
- Validação dos verbos (métodos) de uma API Rest
- Validação dos dados e sua estrutura
- Validação de Errors (status code HTTP)

### Testes Automatizados
- Foram automatizados os testes positivos e alguns alternativos que julguei importantes para a melhor validação da aplicação. 
- Para manipular a API, além da automação, utilizei o Postman.

#### Resultados dos testes exploratórios 
- Foram criados 6 testes, onde 2 obtiveram sucesso e 4 obtiveram falha
	- Sucesso:
		- Criação de usuário com sucesso, validando Status Code e Response body
		- Validação de estrutura da resposta na criação de usuário com sucesso, validando o contrato
	- Falha:
		- Validação de Status code ao tentar criar usuário informando "name" com tipo de dado diferente do contrato
		- Validação de Status code ao tentar criar usuário informando "job" com tipo de dado diferente do contrato
		- Validação de Status code ao tentar criar usuário informando "name" e "job" em branco
		- Validação de Status code e estrutura de resposta ao tentar criar usuário informando método "GET" e body contendo "name" e "job" 

![image](https://github.com/Fernanda-Theobald/DesafioGetNet/assets/61762119/24d18fe3-891e-49b8-afad-a2d261c41a23)

