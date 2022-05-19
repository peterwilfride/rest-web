package br.com.pagrn.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor // lombok para contrutor com todos os argumentos
@NoArgsConstructor // lombok para contrutor sem argumentos
@Data // lombok para geters  e seters 
public class PessoaFisica extends Pessoa {

    private Character sexo;

    private String cpf;

    private Date data_nascimento;

    private String tipo_sangue;

    private String nome_pai;

    private String nome_mae;

    private String foto;

    /*
     * Muitas pessoas tem um único endereço, então Pessoa possui
     * uma chave estrangeira para endereco, com nome endereco_id
     * */
    //@JoinColumn(name = "endereco_id")
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
