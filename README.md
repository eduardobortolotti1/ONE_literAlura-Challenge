# LiterAlura - Catálogo de Livros 📚

Este projeto foi desenvolvido como parte do desafio **LiterAlura**, um exercício prático do curso da **ONE (Oracle Next Education)**. O objetivo é construir um catálogo de livros interativo via console, consumindo uma API de livros, armazenando as informações em um banco de dados e permitindo consultas interativas.

## 📌 Sobre o Projeto

O **LiterAlura** é um sistema baseado em **Java** que permite aos usuários interagir com um catálogo de livros. As informações dos livros são obtidas de uma API externa e armazenadas em um banco de dados relacional, possibilitando operações como busca, filtragem e exibição dos detalhes de cada livro.

O desafio envolve os seguintes passos:
1. **Configuração do ambiente Java** 🛠️
2. **Criação do projeto** 🚀
3. **Consumo da API** 🌐
4. **Análise da resposta JSON** 🗃️
5. **Inserção e consulta no banco de dados** 🗄️
6. **Exibição de resultados para o usuário** 🎭

## 🔥 Funcionalidades

- ✅ **Buscar livros pela API** e armazená-los no banco de dados.
- ✅ **Filtrar livros por autor, gênero ou ano de publicação**.
- ✅ **Listar todos os livros armazenados**.
- ✅ **Exibir detalhes de um livro específico**.

## LiterAlura - Catálogo de Livros 📚

Este projeto foi desenvolvido como parte do desafio **LiterAlura**, um exercício prático do curso da **ONE (Oracle Next Education)**. O objetivo é construir um catálogo de livros interativo via console, consumindo uma API de livros, armazenando as informações em um banco de dados e permitindo consultas interativas.

## 📌 Sobre o Projeto

O **LiterAlura** é um sistema baseado em **Java** que permite aos usuários interagir com um catálogo de livros. As informações dos livros são obtidas de uma API externa e armazenadas em um banco de dados relacional, possibilitando operações como busca, filtragem e exibição dos detalhes de cada livro.

O desafio envolve os seguintes passos:
1. **Configuração do ambiente Java** 🛠️
2. **Criação do projeto** 🚀
3. **Consumo da API** 🌐
4. **Análise da resposta JSON** 🗃️
5. **Inserção e consulta no banco de dados** 🗄️
6. **Exibição de resultados para o usuário** 🎭

## 🔥 Funcionalidades

- ✅ **Buscar livros pela API** e armazená-los no banco de dados.
- ✅ **Filtrar livros por autor, gênero ou ano de publicação**.
- ✅ **Listar todos os livros armazenados**.
- ✅ **Exibir detalhes de um livro específico**.
- ✅ **Registrar avaliações dos usuários sobre os livros**.

## 🛠️ Tecnologias Utilizadas

- **Java** - Linguagem principal do projeto.
- **Spring Boot** - Framework para simplificar o desenvolvimento da aplicação.
- **JPA / Hibernate** - Para a persistência dos dados.
- **PostgreSQL** - Banco de dados utilizado.
- **Lombok** - Para reduzir código boilerplate.
- **Jackson** - Para manipulação de JSON.
- **Maven** - Gerenciador de dependências.

## ⚙️ Configuração do Projeto
### 📌 Pré-requisitos

**Certifique-se de ter instalado:**

- Java 11 ou superior
- Maven
- PostgreSQL

### 🚀 Passos para Rodar o Projeto

Clonar o repositório
```bash
  git clone https://github.com/seu-usuario/literalura.git
  cd literalura
```

**Configurar o Banco de Dados**

  1. Crie um banco de dados PostgreSQL chamado liter_alura.
  2. Atualize o arquivo application.properties com suas credenciais do banco.

**Compilar e Executar**
```bash
  mvn clean install
  mvn spring-boot:run
```

**Interagir com o Sistema**

Após iniciar a aplicação, o sistema exibirá um menu no console, permitindo que você explore as funcionalidades disponíveis.
