package br.com.fiap.api_rest.service;

import br.com.fiap.api_rest.dto.AutorRequest;
import br.com.fiap.api_rest.dto.AutorResponse;
import br.com.fiap.api_rest.model.Autor;
import br.com.fiap.api_rest.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    private Autor requestToAutor (AutorRequest request) {
        Autor autor = new Autor();
        autor.setNome(request.getNome());
        return autor;
    }

    private AutorResponse autorToResponse (Autor autor) {
        AutorResponse response = new AutorResponse();
        response.setId(autor.getId());
        response.setNome(autor.getNome());
        return response;
    }

    public AutorResponse createAutor (AutorRequest request) {
        Autor autor = requestToAutor(request);
        Autor autorSalvo = autorRepository.save(autor);
        return autorToResponse(autorSalvo);
    }

    public List<AutorResponse> readAll () {
        return autorRepository.findAll().stream().map(this::autorToResponse).toList();
    }

    public AutorResponse readById (Long id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isEmpty()) return null;
        return autorToResponse(autor.get());
    }

    public AutorResponse update (Long id, AutorRequest autorRequest) {
        Optional<Autor> autorExistente = autorRepository.findById(id);
        if (autorExistente.isEmpty()) return null;

        Autor autorAtualizado = requestToAutor(autorRequest);
        autorAtualizado.setId(id);
        autorRepository.save(autorAtualizado);
        return autorToResponse(autorAtualizado);
    }

    public boolean delete (Long id) {
        Optional<Autor> autorExistente = autorRepository.findById(id);
        if (autorExistente.isEmpty()) return false;
        autorRepository.deleteById(id);
        return true;
    }
}
