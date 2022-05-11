package br.com.pagrn.demo.service;

import br.com.pagrn.demo.model.Pessoa;
import br.com.pagrn.demo.repository.PessoaRepository;
import br.com.pagrn.demo.service.generic.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class PessoaService extends AbstractService<Pessoa, PessoaRepository> {
    public PessoaService(PessoaRepository repository) {
        super(repository);
    }
}

