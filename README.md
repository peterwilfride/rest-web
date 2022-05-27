# Projeto

- Desenvolver uma aplicaÁ„o web utilizando o estilo arquitetural REST
- A aplicaÁ„o deve conter entidades com relacionamentos 1-1, 1-N e N-N
- Desenvolver todos os endpoints do CRUD para cada recurso
- Implementar um soft delete ou implementar um logger em nÌvel de aplicaÁ„o para qualquer procedimento relacionado ao banco de dados.
- Utilizar verbos HTTP e status code da resposta de maneira adequada
- Implementar a API em grau de maturidade REST nÌvel 3.
- Criar Data Transfer Objects para request/ response para criaÁ„o/update/listagem de objetos
- Criar endpoint para login 
- Adicionar seguranÁa em todos os demais end-points da aplicaÁ„o utilizando uma estratÈgia STATELESS (JWT ou OAuth2.0)
- Busca paginada
- Tema: Pessoa (FÌsica e JurÌdica), Servidor, EndereÁo, VÌnculo, DeficiÍncia
- Grupos de 2-3 pessoas


# pendÔøΩncias
[ ] Implementar entidade deficiente (v√°rios / v√°rios)
[ ] controller advice
[ ] converter os seters dentro de um DTO
[ ] implementar demais controladores

# SOLID
[S - Single Responsibility Principle]
- Cada classe deve ter apenas uma responsabilidade
- Classes pequenas, menos complexas, de f√°cil manuten√ß√£o e de utiliza√ß√£o em diversos contextos (reuso)
- Integridade conceitual (coes√£o)
- Separar responsabilidades de acordo com os diferentes interesses

[O - Open/Closed Principle]
- Uma classe deve ser aberta para extens√£o e fechada para modifica√ß√£o
- Implementa√ß√µes preparadas para mudan√ßas (novas extens√µes)

[L - Liskov Substitution Principle]
- Possibilidade de substituir a interface ou classe abstrata pela classe concreta
- A subclasse n√£o pode restringir ou violar princ√≠pios da superclasse

[I - Interface Segregation Principle]
- Interfaces devem ser quebradas em especifica√ß√µes para atender clientes espec√≠ficos
- Classes n√£o devem implementar funcionalidades desnecess√°rias de interfaces
- Clientes n√£o devem ser obrigados a implementarem m√©todos que n√£o necessitam

[D - Dependency Inversion Principle]
- Classes n√£o devem depender de implementa√ß√µes concretas, mas de abstra√ß√µes (classes abstratas ou interfaces)
- Garante fraco acoplamento e facilita a manutenibilidade e o reuso
- Garante tamb√©m o princ√≠pio OCP


