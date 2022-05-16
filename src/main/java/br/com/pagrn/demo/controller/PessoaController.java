package br.com.pagrn.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pagrn.demo.controller.generic.AbstractController;
import br.com.pagrn.demo.model.Pessoa;
import br.com.pagrn.demo.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController extends AbstractController<Pessoa, PessoaService> {
    public PessoaController(PessoaService service) {
        super(service);
    }
}
