package br.com.pagrn.demo.model;

import br.com.pagrn.demo.model.generic.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "vinculo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vinculo extends AbstractEntity {

    @NotNull
    private Date data_nomeacao;

    @NotNull
    private Date data_posse;

    @NotNull
    private Date data_exercicio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "servidor_id"))
    @JsonIgnoreProperties("vinculos")
    private Servidor servidor_id;
}