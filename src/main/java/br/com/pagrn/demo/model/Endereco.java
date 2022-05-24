package br.com.pagrn.demo.model;

import br.com.pagrn.demo.model.generic.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "endereco")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco extends AbstractEntity {

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @NotNull
    private Integer numero;

    @NotNull
    private String complemento;

    @NotNull
    private String logradouro;

    @NotNull
    private String cep;

    /*
    * Um endereço tem muitas pessoas, ou seja, uma lista de Pessoas,
    * mapeada pelo atributo endereco da tabela pessoa
    * */
    @OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    public List<PessoaFisica> pessoasFisicas = new ArrayList<>();

    /*
    public void addPessoaFisica(PessoaFisica novaPessoaFisica) {
        pessoasFisicas.add(novaPessoaFisica);
        novaPessoaFisica.setEndereco(this);
    }

    public void removePessoaFisica(PessoaFisica novaPessoaFisica) {
        pessoasFisicas.remove(novaPessoaFisica);
        novaPessoaFisica.setEndereco(null);
    }*/
}
