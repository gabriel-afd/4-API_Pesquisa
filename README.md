# API de Pesquisa de Operadoras de Saúde 🏥

Este projeto consiste em uma API REST desenvolvida com Java e Spring Boot para realizar buscas em uma base de dados de operadoras de saúde. A API faz parte de um desafio técnico e está integrada com um front-end em Vue.js também disponibilizado online.

---

## 📌 Descrição Geral

Esta API permite realizar buscas por operadoras de saúde utilizando diferentes filtros(pode ser configurado para mais filtros ao expandir a quantidade de atributos da classe DTO). Aqui adotou-se como registros relevantes:

- Nome fantasia
- Razão social
- Modalidade
- Cidade
- CNPJ
- UF

Exemplos de requisição utilizando o Postman ou o navegador:

- Buscar por nome (ou parte dele):
  `http://localhost:8080/operadoras/busca?termo=dentalmaster`

- Buscar apenas por UF (exato):
  `http://localhost:8080/operadoras/busca?uf=MG`

- Buscar apenas por cidade:
  `http://localhost:8080/operadoras/busca?cidade=Fortaleza`

- Buscar por UF + cidade:
  `http://localhost:8080/operadoras/busca?uf=CE&cidade=Fortaleza`

- Buscar por nome + cidade + UF:
  `http://localhost:8080/operadoras/busca?termo=dental&uf=MG&cidade=São Lourenço`

A API foi construída com base no padrão **MVC** (Model-View-Controller) e conta com testes automatizados utilizando **JUnit** e **Mockito**, além de estar documentada via **Swagger**.

---

## 🚀 Acesso à Aplicação Web (Front-end)

A interface web que consome esta API está publicada no Render e pode ser acessada pelo link:

🔗 [https://front-api-pesquisa-deploy.onrender.com/](https://front-api-pesquisa-deploy.onrender.com/)

⚠️ **Nota**: por ser hospedada na versão gratuita do Render, a aplicação pode demorar entre 20 a 50 segundos para responder no primeiro acesso.

---

### 📎 JSON da Coleção (Importar via Raw Text no Postman)

<details>
<summary><strong>Clique para expandir o JSON</strong></summary>

```json
{
  "info": {
    "name": "Pesquisa Operadoras",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Buscar por termo",
      "request": {
        "method": "GET",
        "url": {
          "raw": "http://localhost:8080/operadoras/busca?termo=dentalmaster",
          "host": ["localhost"],
          "port": "8080",
          "path": ["operadoras", "busca"],
          "query": [{"key": "termo", "value": "dentalmaster"}]
        }
      }
    },
    {
      "name": "Buscar por UF",
      "request": {
        "method": "GET",
        "url": {
          "raw": "http://localhost:8080/operadoras/busca?uf=MG",
          "host": ["localhost"],
          "port": "8080",
          "path": ["operadoras", "busca"],
          "query": [{"key": "uf", "value": "MG"}]
        }
      }
    },
    {
      "name": "Buscar por cidade",
      "request": {
        "method": "GET",
        "url": {
          "raw": "http://localhost:8080/operadoras/busca?cidade=Fortaleza",
          "host": ["localhost"],
          "port": "8080",
          "path": ["operadoras", "busca"],
          "query": [{"key": "cidade", "value": "Fortaleza"}]
        }
      }
    },
    {
      "name": "Buscar por UF + Cidade",
      "request": {
        "method": "GET",
        "url": {
          "raw": "http://localhost:8080/operadoras/busca?uf=CE&cidade=Fortaleza",
          "host": ["localhost"],
          "port": "8080",
          "path": ["operadoras", "busca"],
          "query": [
            {"key": "uf", "value": "CE"},
            {"key": "cidade", "value": "Fortaleza"}
          ]
        }
      }
    },
    {
      "name": "Buscar por termo + cidade + UF",
      "request": {
        "method": "GET",
        "url": {
          "raw": "http://localhost:8080/operadoras/busca?termo=dental&uf=PB&cidade=João Pessoa",
          "host": ["localhost"],
          "port": "8080",
          "path": ["operadoras", "busca"],
          "query": [
            {"key": "termo", "value": "dental"},
            {"key": "uf", "value": "MG"},
            {"key": "cidade", "value": "São Lourenço"}
          ]
        }
      }
    }
  ]
}
```

</details>

✅ Para importar no Postman:
1. Clique em **Import**;
2. Vá na aba **Raw Text**;
3. Cole o JSON acima;
4. Clique em **Continue > Import**.

---


## 🧱 Arquitetura Adotada: MVC

O projeto segue a arquitetura Model-View-Controller:

- **Model:** Classe `Operadora`, mapeada via JPA.
- **DTO:** Classe `OperadoraDTO`, utilizada para respostas resumidas.
- **Repository:** Interface `OperadoraRepository` com query nativa SQL.
- **Service:** Classe `OperadoraService`, contendo a lógica de filtragem.
- **Controller:** Classe `OperadoraController`, expõe a rota `/operadoras/busca`.
- **Config:** Classe `corsConfigurer` para ajustes de CORS. Classe `SpringDocConfig` para documentação da API

---

## 💾 Como Rodar o Projeto Localmente

### ✅ Pré-requisitos

- Java 17+
- Maven
- PostgreSQL
- pgAdmin (opcional, mas recomendado)

### 🏗️ Passos

1. **Clone o repositório:**

```bash
git clone https://github.com/seu-usuario/API_Pesquisa.git
cd API_Pesquisa
```

2. **Configure o banco de dados no PostgreSQL:**

Abra o **pgAdmin** ou seu terminal e execute:

```sql
CREATE DATABASE db_intuitive_care WITH ENCODING 'UTF8';

CREATE TABLE operadoras (
    registro_ans INTEGER PRIMARY KEY,
    cnpj VARCHAR(20),
    razao_social VARCHAR(255),
    nome_fantasia VARCHAR(255),
    modalidade VARCHAR(100),
    logradouro VARCHAR(255),
    numero VARCHAR(20),
    complemento VARCHAR(100),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    uf VARCHAR(2),
    cep VARCHAR(10),
    ddd VARCHAR(3),
    telefone VARCHAR(30),
    fax VARCHAR(30),
    endereco_eletronico VARCHAR(255),
    representante VARCHAR(255),
    cargo_representante VARCHAR(100),
    regiao_de_comercializacao INTEGER,
    data_registro_ans DATE
);
```

3. **Importe o CSV:**

Clique com o botão direito na tabela `operadoras` no pgAdmin → **Import/Export** → selecione o CSV fornecido no desafio e insira os dados corretamente.

<img src="https://github.com/user-attachments/assets/9f831140-c21c-4dd7-81c4-464b6e789d94" width="300"/>

- Filename: copie o caminho do seu arquivo .csv
- Format: csv
- Enconding: UTF8

  <img src="https://github.com/user-attachments/assets/6226e525-f1e3-4222-9c15-769688223aef" width="500"/>
  

- Header: deixe essa opção ativa
- Delimiter: o delimitador deverá ser ";"

<img src="https://github.com/user-attachments/assets/cd93a568-fa23-4cb0-8ec5-03cfb3972bf7" width="500"/>


**Se quiser importar o arquivo .csv automaticamente para o banco de dados, use o seguinte código no pgAdmin**

```
COPY operadoras
FROM 'F:/IntuitiveCare-MySQL/Relatorio de operadoras ativas/Relatorio_cadop.csv'
WITH (
    FORMAT csv,
    DELIMITER ';',
    HEADER true,
    ENCODING 'UTF8',
    QUOTE '"'
);

```

4. **Atualize o arquivo `application.properties`:**

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/db_intuitive_care
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=none
```

5. **Execute a aplicação:**

```bash
./mvnw spring-boot:run
```

---

## ✅ Testes Automatizados

O projeto conta com:

- **Testes de unidade** (`JUnit`) para o `Repository` e `Controller`.
- Simulações de erros com códigos HTTP (200, 404, 500).
- Mock de dependências com **Mockito**.

Para rodar os testes:

```bash
./mvnw test
```

---

## ☁️ Deploy no Render

### Back-end

A API está hospedada no [Render](https://render.com/). O processo de deploy envolveu:

1. Criação de uma conta no Render.
2. Conexão do repositório GitHub.
3. Provisionamento de um banco PostgreSQL pela plataforma.
4. Configuração das variáveis de ambiente (usuário, senha, URL do banco).
5. Deploy automático via push no Git.

---

## 🧭 Documentação da API com Swagger

Rode a API e acesse a documentação completa em:

```
http://localhost:8080/swagger-ui/index.html

```
<img src="https://github.com/user-attachments/assets/824c604b-d414-4ec9-a8c4-ae553dea2536" width="500"/>

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- PostgreSQL
- JPA / Hibernate
- Maven
- Swagger OpenAPI 3
- JUnit 5
- Mockito
- Render (para deploy)
- Postman (testes de requisição)
- Docker (opcional)

---

## ✍️ Autor

**Gabriel Medeiros de Mendonça**  
[github.com/gabriel-afd](https://github.com/gabriel-afd)  
gmedeiros144@gmail.com

---

