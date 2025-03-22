package br.com.fiap.api_rest.dto.record;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class LivroRecordServiceExample {
//    public Livro recordToLivro (LivroRequestDTO livroRecord) {
//        Livro livro = new Livro();
//        livro.setAutor(livroRecord.autor());
//        livro.setTitulo(livroRecord.titulo());
//        return livro;
//    }
//
//    public LivroResponseDTO livroToResponseDTO (Livro livro, boolean self) {
//        Link link;
//
//        if (self) {
//            link = linkTo(methodOn(LivroController.class).readLivro(livro.getId())).withSelfRel();
//        } else {
//            link = linkTo(methodOn(LivroController.class).readLivros(0)).withRel("Lista de Livros");
//        }
//
//        LivroResponseDTO livroResponse = new LivroResponseDTO(livro.getId(), livro.getTitulo() + " - " + livro.getAutor(), link);
//        return livroResponse;
//    }
//
//    public Page<LivroResponseDTO> findAllDTO(Pageable pageable) {
//        return livroRepository.findAll(pageable).map(livro -> livroToResponseDTO(livro, true));
//    }
}
