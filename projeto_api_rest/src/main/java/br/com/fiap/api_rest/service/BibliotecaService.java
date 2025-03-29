package br.com.fiap.api_rest.service;

import br.com.fiap.api_rest.dto.*;
import br.com.fiap.api_rest.model.Biblioteca;
import br.com.fiap.api_rest.model.Endereco;
import br.com.fiap.api_rest.repository.BibliotecaRepository;
import br.com.fiap.api_rest.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<BibliotecaResponse> readAll () {
        return bibliotecaRepository.findAll().stream().map(this::bibliotecaToResponse).toList();
    }

    public BibliotecaResponse readById (Long id) {
        Optional<Biblioteca> biblioteca = bibliotecaRepository.findById(id);
        if (biblioteca.isEmpty()) return null;
        return bibliotecaToResponse(biblioteca.get());
    }

    public BibliotecaResponse update (Long id, BibliotecaRequest bibliotecaRequest) {
        Optional<Biblioteca> bibliotecaExistente = bibliotecaRepository.findById(id);
        if (bibliotecaExistente.isEmpty()) return null;

        Endereco enderecoExistente = bibliotecaExistente.get().getEndereco();
        Endereco enderecoAtualizado = requestToEndereco(bibliotecaRequest.getEndereco());
        enderecoAtualizado.setId(enderecoAtualizado.getId());
        Endereco enderecoSalvo = enderecoRepository.save(enderecoAtualizado);

        Biblioteca bibliotecaAtualizado = requestToBiblioteca(bibliotecaRequest);
        bibliotecaAtualizado.setId(id);
        bibliotecaAtualizado.setEndereco(enderecoSalvo);
        bibliotecaRepository.save(bibliotecaAtualizado);
        return bibliotecaToResponse(bibliotecaAtualizado);
    }

    public boolean delete (Long id) {
        Optional<Biblioteca> bibliotecaExistente = bibliotecaRepository.findById(id);
        if (bibliotecaExistente.isEmpty()) return false;
        bibliotecaRepository.deleteById(id);
        return true;
    }


}
