Transaction Service API

API em Java para gerenciar transações financeiras entre usuários. A aplicação valida o tipo da transação e o saldo disponível antes de efetivar cada operação.

Funcionalidades
Cadastro e consulta de usuários [ajuste conforme o que existe no projeto]
Registro de transações entre usuários
Validação do tipo da transação por enum ([liste os tipos, ex.: TRANSFERENCIA, DEPOSITO, SAQUE])
Validação de saldo antes de efetivar a transação
Consulta de transações [ajuste: por usuário, por período, etc.]
Tecnologias
Java [versão, ex.: 17]
Spring [Boot / Web / Data JPA, conforme usado]
JPA / Hibernate
Banco de dados: [ex.: PostgreSQL, H2]
Maven [ou Gradle]
Estrutura do projeto

O código é organizado em pastas por responsabilidade:

src/main/java/[seu.pacote]
├── controller   -> recebe as requisições HTTP
├── service      -> regras de negócio e validações
├── repository   -> acesso ao banco de dados (JPA)
├── entity       -> entidades do domínio
├── dto          -> objetos de entrada e saída da API
└── enums        -> tipos de transação


Regras de negócio
O tipo da transação deve ser um dos valores do enum; qualquer outro valor é rejeitado.
A transação só é efetivada se o saldo do usuário de origem for suficiente.

Como executar

Pré-requisitos: Java [versão], Maven e [banco de dados] instalado ou em container.

bash
# clonar o repositório
git clone https://github.com/[seu-usuario]/transaction-service-api.git
cd transaction-service-api

# configurar o banco em src/main/resources/application.properties
# [informe as propriedades: url, usuário e senha]

# executar
./mvnw spring-boot:run

A API ficará disponível em http://localhost:8080.

Próximos passos
Testes automatizados (unitários e de integração)
Documentação com Swagger/OpenAPI
Containerização com Docker
[Outras melhorias que você pretende fazer]
Autor

Igor Mendonça de Lima LinkedIn | igorlimamendonca@gmail.com
