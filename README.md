# Validador de dados de Usuários  

Este projeto é uma aplicação simples em Java utilizando o **Spring Framework puro (sem Spring Boot)** para demonstrar:

- Validação de dados de usuários (nome, e-mail e senha)
- Injeção de dependências com Spring Core
- Aplicação de Aspect-Oriented Programming (AOP) para logging de validações
- Leitura de configurações via arquivo `application.properties`

---
## 📌 Tecnologias Utilizadas

- Java 21
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


---

## 🧪 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/validador-usuario-spring.git

2. Compile e execute pela sua IDE ou terminal com Maven:  
   ```bash
   mvn compile
   mvn exec:java -Dexec.mainClass="com.alessandromelo.Main"
   
3. Modifique os **Users** na classe Main para testar os cenários de validação.

## 📋 Exemplo de Saída no Console

Ao tentar registrar um usuário com e-mail inválido, o sistema realiza o seguinte fluxo:

```text
[LOG] ValidatorEmail is running!
[LOG] Validating email: mariafc52gmail.com
[LOG - EXCEPTION]: Validation failed in ValidatorEmail - Reason: Invalid email format! 
