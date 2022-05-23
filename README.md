# rest-web
RepositÃ³rio para guardar a API REST do DER do "pagRN"

# pendências
[ ] Implementar entidade deficiente (vÃ¡rios / vÃ¡rios)
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


