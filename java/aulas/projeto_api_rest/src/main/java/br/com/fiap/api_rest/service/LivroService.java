package br.com.fiap.api_rest.service;

import br.com.fiap.api_rest.dto.LivroRequest;
import br.com.fiap.api_rest.dto.LivroRequestDTO;
import br.com.fiap.api_rest.dto.LivroResponse;
import br.com.fiap.api_rest.model.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {
    public Livro requestToLivro (LivroRequest livroRequest) {
        Livro livro = new Livro();
        livro.setAutor(livroRequest.getAutor());
        livro.setTitulo(livroRequest.getTitulo());
        livro.setPreco(livroRequest.getPreco());
        livro.setCategoria(livroRequest.getCategoria());
        livro.setIsbn(livroRequest.getIsbn());
        return livro;
    }

    public Livro recordToLivro (LivroRequestDTO livroRecord) {
        Livro livro = new Livro();
        livro.setAutor(livroRecord.autor());
        livro.setTitulo(livroRecord.titulo());
        return livro;
    }

    public LivroResponse livroToResponse (Livro livro) {
        LivroResponse livroResponse = new LivroResponse(livro.getTitulo() + " - " + livro.getAutor());
        return livroResponse;
    }

    public List<LivroResponse> livrosToResponse (List<Livro> livros) {
        List<LivroResponse> listaLivros = new ArrayList<>();
        for (Livro livro : livros) {
            listaLivros.add(livroToResponse(livro));
        }
        return listaLivros;

        // Outras formas de obter o mesmo resultado, porem nao tao legivel:
        // return livros.stream().map(this::livroToResponse).collect(Collectors.toList());
        // livros.stream().map(livro -> livroToResponse(livro)).collect(Collectors.toList());
    }

}
