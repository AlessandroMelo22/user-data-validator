# Validador de dados de Usuários  

Este projeto é uma aplicação simples em Java utilizando o **Spring Framework puro (sem Spring Boot)** para demonstrar:

- Validação de dados de usuários (nome, e-mail e senha)
- Injeção de dependências com Spring Core
- Aplicação de Aspect-Oriented Programming (AOP) para logging de validações
- Leitura de configurações via arquivo `application.properties`

---
## 📌 Tecnologias Utilizadas

- Java 17+
- Spring Framework (`spring-core`, `spring-beans`, `spring-context`, `spring-aop`, `spring-aspects`)
- Maven
- AspectJ
- IDE: IntelliJ IDEA / Eclipse

---

## ⚙️ Funcionalidades

- Valida se o **nome** do usuário é nulo ou vazio
- Valida se o **e-mail** possui um formato válido com regex
- Valida se a **senha** atende ao tamanho mínimo definido em propriedades
- Utiliza AOP com AspectJ para:
  - Logar o início de cada validação
  - Capturar exceções e registrar falhas de validação

---

## 🏗️ Estrutura de Pacotes
- src  
  - com.alessandromelo  
    - config        -> Classe de configuração Spring
    - model         -> Classe User
    - service       -> UserService
      - validator -> Validadores individuais (nome, e-mail, senha)
    - aspect        -> Classe LogAspect com AOP
