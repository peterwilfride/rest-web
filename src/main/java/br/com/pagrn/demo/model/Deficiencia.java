package br.com.pagrn.demo.model;

import br.com.pagrn.demo.model.generic.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity(name = "deficiencia")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Deficiencia extends AbstractEntity {

    private String tipo;

    private String denominacao;

    @ManyToMany(mappedBy="deficiencias", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<PessoaFisica> pessoaFisicas;  // = new HashSet<>();
}
