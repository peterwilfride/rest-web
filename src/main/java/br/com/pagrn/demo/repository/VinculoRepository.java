package br.com.pagrn.demo.repository;

import br.com.pagrn.demo.model.Vinculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VinculoRepository extends JpaRepository<Vinculo, Long> {
}
