package br.com.pagrn.demo.model.generic;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/*
* Entidade abstrata que declara apenas o id Long e um removed
* Date, que é comum a todas as entidades
* */

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date removed = null;
}
