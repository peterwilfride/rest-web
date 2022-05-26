package br.com.pagrn.demo.model;

import br.com.pagrn.demo.model.generic.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "pessoa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends AbstractEntity {

    @NotNull
    @Size(max = 100)
    @NotBlank(message = "O campo 'nome' deve ser informado.")
    private String nome;

    @NotNull
    @Size(max = 100)
    @Email
    @NotBlank(message = "O campo 'email' deve ser informado.")
    private String email;

    private String telefones;

    //private Boolean eh_pessoa_fisica;
}