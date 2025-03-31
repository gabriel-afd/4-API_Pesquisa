# API de Pesquisa de Operadoras de Saúde 🏥

Este projeto consiste em uma API REST desenvolvida com Java e Spring Boot para realizar buscas em uma base de dados de operadoras de saúde. A API faz parte de um desafio técnico e está integrada com um front-end em Vue.js também disponibilizado online.

---

## 📌 Descrição Geral

Esta API permite realizar buscas por operadoras de saúde utilizando diferentes filtros, como:

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

## 🧪 Enunciado do Desafio Técnico

O projeto atende ao seguinte item do desafio:

**4. TESTE DE API**  
Desenvolva uma interface web usando Vue.js que interaja com um servidor em Python (adaptado para Java Spring Boot neste projeto) para realizar as tarefas abaixo:

- **4.1** Utilizar o CSV do item 3.2 (cadastro de operadoras).
- **4.2** Criar uma rota de busca textual nos cadastros de operadoras.
- **4.3** Elaborar uma coleção no Postman para demonstrar os resultados.

📁 A coleção Postman foi criada com as seguintes requisições de teste:

- `GET /operadoras/busca?termo=dentalmaster`
- `GET /operadoras/busca?uf=MG`
- `GET /operadoras/busca?cidade=Fortaleza`
- `GET /operadoras/busca?uf=CE&cidade=Fortaleza`
- `GET /operadoras/busca?termo=dental&uf=MG&cidade=São Lourenço`

Essas requisições podem ser salvas no Postman em uma coleção chamada **Pesquisa Operadoras** para facilitar a reutilização e o compartilhamento com outros usuários.

---

## 🧱 Arquitetura Adotada: MVC

O projeto segue a arquitetura Model-View-Controller:

- **Model:** Classe `Operadora`, mapeada via JPA.
- **DTO:** Classe `OperadoraDTO`, utilizada para respostas resumidas.
- **Repository:** Interface `OperadoraRepository` com query nativa SQL.
- **Service:** Classe `OperadoraService`, contendo a lógica de filtragem.
- **Controller:** Classe `OperadoraController`, expõe a rota `/operadoras/busca`.

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

<img src="https://github.com/user-attachments/assets/9f831140-c21c-4dd7-81c4-464b6e789d94" width="400"/>

- Filename: copie o caminho do seu arquivo .csv
- Format: csv
- Enconding: UTF8
- 
  ![image](https://github.com/user-attachments/assets/6226e525-f1e3-4222-9c15-769688223aef)

- Header: deixe essa opção ativa
- Delimiter: o delimitador deverá ser ";"

  ![image](https://github.com/user-attachments/assets/cd93a568-fa23-4cb0-8ec5-03cfb3972bf7)


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

Acesse a documentação completa da API em:

```
http://localhost:8080/swagger-ui/index.html
```

---

## ✍️ Autor

**Gabriel Medeiros de Mendonça**  
[github.com/gabriel-afd](https://github.com/gabriel-afd)  
gmedeiros144@gmail.com

---

Se achou útil, deixe uma ⭐ no repositório! 😉

