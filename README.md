# Gerenciador de Tarefas

API REST desenvolvida em Java com Spring Boot para gerenciamento de projetos, responsáveis e tarefas.

Projeto desenvolvido para a disciplina de **Programação Back-end I**.

## Funcionalidades

A aplicação permite:

- Cadastrar projetos
- Listar projetos
- Consultar projeto por ID
- Cadastrar responsáveis
- Listar responsáveis
- Cadastrar tarefas
- Listar tarefas
- Consultar tarefa por ID
- Filtrar tarefas
- Atualizar tarefas
- Alterar o status de uma tarefa
- Atribuir responsável a uma tarefa
- Excluir tarefas
- Registrar automaticamente a data de criação
- Registrar automaticamente a data de conclusão
- Retornar erro 404 quando um recurso não é encontrado

## Estrutura do projeto

O projeto está organizado em camadas:

```text
src/main/java/posweb/tarefas
│
├── controller
│   ├── ProjetoController.java
│   ├── ResponsavelController.java
│   └── TarefaController.java
│
├── domain
│   ├── Projeto.java
│   ├── Responsavel.java
│   ├── Tarefa.java
│   ├── Status.java
│   └── Prioridade.java
│
├── exception
│   ├── GlobalExceptionHandler.java
│   └── RecursoNaoEncontradoException.java
│
├── repository
│   ├── ProjetoRepository.java
│   ├── ResponsavelRepository.java
│   └── TarefaRepository.java
│
└── service
    ├── ProjetoService.java
    ├── ResponsavelService.java
    └── TarefaService.java
```
## Banco de dados
O projeto utiliza o PostgreSQL.

O banco utilizado pela aplicação é:
```
tarefas
```
A configuração está no arquivo:
```
src/main/resources/application.properties
```
Exemplo de configuração:
```
spring.application.name=tarefas

spring.datasource.url=jdbc:postgresql://localhost:5432/tarefas
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
Substitua SUA_SENHA pela senha do PostgreSQL utilizada na sua máquina.

## Como executar

### Pré-requisitos
É necessário ter instalado:
- Java 25
- Maven
- PostgreSQL

1. Criar o banco de dados
No PostgreSQL, crie um banco chamado:
```
tarefas
```
2. Configurar o banco
Abra o arquivo:
```
src/main/resources/application.properties
```
3. Executar a aplicação
Pelo IntelliJ IDEA, execute a classe principal da aplicação.

## Endpoints

### Projetos

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/projetos` | Criar projeto |
| `GET` | `/projetos` | Listar projetos |
| `GET` | `/projetos/{id}` | Buscar projeto por ID |

### Responsáveis

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/responsaveis` | Criar responsável |
| `GET` | `/responsaveis` | Listar responsáveis |

### Tarefas

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/tarefas` | Criar tarefa |
| `GET` | `/tarefas` | Listar tarefas |
| `GET` | `/tarefas/{id}` | Buscar tarefa por ID |
| `PUT` | `/tarefas/{id}` | Atualizar tarefa |
| `DELETE` | `/tarefas/{id}` | Excluir tarefa |

### Filtros
| Filtro | Exemplo |
|---|---|
| `Status` | `/tarefas?status=NOVA` |
| `Prioridade` | `/tarefas?prioridade=ALTA` |
| `Projeto` | `/tarefas?projetoId=1` |
| `Responsável` | `/tarefas?responsavelId=1` |

## Collection
Link para acessar a Collection : 
```
https://www.postman.com/payload-geoscientist-61108236-s-team/workspace/projeto-ps/collection/33973145-898e729b-ac91-41e1-a275-0952088becf4?action=share&source=copy-link&creator=33973145
```
