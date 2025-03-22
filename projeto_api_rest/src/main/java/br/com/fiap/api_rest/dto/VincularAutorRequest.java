package br.com.fiap.api_rest.dto;

import java.util.List;

public class VincularAutorRequest {
    private List<Long> idAutores;

    public List<Long> getIdAutores() {
        return idAutores;
    }

    public void setIdAutores(List<Long> idAutores) {
        this.idAutores = idAutores;
    }
}
