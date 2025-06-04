package com.application.rest.repository.mapper;

import com.application.rest.entity.Noticia;
import com.application.rest.repository.dto.NoticiaDTO;

public class NoticiaMapper {
    public static NoticiaDTO mapToNoticiaDto(Noticia noticia) {
        return new NoticiaDTO(
                noticia.getId(),
                noticia.getTitulo(),
                noticia.getContenido(),
                noticia.getFechaPublicacion(),
                noticia.getIdAutor()
        );
    }

    public static Noticia mapToNoticia(NoticiaDTO noticiaDto) {
        return new Noticia(
                noticiaDto.getId(),
                noticiaDto.getTitulo(),
                noticiaDto.getContenido(),
                noticiaDto.getFechaPublicacion(),
                noticiaDto.getIdAutor()
        );
    }
}
