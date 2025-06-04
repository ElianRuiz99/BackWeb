package com.application.rest.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutorDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String profesion;
    private Boolean activo;
}
