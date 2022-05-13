package br.com.pagrn.demo.service.generic;

import br.com.pagrn.demo.model.generic.AbstractEntity;

import java.util.List;
import java.util.Optional;

public interface GenericService<E> {
    List<E> findAll();
    E create(E entity);
    Optional<E> findById(Long id);
    Optional<E> update(Long id, E entity);
    Boolean delete(Long id);
}
