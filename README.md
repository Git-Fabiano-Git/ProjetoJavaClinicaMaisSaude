# Instituto Federal de Sergipe
## Professor: Francisco Rodrigues
## Alunos: 
## Aline Santos
## Fabiano Freitas


---

## Sistema Mais Saúde

### Sobre o projeto

Esse é um projeto da matéria Programação 1. A ideia é fazer um sistema que gerencia clínicas médicas, usando Spring Boot e JPA.
O sistema permite:

- Cadastrar médicos, pacientes, clínicas e especialidades.
- Relacionar médicos com várias especialidades e com várias clínicas (N:N).
- Agendar consultas, que ligam um médico, um paciente e uma clínica.

---

### Diagrama ER

![DER_MaisSaude](Docs/DER_MaisSaude.png)


---

### Como rodar o projeto


1. Abra o projeto no IntelliJ (ou outra IDE).
2. Baixar as dependências com o Maven.
3. Execute a classe `ApiApplication.java`.

No console vai aparecer a mensagem:

=== Banco de dados populado com sucesso! ===

---

### Para acessarr o banco:

http://localhost:8080/
http://localhost:8080/h2-console
http://localhost:8080/h2-console/

- **JDBC URL:** `jdbc:h2:mem:maisaude`
- **Usuário:** `sa`
- **Senha(vazia):**  
---


### Tecnologias usadas

- Spring Boot 3.5.14
- Spring Data JPA
- H2 BD 
- Lombok
- Maven

---

### Possíveis problemas

- H2 Console não abre (404) nas versões 4.x do SpringBoot
- Erro de compilação no Lombok: liberar permissões, no caso do Ubuntu

