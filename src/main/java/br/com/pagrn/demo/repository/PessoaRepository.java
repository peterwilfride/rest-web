package br.com.pagrn.demo.repository;

import br.com.pagrn.demo.model.Pessoa;
import br.com.pagrn.demo.repository.generic.GenericRepository;

public interface PessoaRepository extends GenericRepository<Pessoa> {
    //public Pessoa findAllByNome(String nome);
}