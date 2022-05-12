package br.com.pagrn.demo.controller.generic;

import br.com.pagrn.demo.model.generic.AbstractEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
