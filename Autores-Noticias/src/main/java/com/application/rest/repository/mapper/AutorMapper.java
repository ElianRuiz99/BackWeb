package com.application.rest.repository.mapper;

import com.application.rest.entity.Autor;
import com.application.rest.repository.dto.AutorDTO;

public class AutorMapper {
    public static AutorDTO mapToAutorDto(Autor autor) {
        return new AutorDTO(
                autor.getId(),
                autor.getNombre(),
                autor.getApellido(),
                autor.getProfesion(),
                autor.getActivo()
        );
    }

    public static Autor mapToAutor(AutorDTO autorDTO) {
        return new Autor(
                autorDTO.getId(),
                autorDTO.getNombre(),
                autorDTO.getApellido(),
                autorDTO.getProfesion(),
                autorDTO.getActivo()
        );
    }
}
