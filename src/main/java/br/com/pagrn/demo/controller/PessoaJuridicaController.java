package br.com.pagrn.demo.controller;

import br.com.pagrn.demo.dto.PessoaJuridicaDTO;
import br.com.pagrn.demo.model.PessoaJuridica;
import br.com.pagrn.demo.service.PessoaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoajuridica")
public class PessoaJuridicaController {

    @Autowired
    public PessoaJuridicaService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<PessoaJuridica> listPessoasFisicas(Pageable pegeable) {
        return service.findAll(pegeable);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaJuridica> obterPessoaJuridica(@PathVariable Long id) {
        Optional<PessoaJuridica> pessoaJuridica = service.findById(id);
        if (pessoaJuridica.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(pessoaJuridica.get());
        }
    }

    @PostMapping
    public ResponseEntity<PessoaJuridica> savePessoaJuridica(@Valid @RequestBody PessoaJuridicaDTO dto) {
        PessoaJuridica pessoaJuridica = dto.extractPessoaJuridica();

        PessoaJuridica pj = service.create(pessoaJuridica);
        return ResponseEntity.status(201).body(pj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletePessoaJuridica(@PathVariable Long id) {
        Optional<PessoaJuridica> pessoaJuridica = service.findById(id);
        return service.findById(id)
                .map( record -> {
                    service.delete(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
