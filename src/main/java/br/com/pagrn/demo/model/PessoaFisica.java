package br.com.pagrn.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaFisica extends Pessoa {

    char sexo;

    String cpf;

    Date data_nascumento;

    String tipo_sangue;

    String nome_pai;

    String nome_mae;

    String foto;

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
