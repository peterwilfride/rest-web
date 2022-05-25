package br.com.pagrn.demo.controller;

import br.com.pagrn.demo.model.Deficiencia;
import br.com.pagrn.demo.service.DeficienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/deficiencias")
public class DeficienciaController {

    @Autowired
    public DeficienciaService service;

    @PostMapping
    public ResponseEntity<Deficiencia> cadastrarDeficiencia(@Valid @RequestBody Deficiencia deficiencia) {
        Deficiencia d = service.create(deficiencia);
        return ResponseEntity.status(201).body(deficiencia);
    }
}
