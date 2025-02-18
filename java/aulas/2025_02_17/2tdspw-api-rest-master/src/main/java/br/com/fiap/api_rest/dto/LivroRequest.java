package br.com.fiap.api_rest.dto;

// criando um DTO para garantir que os payloads tenham apenas as infos necessarias no formato adequado
public class LivroRequest {
    private String titulo;
    private String autor;



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
}
