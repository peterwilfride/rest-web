package br.com.pagrn.demo.model;

import br.com.pagrn.demo.model.generic.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "endereco")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco extends AbstractEntity {

    //@Id
    //@GeneratedValue
    //Long id;

    Double latitude;

    Double longitude;

    Integer numero;

    String complemento;

    String logradouro;

    String cep;

    /*
    * Um endereço tem muitas pessoas, ou seja, uma lista de Pessoas,
    * mapeada pelo atributo endereco da tabela pessoa
    * */
    @OneToMany(mappedBy = "endereco", fetch = FetchType.LAZY, orphanRemoval = true)
    public List<Pessoa> pessoas = new ArrayList<>();

    public void addPessoa(Pessoa novaPessoa) {
        pessoas.add(novaPessoa);
        novaPessoa.setEndereco(this);
    }

    public void removePessoa(Pessoa removePessoa) {
        pessoas.remove(removePessoa);
        removePessoa.setEndereco(null);
    }
}
