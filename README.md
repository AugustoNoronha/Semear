# 🌱 Projeto SEMEAR

O **SEMEAR** é uma plataforma que conecta produtores rurais interessados em **compra e venda de material genético animal**.  
O projeto foi pensado para ser **moderno, escalável e cloud-native**, utilizando **microsserviços em Java (Micronaut)**, **Flutter** para mobile e **AWS** como principal infraestrutura.

---

## 🚀 Tecnologias Utilizadas
- **Backend**: [Micronaut](https://micronaut.io/) (Java 17 + Gradle)  
- **Mobile**: Flutter (em desenvolvimento)  
- **Arquitetura**: Microsserviços  
- **Cloud (MVP futuro)**: AWS (DynamoDB, S3, SQS, SNS, Lambda, API Gateway, Cognito)  

---

## 📦 Estrutura do MVP
Neste momento o projeto possui o **User Service**, responsável por gerenciar usuários (cadastro, listagem, busca e remoção).  
- Dados armazenados **em memória** (serão migrados para DynamoDB).  
- Endpoints REST disponíveis via Micronaut.  
- Uso de **injeção de dependência** e arquitetura organizada (Controller → Service → Model).  
- **Lombok** para eliminar boilerplate de código.  

---

## 🔎 Endpoints disponíveis

### Criar Usuário
`POST /users`  
Body:
```json
{
  "name": "Maria Oliveira",
  "email": "maria@email.com"
}
```

### Listar Usuários
`GET /users`

### Buscar Usuário por ID
`GET /users/{id}`

### Remover Usuário
`DELETE /users/{id}`

---

## 🛠 Como rodar o projeto localmente

### Pré-requisitos
- [Java 17 (Temurin)](https://adoptium.net/)  
- [Gradle](https://gradle.org/)  
- [Micronaut CLI](https://micronaut.io/download.html)  

### Passos
```bash
# Clonar repositório
git clone https://github.com/seu-usuario/semeiar.git
cd semeiar/user-service

# Rodar aplicação
./gradlew run
```

A aplicação estará disponível em:  
👉 `http://localhost:8080`

---

## 📅 Roadmap (próximos passos)
- [x] Criar User Service (CRUD básico em memória)  
- [ ] Conectar User Service ao **DynamoDB (AWS Free Tier)**  
- [ ] Criar Animal Service  
- [ ] Implementar autenticação com **AWS Cognito**  
- [ ] Adicionar mensageria com **SQS + SNS**  
- [ ] Criar app mobile em Flutter (UI estilo Tinder)  

---

## 👨‍💻 Autor
**Augusto Noronha**  
Full Stack Developer | Engenharia de Software  
