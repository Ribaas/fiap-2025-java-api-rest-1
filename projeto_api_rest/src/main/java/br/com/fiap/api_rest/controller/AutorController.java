package br.com.fiap.api_rest.controller;

import br.com.fiap.api_rest.dto.AutorRequest;
import br.com.fiap.api_rest.dto.AutorResponse;
import br.com.fiap.api_rest.dto.BibliotecaRequest;
import br.com.fiap.api_rest.dto.BibliotecaResponse;
import br.com.fiap.api_rest.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorResponse> createAutor(@RequestBody AutorRequest autor) {
        return new ResponseEntity<>(autorService.createAutor(autor), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AutorResponse>> readAutores() {
        return new ResponseEntity<>(autorService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponse> readAutor(@PathVariable Long id) {
        AutorResponse autor = autorService.readById(id);
        if (autor == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorResponse> updateAutor(@RequestBody AutorRequest autor, @PathVariable Long id) {
        AutorResponse autorAtualizado = autorService.update(id, autor);
        if (autorAtualizado == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(autorAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor (@PathVariable Long id) {
        boolean result = autorService.delete(id);
        if (!result) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
