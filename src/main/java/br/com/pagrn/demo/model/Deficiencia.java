package br.com.pagrn.demo.model;

import br.com.pagrn.demo.model.generic.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "deficiencia")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Deficiencia extends AbstractEntity {

    /*
    private Boolean fisica;
    private Boolean visual;
    private Boolean auditiva;
    private Boolean mental;
    private Boolean intelectual;
    */

    private String tipo;

    private String denominacao;

    @ManyToMany(mappedBy="deficiencias")
    @JsonIgnore
    private Set<PessoaFisica> pessoaFisicas = new HashSet<>();
}
