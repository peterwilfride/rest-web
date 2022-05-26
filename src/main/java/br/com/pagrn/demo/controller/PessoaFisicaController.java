package br.com.pagrn.demo.controller;

import br.com.pagrn.demo.dto.PessoaFisicaDTO;
import br.com.pagrn.demo.model.PessoaFisica;
import br.com.pagrn.demo.service.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/pessoafisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<PessoaFisica> listPessoasFisicas(Pageable pegeable) {
        return service.findAll(pegeable);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaFisica> obterPessoaFisica(@PathVariable Long id) {
        Optional<PessoaFisica> pessoaFisica = service.findById(id);
        if (pessoaFisica.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(pessoaFisica.get());
        }
    }

    @PostMapping
    public ResponseEntity<PessoaFisica> savePessoaFisica(@Valid @RequestBody PessoaFisicaDTO dto) {
        PessoaFisica pessoaFisica = dto.extractPessoaFisica();

        PessoaFisica pf = service.create(pessoaFisica);
        return ResponseEntity.status(201).body(pf);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletePessoaFisica(@PathVariable Long id) {
        Optional<PessoaFisica> pessoaFisica = service.findById(id);
        return service.findById(id)
                .map( record -> {
                    service.delete(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
