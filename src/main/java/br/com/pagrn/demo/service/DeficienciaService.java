package br.com.pagrn.demo.service;

import br.com.pagrn.demo.model.Deficiencia;
import br.com.pagrn.demo.repository.DeficienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeficienciaService {

    @Autowired
    public DeficienciaRepository repository;

    public Deficiencia create(Deficiencia deficiencia) {
        return repository.save(deficiencia);
    }
}
