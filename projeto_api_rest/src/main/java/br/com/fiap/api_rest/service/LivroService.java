package br.com.fiap.api_rest.service;

import br.com.fiap.api_rest.controller.LivroController;
import br.com.fiap.api_rest.dto.LivroRequest;
import br.com.fiap.api_rest.dto.record.LivroRequestDTO;
import br.com.fiap.api_rest.dto.LivroResponse;
import br.com.fiap.api_rest.dto.record.LivroResponseDTO;
import br.com.fiap.api_rest.model.Livro;
import br.com.fiap.api_rest.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro requestToLivro (LivroRequest livroRequest) {
        Livro livro = new Livro();
//        livro.setAutor(livroRequest.getAutor());
        livro.setTitulo(livroRequest.getTitulo());
        livro.setPreco(livroRequest.getPreco());
        livro.setCategoria(livroRequest.getCategoria());
        livro.setIsbn(livroRequest.getIsbn());
        return livro;
    }

    public LivroResponse livroToResponse (Livro livro, boolean self) {
        LivroResponse livroResponse = new LivroResponse(livro.getId(), livro.getTitulo() + " - " /* + livro.getAutor() */);
        return livroResponse;
    }

    public List<LivroResponse> livrosToResponse (List<Livro> livros) {
        List<LivroResponse> listaLivros = new ArrayList<>();
        for (Livro livro : livros) {
            listaLivros.add(livroToResponse(livro, true));
        }
        return listaLivros;

        // Outras formas de obter o mesmo resultado, porem nao tao legivel:
        // return livros.stream().map(this::livroToResponse).collect(Collectors.toList());
        // livros.stream().map(livro -> livroToResponse(livro)).collect(Collectors.toList());
    }

    public Page<LivroResponse> findAll(Pageable pageable) {
        return livroRepository.findAll(pageable).map(livro -> livroToResponse(livro, true));
    }

}
