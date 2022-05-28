package br.com.pagrn.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pagrn.demo.model.PessoaFisica;

import java.util.Date;
import java.util.Optional;

public interface PessoaFisicaRepository extends JpaRepository <PessoaFisica, Long> {
    Page<PessoaFisica> findAllByRemoved(Date date, Pageable pegeable);

    Optional<PessoaFisica> findByIdAndRemoved(Long id, Date date);
}
