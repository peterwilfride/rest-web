package br.com.pagrn.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "pessoa_juridica")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaJuridica extends Pessoa {

    @Column(length = 14)
    @NotBlank
    private String cnpj;

    private String razao_social;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "endereco_id"), name = "endereco_id")
    @NotNull
    private Endereco endereco;
}
