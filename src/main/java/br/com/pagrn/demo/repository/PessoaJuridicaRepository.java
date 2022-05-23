package br.com.pagrn.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pagrn.demo.model.PessoaJuridica;

public interface PessoaJuridicaRepository extends JpaRepository <PessoaJuridica, Long> {
}
