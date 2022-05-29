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

        // listar todas as pessoas fśicas do banco de dados
        // verificar para cada deficiencia o id é igual o da definciencia desse método
        // se sim, excluir a deficiência da lista
        // senão ignora
        // salva, para da pessoa física

        repository.delete(deficiencia);
    }
}
