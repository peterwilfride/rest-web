package br.com.pagrn.demo.controller;

import br.com.pagrn.demo.model.Deficiencia;
import br.com.pagrn.demo.service.DeficienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/deficiencias")
public class DeficienciaController {

    @Autowired
    public DeficienciaService service;

    @PostMapping
    public ResponseEntity<Deficiencia> cadastrar(@Valid @RequestBody Deficiencia deficiencia) {
        Deficiencia d = service.create(deficiencia);
        return ResponseEntity.status(201).body(deficiencia);
    }

    @GetMapping
    public List<Deficiencia> listar() {
        return service.list();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Deficiencia> atualizar(@PathVariable Long id, @RequestBody Deficiencia d) {
        return service.findById(id)
                .map( record -> {
                    service.create(d);
                    return ResponseEntity.ok(d);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return service.findById(id)
                .map( record -> {
                    service.delete(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
