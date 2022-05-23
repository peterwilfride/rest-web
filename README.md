# rest-web
Repositório para guardar a API REST do DER do "pagRN"

# pend�ncias
[ ] Implementar entidade deficiente (vários / vários)
[ ] controller advice
[ ] converter os seters dentro de um DTO
[ ] implementar demais controladores

# SOLID
[S - Single Responsibility Principle]
- Cada classe deve ter apenas uma responsabilidade
- Classes pequenas, menos complexas, de f�cil manuten��o e de utiliza��o em diversos contextos (reuso)
- Integridade conceitual (coes�o)
- Separar responsabilidades de acordo com os diferentes interesses

[O - Open/Closed Principle]
- Uma classe deve ser aberta para extens�o e fechada para modifica��o
- Implementa��es preparadas para mudan�as (novas extens�es)

[L - Liskov Substitution Principle]
- Possibilidade de substituir a interface ou classe abstrata pela classe concreta
- A subclasse n�o pode restringir ou violar princ�pios da superclasse

[I - Interface Segregation Principle]
- Interfaces devem ser quebradas em especifica��es para atender clientes espec�ficos
- Classes n�o devem implementar funcionalidades desnecess�rias de interfaces
- Clientes n�o devem ser obrigados a implementarem m�todos que n�o necessitam

[D - Dependency Inversion Principle]
- Classes n�o devem depender de implementa��es concretas, mas de abstra��es (classes abstratas ou interfaces)
- Garante fraco acoplamento e facilita a manutenibilidade e o reuso
- Garante tamb�m o princ�pio OCP


