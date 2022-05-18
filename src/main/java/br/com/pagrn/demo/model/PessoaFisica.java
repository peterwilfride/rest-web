package br.com.pagrn.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
@Data
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
    @ManyToOne(fetch = FetchType.EAGER) //, cascade = CascadeType.ALL
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "pessoa_fisica_id", fetch = FetchType.LAZY)
    public List<Servidor> servidores = new ArrayList<>();

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
