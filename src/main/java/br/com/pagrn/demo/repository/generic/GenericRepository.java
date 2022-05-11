package br.com.pagrn.demo.repository.generic;

import br.com.pagrn.demo.model.generic.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<E extends AbstractEntity> extends JpaRepository<E, Long> {
}
