package br.com.fiap.api_rest.controller;

import br.com.fiap.api_rest.dto.BibliotecaRequest;
import br.com.fiap.api_rest.dto.BibliotecaResponse;
import br.com.fiap.api_rest.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bibliotecas")
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    @PostMapping
    public ResponseEntity<BibliotecaResponse> createBiblioteca(@RequestBody BibliotecaRequest biblioteca) {
        return new ResponseEntity<>(bibliotecaService.createBiblioteca(biblioteca), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BibliotecaResponse>> readBibliotecas() {
        return new ResponseEntity<>(bibliotecaService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BibliotecaResponse> readBiblioteca(@PathVariable Long id) {
        BibliotecaResponse biblioteca = bibliotecaService.readById(id);
        if (biblioteca == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(biblioteca, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BibliotecaResponse> updateBiblioteca(@RequestBody BibliotecaRequest biblioteca, @PathVariable Long id) {
        BibliotecaResponse bibliotecaAtualizado = bibliotecaService.update(id, biblioteca);
        if (bibliotecaAtualizado == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(bibliotecaAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBiblioteca (@PathVariable Long id) {
        boolean result = bibliotecaService.delete(id);
        if (!result) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
