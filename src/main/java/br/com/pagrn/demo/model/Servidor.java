package br.com.pagrn.demo.model;

import br.com.pagrn.demo.model.generic.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "servidor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Servidor extends AbstractEntity {

    @Size(min = 5, max = 10)
    @Column(unique=true)
    @NotBlank
    public String matricula;

    @Column(length = 100)
    private String nome_social;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "pessoa_fisica_id")/*, name = "pessoa_fisica_id"*/)
    @JsonIgnoreProperties("servidores")
    private PessoaFisica pessoa_fisica_id;

    @OneToMany(mappedBy = "servidor_id",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("servidor_id")
    public List<Vinculo> vinculos = new ArrayList<>();
}