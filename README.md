# PROJECT

- Desenvolver uma aplicação web utilizando o estilo arquitetural REST
- A aplicação deve conter entidades com relacionamentos 1-1, 1-N e N-N
- Desenvolver todos os endpoints do CRUD para cada recurso
- Implementar um soft delete ou implementar um logger em nível de aplicação para qualquer procedimento relacionado ao banco de dados.
- Utilizar verbos HTTP e status code da resposta de maneira adequada
- Implementar a API em grau de maturidade REST nível 3.
- Criar Data Transfer Objects para request/ response para criação/update/listagem de objetos
- Criar endpoint para login 
- Adicionar segurança em todos os demais end-points da aplicação utilizando uma estratégia STATELESS (JWT ou OAuth2.0)
- Busca paginada
- Tema: Pessoa (Física e Jurídica), Servidor, Endereço, Vínculo, Deficiência
- Grupos de 2-3 pessoas


# TO DO
[ ] Implementar entidade deficiente (vÃ¡rios / vÃ¡rios)
[ ] controller advice
[ ] converter os seters dentro de um DTO
[ ] implementar demais controladores

# SOLID
[S - Single Responsibility Principle]
- Cada classe deve ter apenas uma responsabilidade
- Classes pequenas, menos complexas, de fÃ¡cil manutenÃ§Ã£o e de utilizaÃ§Ã£o em diversos contextos (reuso)
- Integridade conceitual (coesÃ£o)
- Separar responsabilidades de acordo com os diferentes interesses

[O - Open/Closed Principle]
- Uma classe deve ser aberta para extensÃ£o e fechada para modificaÃ§Ã£o
- ImplementaÃ§Ãµes preparadas para mudanÃ§as (novas extensÃµes)

[L - Liskov Substitution Principle]
- Possibilidade de substituir a interface ou classe abstrata pela classe concreta
- A subclasse nÃ£o pode restringir ou violar princÃ­pios da superclasse

[I - Interface Segregation Principle]
- Interfaces devem ser quebradas em especificaÃ§Ãµes para atender clientes especÃ­ficos
- Classes nÃ£o devem implementar funcionalidades desnecessÃ¡rias de interfaces
- Clientes nÃ£o devem ser obrigados a implementarem mÃ©todos que nÃ£o necessitam

[D - Dependency Inversion Principle]
- Classes nÃ£o devem depender de implementaÃ§Ãµes concretas, mas de abstraÃ§Ãµes (classes abstratas ou interfaces)
- Garante fraco acoplamento e facilita a manutenibilidade e o reuso
- Garante tambÃ©m o princÃ­pio OCP


