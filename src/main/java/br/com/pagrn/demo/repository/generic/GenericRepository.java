package br.com.pagrn.demo.repository.generic;

import br.com.pagrn.demo.model.generic.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* Repositorio genérico que recebe um tipo de entidade chamada E
* e extende o JpaRepository passando esssa entidade E como argumento
* */

// public interface GenericRepository<E extends AbstractEntity> extends JpaRepository<E, Long>
public interface GenericRepository<E extends AbstractEntity> extends JpaRepository<E, Long> {
}
