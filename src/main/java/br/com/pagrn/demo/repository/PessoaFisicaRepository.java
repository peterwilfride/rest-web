package br.com.pagrn.demo.repository;

import br.com.pagrn.demo.model.Deficiencia;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pagrn.demo.model.PessoaFisica;

import java.util.List;

public interface PessoaFisicaRepository extends JpaRepository <PessoaFisica, Long> {
   //List<Deficiencia> findDeficienciaByPessoaFisicaId(Long id);
}
