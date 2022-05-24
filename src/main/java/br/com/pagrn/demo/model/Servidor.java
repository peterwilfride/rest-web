package br.com.pagrn.demo.model;

import br.com.pagrn.demo.model.generic.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "servidor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Servidor extends AbstractEntity {

    @Column(length = 20, nullable = false)
    Long matricula;

    String nome_social;

    @ManyToOne
    @JoinColumn(name = "pessoa_fisica_id")
    private PessoaFisica pessoa_fisica_id;
}