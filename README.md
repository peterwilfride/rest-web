# Projeto

- Desenvolver uma aplica��o web utilizando o estilo arquitetural REST
- A aplica��o deve conter entidades com relacionamentos 1-1, 1-N e N-N
- Desenvolver todos os endpoints do CRUD para cada recurso
- Implementar um soft delete ou implementar um logger em n�vel de aplica��o para qualquer procedimento relacionado ao banco de dados.
- Utilizar verbos HTTP e status code da resposta de maneira adequada
- Implementar a API em grau de maturidade REST n�vel 3.
- Criar Data Transfer Objects para request/ response para cria��o/update/listagem de objetos
- Criar endpoint para login 
- Adicionar seguran�a em todos os demais end-points da aplica��o utilizando uma estrat�gia STATELESS (JWT ou OAuth2.0)
- Busca paginada
- Tema: Pessoa (F�sica e Jur�dica), Servidor, Endere�o, V�nculo, Defici�ncia
- Grupos de 2-3 pessoas


# pend�ncias
[ ] Implementar entidade deficiente (vários / vários)
[ ] controller advice
[ ] converter os seters dentro de um DTO
[ ] implementar demais controladores

# SOLID
[S - Single Responsibility Principle]
- Cada classe deve ter apenas uma responsabilidade
- Classes pequenas, menos complexas, de fácil manutenção e de utilização em diversos contextos (reuso)
- Integridade conceitual (coesão)
- Separar responsabilidades de acordo com os diferentes interesses

[O - Open/Closed Principle]
- Uma classe deve ser aberta para extensão e fechada para modificação
- Implementações preparadas para mudanças (novas extensões)

[L - Liskov Substitution Principle]
- Possibilidade de substituir a interface ou classe abstrata pela classe concreta
- A subclasse não pode restringir ou violar princípios da superclasse

[I - Interface Segregation Principle]
- Interfaces devem ser quebradas em especificações para atender clientes específicos
- Classes não devem implementar funcionalidades desnecessárias de interfaces
- Clientes não devem ser obrigados a implementarem métodos que não necessitam

[D - Dependency Inversion Principle]
- Classes não devem depender de implementações concretas, mas de abstrações (classes abstratas ou interfaces)
- Garante fraco acoplamento e facilita a manutenibilidade e o reuso
- Garante também o princípio OCP


