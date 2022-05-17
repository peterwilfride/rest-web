package br.com.pagrn.demo.controller.generic;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.pagrn.demo.model.generic.AbstractEntity;

/*
* Interface que contém apenas as assinaturas dos métodos a ser
* implementados pela classe, passsando uma entidade abstrada como
* argumento
* */
public interface GenericController<E extends AbstractEntity> {
    List<E> findAll();
    ResponseEntity<E> create(E entity);
    ResponseEntity<E> findById(Long id);
    ResponseEntity<E> update(Long id, E entity);
    ResponseEntity<?> delete(Long id);
}
