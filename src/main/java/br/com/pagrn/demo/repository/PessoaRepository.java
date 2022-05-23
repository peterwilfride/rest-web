package br.com.pagrn.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pagrn.demo.model.Pessoa;

public interface PessoaRepository extends JpaRepository <Pessoa, Long> {
    //public Pessoa findAllByNome(String nome);
}