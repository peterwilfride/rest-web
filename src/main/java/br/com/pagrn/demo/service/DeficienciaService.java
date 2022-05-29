package br.com.pagrn.demo.service;

import br.com.pagrn.demo.model.Deficiencia;
import br.com.pagrn.demo.repository.DeficienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeficienciaService {

    @Autowired
    public DeficienciaRepository repository;

    public Deficiencia create(Deficiencia deficiencia) {
        return repository.save(deficiencia);
    }

    public List<Deficiencia> list() {
        return repository.findAll();
    }

    public Optional<Deficiencia> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Deficiencia deficiencia) {
        repository.delete(deficiencia);
        // ainda tem que verificar se remove da tabela do join table
    }
}
