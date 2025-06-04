package com.application.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "noticias")
public class Noticia {
    @Id
    private Long id;
    private String titulo;
    private String contenido;
    private LocalDateTime fechaPublicacion;
    private Long idAutor;
}
