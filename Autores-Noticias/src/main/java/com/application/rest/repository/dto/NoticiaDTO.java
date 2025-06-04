package com.application.rest.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NoticiaDTO {
    private Long id;
    private String titulo;
    private String contenido;
    private LocalDateTime fechaPublicacion;
    private Long idAutor;
}
