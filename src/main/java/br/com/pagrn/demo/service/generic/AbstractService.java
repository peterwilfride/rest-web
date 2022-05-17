package br.com.pagrn.demo.service.generic;

import br.com.pagrn.demo.model.generic.AbstractEntity;
import br.com.pagrn.demo.repository.generic.GenericRepository;

import java.util.List;
import java.util.Optional;

/*
* Classe abstrata que implementa a interface genérica, passando como argumento
* uma entidade genérica e um repositório genérico
* */
public abstract class AbstractService<E extends AbstractEntity, R extends GenericRepository<E>> implements GenericService<E> {

    // Não pode ser acessado pelo controlador
    protected final R repository;

    // Recebe uma instância de repository
    public AbstractService(R repository) {
        this.repository = repository;
    }

    /*
    * Os métodos do service chamamam os
    * métodos diretamente do repository
    * */

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public E create(E entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<E> update(Long id, E entity) {
        return repository.findById(id)
                .map(record -> {
                    repository.saveAndFlush(entity);
                    return record;
                });
    }

    @Override
    public Boolean delete(Long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
