package br.com.pagrn.demo.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "pessoa_fisica") //especifica que essa classe será anotada como uma tabela do banco
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor // lombok para cosntrutor com todos os atributos
@NoArgsConstructor // lombok para construtor sem argumentos
@Data // lombok para criar métodos getters, setters, hashCode e equals
public class PessoaFisica extends Pessoa {

    @Column(nullable=false)
    private Character sexo;

    @Column(length = 11, nullable = false)
    @NotBlank(message = "O campo CPF deve ser informado.")
    private String cpf;

    @Column(nullable = false)
    private Date data_nascimento;

    @Column(nullable = false)
    private String tipo_sangue;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "O campo 'nome do pai' deve ser informado.")
    private String nome_pai;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "O campo 'nome da mãe' deve ser informado.")
    private String nome_mae;

    private String foto;

    /*
     * Muitas pessoas tem um único endereço, então Pessoa possui
     * uma chave estrangeira para endereco, com nome endereco_id
     * */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "endereco_id"), name = "endereco_id")
    private Endereco endereco;

    //@OneToMany(mappedBy = "pessoa_fisica_id", fetch = FetchType.LAZY)
    //public List<Servidor> servidores = new ArrayList<>();

    /*
    public void addServidor(Servidor novoServidor) {
        servidores.add(novoServidor);
        novoServidor.setPessoa_fisica_id(this);
    }

    public void removeServidor(Servidor novoServidor) {
        servidores.remove(novoServidor);
        novoServidor.setPessoa_fisica_id(null);
    }*/
}
