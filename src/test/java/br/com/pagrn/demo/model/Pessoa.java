package br.com.pagrn.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "pessoa")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;

    String email;

    String telefones;


}
