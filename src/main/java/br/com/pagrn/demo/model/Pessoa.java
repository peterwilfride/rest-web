package br.com.pagrn.demo.model;

import br.com.pagrn.demo.model.generic.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "pessoa")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends AbstractEntity {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //Long id;

    String nome;

    String email;

    String telefones;

    /*
    * Muitas pessoas tem um único endereço, então Pessoa possui
    * uma chave estrangeira para endereco, com nome endereco_id
    * */
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

}
