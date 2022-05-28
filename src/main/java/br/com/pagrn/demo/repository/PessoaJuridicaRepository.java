package br.com.pagrn.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pagrn.demo.model.PessoaJuridica;

import java.util.Date;
import java.util.Optional;

public interface PessoaJuridicaRepository extends JpaRepository <PessoaJuridica, Long> {

    Page<PessoaJuridica> findAllByRemoved(Date date, Pageable pegeable);

    Optional<PessoaJuridica> findByIdAndRemoved(Long id, Date date);
}
