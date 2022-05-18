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

    private String nome;

    private String email;

    private String telefones;

    private Boolean eh_pessoa_fisica;
}
