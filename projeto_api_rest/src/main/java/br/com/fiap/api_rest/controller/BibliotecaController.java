package br.com.fiap.api_rest.controller;

import br.com.fiap.api_rest.dto.BibliotecaRequest;
import br.com.fiap.api_rest.dto.BibliotecaResponse;
import br.com.fiap.api_rest.model.Biblioteca;
import br.com.fiap.api_rest.model.Livro;
import br.com.fiap.api_rest.repository.BibliotecaRepository;
import br.com.fiap.api_rest.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bibliotecas")
public class BibliotecaController {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @Autowired
    private BibliotecaService bibliotecaService;

    @PostMapping
    public ResponseEntity<BibliotecaResponse> createBiblioteca(@RequestBody BibliotecaRequest biblioteca) {
        return new ResponseEntity<>(bibliotecaService.createBiblioteca(biblioteca), HttpStatus.CREATED);
    }
}
