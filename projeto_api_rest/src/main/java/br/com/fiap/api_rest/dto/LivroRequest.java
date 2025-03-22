package br.com.fiap.api_rest.dto;

import br.com.fiap.api_rest.model.Categoria;
import jakarta.validation.constraints.*;

// criando um DTO para garantir que os payloads tenham apenas as infos necessarias no formato adequado
public class LivroRequest {

    @NotBlank(message = "O titulo nao pode ser nulo ou vazio")
    @Size(min = 3, max = 254, message = "O titulo deve ter entre 3 e 254 caracteres")
    private String titulo;

    @NotBlank(message = "O nome do autor nao pode ser nulo ou vazio")
    @Size(min = 2, max = 254, message = "O nome do autor deve ter entre 2 e 254 caracteres")
    private String autor;

    @Min(value = 1, message = "O preco deve ser no minimo 1")
    @Max(value = 99, message = "O preco deve ser no maximo 99")
    private int preco;

    @NotNull(message = "A categoria e obrigatoria")
    private Categoria categoria;

    @Pattern(regexp = "(^970\\d{7}$)|(^970\\d{10}$)", message = "O ISBN deve seguir o padrao ISBN10 ou ISBN13")
    private String isbn;

    private Long idBiblioteca;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(Long idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }
}
