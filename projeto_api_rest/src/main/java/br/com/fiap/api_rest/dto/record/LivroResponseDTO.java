package br.com.fiap.api_rest.dto.record;

import org.springframework.hateoas.Link;

public record LivroResponseDTO (Long id, String infoLivro, Link link) {
}
