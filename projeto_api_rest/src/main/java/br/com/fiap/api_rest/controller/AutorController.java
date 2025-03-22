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
    public ResponseEntity<AutorResponse> createBiblioteca(@RequestBody AutorRequest autor) {
        return new ResponseEntity<>(autorService.createAutor(autor), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AutorResponse>> readAutores() {
        return new ResponseEntity<>(autorService.readAll(), HttpStatus.OK);
    }
}
