package br.com.fiap.api_rest.controller;

import br.com.fiap.api_rest.model.Livro;
import br.com.fiap.api_rest.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public ResponseEntity<Livro> createLivro (@RequestBody Livro livro) {
        Livro livroSalvo = livroRepository.save(livro);
        // return ResponseEntity.ok(livroSalvo);
        return new ResponseEntity<>(livroSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> readLivros () {
        List<Livro> livros = livroRepository.findAll();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> readLivro (@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(livro.get(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Livro> updateLivro(@RequestBody Livro livro) {
        Livro livroSalvo = livroRepository.save(livro);
        // return ResponseEntity.ok(livroSalvo);
        return new ResponseEntity<>(livroSalvo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro (@PathVariable Long id) {
        livroRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
