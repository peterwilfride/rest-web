package br.com.pagrn.demo.repository;

import br.com.pagrn.demo.model.Deficiencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeficienciaRepository extends JpaRepository<Deficiencia, Long> {
}
