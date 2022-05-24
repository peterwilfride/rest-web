package br.com.pagrn.demo.controller;

import br.com.pagrn.demo.dto.PessoaFisicaDTO;
import br.com.pagrn.demo.model.PessoaFisica;
import br.com.pagrn.demo.service.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoafisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService service;

    @GetMapping
    public ResponseEntity<List<PessoaFisica>> listPessoasFisicas() {
        List<PessoaFisica> pessoaFisicas = service.findAll();
        return ResponseEntity.status(200).body(pessoaFisicas);
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
    public ResponseEntity<PessoaFisicaDTO> savePessoaFisica(@RequestBody PessoaFisicaDTO dto) {
        PessoaFisicaDTO pessoaFisicaDTO = service.create(dto);
        return ResponseEntity.status(201).body(pessoaFisicaDTO);
        //return pessoaFisicaDTO;
    }

}
