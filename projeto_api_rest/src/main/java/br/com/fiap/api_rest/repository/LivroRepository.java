package br.com.fiap.api_rest.repository;

import br.com.fiap.api_rest.model.Categoria;
import br.com.fiap.api_rest.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
//    List<Livro> findByCategoria (Categoria categoria);
//    List<Livro> findTop3ByPreco ();
//    List<Livro> findFirstByTitulo ();
//    List<Livro> findDistinctByAutor (String autor);
//    List<Livro> findByIsbnIs (String isbn);
//    List<Livro> findByTituloEqualsIgnoreCase (String titulo);
//    List<Livro> findByCategoriaIsNot (Categoria categoria);
//    List<Livro> findByAutorIsNull();
//    List<Livro> findByDataLancamentoIsNotNull ();
//    List<Livro> findByEbookTrue();
//    List<Livro> findByEbookFalse();
//    List<Livro> findByTituloStartingWith (String prefix);
//    List<Livro> findByTituloEndingWith (String suffix);
//    List<Livro> findByTituloContaining (String infix);
//    List<Livro> findByAutorLike (String likePattern);
//    List<Livro> findByPrecoLessThan(double preco);
//    List<Livro> findByPrecoLessThanEqual(double preco);
//    List<Livro> findByPrecoGreaterThan(double preco);
//    List<Livro> findByPrecoGreaterThanEqual(double preco);
//    List<Livro> findByCategoriaIn (List<Categoria> categoria);
//    List<Livro> findByPrecoBetween(double min, double max);
//    List<Livro> findByDataLancamentoBefore(Date dataLancamento);
//    List<Livro> findByDataLancamentoAfter(Date dataLancamento);
//    List<Livro> findByDataLancamentoBetween(Date dataLancamentoInicial, Date dataLancamentoFinal);
//    List<Livro> findByIsbnOrTitulo (String isbn, String titulo);
//    List<Livro> findByIsbnAndDataLancamento (String isbn, Date dataLancamento);
//    List<Livro> findAllOrderByTitulo ();
//    List<Livro> findAllOrderByIsbnDesc();
}
