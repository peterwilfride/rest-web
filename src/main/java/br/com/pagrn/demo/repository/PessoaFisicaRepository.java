package br.com.pagrn.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pagrn.demo.model.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository <PessoaFisica, Long> {
   
}
