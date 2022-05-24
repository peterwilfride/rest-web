package br.com.pagrn.demo.model;

import br.com.pagrn.demo.model.generic.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity(name = "pessoa")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends AbstractEntity {

    @Column(length = 100, nullable = false)
    @NotBlank(message = "O campo 'nome' deve ser informado.")
    private String nome;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "O campo 'email' deve ser informado.")
    @Email
    private String email;

    private String telefones;

    private Boolean eh_pessoa_fisica;
}