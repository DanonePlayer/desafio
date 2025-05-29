# 🍲 Sistema de Receitas & Gestão de Tickets - Desafio Técnico ALFA

Este projeto é uma aplicação modular desenvolvida em **Java com Spring Boot**. A API possui duas funcionalidades principais:

---

## 📌 Funcionalidades Implementadas

### 🧾 1. Gestão de Tickets (Problema 01)

A API permite:

- 📬 **Criar um novo Ticket**
- 📅 **Receber mês e ano como parâmetros** e retornar, em uma única chamada:
  - Lista de **Tickets**
  - Dados **agrupados por Cliente**
  - Dados **agrupados por Módulo**

---

### 🔍 2. Busca de Receitas (Problema 02)

- A API permite buscar receitas com base em um **nome de prato** informado pelo usuário.

## 🚀 Como Rodar o Projeto

### ✅ Pré-requisitos

- Java 24  
- Maven 3.8+  
- IDE como IntelliJ ou VS Code com suporte a Spring Boot  
- Banco de Dados: PostgreSQL

### ▶️ Passos

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/DanonePlayer.git
cd desafio

# Build do projeto com Maven
mvn clean install

# Execute a aplicação
mvn spring-boot:run
```

A aplicação estará disponível em:
📍 http://localhost:8080
