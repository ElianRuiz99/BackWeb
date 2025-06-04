package com.application.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "autores")
public class Autor {
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private String profesion;
    private Boolean activo;
}
