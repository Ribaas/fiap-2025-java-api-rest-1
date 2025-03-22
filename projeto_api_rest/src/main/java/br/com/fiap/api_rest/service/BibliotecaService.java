package br.com.fiap.api_rest.service;

import br.com.fiap.api_rest.dto.*;
import br.com.fiap.api_rest.model.Biblioteca;
import br.com.fiap.api_rest.model.Endereco;
import br.com.fiap.api_rest.model.Livro;
import br.com.fiap.api_rest.repository.BibliotecaRepository;
import br.com.fiap.api_rest.repository.EnderecoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    private Biblioteca requestToBiblioteca (BibliotecaRequest request) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNome(request.getNome());
        return biblioteca;
    }

    private Endereco requestToEndereco (EnderecoRequest request) {
        Endereco endereco = new Endereco();
        endereco.setLocalizacao(request.getLocalizacao());
        return endereco;
    }

    private BibliotecaResponse bibliotecaToResponse (Biblioteca biblioteca) {
        BibliotecaResponse response = new BibliotecaResponse();
        response.setId(biblioteca.getId());
        response.setNome(biblioteca.getNome());
        response.setEndereco(enderecoToResponse(biblioteca.getEndereco()));
        return response;
    }

    private EnderecoResponse enderecoToResponse (Endereco endereco) {
        EnderecoResponse response = new EnderecoResponse();
        response.setId(endereco.getId());
        response.setLocalizacao(endereco.getLocalizacao());
        return response;
    }

    public BibliotecaResponse createBiblioteca (BibliotecaRequest request) {
        Biblioteca biblioteca = requestToBiblioteca(request);
        Endereco endereco = requestToEndereco(request.getEndereco());
        Endereco enderecoSalvo = enderecoRepository.save(endereco);
        biblioteca.setEndereco(enderecoSalvo);
        Biblioteca bibliotecaSalva = bibliotecaRepository.save(biblioteca);
        return bibliotecaToResponse(bibliotecaSalva);
    }


}
