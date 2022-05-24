package br.com.pagrn.demo.repository;

import br.com.pagrn.demo.model.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServidorRepository extends JpaRepository<Servidor, Long> {
}
